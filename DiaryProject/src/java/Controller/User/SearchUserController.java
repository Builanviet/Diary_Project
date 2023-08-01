/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.User;

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
public class SearchUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User u = new User();
        List<User> list = u.getUserByName(username);
        String mess = "";
        if(list.isEmpty()){
            mess = "NO RESULT!";
        }else{
            mess = "CLICK USER TO READ THEIR STORIES:";
        }
        req.setAttribute("mess", mess);
        req.setAttribute("data", list);
        req.getRequestDispatcher("SearchUser.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    }
    
}
