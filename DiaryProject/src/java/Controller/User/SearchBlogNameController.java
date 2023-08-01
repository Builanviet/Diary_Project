/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;

import Model.Blog;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Dell
 */
public class SearchBlogNameController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtSearch = req.getParameter("text");
       
        Blog a =new Blog();
        HttpSession session = req.getSession();
        session.setAttribute("titlee", txtSearch);
        User user = (User)session.getAttribute("user");  
        List<Blog> b = a.seachByName(txtSearch,user.getId());
        req.setAttribute("data", b);
        req.getRequestDispatcher("ManageBlog.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
