package Primera_ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;

public class MyJListWindowTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JList Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        JList<String> jList = new JList<>(listModel);
        JLabel statusLabel = new JLabel("Seleccionado ");
        statusLabel.setForeground(Color.BLACK);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = jList.getSelectedValue();
                    statusLabel.setText("Seleccionado " + selectedValue);
                }
            }
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jList.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jList.setForeground(Color.BLACK);
            }
        });

        JTextField textField = new JTextField(15);
        JButton addButton = new JButton("Agregar");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (!text.isEmpty()) {
                    listModel.addElement(text);
                    textField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(textField);
        inputPanel.add(addButton);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(jList, BorderLayout.CENTER);
        panel.add(statusLabel, BorderLayout.SOUTH);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}


