/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClienteFgv;
import bean.CompraFgv;
import bean.CompraprodutoFgv;
import bean.VendedorFgv;
import dao.Cliente_DAO;
import dao.CompraProduto_DAO;
import dao.Compra_DAO;
import dao.Vendedor_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author Felipe Ronceti
 */
public class JDlgCompra extends javax.swing.JDialog {

    private boolean incluindo;
    private Compra_DAO compra_DAO;
    CompraFgv compraFgv;
    CompraProdutoControlle compraProdutoControlle;
    CompraProduto_DAO compraProduto_DAO;
    CompraprodutoFgv compraprodutoFgv;
    JDlgCompraProduto jDlgCompraProduto;
    JDlgCompraPesquisa jDlgCompraPesquisa;
    ClienteFgv clienteFgv;
    VendedorFgv vendedorFgv;
    MaskFormatter mascaradata;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form JDlgCompra
     */
    public JDlgCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Compra");
        habilitar(false);
        Limpar();
        setLocationRelativeTo(null);
        compra_DAO = new Compra_DAO();
        compraProduto_DAO = new CompraProduto_DAO();
        compraFgv = new CompraFgv();
        clienteFgv = new ClienteFgv();
        vendedorFgv = new VendedorFgv();
        compraprodutoFgv = new CompraprodutoFgv();
        compraProdutoControlle = new CompraProdutoControlle();

        try {
            mascaradata = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaradata));

        List lista = new ArrayList();
        Cliente_DAO clientesDAO = new Cliente_DAO();
        List listaCli = clientesDAO.listAll();
        for (int i = 0; i < listaCli.size(); i++) {
            clienteFgv = (ClienteFgv) listaCli.get(i);
            jCboCliente.addItem(clienteFgv);

        }
        Vendedor_DAO vendedor_DAO = new Vendedor_DAO();
        List listaVend = vendedor_DAO.listAll();
        for (int i = 0; i < listaVend.size(); i++) {
            vendedorFgv = (VendedorFgv) listaVend.get(i);
            jCboVendedor.addItem(vendedorFgv);
        }

        List listaProd = new ArrayList();
        listaProd = compraProduto_DAO.listAll();
        compraProdutoControlle.setList(listaProd);
        jTable1.setModel(compraProdutoControlle);

    }

    public void habilitar(boolean valor) {
        Util.habilitar(valor, jTxtNumCompra, jFmtData, jCboCliente, jCboVendedor, jTxtValor, jBtnConfirmar, jBtnCancelar);
        Util.habilitar(valor, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        Util.habilitar(!valor, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }

    public void Limpar() {
        Util.limparCampos(jTxtNumCompra, jFmtData, jCboCliente, jCboVendedor, jTxtValor);
    }

    public CompraFgv viewBean() {
        CompraFgv compraFgv = new CompraFgv();
        compraFgv.setIdcompraFgv(Integer.parseInt(jTxtNumCompra.getText()));
        try {
            compraFgv.setDatadaCompraFgv(dateFormat.parse(jFmtData.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        compraFgv.setClienteFgv((ClienteFgv) jCboCliente.getSelectedItem());
        compraFgv.setVendedorFgv((VendedorFgv) jCboVendedor.getSelectedItem());
        compraFgv.setValorTotalFgv(Util.strDouble(jTxtValor.getText()));

        return compraFgv;
    }

    public void beanView(CompraFgv compraFgv) {
        jTxtNumCompra.setText(String.valueOf(compraFgv.getIdcompraFgv()));
        jFmtData.setText(dateFormat.format(compraFgv.getDatadaCompraFgv()));
        jCboCliente.setSelectedItem(compraFgv.getClienteFgv());
        jCboVendedor.setSelectedItem(compraFgv.getVendedorFgv());
        jTxtValor.setText(String.valueOf(compraFgv.getValorTotalFgv()));

        compraProduto_DAO = new CompraProduto_DAO();
        List listaProd = (List) compraProduto_DAO.listProduto(compraFgv);

        compraProdutoControlle.setList(listaProd);
    }

    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }

    public void paseTotal(String totalCP) {
        double total = Util.strDouble(totalCP) + Util.strDouble(jTxtValor.getText());
        jTxtValor.setText(Util.doubleStr(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNumCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCboCliente = new javax.swing.JComboBox<ClienteFgv>();
        jLabel5 = new javax.swing.JLabel();
        jCboVendedor = new javax.swing.JComboBox<VendedorFgv>();
        jLabel6 = new javax.swing.JLabel();
        jTxtValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jFmtData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num.Compra");

        jLabel2.setText("Data:");

        jLabel4.setText("Cliente");

        jCboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Vendedor");

        jLabel6.setText("Valor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir_1.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir_1.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnConfirmar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnPesquisar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnIncluirProd)
                            .addComponent(jBtnAlterarProd)
                            .addComponent(jBtnExcluirProd))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNumCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addGap(8, 8, 8)
                        .addComponent(jBtnAlterarProd)
                        .addGap(7, 7, 7)
                        .addComponent(jBtnExcluirProd)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClienteActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        compraFgv = viewBean();
        compraProduto_DAO = new CompraProduto_DAO();
        compraprodutoFgv = new CompraprodutoFgv();

        if (incluindo && compraFgv != null) {
            // Incluindo uma nova compra
            compra_DAO.insert(compraFgv);
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                compraprodutoFgv = compraProdutoControlle.getBean(linha);
                compraprodutoFgv.setCompraFgv(compraFgv);
                compraProduto_DAO.insert(compraprodutoFgv);
            }
        } else {
            // Excluindo produtos existentes e atualizando a compra
            compraProduto_DAO.deleteTabela(compraFgv);

            compra_DAO.update(compraFgv);
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                compraprodutoFgv = compraProdutoControlle.getBean(linha);
                compraprodutoFgv.setCompraFgv(compraFgv);
                compraProduto_DAO.insert(compraprodutoFgv);
            }
        }

        habilitar(false);
        Limpar();
        compraProdutoControlle.limparTabela();
        compraFgv = null;
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        compraFgv = viewBean();
        compraProduto_DAO = new CompraProduto_DAO();
        compraprodutoFgv = new CompraprodutoFgv();
        if (compraFgv != null) {
            if (Util.perguntar("Deseja excluir?")) {
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    compraprodutoFgv = compraProdutoControlle.getBean(linha);
                    compraprodutoFgv.setCompraFgv(compraFgv);
                    compraProduto_DAO.delete(compraprodutoFgv);
                }
                compra_DAO.delete(compraFgv);
                Limpar();
                compraProdutoControlle.limparTabela();
                compraFgv = null;
                Util.mensagem("Excluido");
            } else {
                Util.mensagem("Exclusão cancelada");
            }
        } else {

            Util.mensagem("Nenhuma venda foi selecionado");
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        Limpar();
        compraProdutoControlle.limparTabela();
        habilitar(true);
        jTxtNumCompra.grabFocus();
        incluindo = true;
        compraFgv = new CompraFgv();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        if (compraFgv != null) {
            habilitar(true);
            incluindo = false;
            jTxtNumCompra.setEnabled(incluindo);
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        habilitar(false);
        Limpar();

        compraProdutoControlle.limparTabela();
        compraFgv = null;    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        jDlgCompraProduto = new JDlgCompraProduto(null, true);
        jDlgCompraProduto.setTitle("Incluir uma Venda");
        jDlgCompraProduto.setTelaAnterior(this);
        jDlgCompraProduto.setVisible(true);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        compraFgv = new CompraFgv();
        compraprodutoFgv = new CompraprodutoFgv();
        jDlgCompraPesquisa = new JDlgCompraPesquisa(null, true);
        jDlgCompraPesquisa.setTelaAnterior(this);
        jDlgCompraPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        // TODO add your handling code here:
        jDlgCompraProduto = new JDlgCompraProduto(null, true);
        if (getSelectedRowProd() == -1) {
            Util.mensagem("Selecione uma linha antes de alterar");
        }
        jDlgCompraProduto.setTitle("Alterando Produto");
        jDlgCompraProduto.setTelaAnterior(this);
        jDlgCompraProduto.beanView(compraProdutoControlle.getBean(getSelectedRowProd()));
        jDlgCompraProduto.setVisible(true);
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        if (getSelectedRowProd() == -1) {
            Util.mensagem("Nenhuma linha selecionada");
        } else {
            if (Util.perguntar("Deseja excluir?")) {
                compraProdutoControlle.removeBean(jTable1.getSelectedRow());
                Util.mensagem("Excluido");
            } else {
                Util.mensagem("exclusão cancelada");
            }
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompra.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompra dialog = new JDlgCompra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<ClienteFgv> jCboCliente;
    private javax.swing.JComboBox<VendedorFgv> jCboVendedor;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtNumCompra;
    private javax.swing.JTextField jTxtValor;
    // End of variables declaration//GEN-END:variables

}
