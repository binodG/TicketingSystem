/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import com.leapfrog.springFramework.enitity.User;


/**
 *
 * @author BkoNod
 */
public interface UserDAO extends GenericDAO<User> {
    User checkUsername(String username,String password);
    int countUsers();
}
