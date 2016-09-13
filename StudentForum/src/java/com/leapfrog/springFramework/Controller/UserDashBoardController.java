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
import com.leapfrog.springFramework.DAO.QuestionDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.EBooks;
import com.leapfrog.springFramework.enitity.ModalPapers;
import com.leapfrog.springFramework.enitity.Programme;
import com.leapfrog.springFramework.enitity.Question;
import com.leapfrog.springFramework.enitity.User;
import com.leapfrog.springFramework.enitity.faculties;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class UserDashBoardController {

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
    @Autowired
    private QuestionDAO daoQuestion;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userDashboard(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("USER");

        if (session.getAttribute("USER") == null) {
            mv.setViewName("userLogin");

        } else {
            List<faculties> facList = daoFac.getALL();
            List<Programme> progList = daoProg.getALL();
            List<Course> courseList = daoCourse.getALL();
            List<Question> questionList = daoQuestion.getByUserId(user.getUserId());

            List<EBooks> bookList = bookDao.getByUserId(user.getUserId());
            List<ModalPapers> modalList = modalDao.getByUserId(user.getUserId());

            mv.addObject("facList", facList);
            mv.addObject("progList", progList);
            mv.addObject("courseList", courseList);
            mv.addObject("bookList", bookList);
            mv.addObject("modalList", modalList);
            mv.addObject("questionList", questionList);
            mv.setViewName("everyOne/UserDashBoard");
        }
        return mv;
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public void displayImage(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = request.getParameter("image");
            FileInputStream fis = null;
            if (fileName != null) {
                fis = new FileInputStream(new File(fileName));
                BufferedInputStream bis = new BufferedInputStream(fis);
                response.setContentType("text/html");
                BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
                for (int data; (data = bis.read()) > -1;) {
                output.write(data);
                }
            }
        } catch (IOException e) {

        } finally {
            // close the streams
        }
    }

}
