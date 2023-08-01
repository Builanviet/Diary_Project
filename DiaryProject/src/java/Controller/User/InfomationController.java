/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;

import Model.Account;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class InfomationController extends HttpServlet {
    public boolean datecondition(String date){
        LocalDate dob = LocalDate.parse(date);
        Period age = Period.between(dob,LocalDate.now());
        if(age.getYears() >= 16) return true;
        else return false;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String name = req.getParameter("name");
        int gender = 0;
        Account acc = user.getAccount();
        int id = user.getId();
        if(req.getParameter("gender").equals("Male")){
          gender = 1;
        }else{
          gender = 0;
        }
      
         String b = req.getParameter("dob");
        
      if(!datecondition(b)){
          req.setAttribute("mess", "You must be older than 16");
          req.getRequestDispatcher("Information.jsp").forward(req, resp);
      }else{
          User a = new User();
          a.updateUser(user.getId(),name, gender, b, user.getAccount().getId());
          session.removeAttribute("user");
          User u = a.getUserbyAccount(acc);
          session.setAttribute("user", u);
          resp.sendRedirect("home");
      }
       
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("data",user);
        req.getRequestDispatcher("Information.jsp").forward(req, resp); 
        }
    
}
