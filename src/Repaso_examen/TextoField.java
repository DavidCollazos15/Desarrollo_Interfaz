package Repaso_examen;

import javax.swing.*;
import java.awt.*;

public class TextoField {

    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame();
        //Coordenadas y tamaño ventana
        ventana.setBounds(10, 10, 800, 400);
        //Layout
        ventana.setLayout(new FlowLayout());
        //Funcion de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Campo de texto                       Ancho zona
        JTextField textoField = new JTextField(6);

        //(Al final) Añadir a la ventana y activar ventana
        ventana.add(textoField);
        ventana.setVisible(true);
    }
}
