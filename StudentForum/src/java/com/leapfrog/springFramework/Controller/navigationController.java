/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.CourseDAO;
import com.leapfrog.springFramework.DAO.EBooksDAO;
import com.leapfrog.springFramework.DAO.FacultiesDAO;
import com.leapfrog.springFramework.DAO.ModalPapersDAO;
import com.leapfrog.springFramework.DAO.ProgrammeDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.EBooks;
import com.leapfrog.springFramework.enitity.ModalPapers;
import com.leapfrog.springFramework.enitity.Programme;
import com.leapfrog.springFramework.enitity.User;
import com.leapfrog.springFramework.enitity.faculties;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BkoNod
 */
@Controller
@RequestMapping()
public class navigationController {

    @Autowired
    private FacultiesDAO daoFac;
    @Autowired
    private ProgrammeDAO daoProg;
    @Autowired
    private CourseDAO daoCourse;
    @Autowired
    private EBooksDAO bookDao;
    @Autowired
    private ModalPapersDAO modalDao;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("everyOne/index");
        return mv;
    }

    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    public ModelAndView Faculties() {
        ModelAndView mv = new ModelAndView("everyOne/faculties");
        List<faculties> facList = daoFac.getALL();
        List<Programme> progList = daoProg.getALL();
        List<Course> courseList = daoCourse.getALL();
        mv.addObject("facList", facList);
        mv.addObject("progList", progList);
        mv.addObject("courseList", courseList);
        return mv;
    }

    @RequestMapping(value = "/Gallery/{id}", method = RequestMethod.GET)
    public ModelAndView Gallery(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("everyOne/Gallery");

        List<Course> courseList = daoCourse.getCoursesBySem(id);
        List<EBooks> AllbookList = new ArrayList<EBooks>();
        List<EBooks> bookList = new ArrayList<EBooks>();
        if (courseList != null) {
            for (Course c : courseList) {
                bookList = bookDao.getByCourseId(c.getCourseId());
                if (bookList != null) {
                    AllbookList.addAll(bookList);
                }
            }

        }
        
        List<ModalPapers> AllmodalList = new ArrayList<ModalPapers>();
        List<ModalPapers> modalList = new ArrayList<ModalPapers>();
        if (courseList != null) {
            for (Course c : courseList) {
                modalList = modalDao.getByCourseId(c.getCourseId());
                if (modalList != null) {
                    AllmodalList.addAll(modalList);
                }
            }

        }
        
        if(AllbookList!=null)
        {
          mv.addObject("bookList",AllbookList);
        }

        
        if(AllmodalList!=null)
        {
          mv.addObject("modalList",AllmodalList);
        }

        return mv;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView singup() {
        ModelAndView mv = new ModelAndView("Login/signup");
        return mv;
    }

    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public ModelAndView UserDashBoard() {
        ModelAndView mv = new ModelAndView("Login/userLogin");
        return mv;
    }

   
    
    @RequestMapping(value = "/askquestion", method = RequestMethod.GET)
    public ModelAndView askQuestions() {
        ModelAndView mv = new ModelAndView("/Discuss/askQuestion");
        return mv;
    }
    
    

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPanel() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        return mv;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.POST)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        return mv;
    }

    @RequestMapping(value = "/admin/faculty", method = RequestMethod.GET)
    public ModelAndView adminPanelfaculty() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        mv.addObject("retValue", "faculty");
        return mv;
    }

    @RequestMapping(value = "/admin/programme", method = RequestMethod.GET)
    public ModelAndView adminPanelprogramme() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        List<faculties> list = daoFac.getALL();
        mv.addObject("facultyList", list);
        mv.addObject("retValue", "programme");
        return mv;
    }

    @RequestMapping(value = "/admin/subject", method = RequestMethod.GET)
    public ModelAndView adminPanelsubject() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        List<Programme> list = daoProg.getALL();
        mv.addObject("programmeList", list);
        mv.addObject("retValue", "subject");
        return mv;
    }

    @RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public ModelAndView adminPaneluser() {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        mv.addObject("retValue", "user");
        return mv;
    }

    @RequestMapping(value = "/admin/e-books", method = RequestMethod.GET)
    public ModelAndView adminPanelebook() throws IOException {
        ModelAndView mv = new ModelAndView("Admin/AdminPanel");
        List<faculties> facList = daoFac.getALL();
        List<Programme> progList = daoProg.getALL();
        List<Course> courseList = daoCourse.getALL();
        mv.addObject("facList", facList);
        mv.addObject("progList", progList);
        mv.addObject("courseList", courseList);
        mv.addObject("retValue", "e-books");
        return mv;
    }

}
