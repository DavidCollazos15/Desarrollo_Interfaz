package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SoloNumeros {
    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame("Trabajo_Calculadora");
        ventana.setBounds(10, 10, 350, 350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PanelPrincipal = new JPanel(new GridBagLayout());

        JTextField IntroducirNum = new JTextField(20);

        IntroducirNum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Consume el evento si no es un número, punto, ni un operador válido
                }
            }
        });

        PanelPrincipal.add(IntroducirNum);

        ventana.setLayout(new BorderLayout());
        ventana.add(PanelPrincipal);
        ventana.setVisible(true);

    }
}
