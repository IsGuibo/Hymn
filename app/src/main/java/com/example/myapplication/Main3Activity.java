package com.example.myapplication;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

import java.util.Objects;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("关于诗歌✨");


        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.drawable.photo)
                .setCover(R.mipmap.profile_cover)
                .setName("isGuibo")
                .setSubTitle("Android & material design爱好者")
                .setBrief("这是真耶稣教会的赞美诗歌本，图片来自微软Bing。我不是专业开发者，APP还有很多缺陷，希望能够提供帮助的人士联系我。")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGitHubLink("isGuibo")
                .setVersionNameAsAppSubTitle()
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .addGoogleLink("https://isGuibo@gmail.com")
                .addEmailLink("huang_guibo@outlook.com")
                .addLink(R.mipmap.wb,"weibo","https://weibo.com/u/5242479890")
                .addLink(R.mipmap.sharp_feedback_black,"Feedback","huang_guibo@outlook.com")
                .addAction(R.drawable.web,"生命之光网站","http://www.smzg.com/")
                .addAction(R.drawable.dwonload,"更新","https://github.com/IsGuibo/MyApplication/blob/master/app/release/app-release.apk?raw=true")
                .addShareAction("","https://github.com/IsGuibo/MyApplication/blob/master/app/release/app-release.apk")
                .build();
        RelativeLayout.LayoutParams relLayoutParams=new RelativeLayout.LayoutParams
                (RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        addContentView(view, relLayoutParams);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:// 点击返回图标事件
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
