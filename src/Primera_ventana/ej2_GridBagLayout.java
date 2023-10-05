package Primera_ventana;

import javax.swing.*;
import java.awt.*;

public class ej2_GridBagLayout {

    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 380, 280);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new GridBagLayout());

        //Texto
        JLabel Nombre = new JLabel("Full Name");
        JLabel Calle = new JLabel("Street");
        JLabel Ciudad = new JLabel("City");
        JLabel Code = new JLabel("Zip Code");
        JLabel Direccion = new JLabel("Address");
        JLabel Telefono = new JLabel("Phone");
        JLabel Edad = new JLabel("Age");
        JLabel Descripcion = new JLabel("Description");

        //Introducir texto
        JTextField TextNombre = new JTextField(20);
        JTextField TextCalle = new JTextField(20);
        JTextField TextCiudad = new JTextField(20);
        JTextField TextCode = new JTextField(20);
        JTextField TextTelefono = new JTextField(20);
        JTextField TextEdad = new JTextField(20);
        JTextField TextDescripcion = new JTextField(20);

        //Boton
        JButton Submit = new JButton("Submit");

        //Ubicaciones:

        //Nombre
        PrincipalPanel.add(Nombre,
                new GridBagConstraints(
                        0,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(2,5,2,0),
                        0,
                        0
                ));

        //TextNombre
        PrincipalPanel.add(TextNombre,
                new GridBagConstraints(
                        1,
                        0,
                        3,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(2,5,2,25),
                        0,
                        0
                ));

        //Calle
        PrincipalPanel.add(Calle,
                new GridBagConstraints(
                        1,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(2,5,0,0),
                        0,
                        0
                ));

        //Ciudad
        PrincipalPanel.add(Ciudad,
                new GridBagConstraints(
                        2,
                        1,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(2,5,0,0),
                        0,
                        0
                ));

        //Code
        PrincipalPanel.add(Code,
                new GridBagConstraints(
                        3,
                        1,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(2,5,0,25),
                        0,
                        0
                ));

        //Direccion
        PrincipalPanel.add(Direccion,
                new GridBagConstraints(
                        0,
                        2,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(0,5,2,0),
                        0,
                        0
                ));

        //TextCalle
        PrincipalPanel.add(TextCalle,
                new GridBagConstraints(
                        1,
                        2,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,5,2,0),
                        0,
                        0
                ));

        //TextCiudad
        PrincipalPanel.add(TextCiudad,
                new GridBagConstraints(
                        2,
                        2,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,5,2,0),
                        0,
                        0
                ));

        //TextCode
        PrincipalPanel.add(TextCode,
                new GridBagConstraints(
                        3,
                        2,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,5,2,25),
                        0,
                        0
                ));

        //Telefono
        PrincipalPanel.add(Telefono,
                new GridBagConstraints(
                        0,
                        3,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(2,5,2,0),
                        0,
                        0
                ));

        //TextTelefono
        PrincipalPanel.add(TextTelefono,
                new GridBagConstraints(
                        1,
                        3,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(2,5,2,0),
                        0,
                        0
                ));

        //Edad
        PrincipalPanel.add(Edad,
                new GridBagConstraints(
                        2,
                        3,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(2,5,2,0),
                        0,
                        0
                ));

        //TextEdad
        PrincipalPanel.add(TextEdad,
                new GridBagConstraints(
                        3,
                        3,
                        1,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(2,5,2,25),
                        0,
                        0
                ));

        //Descripcion
        PrincipalPanel.add(Descripcion,
                new GridBagConstraints(
                        0,
                        4,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.NORTHEAST,
                        GridBagConstraints.LINE_END,
                        new Insets(2,5,2,0),
                        0,
                        0
                ));

        //TextDescripcion
        PrincipalPanel.add(TextDescripcion,
                new GridBagConstraints(
                        1,
                        4,
                        3,
                        1,
                        0.5,
                        100.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(2,5,2,25),
                        0,
                        0
                ));

        //Edad
        PrincipalPanel.add(Submit,
                new GridBagConstraints(
                        2,
                        5,
                        2,
                        1,
                        0.5,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(2,5,2,25),
                        0,
                        0
                ));


        //Añadir a la ventana y mostrarla
        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }

}
