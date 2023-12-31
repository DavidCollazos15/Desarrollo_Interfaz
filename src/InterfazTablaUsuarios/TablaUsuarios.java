package InterfazTablaUsuarios;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TablaUsuarios {
    public static void main(String[] args) throws SQLException {
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 800, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(new BorderLayout(0, 0));

        // Establecer la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/DesarrolloInterfaces";
        String usuario = "root";
        String contrasena = "admin";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);

        Statement statement = conexion.createStatement();
        String consulta = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(consulta);

        // Crear el contenedor principal con GridBagLayout
        JPanel contenedor = new JPanel(new GridBagLayout());
        ventana.add(contenedor);

        // Paneles
        JPanel TituloPanel = new JPanel();
        JPanel inputPanel = new JPanel(new GridBagLayout()); // Panel para introducción de datos
        JPanel buttonPanel = new JPanel(); // Panel para los botones
        GridBagConstraints ordenar = new GridBagConstraints(); // Crear el GridBagLayout

        // Título
        JLabel tituloLabel = new JLabel("Gestión de Usuarios");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Ajustar el estilo del título

        // Etiquetas y campos de la izquierda
        JLabel idLabel = new JLabel("ID: ");
        JLabel dniLabel = new JLabel("DNI: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField idField = new JTextField(5);
        idField.setEditable(false);
        idField.setText("1"); // Establecer el ID inicial

        JTextField dniField = new JTextField(10);
        JTextField passwordField = new JPasswordField(10);

        // Etiquetas y campos de la derecha
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel apellidosLabel = new JLabel("Apellidos: ");
        JLabel emailLabel = new JLabel("Email: ");

        JTextField nombreField = new JTextField(15);
        JTextField apellidosField = new JTextField(20);
        JTextField emailField = new JTextField(20);

        // Botones
        JButton nuevoButton = new JButton("Nuevo");
        JButton anadirButton = new JButton("Añadir");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");

        // Agregar componentes a los paneles
        TituloPanel.add(tituloLabel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(dniLabel, gbc);
        gbc.gridy = 2;
        inputPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(idField, gbc);
        gbc.gridy = 1;
        inputPanel.add(dniField, gbc);
        gbc.gridy = 2;
        inputPanel.add(passwordField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(nombreLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(apellidosLabel, gbc);
        gbc.gridy = 2;
        inputPanel.add(emailLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        inputPanel.add(nombreField, gbc);
        gbc.gridy = 1;
        inputPanel.add(apellidosField, gbc);
        gbc.gridy = 2;
        inputPanel.add(emailField, gbc);

        buttonPanel.add(nuevoButton);
        buttonPanel.add(anadirButton);
        buttonPanel.add(modificarButton);
        buttonPanel.add(eliminarButton);

        // Tabla
        DefaultTableModel ModeloTabla = new DefaultTableModel();
        ModeloTabla.addColumn("ID");
        ModeloTabla.addColumn("Nombre");
        ModeloTabla.addColumn("Apellidos");
        ModeloTabla.addColumn("DNI");
        ModeloTabla.addColumn("Email");
        ModeloTabla.addColumn("Contraseña");

        JTable tabla = new JTable(ModeloTabla);
        for (int column = 0; column < tabla.getColumnCount(); column++) {
            Class<?> col_class = tabla.getColumnClass(column);
            tabla.setDefaultEditor(col_class, null);
        }

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

        // Agregar un ListSelectionListener a la tabla para llenar los campos al seleccionar una fila
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tabla.getSelectedRow();
                if (selectedRow != -1) {
                    idField.setText(tabla.getValueAt(selectedRow, 0).toString());
                    nombreField.setText(tabla.getValueAt(selectedRow, 1).toString());
                    apellidosField.setText(tabla.getValueAt(selectedRow, 2).toString());
                    dniField.setText(tabla.getValueAt(selectedRow, 3).toString());
                    emailField.setText(tabla.getValueAt(selectedRow, 4).toString());
                    passwordField.setText(tabla.getValueAt(selectedRow, 5).toString());
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(tabla);

        final int[] proximoID = {1}; // Variable para llevar el control del ID

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

        // Funciones de los botones
        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        // Agregar componentes al contenedor utilizando GridBagLayout
        ordenar.fill = GridBagConstraints.BOTH;
        ordenar.weightx = 1.0;
        ordenar.weighty = 0.0;
        ordenar.gridwidth = 1;

        ordenar.gridy = 0;
        contenedor.add(TituloPanel, ordenar);

        ordenar.gridx = 0;
        ordenar.gridy = 1;
        contenedor.add(inputPanel, ordenar);

        ordenar.gridy = 2;
        contenedor.add(buttonPanel, ordenar);

        ordenar.weighty = 1.0;
        ordenar.gridy = 3;
        contenedor.add(scrollPane, ordenar);

        ventana.add(contenedor);
        ventana.setVisible(true);
    }
}

