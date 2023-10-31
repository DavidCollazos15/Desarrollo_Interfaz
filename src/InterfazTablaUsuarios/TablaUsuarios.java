package InterfazTablaUsuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TablaUsuarios {
    public static void main(String[] args) {

        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setLayout(new BorderLayout(0, 0));

        //Paneles
        JPanel inputPanel = new JPanel();
        ventana.getContentPane().add(inputPanel, BorderLayout.NORTH);

        //Descripcion
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel apellidosLabel = new JLabel("Apellidos: ");
        JLabel dniLabel = new JLabel("DNI: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel passwordLabel = new JLabel("Password: ");

        //Zona de texto
        JTextField nombreField = new JTextField(20);
        JTextField apellidosField = new JTextField(20);
        JTextField dniField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField passwordField = new JPasswordField(20);

        //Botones
        JButton nuevoButton = new JButton("Nuevo");
        JButton anadirButton = new JButton("Añadir");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");

        //Añadir a paneles
        inputPanel.add(nombreLabel);
        inputPanel.add(nombreField);

        inputPanel.add(apellidosLabel);
        inputPanel.add(apellidosField);

        inputPanel.add(dniLabel);
        inputPanel.add(dniField);

        inputPanel.add(emailLabel);
        inputPanel.add(emailField);

        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        inputPanel.add(nuevoButton);
        inputPanel.add(anadirButton);
        inputPanel.add(modificarButton);
        inputPanel.add(eliminarButton);

        //Tabla
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
        JScrollPane scrollPane = new JScrollPane(tabla);

        //Funciones de los botones
        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreField.setText("");
                apellidosField.setText("");
                dniField.setText("");
                emailField.setText("");
                passwordField.setText("");
            }
        });

        anadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String dni = dniField.getText();
                String email = emailField.getText();

                if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                    ModeloTabla.addRow(new Object[]{ModeloTabla.getRowCount() + 1, nombre, apellidos, dni, email});
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
                    String nombre = nombreField.getText();
                    String apellidos = apellidosField.getText();
                    String dni = dniField.getText();
                    String email = emailField.getText();

                    if (!nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty()) {
                        ModeloTabla.setValueAt(nombre, selectedRow, 1);
                        ModeloTabla.setValueAt(apellidos, selectedRow, 2);
                        ModeloTabla.setValueAt(dni, selectedRow, 3);
                        ModeloTabla.setValueAt(email, selectedRow, 4);
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
                    int confirm = JOptionPane.showConfirmDialog(ventana, "¿Está seguro de eliminar este usuario?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        ModeloTabla.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(ventana, "Seleccione una fila para eliminar.");
                }
            }
        });

        ventana.getContentPane().add(scrollPane, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}
