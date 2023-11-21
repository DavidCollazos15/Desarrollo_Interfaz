package Conectar_Base_de_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    public static void main(String[] args) throws SQLException {
        // Establecer la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/DesarrolloInterfaces";
        String usuario = "root";
        String contrasena = "admin";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);

        // Query para insertar datos en la tabla
        String query = "INSERT INTO users (username, surname, dni, email, password) VALUES (?, ?, ?, ?, ?)";

        // Crear un objeto PreparedStatement para evitar SQL Injection
        PreparedStatement preparedStatement = conexion.prepareStatement(query);

        // Asignar valores a los parámetros del PreparedStatement
        preparedStatement.setString(1, "Ejemplo");
        preparedStatement.setString(2, "Apellido");
        preparedStatement.setString(3, "12345678A");
        preparedStatement.setString(4, "ejemplo@correo.com");
        preparedStatement.setString(5, "contraseña123");

        // Ejecutar la inserción de datos
        int filasInsertadas = preparedStatement.executeUpdate();

        if (filasInsertadas > 0) {
            System.out.println("Datos insertados correctamente.");
        } else {
            System.out.println("No se pudieron insertar los datos.");
        }

        // Cerrar el PreparedStatement y la conexión al finalizar
        preparedStatement.close();
        conexion.close();
        System.out.println("PreparedStatement cerrado y conexión cerrada.");
    }
}

