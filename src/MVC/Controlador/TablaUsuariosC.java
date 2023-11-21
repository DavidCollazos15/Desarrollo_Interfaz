package MVC.Controlador;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class TablaUsuariosC {
    private JPanel panelV;
    private JPanel tituloLabel;
    private JPanel tablaPanel;
    private JPanel buttonPanel;
    private JPanel inputPanel;
    private JTable tabla;
    private JButton nuevoButton;
    private JButton anadirButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField idField;
    private JTextField dniField;
    private JLabel nombreLabel;
    private JLabel apellidosLabel;
    private JLabel emailLabel;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel dniLabel;

    public TablaUsuariosC() {
    }

    public static void main(String[] args) throws SQLException {
        final JFrame ventana = new JFrame("TablaUsuariosForm");
        ventana.setContentPane(new TablaUsuariosC().panelV);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setMinimumSize(new Dimension(800, 400));
    }
}
