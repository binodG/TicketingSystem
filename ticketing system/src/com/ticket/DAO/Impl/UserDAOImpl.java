/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.DAO.Impl;

import com.ticket.DAO.UserDAO;
import com.ticket.entity.User;
import com.ticket.utility.dbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BkoNod
 */
public class UserDAOImpl implements UserDAO {
 dbConnection dbCon=new dbConnection();
    @Override
    public int Insert(User u) {
    try {
            String sql = "INSERT INTO tbl_user(username,password,role) values(?,?,?)";
            dbCon.open();
            PreparedStatement stmt = dbCon.initStatement(sql);
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getRole());
            int result = dbCon.executeUpdate(stmt);
            dbCon.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public List<User> GetAll() {
     try {
         List<User> clientList = new ArrayList<>();
         String sql = "SELECT *FROM tbl_user";
         dbCon.open();
         PreparedStatement stmt=dbCon.initStatement(sql);
         ResultSet rs = dbCon.executeQuery(stmt);
         while (rs.next()) {
             User client = new User();
             client.setUid(rs.getInt("user_id"));
             client.setUsername(rs.getString("username"));
             client.setPassword(rs.getString("password"));
             client.setRole(rs.getString("role"));
             clientList.add(client);
             
         }
         dbCon.close();
              
         return clientList;
     } catch (SQLException | ClassNotFoundException ex) {
         Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    return null;

    }

    @Override
    public User GetByParam(String username, String password) {
    List<User> list=GetAll();
    for(User u:list)
    {
       if(u.getUsername().equals(username) && u.getPassword().equals(password))
       {
         return u;
       }
    }
    return null;
    }
    
    public static void main(String[] args) {
        User u=new User();
        u.setUsername("Binod");
        u.setPassword("Binod");
        u.setRole("sellers");
        UserDAOImpl obj=new UserDAOImpl();
        obj.Insert(u);
    }
}
