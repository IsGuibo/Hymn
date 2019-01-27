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
    private int op;
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
                    if(op==1){
                        uri = Uri.parse(Music);
                        mMediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                        mMediaPlayer.start();
                        mMediaPlayer.setLooping(true);

                    }else{
                        mMediaPlayer.stop();

                    }
                    if (mMediaPlayer.isPlaying()){
                        Intent intent = new Intent("music_broadcast_code_action");
                        intent.putExtra("isPlaying", 1);
                        sendBroadcast(intent);
                    }
                    else {
                        Intent intent = new Intent("music_broadcast_code_action");
                        intent.putExtra("isPlaying", 0);
                        sendBroadcast(intent);
                    }
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
