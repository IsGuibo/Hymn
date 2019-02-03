package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

    private CoordinatorLayout coordinator;
    private int isPlaying;
    private String MusicUrl;
    private ProgressBar progressBar;
    private FABProgressCircle fabProgressCircle;
    private FloatingActionButton fabPlay;
    private int op = 1;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_circular);
        coordinator = findViewById(R.id.coordinator);
        fabProgressCircle = findViewById(R.id.fabProgressCircle);
        fabPlay = findViewById(R.id.fabPlay);
        //动态注册广播接收者
        MyReceiver receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("music_broadcast_code_action");
        registerReceiver(receiver, intentFilter);
        final Intent intent = getIntent();
        int page = intent.getIntExtra("page", 0);
        final String Name = intent.getStringExtra("name");
        String imageUrl = intent.getStringExtra("Image");
        MusicUrl = intent.getStringExtra("Music");
        Toolbar toolbar = findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.appBar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView imageView = findViewById(R.id.main_image_view);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
                    ShowAndHide.show(fabPlay);
                }else if(state == State.COLLAPSED){
                    ShowAndHide.hide(fabPlay);
                }
            }
        });
        fabPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, MusicService.class );
                intent.putExtra("Music",MusicUrl);
                switch (v.getId()){
                    case R.id.fabPlay:
                        if(Network.isNetworkAvailable(MainActivity.this)){
                            if(isPlaying==0){
                                if(!MusicUrl.contains("null!")){
                                    intent.putExtra("op",op);
                                    if(op==1) {
                                        fabProgressCircle.show();
                                        fabPlay.setEnabled(false);
                                        Snackbar.make(coordinator,"加载中...", Snackbar.LENGTH_LONG).show();
                                    }
                                    startService(intent);
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
        });
        loadPdf(page);
        collapsingToolbar.setTitle(Name);
        Glide.with(this).load(imageUrl).into(imageView);
        new Thread(new Runnable() {
            @Override
            public void run() {
               try{
                   Thread.sleep(600);
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
    public static boolean isTow(int [] arr, int targetValue) {
        for (int i : arr) {
            if (i==targetValue)
                return true;
        }
        return false;
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
    private void loadPdf(int page){
        PDFView pdfView = findViewById(R.id.pdfview);
        if(page<175){
            int[] towPage = {43,53,139,161,141};
            if (isTow(towPage, page)) {
                pdfView.fromAsset("1.pdf").pages(page,page+1).load();
            } else {
                pdfView.fromAsset("1.pdf").pages(page).load();
            }
        }
        else if(page<=350){
            int[] towPage = {175,187,193,293,199,308};
            if(isTow(towPage, page)){
                pdfView.fromAsset("2.pdf").pages(page-175,page-174).load();
            }else{
                pdfView.fromAsset("2.pdf").pages(page-175).load();
            }
        }else if(page<=525){
            int[] towPage = {391,389,385,363,361,353,431,429,403,4176,518,510,508,500,486,482,476,464,460,452,450,446,439,427,437};
            if(isTow(towPage, page)){
                pdfView.fromAsset("3.pdf").pages(page-350,page-349).load();
            }else{
                pdfView.fromAsset("3.pdf").pages(page-350).load();
            }
        }
        else  {
            int[] towPage ={604,616,640,665,672,689,694,704};
            if(isTow(towPage, page)){
                pdfView.fromAsset("诗歌集.pdf").pages(page-598,page-597).load();
            }else{
                pdfView.fromAsset("诗歌集.pdf").pages(page-598).load();
            }

        }
    }
    public class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            isPlaying = intent.getIntExtra("isPlaying",0);
            String musicName = intent.getStringExtra("Name");
            if(musicName !=null&& musicName.equals(MusicUrl)){
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
                fabPlay.setEnabled(true);
            }else {
                FloatingActionButton fabPlay = findViewById(R.id.fabPlay);
                fabPlay.setImageDrawable(getResources().getDrawable(R.drawable.round_play_arrow_24));
            }
        }
    }
}
