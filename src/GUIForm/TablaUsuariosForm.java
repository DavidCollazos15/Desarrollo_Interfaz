package GUIForm;

import javax.swing.*;

public class TablaUsuariosForm {

    private JPanel panel1;
    private JTextField idField;
    private JTextField dniField;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField emailField;
    private JPasswordField passwordField1;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("TablaUsuariosForm");
        frame.setContentPane(new TablaUsuariosForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
