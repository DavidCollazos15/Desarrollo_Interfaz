package MVC.Modelo;

import java.sql.*;

public class TablaUsuariosM {

    public static Statement Conexion_BBDD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/DesarrolloInterfaces";
        String usuario = "root";
        String contrasena = "admin";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
        return conexion.createStatement();
    }
    public void Agregar_BBDD(String nombre, String apellido, String dni, String email, String password) throws SQLException {
        Statement statement = Conexion_BBDD();
        String insertQuery = "INSERT INTO users (username, surname, dni, email, password) " +
                "VALUES ('" + nombre + "', '" + apellido + "', '" + dni + "', '" +
                email + "', '" + password + "')";
        statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
    }

    public void Elimianar_BBDD(int id) throws SQLException {
        Statement statement = Conexion_BBDD();
        String deleteQuery = "DELETE FROM users WHERE id = " + id;
        statement.executeUpdate(deleteQuery);
    }

    public void Actualizar_BBDD(int id, String username, String surname, String dni, String email, String password) throws SQLException {
        Statement statement = Conexion_BBDD();

        String updateQuery = "UPDATE users SET " +
                "username = '" + username + "', " +
                "surname = '" + surname + "', " +
                "dni = " + dni + ", " +
                "email = '" + email + "', " +
                "password = '" + password + "' " +
                "WHERE id = " + id;

        statement.executeUpdate(updateQuery);
    }

    public ResultSet Obtener_BBDD() throws SQLException {
        Statement statement = Conexion_BBDD();
        String consulta = "SELECT * FROM users;";
        return statement.executeQuery(consulta);
    }

}
