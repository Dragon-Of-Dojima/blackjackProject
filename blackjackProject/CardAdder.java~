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

public class CardAdder extends JComponent{

  String val;
  String suit;
  
    
  public CardAdder(Card card){
    this.val = card.value.face;
    this.suit = card.suit.toString();
    String filename = this.fetchCardFileLabel();
    JFrame frame = new JFrame(); // when this class is instantiated in another file, it will be JFrame frame = new BlackjackTable(); or something close
    JLabel lab = new JLabel(new ImageIcon("card deck\\" + filename + ".png"));
    frame.add(lab);
    frame.setSize(400,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    /* for putting it in a panel instead
     *ImageIcon i = new ImageIcon("card deck\\" + filename + ".png");
    JPanel panel = new JPanel();
    panel.add(new JLabel(i)); 
     */
  }
  
    public String fetchCardFileLabel(){
      String first = null;
      String second = suit.substring(0,1);
    if(!val.equals("10"))
     first = val.substring(0,1);
    else
      first = val.substring(0,2);
    
    return "" + first + second;
    
  }
  
  public static void main(String[] args){
    Card c = new Card();
    CardAdder k = new CardAdder(c);
    System.out.println(k.fetchCardFileLabel());
  }

}