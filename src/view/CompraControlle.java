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
public class CompraControlle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;

    }

    public CompraFgv getBean(int linha) {
        return (CompraFgv) lista.get(linha);

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        CompraFgv compra = (CompraFgv) lista.get(rowIndex);

        if (columnIndex == 0) {

            return compra.getIdcompraFgv();
        }
        if (columnIndex == 1) {
            return compra.getClienteFgv().getNomeFgv();
        }
        if (columnIndex == 2) {
            return compra.getVendedorFgv().getNomeFgv();
        }
        if (columnIndex == 3) {
            return compra.getDatadaCompraFgv();
        }
        if (columnIndex == 4) {
            return compra.getValorTotalFgv();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID";
        }
        if (columnIndex == 1) {
            return "Nome Cliente";
        }
        if (columnIndex == 2) {
            return "Nome Vendedor";
        }
        if (columnIndex == 3) {
            return "Data";
        }
        if (columnIndex == 4) {
            return "Totalf";
        }
        return "";
    }
}
