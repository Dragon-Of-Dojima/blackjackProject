import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecisionListener implements ActionListener{
    
    public void actionPerformed(ActionEvent a){
      //code for hit/stay to go here
      if(a.getSource() == HitOrStayButton.hitButton){
        System.out.println("YOU CHOSE HIT!");
      }
      else if(a.getSource() == HitOrStayButton.stayButton){
        System.out.println("YOU CHOSE STAY!");
      }
      
    }
  }