package inn;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class ListProvved extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private String url = "jdbc:sqlite:src/base/Aggenda.db";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ListProvved frame = new ListProvved();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ListProvved() {
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

        String[] columnas = {"Nombre", "Apellido", "Teléfono", "Correo"};
        final javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnas, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 568, 152);
        panel.add(scrollPane);

        JButton bttnVolver = new JButton("Volver");
        bttnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app newframe = new app();
                newframe.setVisible(true);
                dispose();
            }
        });
        bttnVolver.setBounds(489, 290, 89, 23);
        contentPane.add(bttnVolver);
        Cargardatos(model);
    }

    private void Cargardatos(javax.swing.table.DefaultTableModel model) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url);
            String query = "SELECT provved_nombre, provved_apellido, pv_telefono, pv_correo FROM Provved";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("provved_nombre");
                fila[1] = rs.getString("provved_apellido");
                fila[2] = rs.getString("pv_telefono");
                fila[3] = rs.getString("pv_correo");
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