/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.springFramework.Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.leapfrog.springFramework.enitity.User;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author BkoNod
 */
public class SendMail{

    public void execute(User user) {
       PrintStream ps = null;
       String msg="";
       String title="";
       int valid=0;
           final String username="automatedservermail@gmail.com";
           final String password="123456789P";
           Properties props=new Properties();
           props.put("mail.smtp.auth","true");
           props.put("mail.smtp.starttls.enable","true");
           props.put("mail.smtp.host","smtp.gmail.com");
           props.put("mail.smtp.auth","true");
           props.put("mail.smtp.port","587");
           Session session = Session.getInstance(props, new javax.mail.Authenticator() {
               protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                   return new javax.mail.PasswordAuthentication(username, password);
               }
           });
           try {
               
               Message message = new MimeMessage(session);
               message.setFrom(new InternetAddress("automatedservermail@gmail.com"));
               message.setRecipients(Message.RecipientType.TO,
                       InternetAddress.parse(user.getEmail()));
                       message.setSubject(title);
                       message.setText(user.getFirstName()+ "has posted some solution to your question");
               Transport.send(message);
               
           } catch (Exception e) {
               System.out.println(e);
           }
      
        
        
        
    }
    
}
