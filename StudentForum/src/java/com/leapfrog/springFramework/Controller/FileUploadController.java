/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.EBooksDAO;
import com.leapfrog.springFramework.DAO.FileHandlerDAO;
import com.leapfrog.springFramework.DAO.ModalPapersDAO;
import com.leapfrog.springFramework.DAO.UserDAO;
import com.leapfrog.springFramework.enitity.Course;
import com.leapfrog.springFramework.enitity.EBooks;
import com.leapfrog.springFramework.enitity.ModalPapers;
import com.leapfrog.springFramework.enitity.User;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.NativeArray.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class FileUploadController {
    @Autowired
    private FileHandlerDAO fileDao;
    @Autowired
    private EBooksDAO bookDao;
    @Autowired
    private ModalPapersDAO modalDao;
    @Autowired
    private UserDAO userDao;
    
    
    /**
     * Upload single file using Spring Controller
     */
    
@RequestMapping(value = "/fileupload",method = RequestMethod.POST)
    public String AddFile(@RequestParam Map<String,String> parVal,@RequestParam("file") MultipartFile file,HttpServletRequest request)
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
      
      return "redirect:"+"/user";
      }
    
    
  @RequestMapping(value = "/download/{id}",method = RequestMethod.GET)
  public void download(@PathVariable("id") int id, HttpServletResponse response ){
      
      
      PrintWriter out=null;
        try {
            EBooks book=bookDao.getByID(id);
            ModalPapers modal=modalDao.getByID(id);
           
            
            if(book!=null){
            
            response.setContentType("text/html");
            out = response.getWriter();
         String rootpath=System.getProperty("catalina.home");
        String linkReg ="book\\\\(.*)";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(book.getLocation());
        String filename="";
        if(matcher.find())
        {
        filename=matcher.group(1);
         System.out.println(filename);
        }   
            
            String filepath = book.getLocation();
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
            FileInputStream fileInputStream = new FileInputStream(filepath);
            int i;
            while ((i=fileInputStream.read()) != -1) {
                out.write(i);
            }           fileInputStream.close();
            
            }
            
        if(modal!=null){
        response.setContentType("text/html");
        out = response.getWriter();
        String rootpath=System.getProperty("catalina.home");
        String linkReg ="modalPaper\\\\(.*)";
        Pattern pattern = Pattern.compile(linkReg);
        Matcher matcher = pattern.matcher(book.getLocation());
        String filename="";
        if(matcher.find())
        {
        filename=matcher.group(1);
       
        }   
            
            String filepath = book.getLocation();
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
            FileInputStream fileInputStream = new FileInputStream(filepath);
            int i;
            while ((i=fileInputStream.read()) != -1) {
                out.write(i);
            }           fileInputStream.close();
            
        }
           
            
        } catch (IOException ex) {   
            System.out.println(ex.getMessage());
        } finally {
            out.close();
        }
        
    
  
  }

@RequestMapping(value = "/uploadimage",method = RequestMethod.POST)
    public String UploadImage(@RequestParam Map<String,String> parVal,@RequestParam("file") MultipartFile file,HttpServletRequest request)
    {
    HttpSession session=request.getSession(false);
      User user=(User)session.getAttribute("USER");
      String location=fileDao.uploadImage(file);
      System.out.println("location"+location);
      if(location!=null){
      user.setImage(location);
      userDao.update(user);
      
      }
     return "redirect:"+"/user";
      }
  
    
    
}
