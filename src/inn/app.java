package inn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Verrvv.verificarBaseDatosYTabla();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public app() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bttnCliente = new JButton("Agendar cliente");
		bttnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ag_cliente newframe = new Ag_cliente();
                newframe.setVisible(true);
                
                dispose();
			}
		});
		bttnCliente.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bttnCliente.setBounds(20, 29, 150, 50);
		contentPane.add(bttnCliente);
		
		JButton btnAgendarProveedor = new JButton("Agendar proveedor");
		btnAgendarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ag_provv newframe = new Ag_provv();
				newframe.setVisible(true);
				
				dispose();
			}
		});
		btnAgendarProveedor.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAgendarProveedor.setBounds(20, 90, 150, 50);
		contentPane.add(btnAgendarProveedor);
		
		JButton btnVerListaDe = new JButton("Ver lista de proveedores");
		btnVerListaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProvved newframe = new ListProvved();
				newframe.setVisible(true);
				
				dispose();
			}
		});
		btnVerListaDe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVerListaDe.setBounds(224, 29, 200, 50);
		contentPane.add(btnVerListaDe);
		
		JButton btnVerLista = new JButton("Ver lista de clientes");
		btnVerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListClient newframe = new ListClient();
				newframe.setVisible(true);
				
				dispose();
			}
		});
		btnVerLista.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnVerLista.setBounds(224, 90, 200, 50);
		contentPane.add(btnVerLista);
		
		JButton bttnSalir = new JButton("Cerrar");
		bttnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bttnSalir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		bttnSalir.setBounds(324, 195, 100, 25);
		contentPane.add(bttnSalir);
	}
}
