package Repaso_examen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablaEjemplo {

    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Ejemplo de Tabla");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear un modelo de tabla predeterminado
        DefaultTableModel model = new DefaultTableModel();

        // Añadir columnas al modelo
        model.addColumn("Nombre");
        model.addColumn("Edad");

        // Añadir filas al modelo
        model.addRow(new Object[]{"Juan", 25});
        model.addRow(new Object[]{"María", 30});
        model.addRow(new Object[]{"Carlos", 28});
        model.addRow(new Object[]{"Laura", 22});

        // Crear la JTable con el modelo
        JTable table = new JTable(model);

        // Agregar la tabla a un JScrollPane para permitir desplazamiento si es necesario
        JScrollPane scrollPane = new JScrollPane(table);

        // Agregar el JScrollPane al JFrame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Mostrar el JFrame
        frame.setVisible(true);
    }
}
