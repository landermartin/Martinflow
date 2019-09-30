package Entrega1;
import java.awt.Component;

public class CocheJuego extends Coche{

	private JLabelCoche micoche;
	
	public CocheJuego() {
		this.micoche = new JLabelCoche();
	
	}

	public void setPosX(double posX)
	  {
	    super.setPosX(posX);
	    this.micoche.setLocation((int)posX, (int)this.posY);
	  }
	  
	  public void setPosY(double posY)
	  {
	    super.setPosY(posY);
	    this.micoche.setLocation((int)this.posX, (int)posY);
	  }
	  
	  public void setDireccionActual(double dir)
	  {
	    super.setMiDireccionActual(dir);
	    this.micoche.setGiro(this.miDireccionActual);
	    this.micoche.repaint();
	  }

	public Component getGrafico() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPosicion(int posX, int posY) {
		// TODO Auto-generated method stub
		
	}

}
