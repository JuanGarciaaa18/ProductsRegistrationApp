package com.inventario.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList;
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"};

    public ProductTableModel() {
        this.productList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    // Agrega el metodo addProduct
}