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

/**
 *
 * @author Dell
 */
public class DeleteAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String bid = req.getParameter("bid");
        Account a =new Account();
        User b = new User();
        Blog bl = new Blog();
       
        
        User u = b.getUserByAid(Integer.parseInt(bid));
        bl.deleteBlogByUserID(u.getId());
        b.deleteUser(Integer.parseInt(bid));
        a.deleteAccount(Integer.parseInt(bid));
        resp.sendRedirect("manageaccount");
    }
    
}
