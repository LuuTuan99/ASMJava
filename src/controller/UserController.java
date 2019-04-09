package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");
          req.setAttribute("title","Register Page");
          req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(fullname,username,password);
        if (!user.isValid()){
            HashMap<String, ArrayList<String>> errors = user.getErrors();
            req.setAttribute("title","Trang dang ki");
            req.setAttribute("user",user);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

        UserModel userModel = new UserModel();
        userModel.insert(user);

        resp.getWriter().println("Submit Success!");
    }


    }



