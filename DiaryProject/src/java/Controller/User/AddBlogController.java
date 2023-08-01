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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class AddBlogController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String image = req.getParameter("image");
        String text = req.getParameter("text");
        
        Date date1 = new Date();     
        Date date2 = null;        
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(date2.compareTo(date1) > 0){
          req.setAttribute("mess", "Date after current date");
          req.getRequestDispatcher("AddBlog.jsp").forward(req, resp);
        }else{
           Blog a =new Blog();
           
           HttpSession session = req.getSession();
           User user = (User)session.getAttribute("user");
           a.addBlog(title, date, image, text, user.getId());
           
           resp.sendRedirect("manageBlog");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    
}
