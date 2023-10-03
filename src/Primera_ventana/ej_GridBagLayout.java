package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej_GridBagLayout {
    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 350, 250);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new GridBagLayout());

        //Botones
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        JButton boton4 = new JButton("Boton 4");

        //Texto
        JLabel texto = new JLabel("");

        //Ubicaciones:

        //Botón 1
        PrincipalPanel.add(boton1,
                new GridBagConstraints(
                        0,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 2
        PrincipalPanel.add(boton2,
                new GridBagConstraints(
                        1,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 3
        PrincipalPanel.add(boton3,
                new GridBagConstraints(
                        2,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Texto
        PrincipalPanel.add(texto,
                new GridBagConstraints(
                        0,
                        1,
                        3,
                        1,
                        1.0,
                        4.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.CENTER,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 4
        PrincipalPanel.add(boton4,
                new GridBagConstraints(
                        1,
                        2,
                        2,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.SOUTH,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Acciones de los botones:

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el texto del JLabel cuando se pulsa el botón
                texto.setText("Boton 1");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el texto del JLabel cuando se pulsa el botón
                texto.setText("Boton 2");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el texto del JLabel cuando se pulsa el botón
                texto.setText("Boton 3");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar el texto del JLabel cuando se pulsa el botón
                texto.setText("Boton 4");
            }
        });

        //Añadir a la ventana y mostrarla
        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }
}
