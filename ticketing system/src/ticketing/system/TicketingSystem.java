/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketing.system;

import com.ticket.DAO.Impl.UserDAOImpl;
import com.ticket.DAO.UserDAO;
import com.ticket.entity.User;
import com.ticket.view.TicketSellersView;
import com.ticket.view.adminView;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author BkoNod
 */
public class TicketingSystem {

    
    public static void main(String[] args) {
       
      JFrame mainFrame = new JFrame("Java Swing Examples");
      GridLayout gridLayout=new GridLayout(0,2);
      JLabel usernameLbl=new JLabel("user name");
      JLabel passwordLbl=new JLabel("password");
      JTextField usernameTxt=new JTextField(20);
      JPasswordField passwordTxt=new JPasswordField();
      JButton loginBtn=new JButton("Login");
      mainFrame.setLayout(gridLayout);
      mainFrame.add(usernameLbl);
      mainFrame.add(usernameTxt);
      mainFrame.add(passwordLbl);
      mainFrame.add(passwordTxt);
      mainFrame.add(loginBtn);
      
      loginBtn.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        UserDAO userDao=new UserDAOImpl();
        User u=new User();
      
        u=userDao.GetByParam(usernameTxt.getText(),passwordTxt.getText());
        if(u!=null)
        {
          mainFrame.setVisible(false);     
          if(u.getRole().equalsIgnoreCase("Admin"))
          {
            adminView obj=new adminView();
          }
          else{
            TicketSellersView obj=new TicketSellersView();
          }
        }
        
        
        
       }
    });
      
      
      
      mainFrame.setSize(400,400);
      mainFrame.setLayout(gridLayout);
      mainFrame.setVisible(true);
      mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
      
    }
    
}
