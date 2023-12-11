package Repaso_examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desplegable {

    public static void main(String[] args) {
        //Ventana
        JFrame ventana = new JFrame();
        //Coordenadas y tamaño ventana
        ventana.setBounds(10, 10, 800, 400);
        //Layout
        ventana.setLayout(new FlowLayout());
        //Funcion de cerrar
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Desplegable con las opciones
        JComboBox desplegable = new JComboBox<>();
        desplegable.addItem("Opción 1");
        desplegable.addItem("Opción 2");
        desplegable.addItem("Opción 3");

        //TextField para mostrar la opción seleccionada
        JLabel texto = new JLabel();

        //Funcion del desplegable
        desplegable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setText("Seleccionaste: " + desplegable.getSelectedItem()); // Establecer el texto en el TextField
            }
        });

        //(Al final) Activar ventana
        ventana.add(desplegable);
        ventana.add(texto);
        ventana.setVisible(true);
    }
}
