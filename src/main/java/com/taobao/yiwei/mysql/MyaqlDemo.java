package com.taobao.yiwei.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyaqlDemo {

	public static void main(String[] args) {
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String mysqlUrl = "jdbc:mysql://rds7ya4w83e8y81m1st2.mysql.rds.aliyuncs.com/intl";
        String mysqlUser = "intladmin";
        String mysqlPwd = "intladmin";
        String tblName = "student004";
 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();// 动态加载mysql驱动
            System.out.println("成功加载MySQL驱动程序");
            
            conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPwd);
            
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();
            sql = "create table " + tblName + "(NO char(20),name varchar(20),primary key(NO))";
            
            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != -1) {
                System.out.println("创建数据表成功");
                
                for (int i = 0; i < 10; i++) {
                	int index = 100 + i;
                	String name = "stu_" + i;
                    sql = "insert into " + tblName + "(NO,name) values('" + index + "','" + name + "')";
                    result = stmt.executeUpdate(sql);
                }
                sql = "select * from " + tblName;
                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                }
            }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
