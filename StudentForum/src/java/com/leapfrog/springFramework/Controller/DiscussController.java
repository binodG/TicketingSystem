/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Controller;

import com.leapfrog.springFramework.DAO.Impl.AnswerDAOImpl;
import com.leapfrog.springFramework.DAO.Impl.QuestionDAOImpl;
import com.leapfrog.springFramework.Utility.SendMail;
import com.leapfrog.springFramework.enitity.Answer;
import java.util.Map;
import com.leapfrog.springFramework.enitity.Question;
import com.leapfrog.springFramework.enitity.User;
import java.util.List;
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
public class DiscussController {
    @Autowired
    private QuestionDAOImpl qDao;
    
    @Autowired
    private AnswerDAOImpl aDao;
     
    
     @RequestMapping(value = "/postquestion",method = RequestMethod.POST)
     public String InserQuestion( @RequestParam Map<String,String> parVal,HttpServletRequest request)
     {
     HttpSession session=request.getSession(false);
     User user=(User)session.getAttribute("USER");
    
      String title=parVal.get("title"); 
      String Question=parVal.get("question");
      String tag=parVal.get("tags");
      Question q=new Question();
      q.setTitle(title);
      q.setQuestion(Question);
      q.setStatus(false);
      q.setTags(tag);
      q.setUser(user);
      qDao.insert(q);
      return "redirect:"+"/askquestion";
      
     }
     
    @RequestMapping(value = "/discuss", method = RequestMethod.GET)
    public ModelAndView Questions() {
        ModelAndView mv = new ModelAndView("/Discuss/Questions");
        List<Question> list=qDao.getALL();
        mv.addObject("attList",list);
        return mv;
    }
    
    @RequestMapping(value = "/discuss/answer/{id}", method = RequestMethod.GET)
    public ModelAndView Answer(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("/Discuss/Answers");
        List<Answer> list=aDao.getAnswers(id);
        Question question=qDao.getByID(id);
        mv.addObject("qObject",question);
        mv.addObject("aObjectList",list);
        return mv;
    }
    
    
    
    
    
    
     @RequestMapping(value = "/discuss/postanswer",method = RequestMethod.POST)
     public String PostAnswers( @RequestParam Map<String,String> parVal,HttpServletRequest request)
     {
     HttpSession session=request.getSession(false);
     User user=(User)session.getAttribute("USER");
     
      
      int id=Integer.parseInt(parVal.get("hidden"));
      Question question=qDao.getByID(id);
      int noOFanswers=question.getNoOFanswer()+1;
      question.setNoOFanswer(noOFanswers);
      SendMail mail=new SendMail();
      Answer a=new Answer();
      if(user!=null)
      {
       String answer=parVal.get("answer");
       a.setAnswer(answer);
       a.setQuestion(question);
       a.setUser(user);
       aDao.insert(a);
       qDao.update(question);
       mail.execute(user);
       return "redirect:"+"/discuss";
      }
     else {
            String message = "You need to login to Post the Answer";
            session.setAttribute("loginMsg", message);

        }
      return "redirect:"+"/discuss/answer/"+id;
      
      
     }
    
     @RequestMapping(value="/searchquestion",method = RequestMethod.POST)
    public ModelAndView adminPanelSearchCourse(@RequestParam Map<String,String> parVal)
    {
      ModelAndView mv=new ModelAndView("/Discuss/Questions");
      String param=parVal.get("searchkey");
      List<Question> list=qDao.getByParam(param);
      mv.addObject("attList", list);
      return mv;
    }
    
     
     
     
}
