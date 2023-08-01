/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ADMIN;

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
public class ViewUserBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bid = req.getParameter("bid");
        int uid = Integer.parseInt(bid);
        User u = new User();
        Blog bl = new Blog();
        User user = u.getUserByAid(uid);
        List<Blog> data = bl.getBlogByUserID(user);
        req.setAttribute("name", user.getName());
        req.setAttribute("data", data);
        req.getRequestDispatcher("ViewUserBlog.jsp").forward(req, resp);
        
    }
    
}
