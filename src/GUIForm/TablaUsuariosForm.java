package GUIForm;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TablaUsuariosForm {

    private JPanel panel1;
    private JTextField idField;
    private JTextField dniField;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton nuevoButton;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JTable tabla;
    private JLabel idLabel;
    private JLabel dniLabel;
    private JLabel passwordLabel;
    private JPanel tituloLabel;
    private JPanel tablaPanel;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JLabel nombreLabel;
    private JLabel apellidosLabel;
    private JLabel emailLabel;
    private JFrame ventana;
    private static final String URL = "jdbc:mysql://localhost:3306/desarrollointerfaces";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private ResultSet resultSet;

        public static void main(String[] args) throws SQLException {
        final JFrame ventana = new JFrame("TablaUsuariosForm");
        ventana.setContentPane(new TablaUsuariosForm().panel1);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setMinimumSize(new Dimension(800, 400));
    }

    public TablaUsuariosForm() throws SQLException {

        Connection conexion = getConnection();
        Statement statement = conexion.createStatement();
        String consulta = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(consulta);

        DefaultTableModel ModeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que todas las celdas no sean editables
            }
        };

        ModeloTabla.addColumn("ID");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Apellidos");
        ModeloTabla.addColumn("DNI");
        ModeloTabla.addColumn("Email");
        ModeloTabla.addColumn("Password");

        tabla.setModel(ModeloTabla);

        // Inicializar el ID en 1
        idField.setText("1");

        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();

                    if (selectedRow != -1) {
                        // Obtener los valores de la fila seleccionada
                        String id = tabla.getValueAt(selectedRow, 0).toString();
                        String nombre = tabla.getValueAt(selectedRow, 1).toString();
                        String apellido = tabla.getValueAt(selectedRow, 2).toString();
                        String dni = tabla.getValueAt(selectedRow, 3).toString();
                        String email = tabla.getValueAt(selectedRow, 4).toString();
                        String password = tabla.getValueAt(selectedRow, 5).toString();

                        // Llenar los campos de texto con los valores
                        idField.setText(id);
                        nombreField.setText(nombre);
                        apellidosField.setText(apellido);
                        dniField.setText(dni);
                        emailField.setText(email);
                        passwordField.setText(password);
                    }
                }
            }
        });

        //Que el usuario no pueda mover las columnas
        tabla.getTableHeader().setReorderingAllowed(false);

        //Que la contraseña se mantenga oculta en la tabla
        DefaultTableCellRenderer contrasenaRenderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value){
                if (value != null){
                    String contrasena = (String) value;
                    String contrasenaOculta = "*".repeat(contrasena.length());
                    setText(contrasenaOculta);
                }else {
                    setText("");
                }
            }
        };
        tabla.getColumnModel().getColumn(5).setCellRenderer(contrasenaRenderer);

        // Variable para llevar el control del ID
        final int[] proximoID = {1};

        //Mostrar datos de la base de datos
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("username");
            String apellidos = resultSet.getString("surname");
            String dni = resultSet.getString("dni");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            ModeloTabla.addRow(new Object[]{id, nombre, apellidos, dni, email, password});
            proximoID[0]=id+1;
            idField.setText(String.valueOf(proximoID[0]));
        }

        //Funciones botones
        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restablecer los campos de texto
                nombreField.setText("");
                apellidosField.setText("");
                dniField.setText("");
                emailField.setText("");
                passwordField.setText("");
                idField.setText(String.valueOf(proximoID[0]));
            }
        });

        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String dni = dniField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();

                if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                    boolean passwordExists = false;

                    // Verificar si la contraseña ya existe en la tabla
                    for (int row = 0; row < ModeloTabla.getRowCount(); row++) {
                        String existingPassword = (String) ModeloTabla.getValueAt(row, 5);
                        if (password.equals(existingPassword)) {
                            passwordExists = true;
                            break;
                        }
                    }
                    if (!passwordExists) {
                        try {
                            // Insertar el nuevo usuario en la base de datos
                            String insertQuery = "INSERT INTO users (username, surname, dni, email, password) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement preparedStatement = conexion.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                            preparedStatement.setString(1, nombre);
                            preparedStatement.setString(2, apellidos);
                            preparedStatement.setString(3, dni);
                            preparedStatement.setString(4, email);
                            preparedStatement.setString(5, password);

                            int affectedRows = preparedStatement.executeUpdate();

                            if (affectedRows > 0) {
                                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                                int idUsuarioInsertado = -1;
                                if (generatedKeys.next()) {
                                    idUsuarioInsertado = generatedKeys.getInt(1);
                                }

                                // Agregar el nuevo usuario a la tabla en la interfaz
                                ModeloTabla.addRow(new Object[]{idUsuarioInsertado, nombre, apellidos, dni, email, password});
                                JOptionPane.showMessageDialog(ventana, "Usuario agregado a la base de datos.");
                                proximoID[0]++;
                                idField.setText(String.valueOf(proximoID[0])); // Actualizar el ID en el campo
                                nombreField.setText("");
                                apellidosField.setText("");
                                dniField.setText("");
                                emailField.setText("");
                                passwordField.setText("");
                                idField.setText(String.valueOf(proximoID[0]));

                            } else {
                                JOptionPane.showMessageDialog(ventana, "No se pudo agregar el usuario a la base de datos.");
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(ventana, "Error al agregar usuario a la base de datos.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(ventana, "La contraseña no es servible");
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "Nombre, apellidos y email son campos obligatorios.");
                }
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabla.getSelectedRow();
                if (selectedRow != -1) {
                    String id = tabla.getValueAt(selectedRow, 0).toString();
                    String nombre = nombreField.getText();
                    String apellidos = apellidosField.getText();
                    String dni = dniField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();

                    if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                        ModeloTabla.setValueAt(nombre, selectedRow, 1);
                        ModeloTabla.setValueAt(apellidos, selectedRow, 2);
                        ModeloTabla.setValueAt(dni, selectedRow, 3);
                        ModeloTabla.setValueAt(email, selectedRow, 4);
                        ModeloTabla.setValueAt(password, selectedRow, 5);

                        // Actualizar los datos en la base de datos
                        String updateQuery = "UPDATE users SET username = ?, surname = ?, dni = ?, email = ?, password = ? WHERE id = ?";
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = conexion.prepareStatement(updateQuery);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {

                            preparedStatement.setString(1, nombre);
                            preparedStatement.setString(2, apellidos);
                            preparedStatement.setString(3, dni);
                            preparedStatement.setString(4, email);
                            preparedStatement.setString(5, password);
                            preparedStatement.setString(6, id);
                            preparedStatement.executeUpdate();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(ventana, "Usuario actualizado en la base de datos.");

                    } else {
                        JOptionPane.showMessageDialog(ventana, "Nombre, apellidos y email son campos obligatorios.");
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione una fila para modificar.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tabla.getSelectedRow();
                if (selectedRow != -1) {
                    String id = tabla.getValueAt(selectedRow, 0).toString();

                    int confirm = JOptionPane.showConfirmDialog(ventana, "¿Está seguro de eliminar este usuario?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        try {
                            // Eliminar el registro de la base de datos
                            String deleteQuery = "DELETE FROM users WHERE id = ?";
                            PreparedStatement preparedStatement = conexion.prepareStatement(deleteQuery);
                            preparedStatement.setString(1, id);

                            preparedStatement.executeUpdate();
                            ModeloTabla.removeRow(selectedRow);
                            JOptionPane.showMessageDialog(ventana, "Usuario eliminado de la base de datos.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(ventana, "Error al eliminar usuario de la base de datos.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione una fila para eliminar.");
                }
            }
        });

    }
}
