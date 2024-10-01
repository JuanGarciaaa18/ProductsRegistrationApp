package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    private JTextField nameField, priceField, quantityField;
    private JButton saveButton;
    private JTable productTable;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame() {
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Precio:"));
        priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("Cantidad:"));
        quantityField = new JTextField();
        panel.add(quantityField);

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(new SaveProductAction());
        panel.add(saveButton);

        add(panel, BorderLayout.NORTH);

        productTableModel = new ProductTableModel();
        productTable = new JTable(productTableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
    }

    private class SaveProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                if (name.isEmpty()) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío.");
                }

                int id = productTableModel.getRowCount() + 1; // Simple ID generation
                Product product = new Product(id, name, price, quantity);
                productTableModel.addProduct(product);

                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ProductRegistrationFrame.this, "Por favor, ingresa un precio o una cantidad valida.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(ProductRegistrationFrame.this, ex.getMessage());
            }
        }
    }
}
