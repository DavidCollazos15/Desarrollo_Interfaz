package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculadora {
    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 350, 350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PanelPrueba = new JPanel();
        JPanel PanelPrincipal = new JPanel();
        JPanel PanelSecundario = new JPanel(new GridLayout(5, 4, 2, 2));
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));
        PanelPrincipal.setPreferredSize(new Dimension(0, 100));

        //Nombre Calculadora
        JLabel nombreCal = new JLabel("Calculadora");

        //Zona de introduccion de numeros
        JTextField IntroducirNum = new JTextField(20);
        IntroducirNum.setMaximumSize(IntroducirNum.getPreferredSize());
        IntroducirNum.setMinimumSize(IntroducirNum.getPreferredSize());

        PanelPrueba.add(nombreCal);
        PanelPrincipal.add(IntroducirNum);

        JButton boton01 = new JButton("C");
        JButton boton02 = new JButton("DEL");
        JButton boton03 = new JButton("CE");
        JButton boton04 = new JButton("/");
        JButton boton05 = new JButton("7");
        JButton boton06 = new JButton("8");
        JButton boton07 = new JButton("9");
        JButton boton08 = new JButton("*");
        JButton boton09 = new JButton("4");
        JButton boton10 = new JButton("5");
        JButton boton11 = new JButton("6");
        JButton boton12 = new JButton("-");
        JButton boton13 = new JButton("1");
        JButton boton14 = new JButton("2");
        JButton boton15 = new JButton("3");
        JButton boton16 = new JButton("+");
        JButton boton17 = new JButton("0");
        JButton boton18 = new JButton(".");
        JButton boton19 = new JButton("ANS");
        JButton boton20 = new JButton("=");

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

        ActionListener numeroActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                String numero = boton.getText();
                IntroducirNum.setText(IntroducirNum.getText() + numero);
            }
        };

        ActionListener operadorActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                String operador = boton.getText();
                IntroducirNum.setText(IntroducirNum.getText() + operador);
            }
        };

        ActionListener igualActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = IntroducirNum.getText();
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                try {
                    Object resultado = engine.eval(expresion);
                    IntroducirNum.setText(resultado.toString());
                } catch (ScriptException ex) {
                    IntroducirNum.setText("Error");
                }
            }
        };

        ActionListener ceActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IntroducirNum.setText("");
            }
        };

        boton05.addActionListener(numeroActionListener);
        boton06.addActionListener(numeroActionListener);
        boton07.addActionListener(numeroActionListener);
        boton09.addActionListener(numeroActionListener);
        boton10.addActionListener(numeroActionListener);
        boton11.addActionListener(numeroActionListener);
        boton13.addActionListener(numeroActionListener);
        boton14.addActionListener(numeroActionListener);
        boton15.addActionListener(numeroActionListener);
        boton17.addActionListener(numeroActionListener);
        boton18.addActionListener(numeroActionListener);

        boton04.addActionListener(operadorActionListener);
        boton08.addActionListener(operadorActionListener);
        boton12.addActionListener(operadorActionListener);
        boton16.addActionListener(operadorActionListener);

        boton20.addActionListener(igualActionListener);
        boton03.addActionListener(ceActionListener);

        ventana.setLayout(new BorderLayout());
        ventana.add(PanelPrincipal, BorderLayout.NORTH);
        ventana.add(PanelSecundario, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}
