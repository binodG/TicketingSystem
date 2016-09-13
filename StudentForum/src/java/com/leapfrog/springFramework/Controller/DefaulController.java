/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.EBooksDAO;
import com.leapfrog.springFramework.DAO.ModalPapersDAO;
import com.leapfrog.springFramework.DAO.QuestionDAO;
import com.leapfrog.springFramework.DAO.UserDAO;
import com.leapfrog.springFramework.enitity.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BkoNod
 */
@Controller
@RequestMapping(value="/")
public class DefaulController {
    @Autowired
    QuestionDAO questionDao;
    @Autowired
    UserDAO userDao;
    @Autowired
    EBooksDAO bookDao;
    @Autowired
    ModalPapersDAO modalDao;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index()
    {
      ModelAndView mv=new ModelAndView("everyOne/index");
      List<Question> list=questionDao.getALL();
      int member=userDao.countUsers();
      int books=bookDao.countBooks();
        System.out.println("books:"+books);
      int modal=modalDao.coutModals();
        System.out.println(modal+"mod");
      int post=books+modal;
      mv.addObject("posts",post);
      mv.addObject("member",member);
      mv.addObject("questionList",list);
      return mv;
    }
    
}
