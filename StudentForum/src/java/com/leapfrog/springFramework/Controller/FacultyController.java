package com.leapfrog.springFramework.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leapfrog.springFramework.DAO.FacultiesDAO;
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
public class FacultyController {
    @Autowired
    private FacultiesDAO dao;
    @RequestMapping(value = "/admin/insertFaculties",method = RequestMethod.POST)
    public String insertFaculties(@RequestParam Map<String,String> parVal)
    {
      String faculty=parVal.get("faculty");
      faculties fac=new faculties();
      fac.setFacultyName(faculty);
      faculties existfac=dao.CheckFaculty(faculty);
      if(existfac!=null)
      {
      return "redirect:"+"../admin/faculty?q=facultyExist";
      }else{
         dao.insert(fac);
      }
     
      return "redirect:"+"../admin/faculty";
    
    
    }
    
    
    
    @RequestMapping(value="/admin/viewfaculty",method = RequestMethod.GET)
    public ModelAndView adminPanelviewfaculty()
    {
      ObjectMapper mapper = new ObjectMapper();

      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
       List<faculties> list=dao.getALL();
        
      mv.addObject("retListData", list);
      
      mv.addObject("retValue", "viewfaculty");
      return mv;
    }
    
    @RequestMapping(value="/admin/searchfaculty",method = RequestMethod.POST)
    public ModelAndView adminPanelSearchfaculty(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      String param=parVal.get("searchkey");
      List<faculties> list=dao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewfaculty");
      return mv;
    }
    
    @RequestMapping(value="/admin/updatefaculty/{id}",method = RequestMethod.GET)
    public ModelAndView Updatefaculty(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      faculties faculty=dao.getByID(id);
      mv.addObject("retObjData",faculty);
      mv.addObject("retValue", "editfaculty");
      return mv;
    }
    
     @RequestMapping(value = "/admin/editfaculty",method = RequestMethod.POST)
    public String EditFaculties(@RequestParam Map<String,String> parVal)
    {
      String faculty=parVal.get("faculty");
      int id=Integer.parseInt(parVal.get("hidden"));
      
      faculties fac=new faculties();
      fac.setFacultyId(id);
      fac.setFacultyName(faculty);
      dao.update(fac);
      
      return "redirect:" +"../admin/viewfaculty";
      
      
    }
    
    @RequestMapping(value="/admin/deletefaculty/{id}",method = RequestMethod.GET)
    public String Deletefaculty(@PathVariable("id") int id)
    {
        
      dao.delete(id);
      return "redirect:" +"../viewfaculty";
      
    }
    
    @RequestMapping(value = "/admin/GetAllFaculty", method = RequestMethod.GET)
    public  @ResponseBody List<faculties> GetAllFaculties() 
    {
         List<faculties> list=dao.getALL();
         return list;
         }
    
    
}
