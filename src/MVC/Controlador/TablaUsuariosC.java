package MVC.Controlador;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import MVC.Modelo.TablaUsuariosM;

public class TablaUsuariosC {
    private JPanel panel1;
    private JButton buttonNuevo;
    private JButton buttonEliminar;
    private JButton buttonAnadir;
    private JButton buttonModificar;
    private JTable table;
    private JTextField txtID;
    private JTextField txtDNI;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JPasswordField txtPassword;
    private JTextField txtEmail;
    private final TablaUsuariosM tablaUsuariosM;
    final int[] currentID = {1};

    // Constructor


    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("formulario");
        TablaUsuariosC form = new TablaUsuariosC();

        // Add some sample data to the table
        frame.setContentPane(form.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public TablaUsuariosC() {
        tablaUsuariosM = new TablaUsuariosM();
        cargarDatosDesdeBaseDeDatos();

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {
                        // Obtener los valores de la fila seleccionada
                        String id = table.getValueAt(selectedRow, 0).toString();
                        String nombre = table.getValueAt(selectedRow, 1).toString();
                        String apellido = table.getValueAt(selectedRow, 2).toString();
                        String dni = table.getValueAt(selectedRow, 3).toString();
                        String email = table.getValueAt(selectedRow, 4).toString();
                        String password = table.getValueAt(selectedRow, 5).toString();

                        // Llenar los campos de texto con los valores
                        txtID.setText(id);
                        txtNombre.setText(nombre);
                        txtApellido.setText(apellido);
                        txtDNI.setText(dni);
                        txtEmail.setText(email);
                        txtPassword.setText(password);
                    }
                }
            }
        });

        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDNI.getText();
                String email = txtEmail.getText();
                char[] passwordChars = txtPassword.getPassword();
                String password = new String(passwordChars);
                if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "El Nombre, Apellido y el Email son obligatorios");
                } else {
                    txtID.setText(String.valueOf(currentID[0]));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{currentID[0], nombre, apellido, dni, email, password});
                    try {
                        tablaUsuariosM.Agregar_BBDD(nombre,apellido, dni, email, password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    currentID[0]++;
                    txtID.setText(String.valueOf(currentID[0]));

                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtDNI.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");
                }
            }
        });
        buttonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText(String.valueOf(currentID[0]));
                txtNombre.setText("");
                txtApellido.setText("");
                txtDNI.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
            }
        });

        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) { // Verificar si se seleccionó una fila
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int userId = (int) model.getValueAt(selectedRow, 0); // Assuming user ID is in the first column
                    model.removeRow(selectedRow); // Eliminar la fila seleccionada
                    try {
                        tablaUsuariosM.Elimianar_BBDD(userId); // Use the correct user ID for deletion
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        buttonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    // Obtener los nuevos valores de los campos de texto
                    String id = txtID.getText();
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    String dni = txtDNI.getText();
                    String email = txtEmail.getText();
                    String password = new String(txtPassword.getPassword());
                    if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(panel1, "El Nombre, Apellido y el Email son obligatorios");
                    } else {

                        // Actualizar la fila en la tabla con los nuevos valores
                        model.setValueAt(id, selectedRow, 0);
                        model.setValueAt(nombre, selectedRow, 1);
                        model.setValueAt(apellido, selectedRow, 2);
                        model.setValueAt(dni, selectedRow, 3);
                        model.setValueAt(email, selectedRow, 4);
                        model.setValueAt(password, selectedRow, 5);
                        try {
                            tablaUsuariosM.Actualizar_BBDD(Integer.parseInt(id), nombre,apellido,dni,email,password);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
            }
        });

        DefaultTableCellRenderer contrasenaRemderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value != null) {
                    String contra = (String) value;
                    String oculta = "*".repeat(contra.length());
                    setText(oculta);
                } else {
                    setText("");
                }
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(contrasenaRemderer);
    }
    public void cargarDatosDesdeBaseDeDatos() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos

            ResultSet resultSet = tablaUsuariosM.Obtener_BBDD();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("username");
                String apellido = resultSet.getString("surname");
                String dni = resultSet.getString("dni");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                model.addRow(new Object[]{id, nombre, apellido, dni, email, password});
                currentID[0] = id + 1;
                txtID.setText(String.valueOf(currentID[0]));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Manejar la excepción apropiadamente
        }
    }


    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables
            }
        };

        // Agregar los nombres de las columnas como la primera fila
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("DNI");
        model.addColumn("Email");
        model.addColumn("Password");

        table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);

    }




}
