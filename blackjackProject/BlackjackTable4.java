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
import java.awt.FlowLayout;

public class BlackjackTable4 extends JFrame{
  
  JButton stayButton = new JButton("STAY");
  JButton hitButton = new JButton("HIT");
  JLabel background;
  
  class DecisionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
      //code for hit/stay to go here
      //FlowLayout f = new FlowLayout();
      
      if(a.getSource() == hitButton){
        System.out.println("YOU CHOSE HIT!");
        CardRender2 c = new CardRender2(new Card());
        //FlowLayout f = new FlowLayout();
        background.add(c);

        revalidate();
      }
      else if(a.getSource() == stayButton){
        System.out.println("YOU CHOSE STAY!");
      }
      
    }
  }
  
  public BlackjackTable4(){
    
    this.setTitle("Blackjack");
    background = new TableComponent();
    background.setLayout(new FlowLayout(0,0,50));
    this.add(background,BorderLayout.CENTER);
    this.setVisible(true);
    this.setSize(1300,867);
    
    JPanel buttonPanel = new JPanel();
    JLabel score = new JLabel("Your score: ");
    ActionListener pressChoice = new DecisionListener();
    hitButton.addActionListener(pressChoice);
    stayButton.addActionListener(pressChoice);
    buttonPanel.setSize(300,150);
    buttonPanel.add(hitButton,BorderLayout.WEST);
    buttonPanel.add(stayButton,BorderLayout.EAST);
    buttonPanel.add(score, BorderLayout.PAGE_END);
    buttonPanel.setVisible(true);
    

    
    
    this.add(buttonPanel, BorderLayout.SOUTH);
  } 
  
  public static void main(String[] args){
    BlackjackTable4 f = new BlackjackTable4();
  }
  
}