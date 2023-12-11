package Repaso_examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox {

    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame();
        //Coordenadas y tamaño ventana
        ventana.setBounds(10, 10, 800, 400);
        //Layout
        ventana.setLayout(new FlowLayout());
        //Funcion de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CheckBox
        JCheckBox casilla = new JCheckBox("Marcar casilla");

        //(Al final) Añadir a la ventana y activar ventana
        ventana.add(casilla);
        ventana.setVisible(true);
    }
}
