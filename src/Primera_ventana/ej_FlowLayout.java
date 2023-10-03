package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej_FlowLayout {

    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 480, 120);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new FlowLayout(0,5,10));

        //Botones
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        JButton boton4 = new JButton("Nombre-Largo Boton 4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("Aplicar orientacion");

        //RadioButton
        JRadioButton radio1 = new JRadioButton("Izquierda a derecha");
        JRadioButton radio2 = new JRadioButton("Derecha a izquierda");

        //ButtonGroup
        ButtonGroup Grupo_boton=new ButtonGroup();

        Grupo_boton.add(radio1);
        Grupo_boton.add(radio2);

        //Añadir al PrincipalPanel
        PrincipalPanel.add(boton1);
        PrincipalPanel.add(boton2);
        PrincipalPanel.add(boton3);
        PrincipalPanel.add(boton4);
        PrincipalPanel.add(boton5);
        PrincipalPanel.add(radio1);
        PrincipalPanel.add(radio2);
        PrincipalPanel.add(boton6);

        // Añadir al ActionListener al botón "Aplicar orientación"
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    PrincipalPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,10));;
                } else if (radio2.isSelected()) {
                    PrincipalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,10));;
                }
                PrincipalPanel.revalidate();
                PrincipalPanel.repaint();
            }
        });


        //Añadir a la ventana y mostrarla
        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }

}
