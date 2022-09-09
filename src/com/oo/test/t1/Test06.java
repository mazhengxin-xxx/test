package com.oo.test.t1;
import com.oo.test.utils.DButil;

import java.sql.*;
public class Test06 {
    public static void main(String[] args) {
        Connection conn =null;
        Statement stmt =null;

        try {
            conn = DButil.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql1 ="update shiyan set money=money-1000 where name='1' and money>0";
            int i=stmt.executeUpdate(sql1);
            String sql2 ="update shiyan set money=money+1000 where name='2'";
            int j=stmt.executeUpdate(sql2);
            if(i==1&&j==1){//次数执行都是一提交，  执行次数为一不设置if
                conn.commit();
            }else{
                throw new Exception("youmeizhiixngde");
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            DButil.close(conn,stmt,null);
        }
    }
}
