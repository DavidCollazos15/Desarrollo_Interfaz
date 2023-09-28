package Primera_ventana;

import javax.swing.*;
import java.awt.*;

public class Layouts {
    public static void main(String[] args) {

        // Crear la ventana principal
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 200, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        //Botones
        JButton boton01 = new JButton("Boton 01");
        JButton boton02 = new JButton("Boton 02");
        JButton boton03 = new JButton("Boton 03");

        Panel1.add(boton01);
        Panel2.add(boton02);
        Panel3.add(boton03);


        ventana.add(Panel1);
        ventana.add(Panel2);
        ventana.add(Panel3);

        //Colores

        ventana.setBackground(Color.GREEN);
        Panel1.setBackground(Color.RED);
        Panel2.setBackground(Color.BLUE);
        Panel3.setBackground(Color.MAGENTA);

        //Layouts

        ventana.setLayout(new FlowLayout());
        //ventana.setLayout(new BorderLayout());

        /* Agregar los paneles a la ventana en regiones específicas (BorderLayout)

        ventana.add(Panel1, BorderLayout.NORTH);
        ventana.add(Panel2, BorderLayout.SOUTH);
        ventana.add(Panel3, BorderLayout.CENTER); */


        ventana.setVisible(true);

    }

}
