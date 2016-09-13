/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import com.leapfrog.springFramework.enitity.Question;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface QuestionDAO extends GenericDAO<Question> {
    List<Question> getByUserId(int id);
   
   
}
