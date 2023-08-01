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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Blog {

    private int id;
    private String title;
    private String date;
    private String image;
    private String text;
    private int uid;
    private int favourite;

    public Blog() {
        connect();
    }

    public Blog(int id, String title, String date, String image, String text, int uid,int favourite) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.image = image;
        this.text = text;
        this.uid = uid;
        this.favourite = favourite;
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

    public List<Blog> getAllBlog() {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from Blog";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text, uid,favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getAllBlog: " + e.getMessage());
        }
        return data;
    }

    public List<Blog> getBlogByUserID(User user) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select Blog.id,title,[date],[image],[text],[uid],favourite from Blog left join \n" +
"                   [User] on Blog.uid=[User].id where uid =?";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setInt(1, user.getId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text, uid,favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getBlogbyUser: " + e.getMessage());
        }
        return data;
    }

    public List<Blog> getBlogByUserIDD(int idd) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from Blog where uid = ?";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setInt(1, idd);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text,uid, favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getBlogbyUser: " + e.getMessage());
        }
        return data;
    }
     public List<Blog> getBlogByFav(int idd) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from Blog where uid = ? and favourite = 1";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setInt(1, idd);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text,uid, favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getBlogbyUser: " + e.getMessage());
        }
        return data;
    }

    public List<Blog> OrderDate(int idd, String titlee) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from [Blog]\n"
                    + "where uid = ? and title like ? \n"
                    + "order by [date] DESC";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, idd);
            pstm.setString(2, "%" + titlee + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text, uid,favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getBlogbyUser: " + e.getMessage());
        }
        return data;
    }

    public void updateBlog(int id, String title, String date, String image, String text, int uid) {
        try {
            String strAdd = "update Blog "
                    + "set title = ?,"
                    + "date = ?,"
                    + "image = ?,"
                    + "text = ?,"
                    + "uid = ?,"
                    + "where id = ?";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, title);
            pstm.setString(2, date);
            pstm.setString(3, image);
            pstm.setString(4, text);
            pstm.setInt(5, uid);
            pstm.setInt(6, id);
           
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addBlog: " + e.getMessage());
        }

    }

    public Blog getBlogById(int bid) {

        try {
            String strSelect = "select * from Blog where id = ?";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setInt(1, bid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                return new Blog(id, title, date, image, text, uid,favourite);

            }
        } catch (Exception e) {
            System.out.println("getBlogbyID: " + e.getMessage());
        }
        return null;
    }


    public void deleteBlog(int id) {
        try {
            String strSelect = "delete from Blog where id = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteBlog: " + e.getMessage());
        }
    }
    public void favourite(int id){
        try {
            String strAdd = "update Blog "
                    + "set favourite = 1"                   
                    + "where id = ?";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setInt(1, id);          
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Favourite: " + e.getMessage());
        }
    }
      public void hate(int id){
        try {
            String strAdd = "update Blog "
                    + "set favourite = 0"                   
                    + "where id = ?";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setInt(1, id);          
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hate: " + e.getMessage());
        }
    }
    public void deleteBlogByUserID(int id) {
        try {
            String strSelect = "delete from Blog where uid = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteBlogByUserID: " + e.getMessage());
        }
    }

    public void addBlog(String title, String date, String image, String text, int uid) {
        try {
            String strAdd = "insert into Blog "
                    + "values(?,?,?,?,?,0)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, title);
            pstm.setString(2, date);
            pstm.setString(3, image);
            pstm.setString(4, text);
            pstm.setInt(5, uid);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addBlog: " + e.getMessage());
        }
    }

    public List<Blog> seachByName(String txtSearch, int uid) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from Blog where title LIKE ? and uid = ? ";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setString(1, "%" + txtSearch + "%");
            pstm.setInt(2, uid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                
                int favourite =rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text, uid,favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("searchByName: " + e.getMessage());
        }
        return data;
    }
    
    
     public List<Blog> seachByNameorText(String txtSearch) {
        List<Blog> data = new ArrayList<>();
        try {
            String strSelect = "select * from Blog where title LIKE ? or  text LIKE ? ";
            pstm = cnn.prepareStatement(strSelect);

            pstm.setString(1, "%" + txtSearch + "%");       
            pstm.setString(2,  "%" + txtSearch + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String date = rs.getString(3);
                String image = rs.getString(4);
                String text = rs.getString(5);
                int uid = rs.getInt(6);
                int favourite = rs.getInt(7);
                Blog p = new Blog(id, title, date, image, text, uid,favourite);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("searchByNameorText: " + e.getMessage());
        }
        return data;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

}
