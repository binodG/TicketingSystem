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
import com.leapfrog.springFramework.DAO.UserDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.EBooks;
import com.leapfrog.springFramework.enitity.ModalPapers;
import com.leapfrog.springFramework.enitity.Programme;
import com.leapfrog.springFramework.enitity.User;
import com.leapfrog.springFramework.enitity.faculties;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BkoNod
 */
@Controller
public class LoginController {

    @Autowired
    private UserDAO dao;
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

    @RequestMapping(value = "/loggedIn", method = RequestMethod.POST)
    public String LoginUser(@RequestParam Map<String, String> parVal, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String username = parVal.get("username");
        String password = parVal.get("password");

        User user = dao.checkUsername(username, password);
        if (user != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("USER", user);
            session.setAttribute("user", user.getUsername());
            session.setAttribute("ROLE", user.getRole());
            
            //To remove login msg from discuss forum
            session.removeAttribute("loginMsg");
            return "redirect:" + "/user";
        }
        return "redirect:" + "/userlogin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String Logout(@RequestParam Map<String, String> parVal, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:" + "/home";
    }

    @RequestMapping(value = "/login/signup", method = RequestMethod.POST)
    public String singupUser(@RequestParam Map<String, String> parVal, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String firstname = parVal.get("firstName");
        String lastname = parVal.get("lastName");
        String username = parVal.get("username");
        String password = parVal.get("password");
        String email = parVal.get("email");

        User user = new User();

        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole("USERS");
        User existUser = dao.checkUsername(username, password);
        if (existUser != null) {
            return "redirect:" + "../userlogin?q=usernameExist";
        } else {
            dao.insert(user);
            
        }
        return "redirect:" + "../userlogin";

    }

    @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("Login/login");

        return model;

    }

    @RequestMapping(value = "/check/login", method = RequestMethod.POST)
    public String LoginAdmin(@RequestParam Map<String, String> parVal, HttpServletRequest request) {
        String username = parVal.get("username");
        String password = parVal.get("password");
        System.out.println(username + password);
        User user = dao.checkUsername(username, password);
        if (user != null && user.getRole().equalsIgnoreCase("ADMIN")) {
            HttpSession session = request.getSession(true);
            session.setAttribute("USER", user);
            session.setAttribute("ROLE", user.getRole());

        }
        return "redirect:" + "/admin";
    }

}
