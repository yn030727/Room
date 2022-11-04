package com.example.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

//在StudentViewModel中实例化数据库
public class StudentViewModel extends AndroidViewModel {
    private MyDatabase myDatabase;
    private LiveData<List<Student>> liveDataStudent;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        myDatabase=MyDatabase.getInstance(application);
        liveDataStudent = myDatabase.studentDao().getStudentList();
    }
    //对外暴露LiveData<List<Student>>
    public LiveData<List<Student>> getLiveDataStudent(){
        return liveDataStudent;
    }
}
