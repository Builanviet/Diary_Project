/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ADMIN;

import Model.Account;
import Model.Blog;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ListBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Blog bl = new Blog();
        Account u = new Account();
        List<Account> acc = u.getAllAccount();
        List<Blog> data = bl.getAllBlog();
        HttpSession session = req.getSession();
        session.setAttribute("acc", acc);
      
        req.setAttribute("data", data);
        req.getRequestDispatcher("ListBlog.jsp").forward(req, resp);
       
      
   }
    
}
