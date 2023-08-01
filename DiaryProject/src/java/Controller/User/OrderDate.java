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
import java.util.List;

/**
 *
 * @author Dell
 */
public class OrderDate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int idd = user.getId();     
         Blog  blog = new Blog();
        if(session.getAttribute("titlee")!= null) {
            String titlee = (String) session.getAttribute("titlee");
            
             List<Blog> list = blog.OrderDate(idd, titlee);
             session.removeAttribute("titlee");
             req.setAttribute("data", list);
             req.getRequestDispatcher("ManageBlog.jsp").forward(req, resp);
        }else{
            String titlee = "";
               List<Blog> list = blog.OrderDate(idd, titlee);
          
             req.setAttribute("data", list);
             req.getRequestDispatcher("ManageBlog.jsp").forward(req, resp);
        }
   
       
        
    }
    
}
