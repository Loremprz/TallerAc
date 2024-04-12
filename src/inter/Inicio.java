package inter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Agendar cliente");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientevent newframe = new clientevent();
                newframe.setVisible(true);
                
                dispose();
            }
        });
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(65, 94, 200, 60);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(" Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 616, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnAgendarProveedor = new JButton("Agendar proveedor");
		btnAgendarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provevent newframe = new provevent();
                newframe.setVisible(true);
                
                dispose();
			}
		});
		
		btnAgendarProveedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAgendarProveedor.setBounds(65, 172, 200, 60);
		contentPane.add(btnAgendarProveedor);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBounds(526, 263, 100, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Ver clientes");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(356, 94, 200, 60);
		contentPane.add(btnNewButton_1);
	}
}
