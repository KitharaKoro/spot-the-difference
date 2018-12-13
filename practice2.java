
/**
 * The starting window for the game. This is the one that organizes data.
 * 

 */
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
public class practice2 extends JFrame implements ActionListener//directly inhereits JFrame's methods and conforms to ActionListener(the listening of fired events)
{

    JComboBox size;
    
    JButton Clickeh;
    JButton Import;
    double vertical;
    double horizontal;
    Ellipse2D shapeToBe;
    Ellipse2D shapeToBe2;
    Ellipse2D shapeToBe3;
    Ellipse2D shapeToBe4;
    Ellipse2D shapeToBe5;
    Image my_gif;
    Image my_gif2;
    Image crazy;
    Image crazy2;
    MediaTracker mt;


    

    int pageNumber;
    HashMap firstImage;
    HashMap secondImage;
    HashMap firstMark;
    HashMap secondMark;
    HashMap thirdMark;
    HashMap amount;
    HashMap difficulty;
    String strength;
    
    Image currentFirstImage;
    Image currentSecondImage;
    Ellipse2D currentFirstMark;
    Ellipse2D currentSecondMark;
    Ellipse2D currentThirdMark;
    Ellipse2D currentFirstMarkCopy;
    Ellipse2D currentSecondMarkCopy;
    Ellipse2D currentThirdMarkCopy;
    double firstMarkX;
    int reference;

    

    JTextArea ta;
    int remaining;
    int differences;
    instructions la;
    String something;
    JComboBox cb;
    ImageIcon icon; 
    Dimension dimension;
    
    JPanel panel;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    practice7 furious;
    practice6 loaded;
    Toolkit toolkit;
    Image nep;
    Image nep2;
    JPanel panel2;
    //instantializing parts of code
    practice2(){
        
        setLayout(new BorderLayout());//frame will be set to a borderlayout
        panel = new JPanel();
        panel2 = new JPanel();
        panel2.setVisible(true);
        b1 = new JButton("Instructions");
        b2 = new JButton("Upload");
        b3 = new JButton("Start");
        b4 = new JButton("Continue");
        panel.add(b1);
        panel.add(b3);
        panel.add(b2);
        panel.add(b4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        //add("North", panel2);
        add("South", panel);
        
        setSize(500,500);
        setResizable(false);
        //establishing a panel to add to the JFrame and buttons to the panel
        //added ActionListeners to all the buttons
        

        toolkit = Toolkit.getDefaultToolkit();
        shapeToBe = new Ellipse2D.Double(80,70,20,20);
        shapeToBe2 = new Ellipse2D.Double(34,113,27,8);
        shapeToBe3 = new Ellipse2D.Double(95,335,15,15);
        shapeToBe4 = new Ellipse2D.Double(123,121,16,16);
        shapeToBe5 = new Ellipse2D.Double(51,491,18,14);
        mt = new MediaTracker(this);
        
        
        my_gif = toolkit.getImage("Boo.jpg");
        my_gif2 = toolkit.getImage("Boo copy.jpg");
        crazy = toolkit.getImage("crazy.jpg");
        crazy2 = toolkit.getImage("crazy copy.jpg");
        //establishing images and ellipes
        
        
        Image image = toolkit.getImage("green star copy.JPG");
            
        Point hotSpot = new Point(10,10);
            
        Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Hershey's");
        setCursor(cursor); 
        //sets the cursor to a custom one
        //mt.addImage(my_gif,1);
        //mt.addImage(my_gif2,2);
        //mt.addImage(crazy,3);
        //mt.addImage(crazy2,4);
        
        //try { 
        //       mt.waitForAll(); 
        //  } 
        //catch (InterruptedException  e) {}
        //ideal to use, but in a small program like this, simpler to not use one
        //but for the online version yes
        
        firstImage = new HashMap();
        secondImage = new HashMap();
        firstMark = new HashMap();
        secondMark = new HashMap();
        thirdMark = new HashMap();
        amount = new HashMap();
        difficulty = new HashMap();
        //establish 7 hashmaps that deal with all the images, ellipses, the amount of ellipses per page, and the difficulty of said page
        
        pageNumber = 1;
        firstImage.put(pageNumber,my_gif);
        secondImage.put(pageNumber,my_gif2);
        firstMark.put(pageNumber, shapeToBe);
        secondMark.put(pageNumber, shapeToBe2);
        
        amount.put(pageNumber, 2);
        difficulty.put(pageNumber, "easy");
        
        pageNumber ++;
        firstImage.put(pageNumber,crazy);
        secondImage.put(pageNumber,crazy2);
        
        amount.put(pageNumber, 3);
        firstMark.put(pageNumber, shapeToBe3);
        
        secondMark.put(pageNumber, shapeToBe4);
        
        thirdMark.put(pageNumber,shapeToBe5);
        difficulty.put(pageNumber, "expert");
        
        
        //crazy = toolkit.getImage("green star copy.jpg");
        //firstImage.put(5,crazy);
        //this part proves that you can use only one instantialized Image, but altering it AFTER inserting into a hashmap has no effect on the stored image, awsome
        
//         icon = new ImageIcon("green star.jpeg");

        
        
        //String importedImageName = practice6.getName();
        
        
        //System.out.println(my_gif.getHeight(null));
        //System.out.println(my_gif.getWidth(null));
        //tested to see if it works, and it does
        //used later in the paint section for properly placing both images next to oneanother

    
        setForeground(Color.red);
        b4.setEnabled(false);
        setTitle("Hidden Catch2");
        setVisible(true);
        repaint();
        
    }
    
    
    public void actionPerformed(ActionEvent a){//this part specifies how to deal with particular fired events
        //if you pressed a button called Instructions, do whatever is specified inside of its "if" statement
        //all 4 of these commands deal with information comming and going to other classes
        //the first 3 make new windows
        //the last one imports data from the "Upload" window
        
        if(a.getActionCommand() == "Instructions"){//the instructions page
            la = new instructions();
            //System.out.println("Hi?");
        }
        if(a.getActionCommand() == "Start"){//the actual game page
            furious = new practice7(firstImage,secondImage,firstMark,secondMark,thirdMark, amount, difficulty, pageNumber);
        }
        if(a.getActionCommand() == "Upload"){//customize pages to your choosing
            
            loaded = new practice6();
            b4.setEnabled(true);
               
        }
        if(a.getActionCommand() == "Continue"){//as stated under ActionPerformed, this part imports data from the "Upload" window
            try{
                //use current position number instead of 3 if you have enough time to implement it
                nep = loaded.getImage();
                //System.out.println(loaded.getName());
                
                firstImage.put(pageNumber,nep);
                nep = loaded.getImage2();
                
               
                
                
                secondImage.put(pageNumber,nep2);
                
                differences = 0;
                
                
            
                try{
                    shapeToBe = loaded.getFirstMark();
                    firstMark.put(pageNumber,shapeToBe);
                    differences ++;
                }
                catch(NullPointerException npe){//many many different catch scenarios just to specify exactly what is null
                    System.out.println("No first mark...");
                }
                try{
                    shapeToBe2 = loaded.getSecondMark();
                    secondMark.put(pageNumber,shapeToBe2);
                    differences ++;
                } 
                catch(NullPointerException npe){
                    System.out.println("No second mark..");
                }
                
                try{
                    shapeToBe3 = loaded.getThirdMark();
                    thirdMark.put(pageNumber,shapeToBe3);
                    differences ++;
                }
                catch(NullPointerException npe){
                    System.out.println("No third mark.");
                }
                try{
                    strength = loaded.getDifficulty();
                    difficulty.put(pageNumber, strength);
                }
                catch(NullPointerException npe){
                    System.out.println("No specified difficulty.");
                }
                if(differences>0){
                    amount.put(pageNumber,differences);
                    pageNumber++;
                    b4.setEnabled(false);
                }
                else{
                    System.out.println("You have no differences inbetween the two photos. Restart if you wish.");
                }
            }
            catch(NullPointerException l){
                System.out.println("Hm, that's odd... Make sure you entered the information properly and in the required fashion. Please refer to the instructions page for further details");
            }
           
            
                
            
            
            
            
        }
    }
        
        
        
        
    
    
    
        
        public void paint(Graphics g){//prints out a little background for this starting window
            Graphics2D g2 = (Graphics2D)g;
            super.paint(g2);
            try{
                g2.drawImage(my_gif2,50,30,null);
                g2.drawImage(nep,0,30,null);
                
            }
            catch(NullPointerException npe){
            }
            setBackground(new Color(45,120,34));
            
        }///LLLLLLLLLLLLLAAAAAAAAAAAAAAAAAAAAAA, FIX THIS!!!!!!!!
    


    
    
        
    public static void main (String [] args) throws Exception{//calls itself since it is the starting point of the program
        practice2 sigh = new practice2();



    }
}
