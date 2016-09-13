/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface GenericDAO<T> {
    void insert(T t);
    void update(T t);
    void delete(int id);
    void update(int id); 
    T getByID(int id);
    List<T> getByParam(String param);
    List<T> getALL();
       
}
