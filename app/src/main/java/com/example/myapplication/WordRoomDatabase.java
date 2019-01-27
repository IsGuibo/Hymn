package com.example.myapplication;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
@Database(entities = {ZMS.class}, version = 5,exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    private static volatile WordRoomDatabase INSTANCE;
    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            ZMS zms=new ZMS("001.颂赞独一真神",1,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/001/1.mp3");
            mDao.insert(zms);
            zms=new ZMS("002.赞美圣父",2,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/002/2.mp3");
            mDao.insert(zms);
            zms=new ZMS("003.亚伯拉罕的神",3,getRandImageUrl(),"null!");
            mDao.insert(zms);
            zms=new ZMS("004.赞美天父",4,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/004/4.mp3");
            mDao.insert(zms);
            zms=new ZMS("005.万有赞美天父",5,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/005/5.mp3");
            mDao.insert(zms);
            zms=new ZMS("006.颂主造化大功",6,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/006/6.mp3");
            mDao.insert(zms);
            zms=new ZMS("007.万有齐颂主",7,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/007/7.mp3");
            mDao.insert(zms);
            zms=new ZMS("008.当向神歌颂",8,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/008/8.mp3");
            mDao.insert(zms);
            zms=new ZMS("009.向主欢呼",9,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/009/9.mp3");
            mDao.insert(zms);
            zms=new ZMS("010.荣耀归耶稣",10,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/010/10.mp3");
            mDao.insert(zms);
            zms=new ZMS("011.在主内顶快乐",11,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/011/11.mp3");
            mDao.insert(zms);
            zms=new ZMS("012.耶稣尊名",12,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/012j/12j.mp3");
            mDao.insert(zms);
            zms=new ZMS("013.无人能比耶稣",13,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/013/13.mp3");
            mDao.insert(zms);
            zms=new ZMS("014.万王之王",14,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/014/14.mp3");
            mDao.insert(zms);
            zms=new ZMS("015.颂赞耶稣",15,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/015/15.mp3");
            mDao.insert(zms);
            zms=new ZMS("016.敬拜天地主宰",16,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/016/16.mp3");
            mDao.insert(zms);
            zms=new ZMS("017.颂赞主慈爱",17,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/017/17.mp3");
            mDao.insert(zms);
            zms=new ZMS("018.歌颂主恩",18,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/018/18.mp3");
            mDao.insert(zms);
            zms=new ZMS("019.和散那",19,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/019/19.mp3");
            mDao.insert(zms);
            zms=new ZMS("020.尊主为王",20,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/020/20.mp3");
            mDao.insert(zms);
            zms=new ZMS("021.美哉，主耶稣！",21,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/021/21.mp3");
            mDao.insert(zms);
            zms=new ZMS("022.赞美经训",22,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/022/22.mp3");
            mDao.insert(zms);
            zms=new ZMS("023.圣经宝贵",23,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/023/23.mp3");
            mDao.insert(zms);
            zms=new ZMS("024.生命之道",24,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/024/24.mp3");
            mDao.insert(zms);
            zms=new ZMS("025.神言纯洁真诚",25,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/025/25.mp3");
            mDao.insert(zms);
            zms=new ZMS("026.求主向我发言",26,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/026/26.mp3");
            mDao.insert(zms);
            zms=new ZMS("027.耶稣爱我",27,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/027/27.mp3");
            mDao.insert(zms);
            zms=new ZMS("028.耶稣仁爱",28,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/028/28.mp3");
            mDao.insert(zms);
            zms=new ZMS("029.主寻亡羊",29,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/029/29.mp3");
            mDao.insert(zms);
            zms=new ZMS("030.妙爱找我",30,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/030/30.mp3");
            mDao.insert(zms);
            zms=new ZMS("031.主全为我",31,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/031/31.mp3");
            mDao.insert(zms);
            zms=new ZMS("032.耶稣肯收纳罪人",32,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/032/32.mp3");
            mDao.insert(zms);
            zms=new ZMS("033.到新耶路撒冷",33,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/033/33.mp3");
            mDao.insert(zms);
            zms=new ZMS("034.耶稣恩召",34,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/034/34.mp3");
            mDao.insert(zms);
            zms=new ZMS("035.雨夜过后见光明",35,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/035/35.mp3");
            mDao.insert(zms);
            zms=new ZMS("036.微声盼望",36,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/036/36.mp3");
            mDao.insert(zms);
            zms=new ZMS("037.朱红罪变如雪",37,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/037/37.mp3");
            mDao.insert(zms);
            zms=new ZMS("038.我闻耶稣呼声",38,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/038/38.mp3");
            mDao.insert(zms);
            zms=new ZMS("039.惟独主血有效",39,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/039/39.mp3");
            mDao.insert(zms);
            zms=new ZMS("040.主之宝血",40,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/040/40.mp3");
            mDao.insert(zms);
            zms=new ZMS("041.主血有权能",41,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/041/41.mp3");
            mDao.insert(zms);
            zms=new ZMS("042.羔羊宝血",43,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/042/42.mp3");
            mDao.insert(zms);

            zms=new ZMS("043.宝血洗净",45,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/043/43.mp3");
            mDao.insert(zms);
            zms=new ZMS("044.惟有主能救我",46,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/044/44.mp3");
            mDao.insert(zms);
            zms=new ZMS("045.搭救罪人",47,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/045/45.mp3");
            mDao.insert(zms);
            zms=new ZMS("046.主开心眼",48,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/046/46.mp3");
            mDao.insert(zms);
            zms=new ZMS("047.耶稣救我",49,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/047/47.mp3");
            mDao.insert(zms);
            zms=new ZMS("048.救恩成在十架",50,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/048/48.mp3");
            mDao.insert(zms);
            zms=new ZMS("049.主拯救我",51,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/049/49.mp3");
            mDao.insert(zms);
            zms=new ZMS("050.惟独耶稣",52,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/050/50.mp3");
            mDao.insert(zms);
            zms=new ZMS("051.万古灵磐(甲)",53,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/051j/51j.mp3");
            mDao.insert(zms);

            zms=new ZMS("051.万古灵磐(乙)",55,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/051y/51y.mp3");
            mDao.insert(zms);
            zms=new ZMS("052.主恩浩大",56,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/052/52.mp3");
            mDao.insert(zms);
            zms=new ZMS("053.天父慈仁",57,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/053/53.mp3");
            mDao.insert(zms);
            zms=new ZMS("054.离暗就光",58,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/054/54.mp3");
            mDao.insert(zms);
            zms=new ZMS("055.蒙主释放",59,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/055/55.mp3");
            mDao.insert(zms);
            zms=new ZMS("056.禧年已到",60,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/056/56.mp3");
            mDao.insert(zms);
            zms=new ZMS("057.我罪极重",61,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/057/57.mp3");
            mDao.insert(zms);
            zms=new ZMS("058.耶稣领我",62,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/058/58.mp3");
            mDao.insert(zms);
            zms=new ZMS("059.求主引导",63,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/059/59.mp3");
            mDao.insert(zms);
            zms=new ZMS("060.行走天路",64,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/060/60.mp3");
            mDao.insert(zms);
            zms=new ZMS("061.求主引路",65,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/061/61.mp3");
            mDao.insert(zms);
            zms=new ZMS("062.愿主偕行",66,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/062/62.mp3");
            mDao.insert(zms);
            zms=new ZMS("063.愿主领路",67,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/063/63.mp3");
            mDao.insert(zms);
            zms=new ZMS("064.真光领导",68,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/064/64.mp3");
            mDao.insert(zms);
            zms=new ZMS("065.靠近主",69,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/065/65.mp3");
            mDao.insert(zms);
            zms=new ZMS("066.主，我等候祢！",70,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/066/66.mp3");
            mDao.insert(zms);
            zms=new ZMS("067.求主指引我路",71,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/067/67.mp3");
            mDao.insert(zms);
            zms=new ZMS("068.求主携我手",72,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/068/68.mp3");
            mDao.insert(zms);
            zms=new ZMS("069.求主掌我舵",73,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/069/69.mp3");
            mDao.insert(zms);
            zms=new ZMS("070.主有万福",74,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/070/70.mp3");
            mDao.insert(zms);
            zms=new ZMS("071.耶稣我主",75,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/071/71.mp3");
            mDao.insert(zms);
            zms=new ZMS("072.万福之主",76,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/072/72.mp3");
            mDao.insert(zms);
            zms=new ZMS("073.赐福救主",77,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/073/73.mp3");
            mDao.insert(zms);
            zms=new ZMS("074.救主降生",78,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/074/74.mp3");
            mDao.insert(zms);
            zms=new ZMS("075.基督降生",79,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/075/75.mp3");
            mDao.insert(zms);
            zms=new ZMS("076.耶稣受死",80,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/076/76.mp3");
            mDao.insert(zms);
            zms=new ZMS("077.高举十架",81,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/077/77.mp3");
            mDao.insert(zms);
            zms=new ZMS("078.乐主复活",82,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/078/78.mp3");
            mDao.insert(zms);
            zms=new ZMS("079.耶稣复活颂",83,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/079/79.mp3");
            mDao.insert(zms);
            zms=new ZMS("080.主已战胜死亡",84,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/080/80.mp3");
            mDao.insert(zms);
            zms=new ZMS("081.耶稣再临",85,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/081/81.mp3");
            mDao.insert(zms);
            zms=new ZMS("082.警醒预备",86,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/082/82.mp3");
            mDao.insert(zms);
            zms=new ZMS("083.耶稣来时",87,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/083/83.mp3");
            mDao.insert(zms);
            zms=new ZMS("084.欢迎我王",88,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/084/82.mp3");
            mDao.insert(zms);
            zms=new ZMS("085.主快再来",89,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/085/85.mp3");
            mDao.insert(zms);
            zms=new ZMS("086.善恶有报",90,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/086/86.mp3");
            mDao.insert(zms);
            zms=new ZMS("087.审判大日",91,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/087/87.mp3");
            mDao.insert(zms);
            zms=new ZMS("088.救主恩功",92,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/088/88.mp3");
            mDao.insert(zms);
            zms=new ZMS("089.主恩更多",93,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/089/89.mp3");
            mDao.insert(zms);
            zms=new ZMS("090.数算恩典",94,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/090/90.mp3");
            mDao.insert(zms);
            zms=new ZMS("091.想念主爱",95,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/091/91.mp3");
            mDao.insert(zms);
            zms=new ZMS("092.病愈感恩",96,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/092/92.mp3");
            mDao.insert(zms);
            zms=new ZMS("093.更新感恩",97,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/093/93.mp3");
            mDao.insert(zms);
            zms=new ZMS("094.主恩长存",98,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/094/94.mp3");
            mDao.insert(zms);
            zms=new ZMS("095.受膏的君王",99,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/095/95.mp3");
            mDao.insert(zms);
            zms=new ZMS("096.奇异恩典",100,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/096/96.mp3");
            mDao.insert(zms);
            zms=new ZMS("097.我主离开象牙宫",101,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/097/97.mp3");
            mDao.insert(zms);
            zms=new ZMS("098.神言纯洁真诚",102,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/098/98.mp3");
            mDao.insert(zms);
            zms=new ZMS("099.爱主更深",103,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/099/99.mp3");
            mDao.insert(zms);
            zms=new ZMS("100.舍己为主",104,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/100/100.mp3");
            mDao.insert(zms);
            zms=new ZMS("101.专爱耶稣",105,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/101/101.mp3");
            mDao.insert(zms);
            zms=new ZMS("102.为主而活",106,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/0102/102.mp3");
            mDao.insert(zms);
            zms=new ZMS("103.快亲近主",107,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/103/103.mp3");
            mDao.insert(zms);
            zms=new ZMS("104.深爱耶稣",108,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/104/104.mp3");
            mDao.insert(zms);
            zms=new ZMS("105.为主舍命",109,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/105/105.mp3");
            mDao.insert(zms);
            zms=new ZMS("106.我是耶稣门徒",110,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/106/106.mp3");
            mDao.insert(zms);
            zms=new ZMS("107.容我与主同行",111,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/107/107.mp3");
            mDao.insert(zms);
            zms=new ZMS("108.跟从救主",112,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/108/108.mp3");
            mDao.insert(zms);
            zms=new ZMS("109.践主迹行",113,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/109/109.mp3");
            mDao.insert(zms);
            zms=new ZMS("110.撇物从主",114,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/110/110.mp3");
            mDao.insert(zms);
            zms=new ZMS("111.跟随救主",115,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/111/111.mp3");
            mDao.insert(zms);
            zms=new ZMS("112.我跟随主",116,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/112/112.mp3");
            mDao.insert(zms);
            zms=new ZMS("113.奉献会堂",117,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/113/113.mp3");
            mDao.insert(zms);
            zms=new ZMS("114.感恩奉献",118,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/114/114.mp3");
            mDao.insert(zms);
            zms=new ZMS("115.会堂落成",119,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/115/115.mp3");
            mDao.insert(zms);
            zms=new ZMS("116.献上身心",120,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/116/116.mp3");
            mDao.insert(zms);
            zms=new ZMS("117.奉献祈纳",121,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/117/117.mp3");
            mDao.insert(zms);
            zms=new ZMS("118.奉献全生",122,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/118/118.mp3");
            mDao.insert(zms);
            zms=new ZMS("119.都归耶稣我救主",123,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/119/119.mp3");
            mDao.insert(zms);
            zms=new ZMS("120.奉献所有",124,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/120/120.mp3");
            mDao.insert(zms);
            zms=new ZMS("121.我献何物给耶稣？",125,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/121/121.mp3");
            mDao.insert(zms);
            zms=new ZMS("122.彼此相爱",126,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/122/122.mp3");
            mDao.insert(zms);
            zms=new ZMS("123.圣徒送行",127,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/123/123.mp3");
            mDao.insert(zms);
            zms=new ZMS("124.实行爱心(甲)",128,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/124j/124j.mp3");
            mDao.insert(zms);
            zms=new ZMS("124.实行爱心（乙）",129,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/124y/124y.mp3");
            mDao.insert(zms);
            zms=new ZMS("125.别离诗",130,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/125/125.mp3");
            mDao.insert(zms);
            zms=new ZMS("126.兄弟相爱",131,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/126/126.mp3");
            mDao.insert(zms);
            zms=new ZMS("127.切实相爱",132,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/127/127.mp3");
            mDao.insert(zms);
            zms=new ZMS("128.快乐圣日",133,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/128/128.mp3");
            mDao.insert(zms);
            zms=new ZMS("129.纪念圣日",134,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/129/129.mp3");
            mDao.insert(zms);
            zms=new ZMS("130.安息圣日",135,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/130/130.mp3");
            mDao.insert(zms);
            zms=new ZMS("131.乐守圣日",136,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/131/131.mp3");
            mDao.insert(zms);
            zms=new ZMS("132.求主荫庇（甲）",137,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/132j/132j.mp3");
            mDao.insert(zms);
            zms=new ZMS("132.求主荫庇（乙）",139,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/132y/132y.mp3");
            mDao.insert(zms);
//
            zms=new ZMS("133.耶稣不改变",141,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/133/133.mp3");
            mDao.insert(zms);
//
            zms=new ZMS("134.仰望救主",143,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/134/134.mp3");mDao.insert(zms);
            zms=new ZMS("135.为什么忙？",144,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/135/135.mp3");mDao.insert(zms);
            zms=new ZMS("136.我知所信的是谁",145,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/136/136.mp3");mDao.insert(zms);
            zms=new ZMS("137.主是我良友",146,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/137/137.mp3");mDao.insert(zms);
            zms=new ZMS("138.我所信有根基",147,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/138/138.mp3");mDao.insert(zms);
            zms=new ZMS("139.闻主过路",148,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/139/139.mp3");mDao.insert(zms);
            zms=new ZMS("140.救主明白你忧伤",149,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/140/140.mp3");mDao.insert(zms);
            zms=new ZMS("141.永乐或永苦？",150,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/141/141.mp3");mDao.insert(zms);
            zms=new ZMS("142.靠主消除忧伤",151,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/142/142.mp3");mDao.insert(zms);
            zms=new ZMS("143.我要投靠主",152,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/143/143.mp3");mDao.insert(zms);
            zms=new ZMS("144.专心仰赖主",153,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/144/144.mp3");mDao.insert(zms);
            zms=new ZMS("145.倚靠耶稣",154,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/145/145.mp3");mDao.insert(zms);
            zms=new ZMS("146.时刻靠主",155,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/146/146.mp3");mDao.insert(zms);
            zms=new ZMS("147.先求神国神义",156,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/147/147.mp3");mDao.insert(zms);
            zms=new ZMS("148.耶稣牧我",157,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/148/148.mp3");mDao.insert(zms);
            zms=new ZMS("149.安息在主膀臂中",158,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/149/149.mp3");mDao.insert(zms);
            zms=new ZMS("150.善牧看顾",159,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/150/150.mp3");mDao.insert(zms);
            zms=new ZMS("151.天父必看顾你",160,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/151/151.mp3");mDao.insert(zms);
            zms=new ZMS("152.主必预备",161,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/152/152.mp3");
            mDao.insert(zms);
//
            zms=new ZMS("153.时刻交托主",163,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/153/153.mp3");mDao.insert(zms);
            zms=new ZMS("154.耶稣是我坚固保障",164,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/154/154.mp3");mDao.insert(zms);
            zms=new ZMS("155.主常看顾我",165,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/155/155.mp3");mDao.insert(zms);
            zms=new ZMS("156.与主同行",166,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/156/156.mp3");mDao.insert(zms);
            zms=new ZMS("157.神国在心",167,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/157/157.mp3");mDao.insert(zms);
            zms=new ZMS("158.走在主路上",168,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/158/158.mp3");mDao.insert(zms);
            zms=new ZMS("159.主赐真平安",169,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/159/159.mp3");mDao.insert(zms);
            zms=new ZMS("160.真光在心",170,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/160/160.mp3");mDao.insert(zms);
            zms=new ZMS("161.在主荫下",171,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/161/161.mp3");mDao.insert(zms);
            zms=new ZMS("162.主负我重担",172,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/162/162.mp3");mDao.insert(zms);
            zms=new ZMS("163.我灵魂永安乐",173,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/163/163.mp3");mDao.insert(zms);
            zms=new ZMS("164.主恩够用",174,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/164/164.mp3");mDao.insert(zms);
            zms=new ZMS("165.耶稣怀抱我",175,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/165/165.mp3");mDao.insert(zms);
//
            zms=new ZMS("166.在主荫庇之下",177,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/166/166.mp3");mDao.insert(zms);
            zms=new ZMS("167.十架精兵",178,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/167/167.mp3");mDao.insert(zms);
            zms=new ZMS("168.精兵前进",179,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/168/168.mp3");mDao.insert(zms);
            zms=new ZMS("169.善恶对敌",180,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/169/169.mp3");mDao.insert(zms);
            zms=new ZMS("170.为主勇往",181,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/170/170.mp3");mDao.insert(zms);
            zms=new ZMS("171.教会惟一根基",182,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/171/171.mp3");mDao.insert(zms);
            zms=new ZMS("172.你该得胜",183,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/172/172.mp3");mDao.insert(zms);
            zms=new ZMS("173.十架旌旗",184,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/173/173.mp3");mDao.insert(zms);
            zms=new ZMS("174.真教会必兴起",185,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/174/174.mp3");mDao.insert(zms);
            zms=new ZMS("175.真教会必兴起",186,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/175/175.mp3");mDao.insert(zms);
            zms=new ZMS("176.常常有胜利",187,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/176/176.mp3");mDao.insert(zms);
//
            zms=new ZMS("177.切莫顺从诱惑",189,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/177/177.mp3");mDao.insert(zms);
            zms=new ZMS("178.趁还有今天",190,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/178/178.mp3");mDao.insert(zms);
            zms=new ZMS("179.预备进天国",191,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/179/179.mp3");mDao.insert(zms);
            zms=new ZMS("180.永生门路",192,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/180/180.mp3");mDao.insert(zms);
            zms=new ZMS("181.我必前进",193,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/181/181.mp3");mDao.insert(zms);
//
            zms=new ZMS("182.往前走",195,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/182/182.mp3");mDao.insert(zms);
            zms=new ZMS("183.勇往直前",196,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/183/183.mp3");mDao.insert(zms);
            zms=new ZMS("184.奔跑天路",197,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/184/184.mp3");mDao.insert(zms);
            zms=new ZMS("185.思慕天家",198,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/185/185.mp3");mDao.insert(zms);
            zms=new ZMS("186.我家乃在天",199,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/186/186.mp3");mDao.insert(zms);
//
            zms=new ZMS("187.来到美地",201,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/187/187.mp3");mDao.insert(zms);
            zms=new ZMS("188.荣归天乡",202,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/188/1858.mp3");mDao.insert(zms);
            zms=new ZMS("189.天城美景",203,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/189/189.mp3");mDao.insert(zms);
            zms=new ZMS("190.天国的人",204,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/190/190.mp3");mDao.insert(zms);
            zms=new ZMS("191.我家在天",205,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/191/191.mp3");mDao.insert(zms);
            zms=new ZMS("192.十架领路",206,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/192/192.mp3");mDao.insert(zms);
            zms=new ZMS("193.荣耀天国",207,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/193/193.mp3");mDao.insert(zms);
//
            zms=new ZMS("194.安息在天家",209,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/194/194.mp3");mDao.insert(zms);
            zms=new ZMS("195.羡慕福地",210,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/195/195.mp3");mDao.insert(zms);
            zms=new ZMS("196.荣美福地",211,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/196/196.mp3");mDao.insert(zms);
//
            zms=new ZMS("197.非金也非银",213,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/197/197.mp3");mDao.insert(zms);
            zms=new ZMS("198.靠主领回天家",214,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/198/198.mp3");mDao.insert(zms);
            zms=new ZMS("199.天上快乐家",215,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/199/199.mp3");mDao.insert(zms);
            zms=new ZMS("200.思慕天乡",216,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/200/200.mp3");mDao.insert(zms);
            zms=new ZMS("201.永远的荣耀",217,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/201/201.mp3");mDao.insert(zms);
            zms=new ZMS("202.天上安乐处",218,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/202/202.mp3");mDao.insert(zms);
            zms=new ZMS("203.百合花",219,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/203/203.mp3");mDao.insert(zms);
//
            zms=new ZMS("204.因信有盼望",221,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/204/204.mp3");mDao.insert(zms);
            zms=new ZMS("205.在基督里必复活",222,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/205/205.mp3");mDao.insert(zms);
            zms=new ZMS("206.我必亲见主面",223,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/206/206.mp3");mDao.insert(zms);
            zms=new ZMS("207.思念主来",224,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/207/207.mp3");mDao.insert(zms);
            zms=new ZMS("208.圣徒被提",225,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/208/208.mp3");mDao.insert(zms);
//
            zms=new ZMS("209.我必当面见主",227,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/209/209.mp3");mDao.insert(zms);
            zms=new ZMS("210.当我行完今生路",228,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/210/210.mp3");mDao.insert(zms);
            zms=new ZMS("211.天父监察",229,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/211/211.mp3");mDao.insert(zms);
            zms=new ZMS("212.为主发光",230,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/212/212.mp3");mDao.insert(zms);
            zms=new ZMS("213.积少成多",231,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/213/213.mp3");mDao.insert(zms);
            zms=new ZMS("214.八福颂",232,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/214/214.mp3");mDao.insert(zms);
            zms=new ZMS("215.真教会美德",233,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/215/215.mp3");mDao.insert(zms);
            zms=new ZMS("216.圣徒美德",234,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/216/216.mp3");mDao.insert(zms);
            zms=new ZMS("217.力行主道",235,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/217/217.mp3");mDao.insert(zms);
            zms=new ZMS("218.圣灵佳果",236,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/218/218.mp3");mDao.insert(zms);
            zms=new ZMS("219.随处发光",237,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/219/219.mp3");mDao.insert(zms);
//
            zms=new ZMS("220.火炼精金",239,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/220/220.mp3");mDao.insert(zms);
//
            zms=new ZMS("221.克制情欲",241,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/221/221.mp3");mDao.insert(zms);
            zms=new ZMS("222.清心有福",242,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/222/222.mp3");mDao.insert(zms);
            zms=new ZMS("223.选民灵歌",243,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/223/223.mp3");mDao.insert(zms);
            zms=new ZMS("224.求主察看",244,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/224/224.mp3");mDao.insert(zms);
            zms=new ZMS("225.顺从圣灵",245,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/225/225.mp3");mDao.insert(zms);
            zms=new ZMS("226.愿成主旨",246,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/226/226.mp3");mDao.insert(zms);
            zms=new ZMS("227.听命有福",247,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/227/227.mp3");mDao.insert(zms);
            zms=new ZMS("228.遵命有福",248,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/228/228.mp3");mDao.insert(zms);
            zms=new ZMS("229.谨守十诫",249,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/229/229.mp3");mDao.insert(zms);
            zms=new ZMS("230.义人有福",250,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/230/230.mp3");mDao.insert(zms);
            zms=new ZMS("231.照主所愿",251,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/231/231.mp3");mDao.insert(zms);
            zms=new ZMS("232.要同耶稣一样",252,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/232/232.mp3");mDao.insert(zms);
            zms=new ZMS("233.联属耶稣",253,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/233/233.mp3");mDao.insert(zms);
            zms=new ZMS("234.与主日近",254,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/234/234.mp3");mDao.insert(zms);
            zms=new ZMS("235.主我一体",255,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/235/235.mp3");mDao.insert(zms);
            zms=new ZMS("236.我属耶稣",256,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/236/236.mp3");mDao.insert(zms);
            zms=new ZMS("237.耶稣住在我心",257,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/237/237.mp3");mDao.insert(zms);
            zms=new ZMS("238.来居我心，主耶稣！",258,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/238/238.mp3");mDao.insert(zms);
            zms=new ZMS("239.求主同住",259,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/239/239.mp3");mDao.insert(zms);
            zms=new ZMS("240.与主同乐",260,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/240/240.mp3");mDao.insert(zms);
            zms=new ZMS("241.我生命的君王",261,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/241/241.mp3");mDao.insert(zms);
            zms=new ZMS("242.主在门外等候",262,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/242/242.mp3");mDao.insert(zms);
            zms=new ZMS("243.引我更亲近",263,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/243/243.mp3");mDao.insert(zms);
            zms=new ZMS("244.主，我愿像祢！",264,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/244/244.mp3");mDao.insert(zms);
            zms=new ZMS("245.求主密相契",265,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/245/245.mp3");mDao.insert(zms);
            zms=new ZMS("246.恳求圣灵",266,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/246/246.mp3");mDao.insert(zms);
            zms=new ZMS("247.圣灵权能",267,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/247/247.mp3");mDao.insert(zms);
            zms=new ZMS("248.我要求圣灵",268,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/248/248.mp3");mDao.insert(zms);
            zms=new ZMS("249.灵洗各人",269,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/249/249.mp3");mDao.insert(zms);
            zms=new ZMS("250.从新得力",270,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/250/250.mp3");mDao.insert(zms);
            zms=new ZMS("251.圣灵的洗",271,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/251/251.mp3");mDao.insert(zms);
            zms=new ZMS("252.渴慕圣灵充满",272,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/252/252.mp3");mDao.insert(zms);
            zms=new ZMS("253.圣灵已来",273,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/253/253.mp3");mDao.insert(zms);
            zms=new ZMS("254.方言宝贵",274,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/254/254.mp3");mDao.insert(zms);
            zms=new ZMS("255.主今夜赐福",275,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/255/255.mp3");mDao.insert(zms);
            zms=new ZMS("256.恩雨大降",276,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/256/256.mp3");mDao.insert(zms);
            zms=new ZMS("257.警醒祈祷",277,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/257/257.mp3");mDao.insert(zms);
            zms=new ZMS("258.禁食祈祷",278,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/258/258.mp3");mDao.insert(zms);
            zms=new ZMS("259.恒切祷告",279,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/259/259.mp3");mDao.insert(zms);
            zms=new ZMS("260.清晨颂主",280,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/260/260.mp3");mDao.insert(zms);
            zms=new ZMS("261.晚祷感恩",281,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/261/261.mp3");mDao.insert(zms);
            zms=new ZMS("262.与神灵交",282,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/262/262.mp3");mDao.insert(zms);
            zms=new ZMS("263.耶稣恩友",283,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/263/263.mp3");mDao.insert(zms);
            zms=new ZMS("264.求主垂怜",284,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/264/264.mp3");mDao.insert(zms);
            zms=new ZMS("265.快告诉耶稣",285,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/265/265.mp3");mDao.insert(zms);
            zms=new ZMS("266.传扬福音",286,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/266/266.mp3");mDao.insert(zms);
            zms=new ZMS("267.听主差遣",287,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/267/267.mp3");mDao.insert(zms);
            zms=new ZMS("268.听从主呼召",288,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/268/268.mp3");mDao.insert(zms);
            zms=new ZMS("269.闻主呼召我",289,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/269/269.mp3");mDao.insert(zms);
            zms=new ZMS("270.到遥远地方",290,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/270/270.mp3");mDao.insert(zms);
            zms=new ZMS("271.不要惧怕",291,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/271/271.mp3");mDao.insert(zms);
            zms=new ZMS("272.保惠师已经到",292,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/272/272.mp3");mDao.insert(zms);
            zms=new ZMS("273.大喜信息",293,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/273/273.mp3");mDao.insert(zms);
//
            zms=new ZMS("274.晚雨降临(甲)",295,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/274/274.mp3");mDao.insert(zms);
            zms=new ZMS("274.福音要传遍(乙)",296,getRandImageUrl(),"null！");mDao.insert(zms);
            zms=new ZMS("275.禾捆收回家",297,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/275/275.mp3");mDao.insert(zms);
            zms=new ZMS("276.来听福音",298,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/276/276.mp3");mDao.insert(zms);
            zms=new ZMS("277.喜传福音",299,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/278/278.mp3");mDao.insert(zms);
//
            zms=new ZMS("278.主拯救",301,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/278/278.mp3");mDao.insert(zms);
            zms=new ZMS("279.敞开恩门",302,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/279/279.mp3");mDao.insert(zms);
            zms=new ZMS("280.广传福音",303,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/280/280.mp3");mDao.insert(zms);
            zms=new ZMS("281.叹未得人",304,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/281/281.mp3");mDao.insert(zms);
            zms=new ZMS("282.努力工作",305,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/282/282.mp3");mDao.insert(zms);
            zms=new ZMS("283.为主收庄稼",306,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/283/283.mp3");mDao.insert(zms);
            zms=new ZMS("284.发出福音真光",307,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/284/284.mp3");mDao.insert(zms);
            zms=new ZMS("285.开船入深海",308,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/285/285.mp3");mDao.insert(zms);
//
            zms=new ZMS("286.传布救恩",310,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/286/286.mp3");mDao.insert(zms);
            zms=new ZMS("287.为耶稣劳力",311,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/287/287.mp3");mDao.insert(zms);
            zms=new ZMS("288.赶快工作",312,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/288/288.mp3");mDao.insert(zms);
            zms=new ZMS("289.派任圣职",313,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/289/289.mp3");mDao.insert(zms);
            zms=new ZMS("290.按立礼",314,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/290/290.mp3");mDao.insert(zms);
            zms=new ZMS("291.洗罪泉源",315,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/291/291.mp3");mDao.insert(zms);
            zms=new ZMS("292.赎罪妙恩",316,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/292/292.mp3");mDao.insert(zms);
            zms=new ZMS("293.洗净罪愆",317,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/293/293.mp3");mDao.insert(zms);
            zms=new ZMS("294.我来就你",318,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/294/294.mp3");mDao.insert(zms);
//
            zms=new ZMS("295.洗脚礼",319,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/295/295.mp3");mDao.insert(zms);
            zms=new ZMS("296.纪念主死(甲)",321,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/296/296.mp3");mDao.insert(zms);
            zms=new ZMS("296.岂能让主独背十架？(乙)",322,getRandImageUrl(),"null！");mDao.insert(zms);
            zms=new ZMS("297.为主我立何志？",323,getRandImageUrl(),"null！");mDao.insert(zms);
            zms=new ZMS("298.圣徒婚礼",324,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/298j/298j.mp3");mDao.insert(zms);
            zms=new ZMS("299.婚礼祝歌",325,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/299/299.mp3");mDao.insert(zms);
            zms=new ZMS("300.祝新婚之乐",326,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/300/300.mp3");mDao.insert(zms);
            zms=new ZMS("301.人生不长",327,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/301/301.mp3");mDao.insert(zms);
            zms=new ZMS("302.安葬",328,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/302/302.mp3");mDao.insert(zms);
            zms=new ZMS("303.天国来了",329,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/303/303.mp3");mDao.insert(zms);
            zms=new ZMS("304.浪子回家",330,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/304/304.mp3");mDao.insert(zms);
            zms=new ZMS("305.警醒自责",331,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/305/305.mp3");mDao.insert(zms);
            zms=new ZMS("306.悔改重生",332,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/306/306.mp3");mDao.insert(zms);
            zms=new ZMS("307.回来吧！",333,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/307/307.mp3");mDao.insert(zms);
            zms=new ZMS("308.天父接纳我",334,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/308/308.mp3");mDao.insert(zms);
            zms=new ZMS("309.新年祈望",335,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/309/309.mp3");mDao.insert(zms);
            zms=new ZMS("310.年终感颂",336,getRandImageUrl(),"http://api.zysjh.com/Data/zjhzms/y_mp3/310/310.mp3");mDao.insert(zms);
            zms=new ZMS("311.一齐来歌颂",337,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("312.齐聚主前",338,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("313.这世界的光是耶稣",339,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("314.耶稣呼召",340,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("315.永世的君王",341,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("316.敬拜荣耀王",342,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("317.我救主已来到",343,getRandImageUrl(),"null!");mDao.insert(zms);
//
            zms=new ZMS("318.安稳港口",345,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("319.敬拜基督新生王",346,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("320.天使歌唱",347,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("321.信徒齐来颂主",348,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("322.荣耀归于天父",349,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("323.献上千万荣冠",351,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("324.慈爱的救主",352,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("325.救主耶稣是我至宝",353,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("326.欢唱咏不停",355,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("327.多认识耶稣",356,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("328.赞美真神创造主",357,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("329.天父我神",358,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("330.奇妙平安由神来",359,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("331.圣灵信实保惠师",360,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("332.真神大爱",361,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("333.欣逢圣日",363,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("334.耶稣，沙仑玫瑰",365,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("335.真希奇，我主的慈爱",367,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("336.耶稣是否仍然看顾我？",368,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("337.耶稣拣选我",369,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("338.祂拯救我",370,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("339.耶稣是我一切所有",371,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("340.奇妙的救主",372,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("341.让主耶稣进入你心",373,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("342.你的光当照耀",374,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("343.爱拯救我",375,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("344.暴风雨中的避难所",377,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("345.深哉，深哉，耶稣的爱",378,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("346.耶稣温柔慈声呼唤",379,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("347.万古磐石藏身所",380,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("348.祂是奇妙救主",381,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("349.救主正在等待",382,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("350.主比生命更宝贵",383,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("351.每一天",384,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("352.主藏我灵",385,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("353.在主十架下",387,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("354.只要信祂",388,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("355.平安永在我心",389,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("356.信心使我得胜",391,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("357.主耶和华是我牧者",393,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("358.基督活在我心",394,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("359.同心前往锡安",395,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("360.你心可有住处为主？",396,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("361.领我到髑髅地",397,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("362.求主擘生命饼",398,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("363.坚立在应许上",399,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("364.主话语深藏我心",400,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("365.救主受难",401,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("366.照主旨意行",402,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("367.祂看顾麻雀",403,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("368.快传福音",405,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("369.在各各他",406,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("370.主帮助我们",407,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("371.面临试炼时候",408,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("372.降百福甘霖",409,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("373.只要相信",410,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("374.求永恒君王前导",411,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("375.主呼召你",412,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("376.坚固磐石",413,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("377.主常常顾念我",414,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("378.信靠顺服",415,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("379.转眼仰望耶稣",416,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("380.我主是我生命标竿",417,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("381.我何等爱耶稣",419,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("382.我灵安稳",420,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("383.将有一天",421,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("384.我愿效法耶稣",422,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("385.救赎",423,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("386.我得一友",424,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("387.求主对我述说",425,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("388.靠近耶稣慈怀",426,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("389.亲近，更亲近",427,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("390.主！我愿更亲近祢",428,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("391.永不孤单",429,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("392.任主差派",431,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("393.听！良牧慈声",433,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("394.感谢神",434,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("395.向高处行",435,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("396.我要真诚",436,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("397.何不今日归耶稣？",437,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("398.为主而活",439,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("399.主，我愿做祢门徒",441,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("400.我深愿更像耶稣",442,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("401.须用工夫成圣",443,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("402.神的道路",444,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("403.任凭主旨意",445,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("404.赞美救主",446,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("405.你是否已祷告",448,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("406.要告诉耶稣",449,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("407.在花园里",450,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("408.若主今日再临",452,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("409.我可愿作十架精兵？",454,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("410.再等不多时",455,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("411.美丽的祷告花园",456,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("412.宝贵祷告良辰",457,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("413.我们同心聚集",458,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("414.恩主与我同在",459,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("415.献上至好的",460,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("416.你可情愿？",462,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("417.耶稣领我回家",463,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("418.一切献在坛上",464,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("419.因我得福",466,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("420.奉献与祢",467,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("421.请来赴宴",468,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("422.我锚坚固牢靠",469,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("423.对我述说耶稣故事",470,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("424.我王之事工",471,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("425.我属我王",472,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("426.何等奇妙的救主",473,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("427.有一故事传给万邦",474,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("428.耶稣与我同行",475,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("429.我必亲见荣耀主",476,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("430.我们聚集生命河边",478,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("431.全备的爱",479,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("432.祂大能手扶持我",480,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("433.奇妙平安",481,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("434.在那荣耀国度",482,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("435.歌颂救赎恩主",484,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("436.我一生蒙救主引导",486,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("437.谁正守候在门外？",488,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("438.颂主创造美好",489,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("439.时刻交托主",490,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("440.在主爱中团契",491,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("441.我立下决心",492,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("442.神一路引领",493,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("443.荣耀永归耶稣",494,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("444.耶稣圣名最甜美",495,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("445.恩典大过我罪愆",496,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("446.颂赞主圣名",497,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("447.高唱和散那",498,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("448.欢欣，主为君王",499,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("449.何能如此",500,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("450.吹响征战号",502,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("451.藏身主怀",503,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("452.我愿常见祢",504,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("453.我是君王后嗣",505,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("454.以马内利，恳求降临",506,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("455.最美圣名",507,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("456.归家",508,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("457.耶稣奇妙的救恩",510,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("458.你在哪里？",512,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("459.约旦河畔",513,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("460.愿主赐福保佑你",514,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("461.快抛救生索",515,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("462.哈利路亚，奇妙君王",516,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("463.当欢欣喜乐",517,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("464.先贤所信",518,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("465.到各山岭去传扬",520,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("466.赞美耶稣基督",521,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("467.主的应许",522,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("468.宝贵回忆",523,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("469.灵恩大会",524,getRandImageUrl(),"null!");mDao.insert(zms);




            zms=new ZMS("爱的真谛&爱喜乐生命",600,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("爱是不保留&爱使我们相聚在一起",601,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("爱在盛开",602,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("爱，我愿意",603,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("爱的钟声",604,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("宝贵十架",606,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("别哭，我帮你祷告",607,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("杯子歌&除祢以外",608,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("不是没有家",609,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("彩虹下的约定",610,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("点灯在台上",611,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("恩典太美丽",612,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("恩曲不休",613,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("恩典够用",614,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("各各他的爱",615,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("给怀疑的你",616,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("神要开道路",618,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("海边的脚印",619,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("今生若比永恒长",620,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("克西马尼",621,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("两个门",622,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("两个环",623,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("美好之日",624,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("蒙福的人",625,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("没有祢就没有我",626,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("你知道吗?",627,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("你默然爱我",628,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("祢是我永远的救主",629,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("你是葡萄树",630,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("年轻告白",631,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("那双看不见的手",632,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("朋友请听",633,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("起来吧！青年们",634,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("轻轻听&奇妙双手",635,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("牵我手，伴我走",636,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("劝",637,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("全然向祢",638,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("亲近主",639,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("认识祢真好",640,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("日光之下",642,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("人的生命只有一次",643,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("若&恩爱孝亲",644,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("是谁/1",645,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("是谁/2",646,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("沙仑玫瑰",647,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("世界美丽非常",648,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("生命的执著",649,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("神的奇妙大爱",650,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("深深爱祢",652,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("谁可倾诉",653,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("说一说",654,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("主赐福如春雨",655,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("贴心",656,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("田地里的庄稼",657,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("天父必看顾你",658,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("听我求",659,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("同路人",660,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我在这里",661,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我的家",662,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我永远地爱你",663,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我心不高",664,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我知谁管着明天",665,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("我以祷告来到你面前&我是主的羊",667,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我要向高山举目",668,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("我最爱的你",669,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("无愧见主面",670,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("无所不在",671,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("惟有你",672,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("小小的梦想&心愿",674,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("相约在主里",675,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("心的归回",676,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("心的开始",677,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("新希望",678,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("寻找",679,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("惜别&耶稣恩友",680,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣，沙仑玫瑰",681,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶和华是爱",682,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣给你平安&耶和华祝福满满",683,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣是我宝",684,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣永远伴着你",685,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣不着急",686,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶和华祢是我的神",687,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶和华神已掌权",688,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("耶稣爱你",689,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("一生爱你",691,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("一件礼物",692,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("因你与我同行&因主爱而感动",693,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("因耶稣的爱",694,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("有一条路",696,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("有一位神&愿耶和华赐福给你",697,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("电的故事，神的故事",698,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("永远有祢",699,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("仰望主",700,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("与祢相遇",701,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("与你有约",702,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("云上太阳&在耶稣里我们是一家人",703,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("赞美之泉",704,getRandImageUrl(),"null!");mDao.insert(zms);

            zms=new ZMS("种子",706,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("这一生最美的祝福",707,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("展开清晨的翅膀",708,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("主永活在我心",709,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("主啊，陶造我",710,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("主恩典够我用",711,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("走出去",712,getRandImageUrl(),"null!");mDao.insert(zms);
            zms=new ZMS("最真的爱",713,getRandImageUrl(),"null!");mDao.insert(zms);


            return null;
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
    }


}
