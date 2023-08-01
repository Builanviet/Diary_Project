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
public class EditHomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int id = (int)session.getAttribute("bid");
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        Date date1 = new Date();     
        Date date2 = null;              
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(UpdateBlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(date2.compareTo(date1) > 0){
          req.setAttribute("mess", "Update failed due to date");
          req.getRequestDispatcher("ManageBlog.jsp").forward(req, resp);
        }else{
        String image = req.getParameter("image");
        String text = req.getParameter("text");
        User u = (User) session.getAttribute("user");
        
        Blog a = new Blog();
        a.updateBlog(id, title, date, image, text, u.getId());
        session.removeAttribute("bid");
        resp.sendRedirect("home");
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String bid = req.getParameter("bid");
        Blog a = new Blog();
        int c= Integer.parseInt(bid);
        Blog b = a.getBlogById(c);
        HttpSession session = req.getSession();
        session.setAttribute("bid",c);
        req.setAttribute("detail",b);
        req.getRequestDispatcher("UpdateHomeBlog.jsp").forward(req, resp);    }
    }
   
