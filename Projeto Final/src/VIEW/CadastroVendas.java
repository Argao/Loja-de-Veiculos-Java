/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLLER.*;
import MODEL.*;
import SERVICES.MudaValores;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author jgabr
 */
public class CadastroVendas extends javax.swing.JFrame {

    /**
     * Creates new form CadastroVendas
     */
    public CadastroVendas(int id) {
        idLogado = id;
        initComponents();
    }


    public void limpaOsCampos(){
        filialTextField.setText("");
        precoTextField.setText("");
        pagamentoTextField.setText("");
        obsTextArea.setText("");
        carregaDados();
    }

    public  void carregaDados(){
        carregaClientes();
        carregaVeiculos();
    }

    public  void carregaClientes(){
        ArrayList<Cliente> listaClientes = ClienteController.getAll();

        for (Cliente c : listaClientes){
            this.clienteComboBox.addItem(c);
        }
    }

    public  void carregaVeiculos(){

        int tipo = this.tipoComboBox.getSelectedIndex();
        this.veiculoComboBox.removeAllItems();
        switch (tipo) {
            case 0:
                ArrayList<Carro> listaCarros = CarroController.getAll();
                //tela.veiculoComboBox.removeAllItems();
                for (Carro c : listaCarros){
                    this.veiculoComboBox.addItem(c);
                }
                break;
            case 1:
                ArrayList<Moto> listaMotos = MotoController.getAll();
                //tela.veiculoComboBox.removeAllItems();
                for (Moto c : listaMotos){
                    this.veiculoComboBox.addItem(c);
                }
                break;
            case 2:
                ArrayList<Caminhao> listaCaminhoes = CaminhaoController.getAll();
                // tela.veiculoComboBox.removeAllItems();
                for (Caminhao c : listaCaminhoes){
                    this.veiculoComboBox.addItem(c);
                }
                break;
        }
    }

    public void cerregaPreco(){
        int tipo = this.tipoComboBox.getSelectedIndex();

        System.out.println(tipo);
        String preco;
        switch (tipo) {
            case 0:
                try {
                    Carro c = (Carro) this.veiculoComboBox.getSelectedItem();
                    if (c != null){
                        preco = Double.toString(c.getPreco());
                        this.precoTextField.setText(preco);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 1:

                try {
                    Moto m = (Moto) this.veiculoComboBox.getSelectedItem();
                    if (m != null){
                        preco = Double.toString(m.getPreco());
                        this.precoTextField.setText(preco);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case 2:
                try {
                    Caminhao ca = (Caminhao) this.veiculoComboBox.getSelectedItem();
                    if (ca != null){
                        preco = Double.toString(ca.getPreco());
                        this.precoTextField.setText(preco);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        clienteComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        veiculoComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        filialTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pagamentoTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obsTextArea = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();
        precoTextField = new javax.swing.JFormattedTextField();
        sucessoTxt1 = new javax.swing.JLabel();
        erroTxt1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("CADASTRO DE VENDAS");

        jLabel1.setText("Cliente:");

        clienteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de veículo:");

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carro", "Moto", "Caminhão" }));
        tipoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoComboBoxItemStateChanged(evt);
            }
        });
        tipoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Veículo:");

        veiculoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                veiculoComboBoxItemStateChanged(evt);
            }
        });
        veiculoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veiculoComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Filial: ");

        filialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filialTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Preço:");

        jLabel6.setText("Tipo de pagamento:");

        pagamentoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Observações:");

        obsTextArea.setColumns(20);
        obsTextArea.setRows(5);
        jScrollPane1.setViewportView(obsTextArea);

        jToggleButton1.setText("Cadastrar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        precoTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        precoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoTextFieldActionPerformed(evt);
            }
        });

        sucessoTxt1.setForeground(new java.awt.Color(0, 243, 33));
        sucessoTxt1.setToolTipText("");

        erroTxt1.setForeground(java.awt.Color.red);

        jMenu1.setText("Cadastros");

        jMenuItem6.setText("Venda");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("Funcionários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenu3.setText("Veículos");

        jMenuItem3.setText("Carro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Moto");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Caminhão");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");

        jMenuItem7.setText("Clientes");
        jMenuItem7.setToolTipText("");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Funcionarios");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("Veiculos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setText("Vendas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tipoComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE))
                                    .addComponent(veiculoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(clienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(filialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(pagamentoTextField))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(sucessoTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(erroTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToggleButton1)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel22)
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(veiculoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sucessoTxt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erroTxt1)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void tipoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoComboBoxActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tipoComboBoxActionPerformed

    private void clienteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteComboBoxActionPerformed

    private void filialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filialTextFieldActionPerformed

    private void veiculoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veiculoComboBoxActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_veiculoComboBoxActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        Cliente cliente = (Cliente) clienteComboBox.getSelectedItem();

        String tipo = tipoComboBox.getSelectedItem().toString(),
                filial = filialTextField.getText(),
                pagamento = pagamentoTextField.getText(),
                obs = obsTextArea.getText();
        int idVeiculo = 0, idCliente = cliente.getId();
        double preco = MudaValores.precoToDouble(precoTextField.getText());
        switch (tipo){
            case "Carro":
                Carro c = (Carro) veiculoComboBox.getSelectedItem();
                idVeiculo = c.getId();
                break;
            case  "Moto":
                Moto m = (Moto) veiculoComboBox.getSelectedItem();
                idVeiculo = m.getId();
                break;
            case "Caminhão":
                Caminhao ca = (Caminhao) veiculoComboBox.getSelectedItem();
                idVeiculo = ca.getId();
                break;
        }

        Vendas venda = new Vendas(idCliente,idLogado,idVeiculo,preco,filial,obs,pagamento,tipo);
        VendasController.cadastra(this,venda);



    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void precoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoTextFieldActionPerformed

    private void pagamentoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagamentoTextFieldActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        carregaDados();
    }//GEN-LAST:event_formWindowOpened

    private void tipoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoComboBoxItemStateChanged
        // TODO add your handling code here:
        carregaVeiculos();
    }//GEN-LAST:event_tipoComboBoxItemStateChanged

    private void veiculoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_veiculoComboBoxItemStateChanged
        // TODO add your handling code here:v
        cerregaPreco();
        
    }//GEN-LAST:event_veiculoComboBoxItemStateChanged

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        CadastroVendas c = new CadastroVendas(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CadastroClientes c = new CadastroClientes(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CadastroFuncionarios c = new CadastroFuncionarios(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        CadastroCarros c = new CadastroCarros(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        CadastroMotos c = new CadastroMotos(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        CadastroCaminhoes c = new CadastroCaminhoes(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        RelatorioClientes c = new RelatorioClientes(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        RelatorioFuncionarios c = new RelatorioFuncionarios(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        RelatorioVeiculos c = new RelatorioVeiculos(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        RelatorioVendas c = new RelatorioVendas(idLogado);
        c.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem10ActionPerformed





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    public javax.swing.JComboBox<Cliente> clienteComboBox;
    public javax.swing.JLabel erroTxt1;
    private javax.swing.JTextField filialTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextArea obsTextArea;
    private javax.swing.JTextField pagamentoTextField;
    public javax.swing.JFormattedTextField precoTextField;
    public javax.swing.JLabel sucessoTxt1;
    public javax.swing.JComboBox<String> tipoComboBox;
    public javax.swing.JComboBox<Object> veiculoComboBox;
    // End of variables declaration//GEN-END:variables
    private int idLogado;
}
