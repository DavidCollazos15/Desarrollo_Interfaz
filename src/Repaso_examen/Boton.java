package Repaso_examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boton {

    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame();
        //Coordenadas y tamaño ventana
        ventana.setBounds(10, 10, 800, 400);
        //Layout
        ventana.setLayout(new FlowLayout());
        //Funcion de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Boton
        JButton boton1 = new JButton("Texto Boton");

        //Funcion al pulsar el boton
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton1.setBackground(Color.BLUE);
            }
        });
        //(Al final) Añadir a la ventana y activar ventana
        ventana.add(boton1);
        ventana.setVisible(true);
    }
}
