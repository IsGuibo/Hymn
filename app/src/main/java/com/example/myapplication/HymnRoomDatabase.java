package com.example.myapplication;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
@Database(entities = {Hymn.class}, version = 6,exportSchema = false)
public abstract class HymnRoomDatabase extends RoomDatabase {
    public abstract DAO wordDao();
    private static volatile HymnRoomDatabase INSTANCE;
    static HymnRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HymnRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HymnRoomDatabase.class, "word_database")
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

        private final DAO mDao;

        PopulateDbAsync(HymnRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
           new Init(mDao);
           Init.initDate();
           return null;
        }
       
    }


}
