package Primera_ventana;
import javax.swing.*;
import java.awt.*;

public class Ventana {

    public static void main(String[] args) {

        // Crear la ventana principal
        JFrame miPrimeraVentana = new JFrame();
        miPrimeraVentana.setBounds(10, 10, 200, 300);
        miPrimeraVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles                   //Layout
        JPanel PanelPrincipal = new JPanel(new GridLayout(7, 1, 0, 10)); // 6 filas, 1 columna, espaciado vertical de 10
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();
        JPanel Panel5 = new JPanel();
        JPanel Panel6 = new JPanel();

        //Imagen

        JLabel Imagen = new JLabel();
        Imagen.setIcon(new ImageIcon("C:\\Users\\DavidGonzálezC\\Desktop\\Calendario.png"));

        // Etiqueta apellidos
        JLabel apellidos = new JLabel("Apellidos:");
        Panel1.add(apellidos);

        // Crear el JTextField
        JTextField apellidosField = new JTextField(20); // 20 es el ancho inicial del campo de texto
        Panel1.add(apellidosField);

        // Etiqueta nombre
        JLabel nombre = new JLabel("Nombre:");
        Panel2.add(nombre);

        // Crear el JTextField
        JTextField NombreField = new JTextField(20);
        Panel2.add(NombreField);

        // Etiqueta sexo
        JLabel sexo = new JLabel("Sexo:");
        Panel3.add(sexo);

        // Crear un grupo para los JCheckBox de sexo
        ButtonGroup grupoSexo = new ButtonGroup();

        // Crear JCheckBox para "Masculino"
        JCheckBox masculinoCheckBox = new JCheckBox("Masculino");
        grupoSexo.add(masculinoCheckBox);
        Panel3.add(masculinoCheckBox);

        // Crear JCheckBox para "Femenino"
        JCheckBox femeninoCheckBox = new JCheckBox("Femenino");
        grupoSexo.add(femeninoCheckBox);
        Panel3.add(femeninoCheckBox);

        // Etiqueta nacionalidad
        JLabel nacionalidad = new JLabel("Nacionalidad:");
        Panel4.add(nacionalidad);

        // Crear ComboBox nacionalidad
        JComboBox NacionalidadBox = new JComboBox<>();
        NacionalidadBox.addItem("");
        NacionalidadBox.addItem("España");
        NacionalidadBox.addItem("Francia");
        NacionalidadBox.addItem("Alemania");
        NacionalidadBox.addItem("Italia");
        Panel4.add(NacionalidadBox);

        // Etiqueta nacimiento
        JLabel nacimiento = new JLabel("Fecha de nacimiento:");
        Panel5.add(nacimiento);

        // Crear el JTextField
        JTextField NacimientoField = new JTextField(20);
        Panel5.add(NacimientoField);

        // Etiqueta domicilio
        JLabel domicilio = new JLabel("Domicilio:");
        Panel6.add(domicilio);

        // Crear el JTextField
        JTextField DomicilioField = new JTextField(20);
        Panel6.add(DomicilioField);

        //Añadirlos al PanelPrincipal

        PanelPrincipal.add(Panel1);
        PanelPrincipal.add(Panel2);
        PanelPrincipal.add(Panel3);
        PanelPrincipal.add(Panel4);
        PanelPrincipal.add(Panel5);
        PanelPrincipal.add(Panel6);
        PanelPrincipal.add(Imagen);

        //Añadirlos a la ventana y hacerla visibel

        miPrimeraVentana.add(PanelPrincipal);
        miPrimeraVentana.setVisible(true);
    }

}
