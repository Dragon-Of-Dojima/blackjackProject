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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BlackjackTable2 extends JFrame {

  
  JButton stayButton = new JButton("STAY");
  JButton hitButton = new JButton("HIT");
  JPanel mainPanel = new JPanel();

  public BlackjackTable2() {
    this.setTitle("Blackjack Test Table");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //JPanel tablePanel = new JPanel();
    ImageIcon pic = new ImageIcon("blackjackTableCanvas.jpg");
    mainPanel.add(new JLabel(pic));
    
    this.add(mainPanel, BorderLayout.PAGE_START);
    this.setSize(1200,900);
    this.setVisible(true);
    
    JPanel buttonPanel = new JPanel();
    ActionListener pressChoice = new DecisionListener();
    hitButton.addActionListener(pressChoice);
    stayButton.addActionListener(pressChoice);
    
    buttonPanel.setSize(300,150);
    buttonPanel.add(hitButton,BorderLayout.WEST);
   buttonPanel.add(stayButton,BorderLayout.EAST);
    buttonPanel.setVisible(true);
    this.add(buttonPanel);
//    this.add(hitButton, BorderLayout.WEST);
//    this.add(stayButton, BorderLayout.EAST);
    
  }
  

  
  class DecisionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
      //code for hit/stay to go here
      if(a.getSource() == hitButton){
        System.out.println("YOU CHOSE HIT!");
        add(new CardAdder2(new Card())); //could work
        
      }
      else if(a.getSource() == stayButton){
        System.out.println("YOU CHOSE STAY!");
      }
      
    }
  }
  
  public class CardAdder2 extends JComponent{

  String val;
  String suit;
  
    
  public CardAdder2(Card card){
    this.val = card.value.face;
    this.suit = card.suit.toString();
    String filename = this.fetchCardFileLabel();
    JFrame frame = new JFrame();
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
  }
  
  
  public static void main(String[] args){
    BlackjackTable2 b = new BlackjackTable2();

  }
  
}