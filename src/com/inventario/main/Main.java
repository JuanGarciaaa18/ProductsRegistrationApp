package com.inventario.main;

import com.inventario.Gui.ProductRegistrationFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductRegistrationFrame frame = new ProductRegistrationFrame();
            frame.setVisible(true);
        });
    }
}