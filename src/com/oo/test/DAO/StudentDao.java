package com.oo.test.DAO;

import com.oo.test.pojo.Student;

import java.util.List;

public interface StudentDao {
    //定义四五个抽象
     int insert(Student student);//增
    //删
    int delete(Student student);
    //查所有、
    List<Student> selectAll();
    // 查一个
    Student selectOne(int i);
    // 改
    int update(Student student,int i);
}
