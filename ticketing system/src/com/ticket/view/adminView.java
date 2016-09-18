/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.view;

import com.ticket.DAO.Impl.SitsDAOImpl;
import com.ticket.DAO.Impl.UserDAOImpl;
import com.ticket.DAO.SitsDAO;
import com.ticket.DAO.UserDAO;
import com.ticket.entity.Sits;
import com.ticket.entity.User;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author BkoNod
 */
public class adminView {

    public adminView() {

        JFrame mainFrame = new JFrame("Java Swing Examples");

        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("Add TicketSeller");
        JMenu menu2 = new JMenu("Show status");
        JMenuItem menuItem1 = new JMenuItem("add");
        JMenuItem menuItem2 = new JMenuItem("show");
        menu1.add(menuItem1);
        menu2.add(menuItem2);
        menubar.add(menu1);
        menubar.add(menu2);

        ActionListener menuListener = new MenuActionListener();
        menuItem1.addActionListener(menuListener);
        menuItem2.addActionListener(menuListener);

        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
        mainFrame.setJMenuBar(menubar);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        adminView obj = new adminView();

    }

    class MenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getActionCommand().equalsIgnoreCase("add")) {
                JDialog dialog = new JDialog();
                JPanel pan = new JPanel();
                GridLayout grid = new GridLayout(0, 2);
                pan.setLayout(grid);
                JLabel usernameLbl = new JLabel("user name");
                JLabel passwordLbl = new JLabel("password");
                JTextField usernameTxt = new JTextField(20);
                JPasswordField passwordTxt = new JPasswordField();
                JButton submitBtn = new JButton("Submit");
                
                submitBtn.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
          User u=new User();
          u.setUsername(usernameTxt.getText());
          u.setPassword(passwordTxt.getText());
          u.setRole("seller");
          UserDAO userDao=new UserDAOImpl();
          userDao.Insert(u);
          usernameTxt.setText("");
          passwordTxt.setText("");
          
      }
    });
                
                
                
                
                pan.add(usernameLbl);
                pan.add(usernameTxt);
                pan.add(passwordLbl);
                pan.add(passwordTxt);
                pan.add(submitBtn);
                dialog.add(pan);
                dialog.setVisible(true);
                dialog.setSize(400, 400);
       
                

            } else if (actionEvent.getActionCommand().equalsIgnoreCase("show")) {
                JDialog dialog = new JDialog();
                JPanel pan = new JPanel();
                GridLayout grid = new GridLayout(0, 2);
                pan.setLayout(grid);
                JLabel ticketLbl = new JLabel("No Sold Tickets");
                JLabel salesLbl = new JLabel("Total sales(Rs)");
                JTextField ticketTxt = new JTextField(20);
                JTextField salesTxt = new JTextField(20);
                JButton loginBtn = new JButton("Submit");
                ticketTxt.disable();
                salesTxt.disable();
                
                //
                SitsDAO sitDao=new SitsDAOImpl();
                List<Sits> list=sitDao.GetAll();
                int soldSit=0;
                for(Sits s:list)
                {
                 if(s.getStatus().equalsIgnoreCase("BOOKED"))
                 {
                  soldSit=soldSit+1;
                 }
                
                }
                ticketTxt.setText(String.valueOf(soldSit));
                salesTxt.setText(String.valueOf(soldSit*270));
                pan.add(ticketLbl);
                pan.add(ticketTxt);
                pan.add(salesLbl);
                pan.add(salesTxt);
                pan.add(loginBtn);
                dialog.add(pan);
                dialog.setVisible(true);
                dialog.setSize(400, 400);
       
            }

        }
    }

}
