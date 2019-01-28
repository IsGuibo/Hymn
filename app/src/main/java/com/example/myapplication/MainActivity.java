package com.example.myapplication;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.jorgecastilloprz.FABProgressCircle;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinator;
    private MyReceiver receiver = null;
    private int isPlaying;
    private String MusicName;
    private String MusicUrl;
    private int op = 1;
    private void show(final View view) {
        view.animate().cancel();
        view.setAlpha(0f);
        view.setScaleY(0f);
        view.setScaleX(0f);
        view.animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(200)
                .setInterpolator(new LinearOutSlowInInterpolator())
                .setListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }
                });
    }
    private void hide(final View view) {
        view.animate().cancel();
        view.animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(200)
                .setInterpolator(new FastOutLinearInInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    private boolean mCancelled;

                    @Override
                    public void onAnimationStart(Animator animation) {
                        view.setVisibility(View.VISIBLE);
                        mCancelled = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        mCancelled = true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (!mCancelled) {
                            view.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }



    public class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            isPlaying = intent.getIntExtra("isPlaying",0);
            MusicName = intent.getStringExtra("Name");
            if(MusicName!=null&&MusicName.equals(MusicUrl)){
                op=2;
            }
            SharedPreferences.Editor editor =getSharedPreferences("isPlaying",MODE_PRIVATE).edit();
            editor.putInt("isPlaying",isPlaying);
            editor.apply();
            if (isPlaying==1){
                FloatingActionButton fabPlay = findViewById(R.id.fabPlay);
                fabPlay.setImageDrawable(getResources().getDrawable(R.drawable.sharp_pause_24));
                FABProgressCircle fabProgressCircle = findViewById(R.id.fabProgressCircle);
                if(fabProgressCircle.getVisibility()==View.VISIBLE)
                fabProgressCircle.hide();
            }else {
                FloatingActionButton fabPlay = findViewById(R.id.fabPlay);
                fabPlay.setImageDrawable(getResources().getDrawable(R.drawable.round_play_arrow_24));
            }
        }
    }
    public static boolean isNetworkAvalible(Context context) {
        // 获得网络状态管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 建立网络数组
            NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();

            if (net_info != null) {
                for (NetworkInfo aNet_info : net_info) {
                    // 判断获得的网络状态是否是处于连接状态
                    if (aNet_info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar progressBar = findViewById(R.id.progress_circular);
        coordinator = findViewById(R.id.coordinator);
        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("music_broadcast_code_action");
        registerReceiver(receiver, intentFilter);
        final Intent intent = getIntent();
        int page = intent.getIntExtra("page", 0);
        final String Name = intent.getStringExtra("name");
        String ImageUrl = intent.getStringExtra("Image");
        MusicUrl = intent.getStringExtra("Music");
        Toolbar toolbar = findViewById(R.id.toolbar);
        final FABProgressCircle fabProgressCircle = findViewById(R.id.fabProgressCircle);
        final FloatingActionButton fabPlay = findViewById(R.id.fabPlay);
        AppBarLayout appBarLayout = findViewById(R.id.appBar);
        SharedPreferences preferences = getSharedPreferences("isPlaying",MODE_PRIVATE);
        isPlaying = preferences.getInt("isPlaying",0);
        if(isPlaying==1){
            fabPlay.setImageDrawable(getResources().getDrawable(R.drawable.sharp_pause_24));
        }else {
            fabPlay.setImageDrawable(getResources().getDrawable(R.drawable.round_play_arrow_24));
        }

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {

                if( state == State.EXPANDED ) {

                    show(fabPlay);

                }else if(state == State.COLLAPSED){

                    hide(fabPlay);

                }
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( MainActivity.this, MusicService.class );
                intent.putExtra("Music",MusicUrl);
                switch (v.getId()){
                    case R.id.fabPlay:
                        if(isNetworkAvalible(MainActivity.this)){
                            if(isPlaying==0){
                                if(!MusicUrl.contains("null!")){
                                    intent.putExtra("op",op);
                                    if(op==1) fabProgressCircle.show();
                                    startService(intent);
                                    Snackbar.make(coordinator,"加载中，请勿重复点按。", Snackbar.LENGTH_LONG).show();
                                }else {
                                    Snackbar.make(coordinator,"暂无“"+Name+"”的音频文件", Snackbar.LENGTH_LONG).show();
                                }
                            }
                            else {
                                intent.putExtra("op",0);
                                startService(intent);
                            }

                        }
                        else
                            Snackbar.make(coordinator,"网络不可用！", Snackbar.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        fabPlay.setOnClickListener(listener);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView imageView = findViewById(R.id.main_image_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        PDFView pdfView = findViewById(R.id.pdfview);

        if(page<175){
            if(page == 43||page == 53||page==139||page==161||page==141){
                pdfView.fromAsset("1.pdf").pages(page,page+1).load();
            }else{
                pdfView.fromAsset("1.pdf").pages(page).load();
            }
        }
        else if(page<=350){
            if(page == 175||page == 187||page==193||page==293||page==299||page==308){
                pdfView.fromAsset("2.pdf").pages(page-175,page-174).load();
            }else{
                pdfView.fromAsset("2.pdf").pages(page-175).load();
            }
        }else if(page<=525){
            if(page == 391||page == 389||page==385||page==363||page==361||page==353||page==431||page==429||page==403
            ||page==417||page==518||page==510||page==508||page==500||page==486||page==482||page==476
                    ||page==464||page==460||page==452||page==450||page==446||page==439||page==427||page==437){
                pdfView.fromAsset("3.pdf").pages(page-350,page-349).load();
            }else{
                pdfView.fromAsset("3.pdf").pages(page-350).load();
            }
        }
        else  {
            if(page == 604||page == 616||page==640||page==665||page==672||page==689||page==694||page==704){
                pdfView.fromAsset("诗歌集.pdf").pages(page-598,page-597).load();
            }else{
                pdfView.fromAsset("诗歌集.pdf").pages(page-598).load();
            }

        }

        collapsingToolbar.setTitle(Name);
        Glide.with(this).load(ImageUrl).into(imageView);
        new Thread(new Runnable() {
            @Override
            public void run() {
               try{
                   Thread.sleep(400);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();


    }





    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);//指定Toolbar上的视图文件
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:

                finish();
                return true;
            case R.id.tappp:
                coordinator = findViewById(R.id.coordinator);
                Snackbar.make(coordinator,"滑动图片部分可以实现上拉", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
