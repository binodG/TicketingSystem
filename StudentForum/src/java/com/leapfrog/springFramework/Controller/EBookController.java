/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.CourseDAO;
import com.leapfrog.springFramework.DAO.EBooksDAO;
import com.leapfrog.springFramework.DAO.FileHandlerDAO;
import com.leapfrog.springFramework.DAO.ModalPapersDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.EBooks;
import com.leapfrog.springFramework.enitity.ModalPapers;
import com.leapfrog.springFramework.enitity.User;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author BkoNod
 */
@Controller
public class EBookController {
    @Autowired
    private EBooksDAO bookDao;
    @Autowired
    private ModalPapersDAO modalDao;
    @Autowired
    private FileHandlerDAO fileDao;
    @Autowired
    private CourseDAO courseDao;
    
    
    
    @RequestMapping(value = "/admin/addbooks",method = RequestMethod.POST)
    public String AddUser(@RequestParam Map<String,String> parVal,@RequestParam("file") MultipartFile file,HttpServletRequest request)
    {
    HttpSession session=request.getSession(false);
    User user=(User)session.getAttribute("USER");
    
      String type=parVal.get("Type");
      String faculty=parVal.get("faculty");
      String programme=parVal.get("programme");
      String courseID=parVal.get("course");
      String title=parVal.get("title");
      String description=parVal.get("description");
      String pathName=faculty+"/"+programme+"/"+type;
      String location=fileDao.uploadFile(title,pathName, file);
      
      
      Course course=new Course();
      course.setCourseId(Integer.parseInt(courseID));
      
      
      if(type.equalsIgnoreCase("book"))
      {
      EBooks book=new EBooks();
      book.setEbookName(title);
      book.setDescription(description);
      book.setCourse(course);
      book.setUser(user);
      book.setLocation(location);
      if(location!=null){
      bookDao.insert(book);
      
      }
      
      }
      else{
          ModalPapers modal=new ModalPapers();
          modal.setModalName(title);
          modal.setCourse(course);
          modal.setDescription(description);
          modal.setUser(user);
          modal.setLocation(location);
      if(location!=null){
          modalDao.insert(modal);
      }
      }
      
      return "redirect:"+"../admin/e-books";
      }
    
    
   @RequestMapping(value="/admin/viewbooks",method = RequestMethod.GET)
    public ModelAndView adminPanelviewebook()
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<EBooks> list=bookDao.getALL();
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewe-books");
      return mv;
    }
    @RequestMapping(value="/admin/viewmodal",method = RequestMethod.GET)
    public ModelAndView adminPanelviewmodal()
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<ModalPapers> list=modalDao.getALL();
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewmodal");
      return mv;
    }
   
    
    @RequestMapping(value="/admin/searchbook",method = RequestMethod.POST)
    public ModelAndView adminPanelSearchBook(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      String param=parVal.get("searchkey");
      List<EBooks> list=bookDao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewe-books");
      return mv;
    }
    
    @RequestMapping(value="/admin/searchmodal",method = RequestMethod.POST)
    public ModelAndView adminPanelSearchModal(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      String param=parVal.get("searchkey");
      List<ModalPapers> list=modalDao.getByParam(param);
      mv.addObject("retListData", list);
      mv.addObject("retValue", "viewviewmodal");
      return mv;
    }
    
    
    @RequestMapping(value="/admin/updatebook/{id}",method = RequestMethod.GET)
    public ModelAndView UpdateBook(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      
      List<Course> list=courseDao.getALL();
      mv.addObject("courseList",list);
      EBooks book=bookDao.getByID(id);
      mv.addObject("objBook",book);
      mv.addObject("retValue", "editbook");
      return mv;
    }
    
    @RequestMapping(value="/admin/updatemodal/{id}",method = RequestMethod.GET)
    public ModelAndView UpdateModal(@PathVariable("id") int id)
    {
       
      ModelAndView mv=new ModelAndView("Admin/AdminPanel");
      List<Course> list=courseDao.getALL();
      mv.addObject("courseList",list);
      ModalPapers modal=modalDao.getByID(id);
      mv.addObject("objModal",modal);
      mv.addObject("retValue", "editmodal");
      return mv;
    }
    
    
    @RequestMapping(value = "/admin/editbook",method = RequestMethod.POST)
    public String EditBook(@RequestParam Map<String,String> parVal)
    {
      int id=Integer.parseInt(parVal.get("hidden"));
      String title=parVal.get("title");
      String course=parVal.get("course");
      String description=parVal.get("description");
      Course courseObj=new Course();
      courseObj.setCourseId(Integer.parseInt(course));
      
      EBooks ebook=new EBooks();
      EBooks obj=new EBooks();
      ebook.setEbookId(id);
      //
      obj=bookDao.getByID(id);
      
      ebook.setLocation(obj.getLocation());
      ebook.setUser(obj.getUser());
      
//
      ebook.setEbookName(title);
      ebook.setCourse(courseObj);
      ebook.setDescription(description);
      bookDao.update(ebook);
     
      return "redirect:"+"../admin/viewbooks";
    
    }
    @RequestMapping(value = "/admin/editmodal",method = RequestMethod.POST)
    public String EditModal(@RequestParam Map<String,String> parVal)
    {
      int id=Integer.parseInt(parVal.get("hidden"));
      String title=parVal.get("title");
      String course=parVal.get("course");
      String description=parVal.get("description");
      Course courseObj=new Course();
      courseObj.setCourseId(Integer.parseInt(course));
      
      ModalPapers modal=new ModalPapers();
      ModalPapers obj=new ModalPapers();
      modal.setModalId(id);
      //
      obj=modalDao.getByID(id);
      modal.setLocation(obj.getLocation());
      modal.setUser(obj.getUser());
      
//
      modal.setModalName(title);
      modal.setCourse(courseObj);
      modal.setDescription(description);
      modalDao.update(modal);
     
      return "redirect:"+"../admin/viewmodal";
    
    }
    
    
    
    @RequestMapping(value="/admin/deletebook/{id}",method = RequestMethod.GET)
    public String DeleteBook(@PathVariable("id") int id)
    {
        
      bookDao.delete(id);
      return "redirect:"+"../viewbooks";
      
    }
     @RequestMapping(value="/admin/deletemodal/{id}",method = RequestMethod.GET)
    public String DeleteModal(@PathVariable("id") int id)
    {
        
      modalDao.delete(id);
      return "redirect:"+"../viewmodal";
      
    }
   
    
    
    
}
