package Vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Juego.Juego;
import Tablero.Celda;
import Tablero.CeldaBomba;
import Tablero.CeldaCaliente;
import Tablero.CeldaEstrella;
import Tablero.CeldaExpansiva;
import Tablero.CeldaFria;
import Tablero.EstadoCelda;
import Tablero.Tablero;

public class VentanaPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ancho;
	private int alto;
	private JButton[][] botones;
	
	/**
	 * @param args
	 */
	public VentanaPrincipal(){
		
		Tablero tablero= Juego.getInstancia().getTablero();
		ancho= tablero.getRepresentacion().getAncho();
		alto= tablero.getRepresentacion().getAlto();
		botones= new JButton [ancho][alto];
		
		JPanel panelMedio=new JPanel(new GridLayout(alto,ancho));
		//	Crear y colocar botones
		for(int i=0;i<alto;i++)
			for(int j=0;j<ancho;j++)
				{
					//	Crear boton
					botones [j][i]=new JButton();
					//	Colocar en el panel
					panelMedio.add(botones[j][i]);
					//	Action Listener
					botones[j][i].addActionListener(this);
				}
		this.add(panelMedio,"Center");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,600);
		this.setTitle("|  Explorador  |");
		
		MenuItem juegoNuevo= new MenuItem("Juego Nuevo", new MenuShortcut(KeyEvent.VK_J));
		juegoNuevo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Juego.getInstancia().iniciar();
				redibujar();
			}
		});

		MenuItem salir= new MenuItem("Salir", new MenuShortcut(KeyEvent.VK_S));
		salir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}

		});
		

		Menu juego= new Menu("Juego");
		juego.add(juegoNuevo);
		juego.add(salir);
		
		MenuItem acercaDe= new MenuItem("Acerca de", new MenuShortcut(KeyEvent.VK_D));
		acercaDe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});

		MenuItem bayuda= new MenuItem("Ayuda", new MenuShortcut(KeyEvent.VK_F1,false));
		
		bayuda.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}

		});
		
		
		Menu ayuda = new Menu("Ayuda");
		ayuda.add(acercaDe);
		ayuda.add(bayuda);

		MenuBar barraDeMenu= new MenuBar();
		barraDeMenu.add(juego);
		barraDeMenu.add(ayuda);
		

		this.setMenuBar(barraDeMenu);
	}	

	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
			darVueltaLaCeldaCorrespondiente(ae);
			redibujar();
		
		}catch (Exception ex){}
	
	}

	private void redibujar() {
		Celda unaCelda;
		for(int i=0;i<ancho;i++)
			for(int j=0;j<alto;j++)
			{
				int numeroAsociado=0;
				unaCelda= (Celda)Juego.getInstancia().getTablero().getRepresentacion().getPosicion(i, j);
				numeroAsociado= unaCelda.getNumeroAsociado();
				if (unaCelda.getEstado()!= EstadoCelda.TAPADO){
					if (unaCelda instanceof CeldaEstrella){
						if (unaCelda.getEstado()== EstadoCelda.ENCONTRADO){
							botones[i][j].setBackground(Color.WHITE);
							ImageIcon imagenIcono=new ImageIcon("recursos/imagenes/estrella.png");
							botones[i][j].setIcon(imagenIcono);
						}
					}
					else if (unaCelda instanceof CeldaBomba){
						if (unaCelda.getEstado()== EstadoCelda.EXPLOTADO){
							botones[i][j].setBackground(Color.WHITE);
							ImageIcon imagenIcono=new ImageIcon("recursos/imagenes/bomba.png");
							botones[i][j].setIcon(imagenIcono);
						}
					}else if (unaCelda instanceof CeldaExpansiva){
						if (unaCelda.getEstado()== EstadoCelda.DADOVUELTA){
							botones[i][j].setBackground(Color.WHITE);
						}
					}else if (unaCelda instanceof CeldaFria){
						if (unaCelda.getEstado()== EstadoCelda.DADOVUELTA){
							botones[i][j].setBackground(Color.WHITE);
							if (numeroAsociado!=0){
								botones[i][j].setText(new Integer(numeroAsociado).toString());
								botones[i][j].setForeground(Color.BLUE);
							}
						}
					}else if (unaCelda instanceof CeldaCaliente){
						if (unaCelda.getEstado()== EstadoCelda.DADOVUELTA){
							botones[i][j].setBackground(Color.WHITE);
							if (numeroAsociado!=0){
								botones[i][j].setText(new Integer(numeroAsociado).toString());
								botones[i][j].setForeground(Color.RED);
							}
						}
					}
				}
			}
		
	}

	private void darVueltaLaCeldaCorrespondiente(ActionEvent ae) {
		Celda unaCelda;
		for(int i=0;i<ancho;i++)
			for(int j=0;j<alto;j++)
			{
				unaCelda= (Celda)Juego.getInstancia().getTablero().getRepresentacion().getPosicion(i, j);
				if(ae.getSource()==botones[i][j])
					unaCelda.darVuelta();
			}
	}

}
