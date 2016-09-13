/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import com.leapfrog.springFramework.enitity.EBooks;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface EBooksDAO extends GenericDAO<EBooks> {
    List<EBooks> getByUserId(int param);
    List<EBooks> getByCourseId(int param);
    EBooks CheckBook(String param);
    int countBooks();
    
}
