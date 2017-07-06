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

public class TableComponent extends JLabel{
  
  BufferedImage table;

  public TableComponent(){
  
        try {
        table = ImageIO.read(new File("blackjackTableCanvas.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }
  
  }
  
  @Override
protected void paintComponent(Graphics g) {
  Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g2);
    g2.drawImage(table, 0, 0, null);
}
  
  @Override
public Dimension getPreferredSize() {
    return new Dimension(table.getWidth(), table.getHeight());
}
  
  public static void main(String[] args){
    JFrame f = new JFrame();
    f.add(new TableComponent());
    f.setSize(1400,900);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}