package inn;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private String url = "jdbc:sqlite:src/base/Aggenda.db";
	private JButton bttnVolver;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClient frame = new ListClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 568, 152);
		contentPane.add(panel);
		panel.setLayout(null);

		String[] columnas = { "Nombre", "Apellido", "Teléfono", "Correo" };
		final DefaultTableModel model = new DefaultTableModel(columnas, 0);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 568, 152);
		panel.add(scrollPane);

		bttnVolver = new JButton("Volver");
		bttnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app newframe = new app();
				newframe.setVisible(true);

				dispose();
			}
		});

		bttnVolver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bttnVolver.setBounds(489, 291, 89, 23);
		contentPane.add(bttnVolver);

		Cargardatos(model);
	}

	private void Cargardatos(DefaultTableModel model) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url);
			String query = "SELECT client_nombre, client_apellido, cl_telefono, cl_correo FROM Clientes";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Object[] fila = new Object[4];
				fila[0] = rs.getString("client_nombre");
				fila[1] = rs.getString("client_apellido");
				fila[2] = rs.getString("cl_telefono");
				fila[3] = rs.getString("cl_correo");
				model.addRow(fila);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}