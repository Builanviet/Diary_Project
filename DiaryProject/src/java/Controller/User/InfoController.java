/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;

import Model.Account;
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
public class InfoController extends HttpServlet {
     public boolean datecondition(String date){
        LocalDate dob = LocalDate.parse(date);
        Period age = Period.between(dob,LocalDate.now());
        if(age.getYears() >= 16) return true;
        else return false;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String name = req.getParameter("name");
      int gender = 0;
      if(req.getParameter("gender").equals("Male")){
          gender = 1;
      }else{
          gender = 0;
      }
     
      String b = req.getParameter("dob");
     
      if(!datecondition(b)){
          req.setAttribute("mess", "User must be older than 16");
          req.getRequestDispatcher("Info.jsp").forward(req, resp);
      }else{
          Account p = new Account();
          User u = new User();
          HttpSession session = req.getSession();
          String s = (String)session.getAttribute("username");
          Account a = p.checkAccountExist(s);
          u.signUp(name, gender, b, a);
          req.setAttribute("mess", "Successfully signup");
          req.getRequestDispatcher("Login.jsp").forward(req, resp);
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
