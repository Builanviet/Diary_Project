/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;


import Model.Account;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account p = new Account();
        Account a = p.login(username, password);
        if(a == null){
            req.setAttribute("mess", "Wrong user or pass");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }else{
            User b = new User();
            User c = b.getUserbyAccount(a);
            HttpSession session = req.getSession();
            session.setAttribute("user", c);
            resp.sendRedirect("home");
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Login.jsp");
    }
    
}
