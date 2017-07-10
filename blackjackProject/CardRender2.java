import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.*;

//a class to render a physical representation of a card
public class CardRender2 extends JComponent{
  
  BufferedImage image; //a image to be assigned to a CardRender2 instance
  String val; //a name value
  String suit; //a suit
  String filename; //a file name, which is later fetched thru an instance method
  
  //CardRender2 constructor, with a Card object as parameter
  public CardRender2(Card card) {
    this.val = card.value.face;   //calls card's CardValue face
    this.suit = card.suit.toString(); //calls toString on the enum suit
    filename = this.fetchCardFileLabel(); //assigns the filename instance variable on the output of calling fetchCardFileLabel()
    
    URL cardview = getClass().getResource("card deck/" + filename + ".png"); //used to pull the data at file location and convert into URL
    try {
      
      image = ImageIO.read(cardview); //assigns the reading of cardview to the this.image 
    } catch (IOException e) { //throw exception if not found and print stack trace
      e.printStackTrace();
    }
    
  }
  
  //works similarly to CardRender2(Card card) but used solely for dealer's first card
  public CardRender2(){
    this.val = null;
    this.suit = null;
    filename = "DEALER_FIRST_CARD";
    
    URL cardview = getClass().getResource("card deck/DEALER_FIRST_CARD.png");
    try {
      
      image = ImageIO.read(cardview);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  //paint the card
  @Override
  protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    g2.drawImage(image, 0, 0, null);
    
  }
  //get its size
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(image.getWidth(), image.getHeight());
  }
  
  // used to get the card's file label; all card file labels are their face's first character 
  //(except 10, which gets first 2) and the first letter of their suit
  public String fetchCardFileLabel(){
    String first = null;
    String second = suit.substring(0,1); //gets the first letter of the suit
    if(!val.equals("10"))
      first = val.substring(0,1); //gets the first letter of file name for all numbers except 10
    else                             
      first = val.substring(0,2); //gets first characters of 10
    
    return "" + first + second; //returns the file name before extension
    
  }
  //tests to see if placeable on jframe and jpanel objects, as well as to test constructors
  public static void main(String[] args){
    CardRender2 dealerfirst = new CardRender2();
    JPanel j = new JPanel();
    //j.setSize(dealerfirst.getPreferredSize());
    j.add(dealerfirst);
    JFrame jf = new JFrame();
    jf.add(j);
    jf.setSize(dealerfirst.getPreferredSize());
    jf.setVisible(true);
    
    j.setVisible(true);
    CardRender2 k = new CardRender2(new Card());
    JFrame j2 = new JFrame();
    j2.add(k);
    j2.setSize(k.getPreferredSize());
    j2.setVisible(true);
    
  }
  
}