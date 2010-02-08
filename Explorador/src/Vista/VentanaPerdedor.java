package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaPerdedor extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public VentanaPerdedor(){
		ImageIcon imagenIcono=new ImageIcon("recursos/imagenes/IconoPrincipal.png"); 
		this.setIconImage(imagenIcono.getImage());
		this.setTitle("|  Explorador  |  PERDEDOR");
		int ancho= this.getWidth();
		int alto= this.getHeight();
		this.setSize(ancho,alto);
		
		ImageIcon imagen= new ImageIcon("recursos/imagenes/perdedor.jpg");
		if (imagen!=null){
			ancho=imagen.getIconWidth();
			alto=imagen.getIconHeight();
		}
		this.setResizable(false);
		this.setSize(ancho, alto+15);
		this.setLocationByPlatform(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		this.getContentPane().add(new JLabel(imagen));
	}
}
