package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;

public class MyJListWindow {

    public static void main(String[] args) {

        //Ventana
        JFrame ventana = new JFrame();
        ventana.setBounds(10, 10, 350, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Paneles
        JPanel PrincipalPanel = new JPanel();

        //Layouts
        PrincipalPanel.setLayout(new GridBagLayout());

        //Componentes:

        //JLabel
        JLabel JLabelJList = new JLabel("JList ");
        // Centrar el texto en el JLabel
        JLabelJList.setHorizontalAlignment(SwingConstants.CENTER);
        // Cambiar el tamaño del texto
        JLabelJList.setFont(new Font("Arial", Font.PLAIN, 30));

        //JLabel Seleccionado
        JLabel JLabelSeleccionado = new JLabel("");

        //Agregar
        JTextField textAgregar = new JTextField(15);
        JButton addButton = new JButton("Agregar");

        //Borrar
        JButton deleteButton = new JButton("Eliminar");
        JButton clearButton = new JButton("Borrar Lista");


        // Lista y JScrollPane
        JList<String> listaNombres;
        DefaultListModel<String> model = new DefaultListModel<>();
        String lista[] = {"Paco", "David", "Diego", "Fernando", "Federico"};
        for (String item : lista) {
            model.addElement(item);
        }
        listaNombres = new JList<>(model);
        listaNombres.setVisibleRowCount(4);
        JScrollPane ScrollLista = new JScrollPane(listaNombres);


        // Agrega un MouseListener al JLabel para cambiar el color cuando el ratón entra
        JLabelJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JLabelJList.setForeground(Color.RED); // Cambia el color a rojo
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabelJList.setForeground(Color.BLACK); // Restaura el color original
            }
        });


        //Que el Botón agrege a la lista
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textAgregar.getText().trim();
                if (!text.isEmpty()) {
                    model.addElement(text);
                    textAgregar.setText("");
                }
            }
        });

        //Que el Botón borre a la lista
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaNombres.getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<String> model = (DefaultListModel<String>) listaNombres.getModel();
                    model.remove(selectedIndex);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> model = (DefaultListModel<String>) listaNombres.getModel();
                model.removeAllElements();
            }
        });


        //Nombre seleccionado
        listaNombres.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = listaNombres.getSelectedValue();
                    JLabelSeleccionado.setText("Seleccionado " + selectedValue);
                }
            }
        });

        //Ubicaciones:

        //JLabelJList
        PrincipalPanel.add(JLabelJList,
                new GridBagConstraints(
                        0,
                        0,
                        3,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));

        //textAgregar
        PrincipalPanel.add(textAgregar,
                new GridBagConstraints(
                        0,
                        1,
                        2,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));

        //addButton
        PrincipalPanel.add(addButton,
                new GridBagConstraints(
                        2,
                        1,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));
        //ScrollLista
        PrincipalPanel.add(ScrollLista,
                new GridBagConstraints(
                        0,
                        2,
                        3,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));

// Borrar
        PrincipalPanel.add(deleteButton,
                new GridBagConstraints(
                        0,
                        3,
                        1,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));
// BorrarTodo
        PrincipalPanel.add(clearButton,
                new GridBagConstraints(
                        1,
                        3,
                        2,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));

        //JLabelSeleccionado
        PrincipalPanel.add(JLabelSeleccionado,
                new GridBagConstraints(
                        0,
                        4,
                        3,
                        1,
                        1.0,
                        1.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(5,5,5,5),
                        0,
                        0
                ));

        //Añadir a la ventana y mostrarla
        ventana.add(PrincipalPanel);
        ventana.setVisible(true);

    }

}




