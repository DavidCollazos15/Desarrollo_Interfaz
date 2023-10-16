package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MoveOptionsWindow extends JFrame {

    public static void main(String[] args) {

        // Crear la ventana principal
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 350, 350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new GridBagLayout());

        //Botones
        JButton boton1 = new JButton(">>");
        JButton boton2 = new JButton(">");
        JButton boton3 = new JButton("<<");
        JButton boton4 = new JButton("<");

        // Lista y JScrollPane Izquierda
        JList<String> listaIzq;
        DefaultListModel<String> model1 = new DefaultListModel<>();
        String lista1[] = {"Paco","Jorge","Alonso","Federico"};
        for (String item : lista1) {
            model1.addElement(item);
        }
        listaIzq = new JList<>(model1);
        JScrollPane ScrollIzq = new JScrollPane(listaIzq);


        // Lista y JScrollPane Derecha
        JList<String> listaDer;
        DefaultListModel<String> model2 = new DefaultListModel<>();
        String lista2[] = {};
        for (String item : lista2) {
            model2.addElement(item);
        }
        listaDer = new JList<>(model2);
        JScrollPane ScrollDer = new JScrollPane(listaDer);


        //Ubicaciones:

        //ScrollIzq
        PrincipalPanel.add(ScrollIzq,
                new GridBagConstraints(
                        0,
                        0,
                        1,
                        4,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //ScrollIzq
        PrincipalPanel.add(ScrollDer,
                new GridBagConstraints(
                        2,
                        0,
                        1,
                        4,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 1
        PrincipalPanel.add(boton1,
                new GridBagConstraints(
                        1,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 2
        PrincipalPanel.add(boton2,
                new GridBagConstraints(
                        1,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 3
        PrincipalPanel.add(boton3,
                new GridBagConstraints(
                        1,
                        2,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botón 4
        PrincipalPanel.add(boton4,
                new GridBagConstraints(
                        1,
                        3,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }
}


