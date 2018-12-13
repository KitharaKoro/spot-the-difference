import java.awt.Component; 
import java.util.HashMap; 
import java.util.Map; 
 
 
import javax.swing.DefaultListCellRenderer; 
import javax.swing.Icon; 
import javax.swing.JComboBox; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JList; 
import javax.swing.plaf.metal.MetalIconFactory; 

import java.awt.Toolkit.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.Font.*;
import java.io.*;
import javax.swing.text.*; 
import java.awt.geom.RectangularShape.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.applet.*; 
import java.net.*; 
import java.awt.Toolkit.*;
import java.awt.Point.*;
import java.util.EventObject.*;

public class practice5 extends DefaultListCellRenderer//DeFaultListCellRenderer is the default class that deals with JComboBoxs
//by extending it, practice5 inhereits all of its default methods, and can OVERRIDE any of these methods
//practice5 overrides the default getListCellRendererComponent

{
    Integer pageNumber;
    HashMap difficulty;
    public practice5(HashMap difficulty, Integer pageNumber)
    {
        this.pageNumber = pageNumber;
        this.difficulty = difficulty;
        //import and intantialize pageNumber and difficulty    


        
        
    }
    
    public Component getListCellRendererComponent(JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        ImageIcon bronze = new ImageIcon("bronze star.jpg");
        ImageIcon silver = new ImageIcon("siler star.jpg");
        ImageIcon gold = new ImageIcon("gold star.jpg");
        //if(index == 0){
            
        //    label.setIcon(bronze);
        
        //    label.setSize(50,50);
            
        //}
        if(index <= pageNumber){//if the current cell is within the range we are looking for
            String cookie = (String)difficulty.get((index+1));//+1 is because index(the number from the default method) 
            //always starts off at -1, not 0
            if(cookie == "expert"){//states what to do if the specified string is either expert indermediate or easy
                label.setIcon(gold);
            }
            if(cookie == "intermediate"){
                label.setIcon(silver);
            }
            if(cookie == "easy"){
                label.setIcon(bronze);
            }
        
        }
        return label;
    }
    
    
//     public static void main(String [] args) throws Exception{
//         JPanel panel = new JPanel();
//         JFrame frame = new JFrame();
        
//         String [] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//         JComboBox size = new JComboBox(numbers);
//         panel.add(size);
        //size.setRenderer(new practice5());
//         frame.add(size);
//         frame.pack();
//         frame.setVisible(true);
//     }
    

    
   
}
