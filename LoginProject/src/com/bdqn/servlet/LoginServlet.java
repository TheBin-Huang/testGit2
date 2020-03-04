package com.bdqn.servlet;

import com.bdqn.dao.LoginDAO;
import com.bdqn.entity.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//控制器层，用于接受view层的请求，并分发给model处理
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("uname");//获取输入name为uname的参数 不是用getAttribute()获取！！
        String pwd=request.getParameter("upwd");//获取输入name为upwd的参数
        Login login = new Login(name,pwd);
        LoginDAO loginDao= new LoginDAO();
        //调用模型层的登入功能
        int result=loginDao.login(login);

        if(result>0){//登入成功跳转到welcome页面
            response.sendRedirect("welcome.jsp");
        }else if(result==0){//登入失败重新登入
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
