package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculadora {

    private static double previousResult = 0.0;

    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame("Trabajo_Calculadora");
        ventana.setBounds(10, 10, 350, 350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PanelPrincipal = new JPanel(new GridBagLayout());
        JPanel PanelSecundario = new JPanel(new GridLayout(5, 4, 2, 2));
        PanelPrincipal.setPreferredSize(new Dimension(0, 100));

        //Nombre Calculadora
        JLabel nombreCal = new JLabel("CALCULADORA");
        // Cambiar el tamaño de la fuente
        nombreCal.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente: Arial / Negrita: Font.BOLD / Tamaño: 24

        //Zona de introduccion de numeros
        JTextField IntroducirNum = new JTextField(20);
        // Cambiar el tamaño de la fuente
        IntroducirNum.setFont(new Font("Arial", Font.PLAIN, 24)); // Fuente: Arial / Normal: Font.BOLD / Tamaño: 24

        //Añadir nombre calculadora al PanelPrincipal (GridBagLayout)
        PanelPrincipal.add(nombreCal,
                new GridBagConstraints(
                        0,
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

        //Añadir introduccion de numeros al PanelPrincipal (GridBagLayout)
        PanelPrincipal.add(IntroducirNum,
                new GridBagConstraints(
                        0,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_START,
                        GridBagConstraints.BOTH,
                        new Insets(0,0,0,0),
                        0,
                        0
                ));

        //Botones           //Texto botones
        JButton boton_C     = new JButton("C");
        JButton boton_DEL   = new JButton("DEL");
        JButton boton_CE    = new JButton("CE");
        JButton boton_RES   = new JButton("-");
        JButton boton_MUL   = new JButton("*");
        JButton boton_DIV   = new JButton("/");
        JButton boton_SUM   = new JButton("+");
        JButton boton_1     = new JButton("1");
        JButton boton_2     = new JButton("2");
        JButton boton_3     = new JButton("3");
        JButton boton_4     = new JButton("4");
        JButton boton_5     = new JButton("5");
        JButton boton_6     = new JButton("6");
        JButton boton_7     = new JButton("7");
        JButton boton_8     = new JButton("8");
        JButton boton_9     = new JButton("9");
        JButton boton_0     = new JButton("0");
        JButton boton_PUNT  = new JButton(".");
        JButton boton_ANS   = new JButton("ANS");
        JButton boton_IGU   = new JButton("=");

        //Añadir los botones al panel en un orden
        PanelSecundario.add(boton_C);
        PanelSecundario.add(boton_DEL);
        PanelSecundario.add(boton_CE);
        PanelSecundario.add(boton_DIV);
        PanelSecundario.add(boton_1);
        PanelSecundario.add(boton_2);
        PanelSecundario.add(boton_3);
        PanelSecundario.add(boton_MUL);
        PanelSecundario.add(boton_4);
        PanelSecundario.add(boton_5);
        PanelSecundario.add(boton_6);
        PanelSecundario.add(boton_RES);
        PanelSecundario.add(boton_7);
        PanelSecundario.add(boton_8);
        PanelSecundario.add(boton_9);
        PanelSecundario.add(boton_SUM);
        PanelSecundario.add(boton_0);
        PanelSecundario.add(boton_PUNT);
        PanelSecundario.add(boton_ANS);
        PanelSecundario.add(boton_IGU);

        //Funcion de los botones numericos
        ActionListener numeroActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                String numero = boton.getText();
                IntroducirNum.setText(IntroducirNum.getText() + numero);
            }
        };

        //Funcion de los botones operadores
        ActionListener operadorActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton boton = (JButton) e.getSource();
                String operador = boton.getText();
                IntroducirNum.setText(IntroducirNum.getText() + operador);
            }
        };

        //Funcion del boton de resultado
        ActionListener igualActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = IntroducirNum.getText();
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("js");
                try {
                    Object resultado = engine.eval(expresion);
                    // Validación de división por cero
                    if (Double.isInfinite(Double.parseDouble(resultado.toString())) || Double.isNaN(Double.parseDouble(resultado.toString()))) {
                        IntroducirNum.setText("Error: División por cero");
                    } else {
                        previousResult = Double.parseDouble(resultado.toString()); // Almacena el resultado actual para ANS
                        IntroducirNum.setText(resultado.toString());
                    }
                } catch (ScriptException ex) {
                    IntroducirNum.setText("Error");
                }
            }
        };

        //Funcion del boton de ANS
        ActionListener ansActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IntroducirNum.setText(String.valueOf(previousResult)); // Muestra el resultado anterior
            }
        };

        //Funcion del boton de C
        ActionListener cActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IntroducirNum.setText("");
            }
        };

        //Funcion del boton de CE
        ActionListener ceActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = IntroducirNum.getText();

                if (!currentText.isEmpty()) {
                    // Encuentra la última posición de un operador en el texto
                    int lastIndex = currentText.lastIndexOf("+");
                    int lastIndex2 = currentText.lastIndexOf("-");
                    int lastIndex3 = currentText.lastIndexOf("*");
                    int lastIndex4 = currentText.lastIndexOf("/");

                    int lastOperatorIndex = Math.max(lastIndex, lastIndex2);
                    lastOperatorIndex = Math.max(lastOperatorIndex, lastIndex3);
                    lastOperatorIndex = Math.max(lastOperatorIndex, lastIndex4);

                    if (lastOperatorIndex >= 0) {
                        // Borra el texto después del último operador
                        IntroducirNum.setText(currentText.substring(0, lastOperatorIndex + 1));
                    } else {
                        // Si no hay operadores lo borra
                        IntroducirNum.setText("");
                    }
                }
            }
        };

        //Funcion del boton de DEL
        ActionListener delActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Lógica para eliminar el último carácter en la pantalla de la calculadora.
                String currentText = IntroducirNum.getText();
                if (currentText.length() > 0) {
                    IntroducirNum.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        };

        //Añadir las funciones de los botones a los numeros
        boton_1.addActionListener(numeroActionListener);
        boton_2.addActionListener(numeroActionListener);
        boton_3.addActionListener(numeroActionListener);
        boton_4.addActionListener(numeroActionListener);
        boton_5.addActionListener(numeroActionListener);
        boton_6.addActionListener(numeroActionListener);
        boton_7.addActionListener(numeroActionListener);
        boton_8.addActionListener(numeroActionListener);
        boton_9.addActionListener(numeroActionListener);
        boton_0.addActionListener(numeroActionListener);
        boton_PUNT.addActionListener(numeroActionListener);

        //Añadir las funciones de los botones a los operadores
        boton_DIV.addActionListener(operadorActionListener);
        boton_MUL.addActionListener(operadorActionListener);
        boton_RES.addActionListener(operadorActionListener);
        boton_SUM.addActionListener(operadorActionListener);

        //Añadir la funcion del boton al igual
        boton_IGU.addActionListener(igualActionListener);

        //Añadir la funcion del boton al CE
        boton_CE.addActionListener(ceActionListener);

        //Añadir la funcion del boton al C
        boton_C.addActionListener(cActionListener);

        //Añadir la funcion del boton al DEL
        boton_DEL.addActionListener(delActionListener);

        //Añadir la funcion del boton ANS
        boton_ANS.addActionListener(ansActionListener);

        //Añadir y mostrar ventana
        ventana.setLayout(new BorderLayout());
        ventana.add(PanelPrincipal, BorderLayout.NORTH);
        ventana.add(PanelSecundario, BorderLayout.CENTER);
        ventana.setVisible(true);
    }
}
