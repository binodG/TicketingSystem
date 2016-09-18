/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ticket.view;

import com.ticket.DAO.Impl.SitsDAOImpl;
import com.ticket.DAO.SitsDAO;
import com.ticket.entity.Sits;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author BkoNod
 */
public class TicketSellersView {
   SitsDAO sitDao=new SitsDAOImpl();
   Sits s=new Sits();
   
   public void refreshScreen(JTextArea txtArea){
   
   List<Sits> list = sitDao.GetAll();
     
        
         for(int i=0;i<list.size();i++)
                {
                    txtArea.setText(txtArea.getText()+" \n Sit Number: "+list.get(i).getSitnumber() +"\t\t Status: "+ list.get(i).getStatus());
                }
        
   }
   
    public TicketSellersView() {
        JFrame mainFrame = new JFrame("Java Swing Examples");
        JTextArea txtArea=new JTextArea();
        GridLayout gridLayout = new GridLayout(4, 1);
        
         List<Sits> list = sitDao.GetAll();
        refreshScreen(txtArea);
        
        JButton bookBtn = new JButton("Book");
        JButton cancelBtn = new JButton("Cancel");
         JComboBox comboBox = new JComboBox();
        for (Sits str1 : list) {
            comboBox.addItem(str1.getSitnumber());

        }
       

          bookBtn.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
                s.setStatus("BOOKED");
                String sitnumber=String.valueOf(comboBox.getSelectedItem());
                s.setSitnumber(sitnumber);
                sitDao.update(s);
                txtArea.setText("");
               refreshScreen(txtArea);
            

        
       }
    });
        cancelBtn.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent actionEvent)
      {
                s.setStatus("AVAILABLE");
                String sitnumber=String.valueOf(comboBox.getSelectedItem());
                s.setSitnumber(sitnumber);
                sitDao.update(s);
                 txtArea.setText("");
               
                refreshScreen(txtArea);
            

        
       }
    });
        mainFrame.setLayout(gridLayout);
        mainFrame.add(txtArea);
        mainFrame.add(comboBox);
        mainFrame.add(bookBtn);
        mainFrame.add(cancelBtn);

        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    
    public static void main(String[] args) {
        TicketSellersView obj = new TicketSellersView();
    }
}
