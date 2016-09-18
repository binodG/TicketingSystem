/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.DAO.Impl;

import com.ticket.DAO.SitsDAO;
import com.ticket.entity.Sits;
import com.ticket.utility.dbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public class SitsDAOImpl implements SitsDAO {

    dbConnection dbCon = new dbConnection();

    @Override
    public int insert(Sits s) {
        try {
            String sql = "INSERT INTO sits(sit_number,status) values(?,?)";
            dbCon.open();
            PreparedStatement stmt = dbCon.initStatement(sql);
            stmt.setString(1, s.getSitnumber());
            stmt.setString(2, s.getStatus());

            int result = dbCon.executeUpdate(stmt);
            dbCon.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    @Override
    public List<Sits> GetAll() {
        try {
            List<Sits> sitList = new ArrayList<>();
            String sql = "SELECT * FROM sits";
            dbCon.open();
            PreparedStatement stmt = dbCon.initStatement(sql);
            ResultSet rs = dbCon.executeQuery(stmt);
            while (rs.next()) {
                Sits s = new Sits();
                s.setSitnumber(rs.getString("sit_number"));
                s.setStatus(rs.getString("status"));
                sitList.add(s);

            }
            dbCon.close();

            return sitList;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public int update(Sits s) {
        try {
            String sql = "UPDATE sits SET status=? where sit_number=? ";
            dbCon.open();
            PreparedStatement stmt = dbCon.initStatement(sql);
            stmt.setString(1, s.getStatus());
            stmt.setString(2, s.getSitnumber());

            int result = dbCon.executeUpdate(stmt);
            dbCon.close();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

}
