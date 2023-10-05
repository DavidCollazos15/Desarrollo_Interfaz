package Primera_ventana;

import javax.swing.*;
import java.awt.*;

public class ej_MasComponentes {

    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 500, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new GridBagLayout());

        //Texto
        JLabel Nombre = new JLabel("Lista Nombres:");
        JLabel Contrasena = new JLabel("Contraseña:");
        JLabel Descripcion = new JLabel("Area de texto:");

        //Componentes:

        // Lista y JScrollPane
        JList listaNombres;
        String lista[] = {"Paco", "David", "Diego", "Fernando", "Federico"};
        listaNombres = new JList( lista);
        JScrollPane ScrollLista = new JScrollPane(listaNombres);

        //Contraseña
        ScrollLista.setPreferredSize(new Dimension(ScrollLista.getPreferredSize().width, 80));
        JPasswordField passwordFieldContrasena = new JPasswordField(20);

        //Area de texto
        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane ScrollArea = new JScrollPane(textArea);


        //Ubicaciones:

        //Nombre
        PrincipalPanel.add(Nombre,
                new GridBagConstraints(
                        0,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(25,0,2,0),
                        0,
                        0
                ));

        //TextNombre
        PrincipalPanel.add(ScrollLista,
                new GridBagConstraints(
                        1,
                        0,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(25,5,2,25),
                        0,
                        0
                ));

        //Contrasena
        PrincipalPanel.add(Contrasena,
                new GridBagConstraints(
                        0,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.LINE_END,
                        GridBagConstraints.NONE,
                        new Insets(0,0,2,0),
                        0,
                        0
                ));

        //passwordFieldContrasena
        PrincipalPanel.add(passwordFieldContrasena,
                new GridBagConstraints(
                        1,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(2,5,2,25),
                        0,
                        0
                ));

        //Descripcion
        PrincipalPanel.add(Descripcion,
                new GridBagConstraints(
                        0,
                        2,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.NORTHEAST,
                        GridBagConstraints.LINE_END,
                        new Insets(2,0,2,0),
                        0,
                        0
                ));

        //ScrollArea
        PrincipalPanel.add(ScrollArea,
                new GridBagConstraints(
                        1,
                        2,
                        1,
                        1,
                        1.0,
                        100.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(2,5,25,25),
                        0,
                        0
                ));


        //Añadir a la ventana y mostrarla
        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }

}
