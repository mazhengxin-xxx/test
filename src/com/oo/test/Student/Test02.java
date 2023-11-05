package com.oo.test.Student;

import com.oo.test.pojo.Student;

import java.util.Iterator;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        Student student1 = new Student("张三","male",17);
        /*int insertCount = Test01.insert(student1);
        System.out.println(insertCount);*/
        /*int delete = Test01.delete(student1);
        System.out.println(delete);*/
        /*int update = Test01.update(student1, 11);
        System.out.println(update);*/
       /* List<Student> students = Test01.selectAll();
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(next.getId()+" "+next.getName()+"  "+ next.getSex()+" "+next.getAge());
        }*/
        Student student = Test01.selectOne(4);
        System.out.println(student.getAge());


    }
}
