package com.oo.test.controller;

import com.oo.test.DAO.StudentDao;
import com.oo.test.DAO.impl.StudentDaoImpl;
import com.oo.test.pojo.Student;

public class Test {
    public static void main(String[] args) {
        StudentDao studentDao=new StudentDaoImpl();
        /*Student student=new Student();
        student.setName("张三");
        student.setSex("nan");
        student.setAge(12);*/
        /*int delete = studentDao.delete(student);
        System.out.println(delete);*/
        /*int insert = studentDao.insert(student);
        System.out.println(insert);*/
        Student student1 = studentDao.selectOne(6);
        System.out.println(student1.getAge());
    }
}
