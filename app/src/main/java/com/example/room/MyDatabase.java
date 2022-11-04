package com.example.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

//@Database标签用于告诉系统这是Room数据库对象
//entities属性用于指定该数据库有哪些表（建立多张表，用逗号隔开）
//version属性用于指定数据库版本号
@Database(entities = {Student.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="my_db";
    private static MyDatabase databaseInstance;
    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //执行升级的相关操作
        }
    };
    public static synchronized MyDatabase getInstance(Context context){
        if(databaseInstance==null){
            //创建数据库实例
            databaseInstance= Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DATABASE_NAME).build();
        }
        Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .addMigrations(MIGRATION_1_2).build();
        return databaseInstance;
    }
    public abstract StudentDao studentDao();

}
