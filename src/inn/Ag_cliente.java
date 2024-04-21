package inn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class Ag_cliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private Connection conn;
    private String url = "jdbc:sqlite:src/base/Aggenda.db";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ag_cliente frame = new Ag_cliente();
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
	public Ag_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(45, 40, 86, 26);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellido.setBounds(45, 77, 86, 26);
		contentPane.add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelfono.setBounds(45, 114, 86, 26);
		contentPane.add(lblTelfono);
		
		JLabel lblNombre_2_1 = new JLabel("Correo");
		lblNombre_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre_2_1.setBounds(45, 151, 86, 26);
		contentPane.add(lblNombre_2_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 40, 201, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(141, 77, 201, 26);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(141, 114, 201, 26);
		contentPane.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(141, 151, 201, 26);
		contentPane.add(txtCorreo);
		
		JButton bttnGuardar = new JButton("Guardar");
        bttnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });
        bttnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        bttnGuardar.setBounds(22, 227, 125, 40);
        contentPane.add(bttnGuardar);
		
		JButton bttnNuevo = new JButton("Nuevo");
		bttnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApellido.setText("");
				txtTelefono.setText("");
				txtCorreo.setText("");
			}
		});
		bttnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bttnNuevo.setBounds(157, 227, 125, 40);
		contentPane.add(bttnNuevo);
		
		JButton bttnVolver = new JButton("Volver");
		bttnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app newframe = new app();
                newframe.setVisible(true);
                
                dispose();
			}
		});
		bttnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bttnVolver.setBounds(292, 227, 125, 40);
		contentPane.add(bttnVolver);
	}
	private void guardarCliente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText();

        try {
            conn = DriverManager.getConnection(url);

            if (!nombre.isEmpty() && !apellido.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
            	String sql = "INSERT INTO clientes (client_nombre, client_apellido, cl_telefono, cl_correo) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nombre);
                pstmt.setString(2, apellido);
                pstmt.setString(3, telefono);
                pstmt.setString(4, correo);

                pstmt.executeUpdate();

                pstmt.close();
                conn.close();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", " ", JOptionPane.DEFAULT_OPTION);
            } else {
            	JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
