package seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Selling extends javax.swing.JFrame {

    public Selling() {
        initComponents();
        MostrarProductos();
        PriceTb.setEditable(false);
        VendedorTb.setEditable(false);
        NameTb.setEditable(false);
    }
    
    ResultSet Rs = null, Rs1 = null;
    Connection Con = null;
    Statement St = null, St1 = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        NameTb = new javax.swing.JTextField();
        VendedorTb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddFactBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaProductoFact = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PriceTb = new javax.swing.JTextField();
        CantidadTb = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListaProductos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        ImprimirBtn = new javax.swing.JButton();
        TotalTb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(47, 47, 47));

        jPanel2.setBackground(new java.awt.Color(240, 240, 240));

        jLabel5.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(47, 47, 47));
        jLabel5.setText("Vender Productos");

        NameTb.setBackground(new java.awt.Color(210, 210, 210));
        NameTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        NameTb.setForeground(new java.awt.Color(47, 47, 47));

        VendedorTb.setBackground(new java.awt.Color(210, 210, 210));
        VendedorTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        VendedorTb.setForeground(new java.awt.Color(47, 47, 47));
        VendedorTb.setText("Admin");

        jLabel6.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(47, 47, 47));
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 47, 47));
        jLabel7.setText("Vendedor");

        AddFactBtn.setBackground(new java.awt.Color(129, 78, 250));
        AddFactBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        AddFactBtn.setForeground(new java.awt.Color(240, 240, 240));
        AddFactBtn.setText("Añadir a Factura");
        AddFactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFactBtnActionPerformed(evt);
            }
        });

        ListaProductoFact.setBackground(new java.awt.Color(210, 210, 210));
        ListaProductoFact.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ListaProductoFact.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        ListaProductoFact.setForeground(new java.awt.Color(47, 47, 47));
        ListaProductoFact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Cantidad", "Total"
            }
        ));
        ListaProductoFact.setShowVerticalLines(true);
        jScrollPane1.setViewportView(ListaProductoFact);

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(47, 47, 47));
        jLabel9.setText("Precio");

        jLabel12.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(47, 47, 47));
        jLabel12.setText("Cantidad");

        PriceTb.setBackground(new java.awt.Color(210, 210, 210));
        PriceTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        PriceTb.setForeground(new java.awt.Color(47, 47, 47));
        PriceTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTbActionPerformed(evt);
            }
        });

        CantidadTb.setBackground(new java.awt.Color(210, 210, 210));
        CantidadTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        CantidadTb.setForeground(new java.awt.Color(47, 47, 47));
        CantidadTb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadTbActionPerformed(evt);
            }
        });

        ListaProductos.setBackground(new java.awt.Color(210, 210, 210));
        ListaProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ListaProductos.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        ListaProductos.setForeground(new java.awt.Color(47, 47, 47));
        ListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Precio"
            }
        ));
        ListaProductos.setShowVerticalLines(true);
        ListaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListaProductos);

        jLabel8.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(47, 47, 47));
        jLabel8.setText("Tu Factura");

        ImprimirBtn.setBackground(new java.awt.Color(129, 78, 250));
        ImprimirBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        ImprimirBtn.setForeground(new java.awt.Color(240, 240, 240));
        ImprimirBtn.setText("Imprimir Factura");
        ImprimirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirBtnActionPerformed(evt);
            }
        });

        TotalTb.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        TotalTb.setForeground(new java.awt.Color(47, 47, 47));
        TotalTb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CantidadTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VendedorTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)))
                    .addComponent(NameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(AddFactBtn))
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(424, 424, 424))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImprimirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TotalTb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VendedorTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CantidadTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(AddFactBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(TotalTb, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ImprimirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Productos");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Ventas");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Salir");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(129, 78, 250));
        jLabel10.setText("Facturación");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 550, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarProductos(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM producttbl");
            ListaProductos.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
        }
    };
    
    int FacNum;
    private void ContarFactura(){
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("SELECT MAX(FacNum) FROM billtbl");
            Rs1.next();
            FacNum = Rs1.getInt(1)+1;
        } catch (Exception e) {
        }
    };
    
    private void InsertarFactura(){
        try {
            ContarFactura();
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
            PreparedStatement Pst = Con.prepareStatement("INSERT INTO billtbl (FacNum, Vendedor, FacDate, Amount) VALUES (?, ?, ?, ?)");
            Pst.setInt(1, FacNum);
            Pst.setString(2, VendedorTb.getText());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            Pst.setString(3, now.toString());
            Pst.setInt(4, FactTotal);
            int row = Pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Factura Añadida");
            Con.close();
            MostrarProductos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    };    
    int FactTotal = 0;
    private void AddFactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFactBtnActionPerformed
        if (NameTb.getText().isEmpty() || PriceTb.getText().isEmpty() || CantidadTb.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Falta información");
        }else{
            int Total = Integer.valueOf(PriceTb.getText())*Integer.valueOf(CantidadTb.getText());
            FactTotal = FactTotal + Total;
            TotalTb.setText("Total: "+FactTotal);
            DefaultTableModel model = (DefaultTableModel) ListaProductoFact.getModel();
            String sigIdFila = Integer.toString(model.getRowCount());
            model.addRow(new Object[]{
            Integer.valueOf(sigIdFila)+1,
                NameTb.getText(),
                PriceTb.getText(),
                CantidadTb.getText(),
                Total
            });
        }
        
    }//GEN-LAST:event_AddFactBtnActionPerformed

    private void PriceTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceTbActionPerformed

    private void CantidadTbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadTbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadTbActionPerformed

    private void ImprimirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirBtnActionPerformed
        try {
            InsertarFactura();
            ListaProductoFact.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ImprimirBtnActionPerformed
    
    int Key = 0;
    int Stock;
    private void ListaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaProductosMouseClicked
        DefaultTableModel model = (DefaultTableModel) ListaProductos.getModel();
        int Indice = ListaProductos.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(Indice, 0).toString());
        NameTb.setText(model.getValueAt(Indice, 1).toString());
//        CatTb.setText(model.getValueAt(Indice, 2).toString());
        PriceTb.setText(model.getValueAt(Indice, 3).toString());
    }//GEN-LAST:event_ListaProductosMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Items().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new ViewSells().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selling().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFactBtn;
    private javax.swing.JTextField CantidadTb;
    private javax.swing.JButton ImprimirBtn;
    private javax.swing.JTable ListaProductoFact;
    private javax.swing.JTable ListaProductos;
    private javax.swing.JTextField NameTb;
    private javax.swing.JTextField PriceTb;
    private javax.swing.JLabel TotalTb;
    private javax.swing.JTextField VendedorTb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
