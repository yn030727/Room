package com.example.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student student);
    @Delete
    void deleteStudent(Student student);
    @Update
    void updateStudent(Student student);
    //通过整个Student类查询
    @Query("SELECT * FROM student")
    LiveData<List<Student>> getStudentList();
    //通过Student类中的id字段查询
    @Query("SELECT * FROM student WHERE id =:id")
    Student getStudentById(int id);
}
