import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame; //used for testing

public class HitOrStayButton extends JButton{

JButton stayButton = new JButton("STAY");
JButton hitButton = new JButton("HIT");

public HitOrStayButton(){
  ActionListener pressChoice = new DecisionListener();
  hitButton.addActionListener(pressChoice);
  stayButton.addActionListener(pressChoice);
  JPanel testPanel = new JPanel();
  testPanel.add(hitButton);
  testPanel.add(stayButton);
  JFrame testFrame = new JFrame();
  testFrame.add(testPanel);
  testFrame.setSize(300, 150);
  testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  testFrame.setVisible(true);
}

class DecisionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
      //code for hit/stay to go here
      if(a.getSource() == hitButton){
        System.out.println("YOU CHOSE HIT!");
      }
      else if(a.getSource() == stayButton){
        System.out.println("YOU CHOSE STAY!");
      }
      
    }
  }
  

  public static void main(String[] args){
    HitOrStayButton h = new HitOrStayButton();
    
    
  
  
  }
  
}