/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DBContext.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class User {
    private int id;
    private String name;
    private int gender;
    private String dob;
    private int isWritter;
    private int isAdmin;
    private Account account;
    private int aid;
    public User(){
        connect();
    }
    public User(int id, String name, int gender, String dob, int isWritter, int isAdmin,Account account) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.isWritter = isWritter;
        this.isAdmin = isAdmin;
      this.account = account;
        connect();
    }
    public User(int id, String name, int gender, String dob, int isWritter, int isAdmin,int aid) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.isWritter = isWritter;
        this.isAdmin = isAdmin;
      this.aid =aid;
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
    public void signUp(String name,int gender,String dob,Account a){
        try {
             String strSelect = "insert into [User] "+
             "values(?,?,?,0,0,?)";        
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, name); 
            pstm.setInt(2, gender); 
            pstm.setString(3, dob);
            pstm.setInt(4, a.getId());
            pstm.executeUpdate();          
        } catch (Exception e) {
            System.out.println("signUps: " + e.getMessage());
        }      
    }   
//    public User getUserbyId(int id){
//        try {
//            String strSelect = "select [User].id,[name],gender,dob,isWritter,isAdmin,aid \n" +
//"from [User] left join Account on [User].aid = Account.id where id = ? ";                   
//            pstm = cnn.prepareStatement(strSelect);
//            pstm.setInt(1,id );           
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                return new User(rs.getInt(1),
//                    rs.getString(2),
//                    rs.getInt(3),
//                    rs.getString(4),
//                    rs.getInt(5),
//                    rs.getInt(6),
//                    rs
//                );
//                      
//            }
//        } catch (Exception e) {
//            System.out.println("checkAcc: " + e.getMessage());
//        }
//        return null;
//    }
    public User getUserbyAccount(Account acc){
        try {
            String strSelect = "select [User].id,[name],gender,dob,isWritter,isAdmin,aid \n" +
"from [User] left join Account on [User].aid = Account.id where aid = ? ";                   
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1,acc.getId() );           
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    acc
                );
                      
            }
        } catch (Exception e) {
            System.out.println("getUserbyAccount: " + e.getMessage());
        }
        return null;
    }
 
    
    public List<User> getUserByName(String str){
        List<User> data = new ArrayList<>();
         try{
            String strSelect = "select * from [User] where name LIKE ?";                   
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,"%"+str+"%");           
            rs = pstm.executeQuery();
            
            while (rs.next()) {
               
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int gender =rs.getInt(3);
                String dob =rs.getString(4);
                int isWritter = rs.getInt(5);
                int isAdmin=rs.getInt(6);
                int aid = rs.getInt(7);
//                Account b = a.getAccountByID(aid);
                User u = new User(id, name, gender, dob, isWritter, isAdmin, aid);
                  data.add(u);
            }
        } catch (Exception e) {
            System.out.println("getUserByName: " + e.getMessage());
        }
        return data;
    }
public User getUserByAid(int aid){
        List<User> data = new ArrayList<>();
         try{
            String strSelect = "select * from [User] where aid = ?";                   
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1,aid);           
            rs = pstm.executeQuery();
            
             while (rs.next()) {
                 return new User(
                         rs.getInt(1),
                         rs.getString(2),
                         rs.getInt(3),
                         rs.getString(4),
                         rs.getInt(5),
                         rs.getInt(6),
                         rs.getInt(7));
//                Account b = a.getAccountByID(aid);

             }
        } catch (Exception e) {
            System.out.println("getUserByName: " + e.getMessage());
        }
        return null;
    }
    
 public void deleteUser(int aid){
        try {
             String strSelect = "delete from [User] where aid = ?";        
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, aid); 
            pstm.executeUpdate();          
        } catch (Exception e) {
            System.out.println("deleteUser: " + e.getMessage());
        }   
    }
 
 public void updateUser(int id,String name,int gender,String dob,int aid){
        try {
            String strAdd = "update [User] \n" +
"set name= ?,\n" +
"gender = ?,\n" +
"dob = ?,\n" +
"aid = ? where id = ?";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, name);
            pstm.setInt(2,gender);
            pstm.setString(3, dob);
            pstm.setInt(4,aid);
            pstm.setInt(5,id);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updateUser: " + e.getMessage());
        }
        }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getIsWritter() {
        return isWritter;
    }

    public void setIsWritter(int isWritter) {
        this.isWritter = isWritter;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

  
    
    
}
