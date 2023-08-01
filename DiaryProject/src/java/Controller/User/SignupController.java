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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Dell
 */
public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      String repassword = req.getParameter("repassword");
      
      if(!password.equals(repassword)){
          req.setAttribute("mess", "Passwords are not the same!");
          req.getRequestDispatcher("Signup.jsp").forward(req, resp);
      }else{
          Account p = new Account();
          
          if(p.checkAccountExist(username) == null){
              p.signUp(username, password);
              HttpSession session = req.getSession();
              session.setAttribute("username", username);
            
              req.getRequestDispatcher("Info.jsp").forward(req, resp);
          }else{
              req.setAttribute("mess", "User exists!");
              req.getRequestDispatcher("Signup.jsp").forward(req, resp);
          }
          
      }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
   
}
