package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class MusicService extends Service {
    MediaPlayer mMediaPlayer;
    Uri uri;
    private String Music;
    private String oldMusic;
    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        if(intent !=null){
            Music = intent.getStringExtra("Music");
            final int op = intent.getIntExtra("op",0);
            final Thread thread = new Thread(){
                @Override
                public void run() {
                    switch (op){
                        case 0:
                            mMediaPlayer.pause();
                            break;
                        case 1:
                            uri = Uri.parse(Music);
                            mMediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                            mMediaPlayer.start();
                            mMediaPlayer.setLooping(true);
                            break;
                        case 2:
                            mMediaPlayer.start();
                            mMediaPlayer.setLooping(true);
                            break;
                    }
                    Intent intent = new Intent("music_broadcast_code_action");
                    intent.putExtra("isPlaying", 0);
                    if (mMediaPlayer.isPlaying()){
                        intent.putExtra("Name",Music);
                        intent.putExtra("isPlaying", 1);
                    }
                    else {
                        intent.putExtra("isPlaying", 0);
                    }
                    sendBroadcast(intent);
                }
            };
            thread.start();
        }


        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mMediaPlayer!=null){
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        Intent intent = new Intent("music_broadcast_code_action");
        intent.putExtra("isPlaying", 0);
        sendBroadcast(intent);
        stopSelf();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
