/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import com.leapfrog.springFramework.enitity.Answer;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface AnswerDAO {
    void insert(Answer a);
    List<Answer> getAnswers(int q_id);
    
}
