/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.CourseDAO;
import com.leapfrog.springFramework.DAO.ProgrammeDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.Programme;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BkoNod
 */
@Controller
public class CourseController {
    @Autowired
    private ProgrammeDAO daoProg;
    
    @Autowired
    private CourseDAO dao;
    
    @RequestMapping(value = "/admin/insertsubject",method = RequestMethod.POST)
    public String insertCourse(@RequestParam Map<String,String> parVal)
    {
      int programmeID=Integer.parseInt(parVal.get("programme"));
      String courseName=parVal.get("course");
      String sem=parVal.get("semester");
      
      Programme objprog=new Programme();
      objprog.setProgrammeId(programmeID);
       
      
      Course co=new Course();
      co.setCourseName(courseName);
      co.setProgramme(objprog);
      co.setSemester(Integer.parseInt(sem));
      Course existCo=dao.CheckCourse(courseName);
      if(existCo!=null)
      {
          return "redirect:"+"../admin/subject?q=exist";
   
      }
      else{
      dao.insert(co);
      }
      return "redirect:"+"../admin/subject";
    }
    
    
    @RequestMapping(value="/admin/viewsubject",method = RequestMethod.GET)
    public ModelAndView adminPanelviewsubject()
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<Course> list=dao.getALL();
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewsubject");
      return mv;
    }
    @RequestMapping(value="/admin/searchsubject",method = RequestMethod.POST)
    public ModelAndView adminPanelSearchCourse(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      String param=parVal.get("searchkey");
      List<Course> list=dao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewsubject");
      return mv;
    }
    
    @RequestMapping(value="/admin/updatesubject/{id}",method = RequestMethod.GET)
    public ModelAndView UpdateCourse(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      
      List<Programme> list=daoProg.getALL();
      mv.addObject("programmeList",list);
      Course co=dao.getByID(id);
      mv.addObject("objCourse",co);
      mv.addObject("retValue", "editsubject");
      return mv;
    }
    
    @RequestMapping(value = "/admin/editsubject",method = RequestMethod.POST)
    public String EditCourse(@RequestParam Map<String,String> parVal)
    {
      int programmeId=Integer.parseInt(parVal.get("programme"));
      int id=Integer.parseInt(parVal.get("hidden"));
      String courseName=parVal.get("course");
      String sem=parVal.get("semester");
      Course course=new Course();
      Programme program=new Programme();
      
      program.setProgrammeId(programmeId);
      course.setCourseId(id);
      course.setCourseName(courseName);
      course.setProgramme(program);
      course.setSemester(Integer.parseInt(sem));
      dao.update(course);
      return "redirect:"+"../admin/viewsubject";
    
    }
    
    @RequestMapping(value="/admin/deletesubject/{id}",method = RequestMethod.GET)
    public String DeleteCourse(@PathVariable("id") int id)
    {
        
      dao.delete(id);
      return "redirect:"+"../viewsubject";
      
    }
    
     @RequestMapping(value = "/admin/GetAllCourse", method = RequestMethod.GET)
    public  @ResponseBody List<Course> GetAllCourse() 
    {
         List<Course> list=dao.getALL();
         return list;
         }
    
    
}
