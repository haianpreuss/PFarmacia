/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Produto;
import model.bean.Venda;
import model.bean.Venda_produto;
import model.dao.ClienteDAO;
import model.dao.EstoqueDAO;
import model.dao.ProdutoDAO;
import model.dao.VendaDAO;
import model.dao.Venda_produtoDAO;
import static view.JMainAdmin.jDesktopAdmin;
import static view.JMainFunc.jDesktopFunc;

/**
 *
 * @author Fes-Suporte
 */
public class JInternalVenda extends javax.swing.JInternalFrame {

    private Integer count = 0;
    protected Integer cod_func;

    /**
     * Creates new form JInternalVenda
     */
    public JInternalVenda() {
        initComponents();
        ClienteDAO cdao = new ClienteDAO();
        ProdutoDAO pdao = new ProdutoDAO();
        DefaultTableModel modelo = (DefaultTableModel) jTableVenda.getModel();
        jTableVenda.setRowSorter(new TableRowSorter(modelo));
        for (Cliente c : cdao.read()) {
            cbCliente.addItem(c.toString());
        }
        for (Produto p : pdao.read()) {
            cbProduto.addItem(p.toString());
        }
    }

    public void subQuantidade(Integer chave) {
        for (int i = 0; i < count; i++) {
            if (chave == jTableVenda.getValueAt(i, 0)) {
                Integer a = Integer.parseInt(lbQnt.getText());
                Integer b = Integer.parseInt(jTableVenda.getValueAt(i, 2).toString());
                Integer c = a - b;
                String op = c.toString();
                lbQnt.setText(op);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDados = new javax.swing.JPanel();
        pnBotao = new javax.swing.JPanel();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbUnit = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        cbProduto = new javax.swing.JComboBox<>();
        txtQuantidade = new javax.swing.JTextField();
        btnCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbQnt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVenda = new javax.swing.JTable();
        btnGravar = new javax.swing.JButton();
        pnTabela = new javax.swing.JPanel();

        setTitle("Venda");

        btnInserir.setText("Inserir Produto");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });
        pnBotao.add(btnInserir);

        btnRemover.setText("Remover Produto");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        pnBotao.add(btnRemover);

        jLabel1.setText("Cliente:");

        jLabel2.setText("Produto:");

        jLabel3.setText("Quantidade:");

        jLabel4.setText("Valor Unitário:");

        jLabel5.setText("Valor Total:");

        lbUnit.setText("jLabel6");

        lbTotal.setText("jLabel6");

        cbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbProdutoItemStateChanged(evt);
            }
        });

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        btnCliente.setText("Cadastrar Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("Estoque: ");

        lbQnt.setText("xx");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTotal)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbUnit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbQnt)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbQnt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbUnit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Qnt", "Unit", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVenda);

        btnGravar.setText("Confirmar Compra");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addComponent(btnGravar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(pnDados, java.awt.BorderLayout.PAGE_START);

        pnTabela.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(pnTabela, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbProdutoItemStateChanged
        ProdutoDAO pdao = new ProdutoDAO();
        Double d = pdao.readUnit(Integer.parseInt(cbProduto.getItemAt(cbProduto.getSelectedIndex()).substring(0, 4).replaceAll(" ", "")));
        lbUnit.setText("R$ " + d);
        lbTotal.setText("R$ ");
        txtQuantidade.setText("");
        Integer chave = Integer.parseInt(cbProduto.getItemAt(cbProduto.getSelectedIndex()).substring(0, 4).replaceAll(" ", ""));
        EstoqueDAO edao = new EstoqueDAO();
        lbQnt.setText(edao.getQnt(chave).toString());

        subQuantidade(chave);

    }//GEN-LAST:event_cbProdutoItemStateChanged

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        Double unit = Double.parseDouble(lbUnit.getText().substring(3));
        Integer qnt = Integer.parseInt(txtQuantidade.getText());
        unit *= qnt;
        lbTotal.setText("R$ " + unit);
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        txtQuantidadeKeyPressed(evt);
    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if ((Integer.parseInt(lbQnt.getText()) - (Integer.parseInt(txtQuantidade.getText())) < 0)) {
            JOptionPane.showMessageDialog(null, "Quantidade Inválida no Estoque");
        } else {
            count++;
            ProdutoDAO pdao = new ProdutoDAO();
            DefaultTableModel modelo = (DefaultTableModel) jTableVenda.getModel();
            Integer chave = Integer.parseInt(cbProduto.getItemAt(cbProduto.getSelectedIndex()).substring(0, 4).replaceAll(" ", ""));
            modelo.addRow(new Object[]{
                chave,
                pdao.readDesc(chave),
                txtQuantidade.getText(),
                lbUnit.getText().substring(3),
                lbTotal.getText().substring(3)
            });
            EstoqueDAO edao = new EstoqueDAO();
            lbQnt.setText(edao.getQnt(chave).toString());
            subQuantidade(chave);
        }


    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        count--;
        if (jTableVenda.getSelectedRow() != -1) {
            DefaultTableModel modelo = (DefaultTableModel) jTableVenda.getModel();
            modelo.removeRow(jTableVenda.getSelectedRow());
        }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) jTableVenda.getModel();
        Venda venda = new Venda();
        VendaDAO vdao = new VendaDAO();
        Venda_produtoDAO vpdao = new Venda_produtoDAO();
        Venda_produto venda_produto = new Venda_produto();
        EstoqueDAO edao = new EstoqueDAO();

        venda.setCliente_cod_cliente(Integer.parseInt(cbCliente.getItemAt(cbCliente.getSelectedIndex()).substring(0, 4).replaceAll(" ", "")));

        venda.setFuncionario_cod_funcionario(cod_func);

        Integer chave = vdao.create(venda);

        venda_produto.setVenda_cod_venda(chave);
        for (int i = 0; i < count; i++) {
            venda_produto.setProduto_cod_produto(Integer.parseInt(jTableVenda.getValueAt(i, 0).toString()));
            venda_produto.setQuantidade_produto(Integer.parseInt(jTableVenda.getValueAt(i, 2).toString()));
            vpdao.create(venda_produto);

            edao.updateQnt(venda_produto.getProduto_cod_produto(), venda_produto.getQuantidade_produto());
            edao.deleteZero();

        }
        modelo.setNumRows(0);
        count = 0;
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        JInternalCliente jicliente = new JInternalCliente();

        Boolean exist = false;
        try {
            for (JInternalFrame internal : jDesktopAdmin.getAllFrames()) {
                if (internal.getClass().toString().equalsIgnoreCase(jicliente.getClass().toString())) {
                    internal.moveToFront();
                    exist = true;
                }
            }
            if (!exist) {
                jDesktopAdmin.add(jicliente);
                jicliente.setVisible(true);
                jicliente.setClosable(true);
                jicliente.setIconifiable(true);
            }
        } catch (java.lang.NullPointerException ex) {
            for (JInternalFrame internal : jDesktopFunc.getAllFrames()) {
                if (internal.getClass().toString().equalsIgnoreCase(jicliente.getClass().toString())) {
                    internal.moveToFront();
                    exist = true;
                }
            }
            if (!exist) {
                jDesktopFunc.add(jicliente);
                jicliente.setVisible(true);
                jicliente.setClosable(true);
                jicliente.setIconifiable(true);
            }
        }
    }//GEN-LAST:event_btnClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVenda;
    private javax.swing.JLabel lbQnt;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbUnit;
    private javax.swing.JPanel pnBotao;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}