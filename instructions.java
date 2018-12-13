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
public class instructions extends JFrame//again we inheiret all of JFrames methods directly
{//this class is extremely basic, for it has one function, to display pictures and an informmative textarea
    JPanel orange;
    JTextArea ta;
    Toolkit toolkit;
    Image bronze;
    Image silver;
    Image gold;
    //instantializing parts of the code
    public instructions(){
        orange = new JPanel();
        ta = new JTextArea("This is Hidden Catch2.\nSpot the differences and try to click as much as you can in the centre of them.\nAfter choosing a page with the drop down list, \nyou will not be able to continue untill you find all of the differences \nof the current photographs.\nIf the graphics start to act a little funny, just enlargen or shrink the game window.\nIf the drop-down menu is clickable, \nthat means that whichever page you currently are on is not fully loaded.\nContact an administrator or developper for further information. \nIt is safer to click on the left version of the picture.\nYou will need to find the hidden button to start the game.\nFor now, this game will only be capable of holding 10 pictures.\nThe stars below indicate difficulty\nbronze being the easiest, and gold being the hardest.\nIF YOU ARE IMPORTING IMAGES, MAKE SURE THAT THERE IS INDEED A\nSAVED VERSION OF IT WITHIN THE FOLDER!\nALSO MAKE SURE THAT YOUR IMAGE FILE TYPE IS\nEITHER .JPG OR .GIF! In order to succesfully upload\nthe picture, you must confirm the marks and the pictures. \nAbove all else, have fun");
        orange.add(ta);
        add(orange);
        ta.setEditable(false);
        setSize(500,500);
        
        toolkit = Toolkit.getDefaultToolkit();
        bronze = toolkit.getImage("bronze star.jpg");
        silver = toolkit.getImage("silver star.jpg");
        gold = toolkit.getImage("gold star.jpg");
        setTitle("Instructions");
        setResizable(false);
        setVisible(true);
    }//make a panel, add a textarea to it
    //make the textarea uneditable, stick it on the panel
    //stick the panel on the frame, set the frame unresizable and visible
    
    public void paint(Graphics g){//telling the paint method to stick these 3 pictures onto the frame
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(bronze,0,400,null);
        g2.drawImage(silver,100,400,null);
        g2.drawImage(gold,200,400,null);
    }
     
//      public static void main (String [] args) throws Exception{
//          instructions s = new instructions();
//      }
}
