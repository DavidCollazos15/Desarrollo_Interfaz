package Primera_ventana;

import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {

        // Crear la ventana principal
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles                   //Layout

        JPanel PanelGeneral = new JPanel();
        JPanel PanelPrincipal = new JPanel();
        JPanel PanelSecundario = new JPanel(new GridLayout(5, 4, 2, 2));
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.Y_AXIS));
        PanelPrincipal.setPreferredSize(new Dimension(0, 100));

        // Nombre calculadora
        JLabel nombreCal = new JLabel("Calculadora");

        // Introducir numero
        JTextField IntroducirNum = new JTextField(20);
        IntroducirNum.setMaximumSize(IntroducirNum.getPreferredSize());
        IntroducirNum.setMinimumSize(IntroducirNum.getPreferredSize());

        // Agregar nombreCal y IntroducirNum a PanelPrincipal
        PanelPrincipal.add(nombreCal);
        PanelPrincipal.add(IntroducirNum);

        //Botones
        JButton boton01 = new JButton("Boton 01");
        JButton boton02 = new JButton("Boton 02");
        JButton boton03 = new JButton("Boton 03");
        JButton boton04 = new JButton("Boton 03");
        JButton boton05 = new JButton("Boton 03");
        JButton boton06 = new JButton("Boton 03");
        JButton boton07 = new JButton("Boton 03");
        JButton boton08 = new JButton("Boton 03");
        JButton boton09 = new JButton("Boton 03");
        JButton boton10 = new JButton("Boton 03");
        JButton boton11 = new JButton("Boton 03");
        JButton boton12 = new JButton("Boton 03");
        JButton boton13 = new JButton("Boton 03");
        JButton boton14 = new JButton("Boton 03");
        JButton boton15 = new JButton("Boton 03");
        JButton boton16 = new JButton("Boton 03");
        JButton boton17 = new JButton("Boton 03");
        JButton boton18 = new JButton("Boton 03");
        JButton boton19 = new JButton("Boton 03");
        JButton boton20 = new JButton("Boton 03");



        PanelSecundario.add(boton01);
        PanelSecundario.add(boton02);
        PanelSecundario.add(boton03);
        PanelSecundario.add(boton04);
        PanelSecundario.add(boton05);
        PanelSecundario.add(boton06);
        PanelSecundario.add(boton07);
        PanelSecundario.add(boton08);
        PanelSecundario.add(boton09);
        PanelSecundario.add(boton10);
        PanelSecundario.add(boton11);
        PanelSecundario.add(boton12);
        PanelSecundario.add(boton13);
        PanelSecundario.add(boton14);
        PanelSecundario.add(boton15);
        PanelSecundario.add(boton16);
        PanelSecundario.add(boton17);
        PanelSecundario.add(boton18);
        PanelSecundario.add(boton19);
        PanelSecundario.add(boton20);

        PanelGeneral.add(PanelPrincipal);
        PanelGeneral.add(PanelSecundario);

        ventana.add(PanelGeneral);


        //Layouts

        ventana.setLayout(new BorderLayout());

        //Agregar los paneles a la ventana en regiones específicas (BorderLayout)

        ventana.add(PanelPrincipal, BorderLayout.NORTH);
        ventana.add(PanelSecundario, BorderLayout.CENTER);

        ventana.setVisible(true);

    }

}
