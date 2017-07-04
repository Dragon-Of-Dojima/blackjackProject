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


public class BlackjackTable3 extends JFrame {

  
  JButton stayButton = new JButton("STAY");
  JButton hitButton = new JButton("HIT");
  JPanel mainPanel = new JPanel();

  public BlackjackTable3() {
    this.setTitle("Blackjack Test Table");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel tablePanel = new JPanel();
    ImageIcon pic = new ImageIcon("blackjackTableCanvas.jpg");
    mainPanel.add(new JLabel(pic), BorderLayout.PAGE_START);
    
    
 
    
    this.add(mainPanel);
    this.setSize(1200,1600);
    
    
    JPanel buttonPanel = new JPanel();
    ActionListener pressChoice = new DecisionListener();
    hitButton.addActionListener(pressChoice);
    stayButton.addActionListener(pressChoice);
    
    buttonPanel.setSize(300,150);
    buttonPanel.add(hitButton,BorderLayout.WEST);
   buttonPanel.add(stayButton,BorderLayout.EAST);
    buttonPanel.setVisible(true);
    this.add(buttonPanel, BorderLayout.SOUTH);
//    this.add(hitButton, BorderLayout.WEST);
//    this.add(stayButton, BorderLayout.EAST);
    this.setVisible(true);
    
  }
  

  
  class DecisionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
      //code for hit/stay to go here
      
      if(a.getSource() == hitButton){
        System.out.println("YOU CHOSE HIT!");
        CardRender2 c = new CardRender2(new Card());
        
        mainPanel.add(c, BorderLayout.SOUTH);
        //pack();
        revalidate();
        
        
      }
      else if(a.getSource() == stayButton){
        System.out.println("YOU CHOSE STAY!");
      }
      
    }
  }
  
  
  
  public static void main(String[] args){
    BlackjackTable3 b = new BlackjackTable3();

  }
  
}