package controller;

import entity.User;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setCharacterEncoding("UTF-8");
         String username = req.getParameter("username");
         String password = req.getParameter("password");
        User user = checkLogin(username,password);
        if (user!=null){
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser",user.getUsername());
            System.out.println("Login Success!");
            resp.sendRedirect("/index.jsp");
        }else {
            resp.getWriter().println("Vui long nhap dung thong tin toan khoan");
        }
    }

    private User checkLogin(String username, String password) {
        User user = userModel.getByUser(username,password);
        if (user!=null){
            return  user;
        }
        return null;
    }
}
