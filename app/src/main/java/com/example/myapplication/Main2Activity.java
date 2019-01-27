package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.Objects;

public class Main2Activity extends AppCompatActivity {
    private MaterialViewPager mViewPager;
    static final int TAPS = 2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mViewPager = findViewById(R.id.materialViewPager);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab111);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
            }
        });
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                getRandImageUrl());
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                getRandImageUrl());
                }
                return null;
            }
        });


        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % TAPS) {
                    case 0:
                        return BlankFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return TAPS;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % TAPS) {
                    case 0:
                        return "赞美诗";
                    default:
                        return "诗歌集";
                }
            }
        });
        //设置setViewPager
        mViewPager.getViewPager().setOffscreenPageLimit(Objects.requireNonNull(mViewPager.getViewPager().getAdapter()).getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


    }
    private String getRandImageUrl(){
        String url;
        int x=(int)(Math.random()*73);
        switch (x){
            case 0 :
                url = "http://bimgs.plmeizi.com/images/bing/2019/UKSomerset_ZH-CN2587621995_1920x1080.jpg";
                break;
            case 1 :
                url = "http://bimgs.plmeizi.com/images/bing/2019/Snowkiters_ZH-CN3098762517_1920x1080.jpg";
                break;
            case 2 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/KilimanjaroMawenzi_ZH-CN7924585833_1920x1080.jpg";
                break;
            case 3 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ChristmasIslandCrab_ZH-CN11742198976_1920x1080.jpg";
                break;
            case 4 :
                url = "http://bimgs.plmeizi.com/images/bing/2019/SaguenayIceFishing_ZH-CN9008067301_1920x1080.jpg";
                break;
            case 5 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/EyeFireworks_ZH-CN1712859531_1920x1080.jpg";
                break;
            case 6 :
                url = "http://bimgs.plmeizi.com/images/bing/2019/ParkCity_ZH-CN7858135089_1920x1080.jpg";
                break;
            case 7 :
                url = "http://bimgs.plmeizi.com/images/bing/2019/OceanDrive_ZH-CN8199064696_1920x1080.jpg";
                break;
            case 8 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/WorkingHarbor_ZH-CN10722095387_1920x1080.jpg";
                break;
            case 9 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/MendenhalLake_ZH-CN7598729576_1920x1080.jpg";
                break;
            case 10 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ShinjukuKiku_ZH-CN8446848393_1920x1080.jpg";
                break;
            case 11 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/OxpeckerBoss_ZH-CN6808077622_1920x1080.jpg";
                break;
            case 13 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/DawnRedwoods_ZH-CN11283421324_1920x1080.jpg";
                break;
            case 14 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BodeBerlin_ZH-CN6982399462_1920x1080.jpg";
                break;
            case 15 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ZeroDegrees_ZH-CN10117368234_1920x1080.jpg";
                break;
            case 16 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LascauxCavePainting_ZH-CN11733576571_1920x1080.jpg";
                break;
            case 17 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SchoolGirls_ZH-CN10666418108_1920x1080.jpg";
                break;
            case 18 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/DawnRedwoods_ZH-CN11283421324_1920x1080.jpg";
                break;
            case 19 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SFOTarmac_ZH-CN9823345722_1920x1080.jpg";
                break;
            case 20 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/CanolaBeehives_ZH-CN9545312261_1920x1080.jpg";
                break;
            case 21 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Qxi_ZH-CN15613902048_1920x1080.jpg";
                break;
            case 22 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SkylineparkRoller_ZH-CN8492771279_1920x1080.jpg";
                break;
            case 23 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/OtterChillin_ZH-CN11488013572_1920x1080.jpg";
                break;
            case 24 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ElephantParade_ZH-CN13084036095_1920x1080.jpg";
                break;
            case 25 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/PortAntonio_ZH-CN10325538004_1920x1080.jpg";
                break;
            case 26 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LovePark_ZH-CN10739395628_1920x1080.jpg";
                break;
            case 27 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FringeFireworks_ZH-CN10750567003_1920x1080.jpg";
                break;
            case 28 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BadlandsCycle_ZH-CN11688990875_1920x1080.jpg";
                break;
            case 29 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SwissSuspension_ZH-CN9196527618_1920x1080.jpg";
                break;
            case 30 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ChildrenPlaying_ZH-CN9664693753_1920x1080.jpg";
                break;
            case 31 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/T19Krishna_ZH-CN12651112147_1920x1080.jpg";
                break;
            case 32 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FairSeason_ZH-CN8821036782_1920x1080.jpg";
                break;
            case 33 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SuperBlueBloodMoon_ZH-CN11881086623_1920x1080.jpg";
                break;
            case 34 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LetchworthSP_ZH-CN14963443838_1920x1080.jpg";
                break;
            case 35 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/HomerWatercolor_ZH-CN11392693224_1920x1080.jpg";
                break;
            case 36 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FlamingoCousins_ZH-CN12160048336_1920x1080.jpg";
                break;
            case 37 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/MoriBuilding_ZH-CN5143587469_1920x1080.jpg";
                break;
            case 38 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BeachSoccerBoys_ZH-CN12914801215_1920x1080.jpg";
                break;
            case 39 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BlueShark_ZH-CN12265881842_1920x1080.jpg";
                break;

            case 40 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Honeycomb_ZH-CN7204448210_1920x1080.jpg";
                break;
            case 41 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/RoyalOntarioMuseum_ZH-CN10362892998_1920x1080.jpg";
                break;
            case 42 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BrazilianPine_ZH-CN10573180887_1920x1080.jpg";
                break;
            case 43 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/RoundBales_ZH-CN8377464305_1920x1080.jpg";
                break;
            case 44 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/SunFlowersStorm_ZH-CN8706728441_1920x1080.jpg";
                break;
            case 45 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LawnBowling_ZH-CN10492037230_1920x1080.jpg";
                break;
            case 46 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/CastleFrankenstein_ZH-CN8604017330_1920x1080.jpg";
                break;
            case 47 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/MasaiWildebeest_ZH-CN9807199192_1920x1080.jpg";
                break;
            case 48 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Unisphere_ZH-CN7027287379_1920x1080.jpg";
                break;
            case 49 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FranceMenton_ZH-CN8996032014_1920x1080.jpg";
                break;
            case 50 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/AKSUP_ZH-CN14506867124_1920x1080.jpg";
                break;
            case 51 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/ManedWolf_ZH-CN10924002958_1920x1080.jpg";
                break;
            case 52 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/AuburnBalloons_ZH-CN8649124966_1920x1080.jpg";
                break;
            case 53 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/PJ_ZH-CN10859560585_1920x1080.jpg";
                break;
            case 54 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Liverpool_ZH-CN12418492140_1920x1080.jpg";
                break;
            case 55 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/R2R2R_ZH-CN11140090151_1920x1080.jpg";
                break;
            case 56 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/TSSSF_ZH-CN12002715124_1920x1080.jpg";
                break;
            case 57 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/WineDay_ZH-CN9852912150_1920x1080.jpg";
                break;
            case 58 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/StormyCrater_ZH-CN7380963684_1920x1080.jpg";
                break;
            case 59 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/NamibFace_ZH-CN6782882876_1920x1080.jpg";
                break;
            case 60 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FalcoPeregrinus_ZH-CN12522703608_1920x1080.jpg";
                break;
            case 61 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/FishingWarehouses_ZH-CN12358243818_1920x1080.jpg";
                break;
            case 62 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/OakTreeMaize_ZH-CN10523296117_1920x1080.jpg";
                break;
            case 63 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/BushHyrax_ZH-CN9145408965_1920x1080.jpg";
                break;
            case 64 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/MontezumaSnowGeese_ZH-CN9467663976_1920x1080.jpg";
                break;
            case 65 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/HollowRock_ZH-CN11829527473_1920x1080.jpg";
                break;
            case 66 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Kolonihavehus_ZH-CN6388656996_1920x1080.jpg";
                break;
            case 67 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LongtailedWidowbird_ZH-CN7843068065_1920x1080.jpg";
                break;
            case 68 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/LulworthCoveDorset_ZH-CN6277179800_1920x1080.jpg";
                break;
            case 69 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Knuthojdsmossen_ZH-CN11774377222_1920x1080.jpg";
                break;
            case 70 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/Mariachis_ZH-CN12661065263_1920x1080.jpg";
                break;
            case 71 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/TreeHugger_ZH-CN10397384095_1920x1080.jpg";
                break;
            case 72 :
                url = "http://bimgs.plmeizi.com/images/bing/2018/TopDam_ZH-CN15313174603_1920x1080.jpg";
                break;
            default:
                url="http://bimgs.plmeizi.com/images/bing/2018/PuffinWales_ZH-CN12110916089_1920x1080.jpg";
                break;



        }
        return url;
    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent( Main2Activity.this, MusicService.class );
        SharedPreferences.Editor editor =getSharedPreferences("isPlaying",MODE_PRIVATE).edit();
        editor.putInt("isPlaying",0);
        editor.apply();
        stopService(intent);
    }

}
