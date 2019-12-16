import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.ImageIcon;

public class ImagePanel extends JPanel{

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	  }

	  public void paintComponent(Graphics g) {
		  Graphics2D g2d = (Graphics2D) g;
		  int x = (this.getWidth() - img.getWidth(null)) / 2;
		  int y = (this.getHeight() - img.getHeight(null)) / 2;
		  g.drawImage(img, x, y, null);
	  }
}
