/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.FacultiesDAO;
import com.leapfrog.springFramework.DAO.ProgrammeDAO;
import com.leapfrog.springFramework.enitity.Programme;
import com.leapfrog.springFramework.enitity.faculties;
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

@Controller
public class ProgrammeController {
    @Autowired
    private ProgrammeDAO dao;
    
    @Autowired
    private FacultiesDAO daoFac;
    
    @RequestMapping(value = "/admin/insertprogramme",method = RequestMethod.POST)
    public String insertProgramme(@RequestParam Map<String,String> parVal)
    {
      int faculty=Integer.parseInt(parVal.get("faculty"));
      String programme=parVal.get("programme");
      String type=parVal.get("type");
      String num=parVal.get("num");
      Programme prog=new Programme();
      faculties objfac=new faculties();
      objfac.setFacultyId(faculty);
     
      prog.setProgrammeName(programme);
      prog.setProgrammeType(type);
      prog.setNum(Integer.parseInt(num));
      prog.setFaculty(objfac);
      Programme existProg=dao.CheckProgramme(programme);
      if(existProg!=null)
      {
          return "redirect:"+"../admin/programme?q=exist";
      }else{
      dao.insert(prog);
      }
     return "redirect:"+"../admin/programme";
    }
    
    @RequestMapping(value="/admin/viewprogramme",method = RequestMethod.GET)
    public ModelAndView adminPanelviewprogramme()
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<Programme> list=dao.getALL();
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewprogramme");
      return mv;
    }
    
   @RequestMapping(value="/admin/searchprogramme",method = RequestMethod.POST)
    public ModelAndView SearchProgramme(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      String param=parVal.get("searchkey");
      List<Programme> list=dao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewprogramme");
      return mv;
    }
    
    
    @RequestMapping(value="/admin/updateprogramme/{id}",method = RequestMethod.GET)
    public ModelAndView Updatefaculty(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      
      List<faculties> list=daoFac.getALL();
      mv.addObject("facultyList",list);
      
      Programme prog=dao.getByID(id);
      mv.addObject("retObjData",prog);
      mv.addObject("retValue", "editprogramme");
      return mv;
    }
    
    @RequestMapping(value = "/admin/editprogramme",method = RequestMethod.POST)
    public String EditFaculties(@RequestParam Map<String,String> parVal)
    {
      int faculty=Integer.parseInt(parVal.get("faculty"));
      int id=Integer.parseInt(parVal.get("hidden"));
      String programme=parVal.get("programme");
       String type=parVal.get("type");
      String num=parVal.get("num");
      
      Programme prog=new Programme();
      faculties objfac=new faculties();
      
      objfac.setFacultyId(faculty);
      prog.setProgrammeId(id);
      prog.setProgrammeName(programme);
      prog.setProgrammeType(type);
      prog.setNum(Integer.parseInt(num));
      
      prog.setFaculty(objfac);
      dao.update(prog);
      return "redirect:"+"../admin/viewprogramme";
     
      
      
    }
    
    @RequestMapping(value="/admin/deleteprogramme/{id}",method = RequestMethod.GET)
    public String DeleteProgramme(@PathVariable("id") int id)
    {
        
      dao.delete(id);
      return "redirect:"+"../viewprogramme";
      
    }
    
    
    
    @RequestMapping(value = "/admin/GetAllProgram", method = RequestMethod.GET)
    public  @ResponseBody List<Programme> GetAllProgram() 
    {
         List<Programme> list=dao.getALL();
         return list;
         }
    
    
}
