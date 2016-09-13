/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.UserDAO;
import com.leapfrog.springFramework.enitity.User;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class UserController {
     
    @Autowired
    private UserDAO dao;
    
    @RequestMapping(value = "/admin/adduser",method = RequestMethod.POST)
    public String AddUser(@RequestParam Map<String,String> parVal,HttpServletRequest request)
    {
      String firstname=parVal.get("firstName");
      String lastname=parVal.get("lastName");
      String username=parVal.get("username");
      String password=parVal.get("password");
      String email=parVal.get("email");
      String role=parVal.get("role");
      
      User user=new User();
      user.setFirstName(firstname);
      user.setLastName(lastname);
      user.setUsername(username);
      user.setPassword(password);
      user.setEmail(email);
      user.setRole(role);
       User existUser = dao.checkUsername(username, password);
        if (existUser == null) {
            dao.insert(user);
            HttpSession session = request.getSession(false);
            session.removeAttribute("adminmessage");
        } else {
            String message = "UserName " + existUser.getUsername() + " already exists,Try new One";
            HttpSession session = request.getSession(true);
            session.setAttribute("adminmessage", message);

        }
      
      
      return "redirect:"+"../admin/user";
      
    }
    @RequestMapping(value="/admin/viewuser",method = RequestMethod.GET)
    public ModelAndView adminPanelviewUser()
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<User> list=dao.getALL();
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewuser");
      return mv;
    }
    
    @RequestMapping(value="/admin/searchuser",method = RequestMethod.POST)
    public ModelAndView SearchUser(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("AdminPanel");
      String param=parVal.get("searchkey");
      List<User> list=dao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewuser");
      return mv;
    }
    
     @RequestMapping(value="/admin/updateuser/{id}",method = RequestMethod.GET)
    public ModelAndView UpdateUser(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      User user=dao.getByID(id);
      mv.addObject("retObjData",user);
      mv.addObject("retValue", "edituser");
      return mv;
    }
    
    @RequestMapping(value = "/admin/edituser",method = RequestMethod.POST)
    public String EditUser(@RequestParam Map<String,String> parVal)
    {
      
      int id=Integer.parseInt(parVal.get("hidden"));
      String firstname=parVal.get("firstName");
      String lastname=parVal.get("lastName");
      String username=parVal.get("username");
      String password=parVal.get("password");
      String email=parVal.get("email");
      
      User user=new User();
      user.setUserId(id);
      user.setFirstName(firstname);
      user.setLastName(lastname);
      user.setUsername(username);
      user.setPassword(password);
      user.setEmail(email);
      dao.update(user);
      
      return "redirect:"+"../admin/viewuser";
      
    }
    
    @RequestMapping(value="/admin/deleteuser/{id}",method = RequestMethod.GET)
    public String DeleteUser(@PathVariable("id") int id)
    {
        
      dao.delete(id);
     return "redirect:"+"../viewuser"; 
    }
    
    
    
    
    
    
    
}
