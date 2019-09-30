package PracticaClase;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Hilos1 extends JFrame {
	
	private static final ActionListener ActionEvent = null;
	private static Random r = new Random();
	private static void procesoConfirmar() {
		try {
			Thread.sleep(5000 + 1000*r.nextInt(6));
		}catch (Exception e) {
			
		}
	}
	public static void main(String[] args) {
		JFrame v = new JFrame();
		v.setSize(600, 400);
		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		v.setVisible(true);
		JTextField tfDato = new JTextField(20);
		v.add(tfDato);
		JButton bAceptar = new JButton("Aceptar");
		v.add(bAceptar,BorderLayout.SOUTH);
		v.setVisible(true);
		bAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				procesoConfirmar();
			}
		});
	
	}
}
