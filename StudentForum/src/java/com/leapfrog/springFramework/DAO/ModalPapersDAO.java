/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.DAO;

import com.leapfrog.springFramework.enitity.ModalPapers;
import java.util.List;

/**
 *
 * @author BkoNod
 */
public interface ModalPapersDAO extends GenericDAO<ModalPapers> {
    List<ModalPapers> getByUserId(int param);
    List<ModalPapers> getByCourseId(int param);
    ModalPapers CheckModal(String param);
    int coutModals();
}
