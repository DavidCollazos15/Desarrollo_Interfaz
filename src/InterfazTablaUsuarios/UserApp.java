package InterfazTablaUsuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserApp {
    private JFrame frame;
    private JTextField nombreField, apellidosField, dniField, emailField, passwordField;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserApp window = new UserApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UserApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        nombreField = new JTextField(20);
        apellidosField = new JTextField(20);
        dniField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton nuevoButton = new JButton("Nuevo");
        JButton añadirButton = new JButton("Añadir");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        inputPanel.add(new JLabel("Nombre: "));
        inputPanel.add(nombreField);
        inputPanel.add(new JLabel("Apellidos: "));
        inputPanel.add(apellidosField);
        inputPanel.add(new JLabel("DNI: "));
        inputPanel.add(dniField);
        inputPanel.add(new JLabel("Email: "));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Password: "));
        inputPanel.add(passwordField);
        inputPanel.add(nuevoButton);
        inputPanel.add(añadirButton);
        inputPanel.add(modificarButton);
        inputPanel.add(eliminarButton);

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas sean no editables
            }
        };

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellidos");
        tableModel.addColumn("DNI");
        tableModel.addColumn("Email");
        tableModel.addColumn("Contraseña");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void clearFields() {
        nombreField.setText("");
        apellidosField.setText("");
        dniField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }

    private void addUser() {
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        String dni = dniField.getText();
        String email = emailField.getText();

        if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
            tableModel.addRow(new Object[]{tableModel.getRowCount() + 1, nombre, apellidos, dni, email});
            clearFields();
        } else {
            JOptionPane.showMessageDialog(frame, "Nombre, apellidos y email son campos obligatorios.");
        }
    }

    private void updateUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = nombreField.getText();
            String apellidos = apellidosField.getText();
            String dni = dniField.getText();
            String email = emailField.getText();

            if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                tableModel.setValueAt(nombre, selectedRow, 1);
                tableModel.setValueAt(apellidos, selectedRow, 2);
                tableModel.setValueAt(dni, selectedRow, 3);
                tableModel.setValueAt(email, selectedRow, 4);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(frame, "Nombre, apellidos y email son campos obligatorios.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione una fila para modificar.");
        }
    }

    private void deleteUser() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(frame, "¿Está seguro de eliminar este usuario?");
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione una fila para eliminar.");
        }
    }
}
