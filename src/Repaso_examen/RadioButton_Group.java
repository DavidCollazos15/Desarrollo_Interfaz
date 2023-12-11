package Repaso_examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButton_Group {

    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame();
        //Coordenadas y tamaño ventana
        ventana.setBounds(10, 10, 800, 400);
        //Layout
        ventana.setLayout(new FlowLayout());
        //Funcion de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //RadioButtons
        JRadioButton radioButton1 = new JRadioButton("Opción 1");
        JRadioButton radioButton2 = new JRadioButton("Opción 2");

        //ButonGroups
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        //Funciones de los RadioButtons
        radioButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción 1");
            }
        });

        radioButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionaste la opción 2");
            }
        });

        //(Al final) Añadir a la ventana y activar ventana
        ventana.add(radioButton1);
        ventana.add(radioButton2);
        ventana.setVisible(true);
    }
}
