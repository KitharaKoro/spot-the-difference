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
public class practice7 extends JFrame implements ActionListener, MouseListener//again we inheirit all of JFrame's methods directly, and abide by the requirements of ActionListener and Mouselistener

{//these deal with fired ActionEvents and MouseEvents
//this class is the one that deals with images and ellipses, where to put them, and what to do if the user correctly finds a difference etc.
    JComboBox size;
    JPanel pingpong;
    JButton Clickeh;
    JButton Import;
    double vertical;
    double horizontal;

    Image my_gif;
    Image my_gif2;
    Image crazy;
    Image crazy2;
    MediaTracker mt;
    URL base;
    boolean location;
    boolean location2;
    Point dexter;
    int xposition;
    int yposition;
    int width;
    int height;
    int cookieNumber;
    HashMap firstImage;
    HashMap secondImage;
    HashMap firstMark;
    HashMap secondMark;
    HashMap thirdMark;
    HashMap amount;
    
    
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
    boolean firstFound;
    boolean secondFound;
    boolean thirdFound;

    JTextArea ta;
    int remaining;
    int cookie;
    instructions la;
    Integer something;
    JComboBox cb;
    ImageIcon icon; 
    Dimension dimension;
    public practice7(HashMap firstImage, HashMap secondImage, HashMap firstMark, HashMap secondMark, HashMap thirdMark, HashMap amount, HashMap difficulty, Integer pageNumber )
    {
        Integer [] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        size = new JComboBox(numbers);
        dimension = new Dimension(20,20);
        size.setMaximumSize(dimension);
        size.addActionListener(this);
        size.setRenderer(new practice5(difficulty, pageNumber));
        //remaining = 2;
        setLayout(new BorderLayout());

        pingpong = new JPanel();
        pingpong.setLayout(new BorderLayout());
         
        ta = new JTextArea("" , 3, 3);
        //pingpong.addMouseListener(this);
        Clickeh = new JButton("Instructions");
        Import = new JButton("Import Image");
        Import.addActionListener(this);
                              
        Clickeh.addActionListener(this);
        pingpong.add("South", size);
        pingpong.add("North", Clickeh);
        
        pingpong.add("Center", ta);
        add("East", pingpong);
        addMouseListener(this);
        
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.firstMark = firstMark;
        this.secondMark = secondMark;
        this.thirdMark = thirdMark;
        this.amount = amount;
        firstFound = true;
        secondFound = true;
        thirdFound = true;
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("stamp.jpg");
            
        Point hotSpot = new Point(10,10);
            
        Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Hershey's");
        setCursor(cursor); 
        setTitle("Hidden Catch2");
        setVisible(true);
    }//seting the parametres(frame, panel, hashmaps, you name it)
    
    public void mouseReleased(MouseEvent e){//this part is the command if the user releasing the mouse(after being clicked)
        try{
            
            vertical = e.getX();
            horizontal = e.getY();
            /**
             * take in the co-ordinates of the position the mouse was released at
             * the long messy "if" statements are indeed saying, if the coordinates of the mouse when released match those of the differences of this picture
             * do whatever is inside the "if" statement 
             */
            //dexter = new Point(vertical, horizontal);
            //System.out.println(vertical);
            //System.out.println(horizontal);
            //location = shapeToBe.contains(vertical, horizontal);
        
       
            //if(location = true){
            
                //    System.out.println("Meep 0_o");
                //    location = false;
                //}  //ARRRRRG, IT ALWAYS RETURNS TRUE, BUT THE ELIIPSE IS NOT THE SIZE OF THE SCREEN
                //WTFUDGE?
                double heightStart = currentFirstMark.getHeight();
                if(firstFound == false){
            
                    if(currentFirstMark.getX() < vertical && vertical<currentFirstMark.getX()+currentFirstMark.getWidth() && currentFirstMark.getY() < (horizontal) && (horizontal) < currentFirstMark.getHeight()+currentFirstMark.getY()){
                        firstFound = true;
                
                        //System.out.println("Got one");
                        cookie --;
                    }
                    if(currentFirstMarkCopy.getX() < (vertical) && (vertical)<currentFirstMarkCopy.getX()+currentFirstMarkCopy.getWidth() && currentFirstMarkCopy.getY() < (horizontal) && (horizontal) < currentFirstMarkCopy.getHeight()+currentFirstMarkCopy.getY()){
                        firstFound = true;
                
                        cookie --;
                        //System.out.println("Got one");
                    }
            
            
            
            
                }
                if(secondFound == false){
            
                    if(currentSecondMark.getX() < vertical && vertical<currentSecondMark.getX()+currentSecondMark.getWidth() && currentSecondMark.getY() < (horizontal) && (horizontal) < currentSecondMark.getHeight()+currentSecondMark.getY()){
                        secondFound = true;
                
                        cookie --;
                        //System.out.println("Got two");
                    }
            
                    if(currentSecondMarkCopy.getX() < vertical && vertical<currentSecondMarkCopy.getX()+currentSecondMarkCopy.getWidth() && currentSecondMarkCopy.getY() < (horizontal) && (horizontal) < currentSecondMarkCopy.getHeight()+currentSecondMarkCopy.getY()){
                        secondFound = true;
                
                        cookie --;
                        //System.out.println("Got two");
                    }
            
                }
                
                
                
                if(thirdFound == false){
            
                    if(currentThirdMark.getX() < vertical && vertical<currentThirdMark.getX()+currentThirdMark.getWidth() && currentThirdMark.getY() < (horizontal) && (horizontal) < currentThirdMark.getHeight()+currentThirdMark.getY()){
                        thirdFound = true;
                
                        cookie --;
                        //System.out.println("Got two");
                    }
            
                    if(currentThirdMarkCopy.getX() < vertical && vertical<currentThirdMarkCopy.getX()+currentThirdMarkCopy.getWidth() && currentThirdMarkCopy.getY() < (horizontal) && (horizontal) < currentThirdMarkCopy.getHeight()+currentThirdMarkCopy.getY()){
                        thirdFound = true;
                
                        cookie --;
                        //System.out.println("Got two");
                    }
            
                }
                ta.setText(""+cookie);//this is the part that deals with remaining differences
                //System.out.println("Uh?");
                if(firstFound == true && secondFound == true && thirdFound == true){
                    size.setEnabled(true);//if you have found all the differences, you can now change pictures
                    //cb.getSelectedItem.setIcon(icon);
                    
                }
            }
            
        
        
        //System.out.println(currentFirstMark.getX());
        //System.out.println(vertical);
        //System.out.println(currentFirstMark.getX()+currentFirstMark.getWidth());
        //System.out.println(currentFirstMark.getY());
        //System.out.println(horizontal+30);
        //System.out.println(currentFirstMark.getY()+currentFirstMark.getHeight());
        //System.out.println(currentFirstImage.getWidth(null));
        //the above "if statement" works, but it is a pain in the butt long, and the "contains" method would be much simpler and accurate
        //location2 = Clickeh.contains(dexter);
        //if (location2 = true){
        //    System.out.println("Lets hope this works...");
        //    location2 = false;
        //}   ZOMG, THIS ALSO HAS THE SAME GLITCH AS THE BOOLEAN ABOVE

        //Font [] List = GraphicsEnvironment.getAllFonts();
        //xposition = Clickeh.getX();
        //yposition = Clickeh.getY();
        //width = Clickeh.getWidth();
        //height = Clickeh.getHeight();
        //if(vertical >= xposition && vertical <= (xposition+width) && horizontal >= yposition && horizontal <= (yposition + height)){
        //    System.out.println("Meep? 0_o;;");
        //} THE BUTTON COUNTS AS A SEPERATE CONTAINER, THE LOCATIONS ARE THEN INCORRECT
    catch(NullPointerException nu){
        
        }   
    }
    public void mousePressed(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){//we don't deal with these other mouse events
        
        //System.out.println("Meep");
    }
    public void actionPerformed(ActionEvent a){//the "what to do" part of the program if an actionevent is fired
        
        if(a.getActionCommand() == "Instructions"){//opens the instructions page
            la = new instructions();
           
        }
        else{
            try{
                cb = (JComboBox)a.getSource();
                something = (Integer)cb.getSelectedItem();//take in the selected item of the combobox
            }
            catch(ClassCastException cl){
            }
        }
        
        if(something == 1){
            currentDisplay(1);
            //System.out.println("Lalala");
        }
        if(something == 2){
            currentDisplay(2);
        }
        if(something == 3){
            currentDisplay(3);
        }
        if(something == 4){
            currentDisplay(4);
        }
        if(something == 5){
            currentDisplay(5);
        }
        if(something == 6){
            currentDisplay(6);
        }
        if(something == 7){
            currentDisplay(7);
        }
        if(something == 8){
            currentDisplay(8);
        }
        if(something == 9){
            currentDisplay(9);
        }
        if(something == 10){
            currentDisplay(10);
        }
        
        
    }
    
    public void currentDisplay(int reference){//this is the part that deals with information comming from the start page
       try{//when currentDisplay is called, it will take 2 pictures, and the specified amount of differences(ellipses) of these pictures
            size.setEnabled(false);//whenever this is called, you can no longer change pictures untill setenabled is called to be true
            currentFirstImage = (Image)firstImage.get(reference);
            currentSecondImage = (Image)secondImage.get(reference);
            
            cookie = (Integer)amount.get(reference);
            ta.setText(""+cookie);
            if(cookie >0){
                firstFound = false;
                currentFirstMark = (Ellipse2D)firstMark.get(reference);
                currentFirstMarkCopy = new Ellipse2D.Double(currentFirstMark.getX()+ currentFirstImage.getWidth(null), currentFirstMark.getY(), currentFirstMark.getWidth(), currentFirstMark.getHeight());
                if(cookie >= 2){
                    secondFound = false;
                    currentSecondMark = (Ellipse2D)secondMark.get(reference);
                    currentSecondMarkCopy = new Ellipse2D.Double(currentSecondMark.getX()+ currentFirstImage.getWidth(null), currentSecondMark.getY(), currentSecondMark.getWidth(), currentSecondMark.getHeight());
                    
                    if(cookie >=3){
                        thirdFound = false;
                        currentThirdMark = (Ellipse2D)thirdMark.get(reference);
                        currentThirdMarkCopy = new Ellipse2D.Double(currentThirdMark.getX()+ currentFirstImage.getWidth(null), currentThirdMark.getY(), currentThirdMark.getWidth(), currentThirdMark.getHeight());
                    }//the program duplicates the ellipses so that there are markings for both pictures
                }
            }
        }
            
                
            
            
            
            
            
            
            
            
            
            
            
                
        
        catch(NullPointerException nu){
            //System.out.println("Please feel free to run around while panicking (or bug Fowler)");
            size.setEnabled(true);
        }
        
        
    }
    
    public void paint(Graphics g){//controlls what to be displayed on the frame
       
        //this method is invoked very often(automatically) so the "try" part is incase paint is invoked while the user hasn't decided on a photo
        Graphics2D g2 = (Graphics2D)g;
        super.paint(g2);
       
  // now we are going to draw the gif on the screen 
  // (image name,x,y,observer); 

          //g2.drawImage(my_gif,0,30,null);
          //g2.drawImage(my_gif2,my_gif.getWidth(null),30,null);
          try{
              
            g2.drawImage(currentFirstImage,0,30,null);
            g2.drawImage(currentSecondImage,currentFirstImage.getWidth(null),30,null);
            if(firstFound == true){
                g2.draw(currentFirstMark);
                g2.draw(currentFirstMarkCopy);
            }
            if(secondFound == true){
                g2.draw(currentSecondMark);
                g2.draw(currentSecondMarkCopy);
            }
            if(thirdFound == true){
                g2.draw(currentThirdMark);
                g2.draw(currentThirdMarkCopy);
            }
                
        }
        catch(NullPointerException za){
        }
        
          
        
    }

    
    
}
