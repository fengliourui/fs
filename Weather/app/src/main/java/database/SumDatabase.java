package database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(version = 1, entities = {Sum.class},exportSchema = false)
@TypeConverters(WeatherConverter.class)
public abstract class SumDatabase extends RoomDatabase {
    public abstract SumDao sumDao();
    public  static  SumDatabase sInstance;

    public static SumDatabase getSumDatabase (Context context)
    {
     if(sInstance==null)
     {
         sInstance= Room.databaseBuilder(context.getApplicationContext(),SumDatabase.class,"weather").build();
     }
     return  sInstance;
    }


}
