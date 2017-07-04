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

public class CardRender extends JComponent{

  private Card c;
  String fileName;
  
  public CardRender(){
    this.c = new Card();
    this.fileName = this.fetchCardLabel();
    JFrame frame = new JFrame(); // when this class is instantiated in another file, it will be JFrame frame = new BlackjackTable(); or something close
    JLabel lab = new JLabel(new ImageIcon("card deck\\" + fileName + ".png"));
    frame.add(lab);
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    //System.out.println("" + c.value.face + " of " + c.suit);
  }
  
  
  public String fetchCardLabel(){
    String first = null;
    String second = null;
    switch(c.value.face){
      case "A":
        first = "A";
        break;
      case "K":
        first = "K";
        break;
      case "Q":
        first = "Q";
        break;
      case "J":
        first = "J";
        break;
      case "10":
        first = "10";
        break;
      case "9":
        first = "9";
        break;
      case "8":
        first = "8";
        break;
      case "7":
        first = "7";
        break;
      case "6":
        first = "6";
        break;
      case "5":
        first = "5";
        break;
      case "4":
        first = "4";
        break;
      case "3":
        first = "3";
        break;
      case "2":
        first = "2";
      break;
    }
    { 
    switch(c.suit){
      case CLUBS:
        second = "C";
        break;
      case DIAMONDS:
        second = "D";
        break;
      case HEARTS:
        second = "H";
        break;
      case SPADES:
        second = "S";
        break;
    }
    return "" + first + second;
    }
  }

  public static void main(String[] args){
    CardRender k = new CardRender();
//    Card c = new Card();
//    System.out.println("" + c.value.face + " of " + c.suit);
//    CardRender cr = new CardRender(c); later u can set back the instance c to be rawCard when rc is arg to constructor 
//    System.out.println(cr.fetchCardLabel());
  }
  



}