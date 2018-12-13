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
public class practice8 extends JFrame implements ActionListener{

    

    JButton b1;
    TextArea ta;
    TextArea ta2;
    JPanel panel;
    Map hm;
    SortedSet ts;
    String text;
    Integer i;
    int wordCount;
    
    public practice8(String text){
        this.text = text;
        ta = new TextArea("Replace: ",1,10,3);
        ta2 = new TextArea("With: ",1,10,3);
        b1 = new JButton("Replace");
        b1.addActionListener(this);
        panel = new JPanel();
        panel.add(ta);
        panel.add(ta2);
        panel.add(b1);
        add(panel);
        hm = Collections.synchronizedMap(new HashMap());//hashmap to keep count
        ts = Collections.synchronizedSortedSet(new TreeSet());//my treeset to alphebatize the string tokens later

        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand() == "Replace"){
                //text = ta.getText();
                StringTokenizer st = new StringTokenizer(text);//will split the text into tokens
                while(st.hasMoreTokens()){
                    String getToken = st.nextToken();
                    String getWord = ta.getText();
                    String getReplacingWord = ta2.getText();
                    //System.out.println(getToken);
                    //System.out.println(ta.getText());
                    //System.out.println(ta2.getText());
                    if(getToken == getWord){//i'd forgotten, making a string equal to another string is complex
                        getToken = getReplacingWord;
                        System.out.println("Replaced");
                    }
                    if(hm.containsKey(getToken)){
                        i = (Integer)hm.get(getToken);
                        int incr = i.intValue();
                        incr ++;
                        i = new Integer(incr);
                        hm.put(getToken,i);
                    }
                    else{
                        i = 1;
                        hm.put(getToken,i);
                    }
                    ts.add(getToken);
                    
                }
                
                Iterator it = ts.iterator();
                while(it.hasNext()){
                    System.out.println((String)it.next()+ " ");
                    wordCount ++;
                }
            }
    
    }
    public static void main(String [] args) throws Exception{
        practice8 me = new practice8("Hi, and I feel very sick right now, but I will strive through it anyway.");
    }
    

   
    
}
