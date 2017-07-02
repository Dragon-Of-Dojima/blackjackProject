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


public class BlackjackTable extends JComponent{
  
  private static final int WIDTH = 1200;
  private static final int HEIGHT = 800;
  private Rectangle table;
  
  public BlackjackTable(){
    table = new Rectangle(0,0,WIDTH,HEIGHT);
  
  }
  
  public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    g2.draw(table);
  }
  
  public static void main(String[] args){
    JFrame frame = new JFrame(); // when this class is instantiated in another file, it will be JFrame frame = new BlackjackTable(); or something close
    JLabel panel = new JLabel(new ImageIcon("blackjackTableCanvas.jpg"));
    HitOrStayButton h = new HitOrStayButton();
    
    frame.add(h);
    frame.setSize(WIDTH,HEIGHT);
    panel.setSize(WIDTH,HEIGHT);
    frame.add(panel);
    
    frame.setTitle("Test Canvas");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BlackjackTable sampleTable = new BlackjackTable();
    CardRender c = new CardRender();
    frame.add(sampleTable);
    frame.add(c);
    frame.setVisible(true);
    
    
    
  }

}