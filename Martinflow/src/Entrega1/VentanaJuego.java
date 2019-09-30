package Entrega1;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	JPanel pPrincipal;
	CocheJuego miCoche;
	MiRunnable Hilo;
	public VentanaJuego() {
		JFrame v = new JFrame();
		v.setSize(600, 400);
		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel pBotonera = new JPanel();
		JPanel pPrincipal = new JPanel();
		pPrincipal.setLayout(null);
		pPrincipal.setBackground(Color.white);
		
		
		JButton bAcelerar = new JButton("Acelerar");
		JButton bFrena = new JButton("Frena");
		JButton bGiraIzquierda = new JButton("Gira Izquierda ");
		JButton bGiraDerecha = new JButton("Gira Derecha");
		pBotonera.add(bAcelerar);
		pBotonera.add(bFrena);
		pBotonera.add(bGiraDerecha);
		pBotonera.add(bGiraIzquierda);
	
		v.add(pPrincipal,"Center");
		v.add(pBotonera,"South");
		
		
		 bAcelerar.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		        if (VentanaJuego.this.miCoche.getMiVelocidad() == 0.0D) {
		          VentanaJuego.this.miCoche.acelera(5.0D);
		        } else {
		          VentanaJuego.this.miCoche.acelera(5.0D);
		        }
		        System.out.println("Nueva velocidad de coche: " + VentanaJuego.this.miCoche.getMiVelocidad());
		      }
		    });
		    bFrena.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		        VentanaJuego.this.miCoche.acelera(-5.0D);
		        System.out.println("Nueva velocidad de coche: " + VentanaJuego.this.miCoche.getMiVelocidad());
		      }
		    });
		    bGiraIzquierda.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		        VentanaJuego.this.miCoche.gira(10.0D);
		        System.out.println("Nueva direccion de coche: " + VentanaJuego.this.miCoche.getMiDireccionActual());
		      }
		    });
		    bGiraDerecha.addActionListener(new ActionListener()
		    {
		      public void actionPerformed(ActionEvent e)
		      {
		        VentanaJuego.this.miCoche.gira(-10.0D);
		        System.out.println("Nueva direccion de coche: " + VentanaJuego.this.miCoche.getMiDireccionActual());
		      }
		    });
		    
		    v.setVisible(true);
		
		
	}
	
	
	 public void creaCoche(int posX, int posY){
	      this.miCoche = new CocheJuego();
	      this.miCoche.setPosicion(posX, posY);
	      this.pPrincipal.add(this.miCoche.getGrafico());
	 }
	 
	public static void main(String[] args) {
		 VentanaJuego Juego = new VentanaJuego();
		 Juego.creaCoche(150, 100);
		 Juego.setVisible(true);
		 Juego.miCoche.setPiloto("Lander"); 
		 Thread nuevoHilo = new Thread(Juego.Hilo);
		 nuevoHilo.start();
	
	
}
	class MiRunnable implements Runnable{
		boolean continuar = true;
		@Override
		public void run() {
			while (this.continuar)
		      {
		        VentanaJuego.this.miCoche.mueve(0.04D);
		        if ((VentanaJuego.this.miCoche.getPosX() < -50.0D) || (VentanaJuego.this.miCoche.getPosX() > VentanaJuego.this.pPrincipal.getWidth() - 50))
		        {
		          System.out.println("Choca X");
		          double dir = VentanaJuego.this.miCoche.getMiDireccionActual();
		          dir = 180.0D - dir;
		          if (dir < 0.0D) {
		            dir += 360.0D;
		          }
		          VentanaJuego.this.miCoche.setDireccionActual(dir);
		        }
		        if ((VentanaJuego.this.miCoche.getPosY() < -50.0D) || (VentanaJuego.this.miCoche.getPosY() > VentanaJuego.this.pPrincipal.getHeight() - 50))
		        {
		          System.out.println("Choca Y");
		          double dir = VentanaJuego.this.miCoche.getMiDireccionActual();
		          dir = 360.0D - dir;
		          VentanaJuego.this.miCoche.setDireccionActual(dir);
		        }
		        try
		        {
		          Thread.sleep(40L);
		        }
		        catch (Exception localException) {}
		      }
		    }
		    
		    public void acaba()
		    {
		      this.continuar = false;
		    }
			
			
		}
		
	}

