package Conectar_Base_de_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer la conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/test";
            String usuario = "root";
            String contrasena = "admin";
            conexion = DriverManager.getConnection(url, usuario, contrasena);

            // Comprobar si la conexión se estableció correctamente
            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos MySQL!");
                // Aquí podrías realizar operaciones en la base de datos
            }
        } catch (SQLException e) {
            // Imprimir el stack trace en caso de excepción
            e.printStackTrace();
        } finally {
            // Cerrar la conexión al finalizar (si se estableció)
            try {
                if (conexion != null) {
                    conexion.close();
                    System.out.println("Conexión cerrada.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}