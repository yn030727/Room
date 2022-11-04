package com.example.room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //类似Kotlin的单例类调用方法
        MyDatabase myDatabase = MyDatabase.getInstance(this);
        String name = "严宁";
        int age = 20;
        //进行数据库的操作
        myDatabase.studentDao().insertStudent(new Student(name, age));

        //在Activity中实例化StudentViewModel，并监听LiveData的变化
        StudentViewModel studentViewModel= new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(StudentViewModel.class);
        studentViewModel.getLiveDataStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                /*studentList.clear();
                studentList.addAll(students);
                studentAdapter.notifyDataSetChanged();*/
            }
        });
    }
}