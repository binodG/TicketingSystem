/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.DAO;

import com.ticket.entity.User;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface UserDAO {
    int Insert(User u);
    List<User> GetAll();
    User GetByParam(String param,String Param);
    
    
}
