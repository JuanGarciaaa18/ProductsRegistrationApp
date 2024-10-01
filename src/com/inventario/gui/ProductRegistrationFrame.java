package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.inventario.model.ProductTableModel;

public class ProductRegistrationFrame extends JFrame {
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton saveButton;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame() {
        this.productTableModel = productTableModel;
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // Set layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel nameLabel = new JLabel("Nombre del Producto:");
        nameField = new JTextField();

        JLabel priceLabel = new JLabel("Precio:");
        priceField = new JTextField();

        JLabel quantityLabel = new JLabel("Cantidad:");
        quantityField = new JTextField();

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        add(nameLabel);
        add(nameField);
        add(priceLabel);
        add(priceField);
        add(quantityLabel);
        add(quantityField);
        add(new JLabel());
        add(saveButton);
    }

    private void saveProduct() {
        String name = nameField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();

        // Basic validation
        if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        int quantity;

        try {
            price = Double.parseDouble(priceText);
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos para precio y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }



        JOptionPane.showMessageDialog(this, "Producto guardado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);


        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }
}