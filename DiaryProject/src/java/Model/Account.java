/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DBContext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Account {
    private int id;
    private String username;
    private String password;
   
    
    public Account(){
        connect();
    }
    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        connect();
    }
    Connection cnn;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstm;
    
    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {
        }
    }
     public List<Account> getAllAccount(){
        List<Account> data = new ArrayList<>();
        try{
            String strSelect = "select * from Account";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                Account acc = new Account(id, username, password);
                data.add(acc);
            }
        }catch(Exception e){
             System.out.println("getAllAccount: " + e.getMessage());
        }
        return data;
    }
    
    public void deleteAccount(int bid){
        try {
             String strSelect = "delete from Account where id = ?";        
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, bid); 
            pstm.executeUpdate();          
        } catch (Exception e) {
            System.out.println("deleteAccount: " + e.getMessage());
        }   
    }
    public List<Account> getAllAccountExceptAdmin(){
        List<Account> data = new ArrayList<>();
        try{
            String strSelect = "select Account.id,Account.[User],[Password] from Account left join [User] \n" +
"on Account.id = [User].aid where isAdmin = 0";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                Account acc = new Account(id, username, password);
                data.add(acc);
            }
        }catch(Exception e){
             System.out.println("getAllAccountExceptAdmin: " + e.getMessage());
        }
        return data;
    }
    public Account login(String username, String password){
        try {
            String strSelect = "select * from Account "
                    + "where [User] = ? and "
                    + "[Password] = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3));
                       
            }
        } catch (Exception e) {
            System.out.println("login: " + e.getMessage());
        }
        return null;
    }
    
    public Account checkAccountExist(String username){
        try {
            String strSelect = "select * from Account "
                    + "where [User] = ? ";                   
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username);           
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3));
                      
            }
        } catch (Exception e) {
            System.out.println("checkAcc: " + e.getMessage());
        }
        return null;
    }
   
    public void signUp(String username, String password){
         try {
             String strSelect = "insert into Account "+
             "values(?,?)";        
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, username); 
            pstm.setString(2, password);
            pstm.executeUpdate();          
        } catch (Exception e) {
            System.out.println("signUp: " + e.getMessage());
        }       
    }
    public Account getAccountByID(int id){
        try {
            
             String strSelect = "select * from Account where id = ?";        
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, id); 
           pstm.executeQuery();
           while (rs.next()) {
                return new Account(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3));                      
            }
                     
        } catch (Exception e) {
            System.out.println("getaccbyID: " + e.getMessage());
        }   
        return null ;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    
}
