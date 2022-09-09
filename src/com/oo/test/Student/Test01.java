package com.oo.test.Student;

import com.oo.test.pojo.Student;
import com.oo.test.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test01 {
    //增加
    public static int insert(Student student){
        Connection conn=null;
        PreparedStatement ps=null;
        int readCount=0;
        try {
            conn = DButil.getConnection();
            System.out.println(conn);
            String name=student.getName();
            String sex =student.getSex();
            int age =student.getAge();
            //通过student对象获得值付给SQL语句值
            String sql="insert into student(name,sex,age) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,sex);
            ps.setInt(3,age);
            readCount=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,null);
        }
        return readCount;
    }

    //删除
    public static int delete(Student student){
        Connection conn=null;
        PreparedStatement ps=null;
        int readCount=0;
        try {
            conn = DButil.getConnection();
            String name=student.getName();
            String sex =student.getSex();
            int age =student.getAge();
            //通过student对象获得值付给SQL语句值
            String sql="delete from student where name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            readCount=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,null);
        }
        return readCount;
    }
    //修改
    public static int update(Student student,int i){
        Connection conn=null;
        PreparedStatement ps=null;
        int readCount=0;
        try {
            conn = DButil.getConnection();
            int id = student.getId();
            String name=student.getName();
            String sex =student.getSex();
            int age =student.getAge();
            //通过student对象获得值付给SQL语句值
            String sql="update student set name=? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,i);
            readCount=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,null);
        }
        return readCount;
    }
    //查询所有
    public static List<Student> selectAll(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Student> list =new ArrayList<>();
        try {
            conn = DButil.getConnection();
            String sql="select * from student";
            ps = conn.prepareStatement(sql);
            rs=  ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                Student student =new Student(id,name,sex,age);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,null);
        }
        return list;
    }

    //查某一个
    public static  Student selectOne(int i){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs= null;
        Student student=null;
        try {
            conn = DButil.getConnection();
            String sql="select * from student where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,i);
            rs = ps.executeQuery();
            if (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                student=new Student(id,name,sex,age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButil.close(conn,ps,null);
        }
        return student;
    }
}
