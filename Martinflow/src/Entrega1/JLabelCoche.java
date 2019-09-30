package Entrega1;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.prism.Graphics;


public class JLabelCoche extends JLabel{
	
	 private double miGiro = 1.5707963267948966D;
	 public static final int Tamaño = 100;
	  public JLabelCoche(){
	    try{
	      setIcon(new ImageIcon(JLabelCoche.class.getResource("coche.png")));
	    }
	    catch (Exception e){
	     
	      e.printStackTrace();
	    }
	    setBounds(0, 0, 100, 100);
	  }
	  
	  
	  public void setGiro(double gradosGiro){
	    this.miGiro = (gradosGiro / 180.0D * Math.PI);
	    this.miGiro = (-this.miGiro);
	    this.miGiro += 1.5707963267948966D;
	  }
	  
	  private void paintComponent(Graphics g){
	    Image img = ((ImageIcon)getIcon()).getImage();
	    Graphics2D g2 = (Graphics2D)g;
	    
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    g2.rotate(this.miGiro, 50.0D, 50.0D);
	    
	    g2.drawImage(img, 0, 0, 100, 100, null);
	  }
}
