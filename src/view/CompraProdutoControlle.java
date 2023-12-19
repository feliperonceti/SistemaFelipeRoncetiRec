/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CompraFgv;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Felipe Ronceti
 */

public class CompraProdutoControlle extends AbstractTableModel {
    private List<CompraFgv> lista; // Change the type of the list to CompraFgv

    public void setList(List<CompraFgv> lista) {
        this.lista = lista;
    }

    public CompraFgv getBean(int linha) {
        return lista.get(linha);
    }

    @Override
    public int getRowCount() {
        return (lista != null) ? lista.size() : 0; // Check if lista is not null
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CompraFgv compra = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return compra.getIdcompraFgv();
            case 1:
                return compra.getQuantidadeFgv();
            case 2:
                return compra.getStatusFgv();
            case 3:
                return compra.getNomeclienteFgv();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ID";
            case 1:
                return "Quantidade";
            case 2:
                return "Status";
            case 3:
                return "Cliente";
            default:
                return "";
        }
    }
}
