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
public class practice6 extends JFrame implements ActionListener//inheirets all of JFrames methods directly and abides by ActionListener's requirements
{//this class is simple as it deals only with importing strings and integers to the start program from the user in this "user friendly" zone
    TextArea firstImageName;
    TextArea secondImageName;
    TextArea firstMarkWidth;
    TextArea firstMarkHeight;
    TextArea firstMarkEndX;
    TextArea firstMarkEndY;

    JComboBox whichMark;
    JComboBox difficulty;
    JButton confirmTotal;
    JButton confirmMark;
    String name1;
    String name2;
    JPanel patience;
    String f1;
    String f2;
    String f3;
    String f4;
    int first;
    int second;
    int third;
    int fourth;
    Toolkit toolkit;
    JComboBox cb;
    String something;
    String something2;
    Ellipse2D firstMark;
    Ellipse2D secondMark;
    Ellipse2D thirdMark;
    JPanel top;
    JPanel middle;
    JPanel bottom;
    //instantializing parts of code
    public practice6()
    {
        setLayout(new BorderLayout());
        firstImageName = new TextArea("First Image File Name.",1,20,3);
        secondImageName = new TextArea("Second Image File Name.", 1,20,3);
        firstMarkWidth = new TextArea("Top left point(x)",1,5,3); 
        firstMarkHeight = new TextArea("Top left point(y)",1,5,3); 
        firstMarkEndX = new TextArea("How wide?",1,5,3);
        firstMarkEndY = new TextArea("How tall?",1,5,3); 
        
        String [] placements = {"First Mark", "Second Mark", "Third Mark"};
        String [] levels = {"easy", "intermediate", "expert"};
        
        whichMark = new JComboBox(placements);
        whichMark.addActionListener(this);
        difficulty = new JComboBox(levels);
        difficulty.addActionListener(this);
        top = new JPanel();
        middle = new JPanel();
        bottom = new JPanel();
        
        
        
        
        confirmTotal = new JButton("Confirm Images");
        confirmTotal.addActionListener(this);
        confirmMark = new JButton("Confirm Mark");
        confirmMark.addActionListener(this);
        
        top.add(firstImageName);
        top.add(secondImageName);
        top.add(difficulty);
        
        middle.add(firstMarkWidth);
        middle.add(firstMarkHeight);
        middle.add(firstMarkEndX);
        middle.add(firstMarkEndY);
        middle.add(whichMark);
        
        bottom.add(confirmTotal);
        bottom.add(confirmMark);
        
        
        
        add("North", top);
        add("Center", middle);
        add("South", bottom);
        toolkit = Toolkit.getDefaultToolkit();
        setTitle("Hidden Catch2: Uploading");
        setSize(500,500);
        setResizable(false);
        setVisible(true);
    }//same as the "instructions" method, nothing out of the ordinary
    //establish a panel, stick buttons and textareas to it
    //tell the buttons what to do, set the frame to be visible and unresizable etc.
    
    public void actionPerformed(ActionEvent e){//the "what to do" if a button is fired part
        try{//all actionPerformed is doing is preparing data for the "start" window 
            //so is it calls for these new imported files and ellipses, that it will be ready
            cb = (JComboBox)e.getSource();
            something = (String)cb.getSelectedItem();
            
            //System.out.println(something);
        }
        catch(ClassCastException cl){
        }
        if(e.getActionCommand() == "Confirm Mark"){
            //System.out.println(something);
            if(something == "First Mark"){//data will create different ellipses if the combobox is set to different names
                try{
                    
                
                    f1 = firstMarkWidth.getText();
                    first = Integer.parseInt(f1);
                    System.out.println("Top left point (x value): " + first);
                    f2 = firstMarkHeight.getText();
                    second = Integer.parseInt(f2);
                    System.out.println("Top left point (y value): " + second);
                    f3 = firstMarkEndX.getText();
                    third = Integer.parseInt(f3);
                    System.out.println("Width: " + third);
                    f4 = firstMarkEndY.getText();
                    fourth = Integer.parseInt(f4);
                    System.out.println("Height: " + fourth);
                    firstMark = new Ellipse2D.Double(first,second,third,fourth);
                    System.out.println("First mark confirmed. To make any adjustment, simply change the information and then click Confirm mark again.");
                }
                catch(NullPointerException npe){
                    System.out.println("Please make sure you didn't leave any blanks and have the proper setting selected.");
                }
            }
            
            
            if(something == "Second Mark"){
                try{
                    
                
                    f1 = firstMarkWidth.getText();
                    first = Integer.parseInt(f1);
                    System.out.println("Top left point (x value): " + first);
                    f2 = firstMarkHeight.getText();
                    second = Integer.parseInt(f2);
                    System.out.println("Top left point (y value): " + second);
                    f3 = firstMarkEndX.getText();
                    third = Integer.parseInt(f3);
                    System.out.println("Width: " + third);
                    f4 = firstMarkEndY.getText();
                    fourth = Integer.parseInt(f4);
                    System.out.println("Height: " + fourth);
                    secondMark = new Ellipse2D.Double(first,second,third,fourth);
                    System.out.println("Second mark confirmed. To make any adjustment, simply change the information and then click Confirm Mark again.");
                }
                catch(NullPointerException npe){
                    System.out.println("Please make sure you didn't leave any blanks and have the proper setting selected.");
                }
            }
            
            
            if(something == "Third Mark"){
                try{
                    
                
                    f1 = firstMarkWidth.getText();
                    first = Integer.parseInt(f1);
                    System.out.println("Top left point (x value): " + first);
                    f2 = firstMarkHeight.getText();
                    second = Integer.parseInt(f2);
                    System.out.println("Top left point (y value): " + second);
                    f3 = firstMarkEndX.getText();
                    third = Integer.parseInt(f3);
                    System.out.println("Width: " + third);
                    f4 = firstMarkEndY.getText();
                    fourth = Integer.parseInt(f4);
                    System.out.println("Height: " + fourth);
                    thirdMark = new Ellipse2D.Double(first,second,third,fourth);
                    System.out.println("Third mark confirmed. To make any adjustment, simply change the information and then click OK again.");
                }
                catch(NullPointerException npe){
                    System.out.println("Please make sure you didn't leave any blanks and have the proper setting selected.");
                }
            }
        }
                
            
            
        if(e.getActionCommand()=="Confirm Images"){
            
            try{
                name1 = firstImageName.getText();
           
           
                System.out.println("Name of the first image: " + name1);
                name2 = secondImageName.getText();
                System.out.println("Name of the second image: " + name2);
                something2 = (String)difficulty.getSelectedItem();
                System.out.println("Difficulty: " + something2);
                
                System.out.println("Press continue on the main window to continue. To make any adjustment, simply re-enter any information and then click OK again.");
            }
                
            catch(NullPointerException npe){
                System.out.println("Please make sure you didn't leave any blanks and have the proper setting selected.");
            }
        }
    }
//all of the remaining methods simply return the data that the "start" window will ask for
    public Image getImage(){
        Image firstImage = toolkit.getImage(name1);
        return firstImage;
    }
    public Image getImage2(){
        Image secondImage = toolkit.getImage(name2);
        return secondImage;
    }
    public Ellipse2D getFirstMark(){
        
        return firstMark;
    }
    public Ellipse2D getSecondMark(){
        return secondMark;
    }
    public Ellipse2D getThirdMark(){
        return thirdMark;
    }
    public String getDifficulty(){
        
        return something2;
    }
    
//     public static void main(String [] args) throws Exception{
//         practice6 me = new practice6();
//     }

    
}
