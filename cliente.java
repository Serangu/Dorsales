import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class cliente {

	private static JFrame jf = new JFrame();
	private static JPanel arriba = new JPanel();
	private static JPanel abajo = new JPanel();
	private static JPanel izq = new JPanel();
	private static JPanel dcha = new JPanel();
	private static JLabel jl1 = new JLabel("ip");
	private static JLabel jl2 = new JLabel("puerto");
	private static JTextField jt1 = new JTextField(10);
	private static JTextField jt2 = new JTextField(10);
	private static JButton jb = new JButton("Enviar");


	public static void main(String[] args) {
	
		jf.setLayout(new GridLayout(0,1));
		jf.getContentPane().add(arriba);
		jf.getContentPane().add(abajo);
		arriba.setLayout(new GridLayout(1,0));
		arriba.add(izq);
		arriba.add(dcha);
		izq.add(jl1);
		izq.add(jt1);
		dcha.add(jl2);
		dcha.add(jt2);
		abajo.add(jb);

		boton();

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.pack();

	}

	public static void boton(){

		jb.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				
				try
				{
					String maquina = jt1.getText();
					String puerto = jt2.getText();
					Socket skCliente = new Socket(maquina, Integer.parseInt(puerto));
					InputStream aux = skCliente.getInputStream();
					DataInputStream flujo = new DataInputStream( aux );
					System.out.println( "Mi dorsal es el " + flujo.readInt() );
					skCliente.close();
				}
				catch( Exception en ){
					System.out.println( en.getMessage() );
				}

			}
		});		
	}

}