package inn;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Verrvv {
    private static final String URL_BASE_DATOS = "jdbc:sqlite:src/base/Aggenda.db";

    public static void verificarBaseDatosYTabla() {
        if (!existeBaseDatos()) {
            crearBaseDatos();
        }

        if (!existeTablaClientes()) {
            crearTablaClientes();
        }

        if (!existeTablaProvved()) {
            crearTablaProvved();
        }
    }

    private static boolean existeBaseDatos() {
        File file = new File("src/base/Aggenda.db");
        return file.exists();
    }

    private static boolean existeTablaClientes() {
        try (Connection conn = DriverManager.getConnection(URL_BASE_DATOS);
             Statement stmt = conn.createStatement()) {
            String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='Clientes';";
            return stmt.executeQuery(query).next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean existeTablaProvved() {
        try (Connection conn = DriverManager.getConnection(URL_BASE_DATOS);
             Statement stmt = conn.createStatement()) {
            String query = "SELECT name FROM sqlite_master WHERE type='table' AND name='Provved';";
            return stmt.executeQuery(query).next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void crearBaseDatos() {
        try {
            Files.createDirectories(Paths.get("src/base"));
            Connection conn = DriverManager.getConnection(URL_BASE_DATOS);
            conn.close();
            System.out.println("Base de datos creada en src/base/Aggenda.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearTablaClientes() {
        String query = "CREATE TABLE Clientes (" +
                "id_cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                "client_nombre VARCHAR(50) NOT NULL," +
                "client_apellido VARCHAR(50) NOT NULL," +
                "cl_telefono INTEGER," +
                "cl_correo VARCHAR(50)" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL_BASE_DATOS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabla Clientes creada en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void crearTablaProvved() {
        String query = "CREATE TABLE Provved (" +
                "id_provved INTEGER PRIMARY KEY AUTOINCREMENT," +
                "provved_nombre VARCHAR(50) NOT NULL," +
                "provved_apellido VARCHAR(50) NOT NULL," +
                "pv_telefono INTEGER," +
                "pv_correo VARCHAR(50)" +
                ");";

        try (Connection conn = DriverManager.getConnection(URL_BASE_DATOS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabla Provved creada en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        verificarBaseDatosYTabla();
    }
}
