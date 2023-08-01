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
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Dell
 */
public class FindBlogByAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account a = new Account();
        User u = new User();
        Blog bl = new Blog();
        if(req.getParameter("acc").equals("all")){
            List<Blog> data = bl.getAllBlog();
            req.setAttribute("data", data);
            req.getRequestDispatcher("ListBlog.jsp").forward(req, resp); 
        }else{
        int id = Integer.parseInt(req.getParameter("acc"));
        User user = u.getUserByAid(id);
        List<Blog> data = bl.getBlogByUserID(user);
        req.setAttribute("data", data);
        req.getRequestDispatcher("ListBlog.jsp").forward(req, resp); 
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
