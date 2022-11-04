package com.example.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//最上方需要加上@Entity标签，通过该标签将该类与Room中表关联起来。
//tablename属性可以为该表设置名字，如果不设置，则类名与表名相同
@Entity(tableName = "student")
public class Student {

    //PrimaryKey该字段作为表的主键
    //ColumnInfo标签用于设置该字段存储在数据库中表的名字，并指定字段的类型
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;
    @ColumnInfo(name = "name",typeAffinity = ColumnInfo.TEXT)
    public String name;
    @ColumnInfo(name="age",typeAffinity = ColumnInfo.TEXT)
    public int age;

    public Student(int id,String name,int age){
        this.id=id;
        this.age=age;
        this.name=name;
    }
    //因为Room只能识别一个构造器，如果希望定义多个构造器，你可以使用Ignore标签，让Room忽略这个构造器
    //同样，@Ignore标签还可以用于字段，使用@Ignore标签标记过的字段，Room不会持久化该字段的数据
    @Ignore
    public Student(String name, int age){
        this.name=name;
        this.age=age;
    }
}
