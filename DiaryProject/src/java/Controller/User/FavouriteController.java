/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;

import Model.Blog;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class FavouriteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iid = req.getParameter("bid");
        int bid = Integer.parseInt(iid);
        Blog bl = new Blog();
        Blog a = bl.getBlogById(bid);
        if(a.getFavourite() == 0){
        bl.favourite(bid);
        resp.sendRedirect("home");
        }else{
            bl.hate(bid);
            resp.sendRedirect("home");
        }
    }
    
}
