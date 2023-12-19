/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.CompraprodutoFgv;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tools.Util;

/**
 *
 */
public class CompraProdutoControlle extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public CompraprodutoFgv getBean(int linha) {
        return (CompraprodutoFgv) lista.get(linha);
    }

    public void addBean(CompraprodutoFgv compraProdutoFgv) {
        lista.add(compraProdutoFgv);
        this.fireTableDataChanged();
    }

    public void removeBean(int index) {

        lista.remove(index);
        this.fireTableDataChanged();

    }

    public void updateBean(int index, CompraprodutoFgv compraProdutoFgv) {

        lista.set(index, compraProdutoFgv);
        this.fireTableDataChanged();

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    public void limparTabela() {
        lista.clear();
        this.fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lista != null && rowIndex < lista.size()) {
            Object obj = lista.get(rowIndex);

            if (obj instanceof CompraprodutoFgv) {
                CompraprodutoFgv compraProdutoFgv = (CompraprodutoFgv) obj;

                if (compraProdutoFgv != null) {
                    if (columnIndex == 0) {
                        return compraProdutoFgv.getProdutoFgv().getNomeFgv();
                    }
                    if (columnIndex == 1) {
                        return compraProdutoFgv.getQuantidadeFgv();
                    }
                    if (columnIndex == 2) {
                        return compraProdutoFgv.getValorUnitarioFgv();
                    }
                    if (columnIndex == 3) {
                        return compraProdutoFgv.getQuantidadeFgv() * compraProdutoFgv.getValorUnitarioFgv();
                    }
                }
            }
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome Produto";
        }
        if (columnIndex == 1) {
            return "Quantidade";
        }
        if (columnIndex == 2) {
            return "Valor Unitario";
        }
        if (columnIndex == 3) {
            return "Total";
        }
        return "";
    }

}
