package com.bdqn.dao;

import com.bdqn.entity.Login;

import java.sql.*;

//模型层 处理登入
public class LoginDAO {

    public int login(Login login){
        //boolean flag=false;//登入成功与否的标识
        int count=-1;//-1:系统异常； 0：用户账号或密码错误； 1：登入成功
        int result=-1;
        Connection connection=null;
        PreparedStatement pstatement=null;
        ResultSet rs=null;
        try {
            //使用JDBC连接mysql数据库
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","a1157724662");
            String sql="select count(*) from login where uname=? and upwd=?";
            pstatement=connection.prepareStatement(sql);
            pstatement.setString(1,login.getName());
            pstatement.setString(2,login.getPwd());

            //接受查询结果，判断是否成功
            rs=pstatement.executeQuery();
            if(rs.next()){
                result=rs.getInt(1);
            }
            //判断成功或者账号或密码错误
            if(result>0){
                count=1;
            }else{
                count=0;
            }
            return count;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //系统异常为返回-1
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally{
            try {
                //关闭流
                if (rs!=null) rs.close();
                if (pstatement!=null) pstatement.close();
                if(connection!=null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
