/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author santosh
 */
public class dbConnection {
    
    Connection conn = null;
    PreparedStatement stmt;

    public void open() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/ticketsystem", "root", "");

    }
    public  PreparedStatement initStatement(String sql) throws SQLException{
    stmt=conn.prepareStatement(sql);
    return stmt;
    
    }
    public int executeUpdate(PreparedStatement stmt) throws SQLException{
    return stmt.executeUpdate();
    }
    public ResultSet executeQuery(PreparedStatement stmt) throws SQLException{
     return stmt.executeQuery();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;

        }

    }

    
    
}
