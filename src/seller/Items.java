package seller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class Items extends javax.swing.JFrame {

    public Items() {
        initComponents();
        MostrarProductos();
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
        PriceTb = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CatTb = new javax.swing.JComboBox<>();
        AddBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductList = new javax.swing.JTable();
        FiltroTb = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(47, 47, 47));

        jPanel2.setBackground(new java.awt.Color(240, 240, 240));

        jLabel5.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(47, 47, 47));
        jLabel5.setText("Gestión de Productos");

        NameTb.setBackground(new java.awt.Color(210, 210, 210));
        NameTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        NameTb.setForeground(new java.awt.Color(47, 47, 47));

        PriceTb.setBackground(new java.awt.Color(210, 210, 210));
        PriceTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        PriceTb.setForeground(new java.awt.Color(47, 47, 47));

        jLabel6.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(47, 47, 47));
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 47, 47));
        jLabel7.setText("Categoria");

        jLabel8.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(47, 47, 47));
        jLabel8.setText("Precio");

        CatTb.setBackground(new java.awt.Color(210, 210, 210));
        CatTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        CatTb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Comida", "Limpieza", "Belleza" }));

        AddBtn.setBackground(new java.awt.Color(129, 78, 250));
        AddBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(240, 240, 240));
        AddBtn.setText("Añadir");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        EditBtn.setBackground(new java.awt.Color(129, 78, 250));
        EditBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(240, 240, 240));
        EditBtn.setText("Editar");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setBackground(new java.awt.Color(129, 78, 250));
        DeleteBtn.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        DeleteBtn.setForeground(new java.awt.Color(240, 240, 240));
        DeleteBtn.setText("Eliminar");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(47, 47, 47));
        jLabel10.setText("Lista de Productos");

        jLabel11.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(47, 47, 47));
        jLabel11.setText("Filtrar");

        jButton5.setBackground(new java.awt.Color(129, 78, 250));
        jButton5.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 240, 240));
        jButton5.setText("Refrescar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ProductList.setBackground(new java.awt.Color(210, 210, 210));
        ProductList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ProductList.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        ProductList.setForeground(new java.awt.Color(47, 47, 47));
        ProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoria", "Precio"
            }
        ));
        ProductList.setShowVerticalLines(true);
        ProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductList);

        FiltroTb.setBackground(new java.awt.Color(210, 210, 210));
        FiltroTb.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 12)); // NOI18N
        FiltroTb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Comida", "Limpieza", "Belleza" }));
        FiltroTb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FiltroTbItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(113, 113, 113)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CatTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(113, 113, 113)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FiltroTb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(112, Short.MAX_VALUE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PriceTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CatTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiltroTb, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(129, 78, 250));
        jLabel1.setText("Productos");

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

        jLabel9.setFont(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Facturación");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int PrNum;
    private void ContarProductos(){
        try {
            St1 = Con.createStatement();
            Rs1 = St1.executeQuery("SELECT MAX(Pnum) FROM producttbl");
            Rs1.next();
            PrNum = Rs1.getInt(1)+1;
        } catch (Exception e) {
        }
    };
        
    private void MostrarProductos(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM producttbl");
            ProductList.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
        }
    };
    
    private void FiltrarPorductos(){
        try {
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM producttbl WHERE Category='"+ FiltroTb.getSelectedItem().toString()+"'");
            ProductList.setModel(DbUtils.resultSetToTableModel(Rs));
        } catch (Exception e) {
        }
    };
    
    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        try {
                ContarProductos();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
                PreparedStatement Pst = Con.prepareStatement("DELETE FROM producttbl WHERE Pnum=?");
                Pst.setInt(1, Key);
                int row = Pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Producto Eliminado");
                Con.close();
                MostrarProductos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        if(NameTb.getText().isEmpty() || PriceTb.getText().isEmpty() || CatTb.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Falta Información");
        }else{
            try {
                ContarProductos();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
                PreparedStatement Pst = Con.prepareStatement("UPDATE producttbl SET Pname=?, Category=?, price=? WHERE Pnum=?");
                Pst.setInt(4, Key);
                Pst.setString(1, NameTb.getText());
                Pst.setString(2, CatTb.getSelectedItem().toString());
                Pst.setInt(3, Integer.valueOf(PriceTb.getText()));
                int row = Pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Producto Modificado");
                Con.close();
                MostrarProductos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if(NameTb.getText().isEmpty() || PriceTb.getText().isEmpty() || CatTb.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(this, "Falta Información");
        }else{
            try {
                ContarProductos();
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sellerdb","root","");
                PreparedStatement Pst = Con.prepareStatement("INSERT INTO producttbl (Pname, Category, price) VALUES (?, ?, ?)");
                Pst.setString(1, NameTb.getText());
                Pst.setString(2, CatTb.getSelectedItem().toString());
                Pst.setInt(3, Integer.valueOf(PriceTb.getText()));
                int row = Pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Producto Añadido");
                Con.close();
                MostrarProductos();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }

        }
    }//GEN-LAST:event_AddBtnActionPerformed
    
    int Key = 0;
    private void ProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductListMouseClicked
        DefaultTableModel model = (DefaultTableModel) ProductList.getModel();
        int Indice = ProductList.getSelectedRow();
        Key = Integer.valueOf(model.getValueAt(Indice, 0).toString());
        NameTb.setText(model.getValueAt(Indice, 1).toString());
//        CatTb.setText(model.getValueAt(Indice, 2).toString());
        PriceTb.setText(model.getValueAt(Indice, 3).toString());
    }//GEN-LAST:event_ProductListMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        MostrarProductos();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void FiltroTbItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FiltroTbItemStateChanged
        FiltrarPorductos();
    }//GEN-LAST:event_FiltroTbItemStateChanged

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new Selling().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new ViewSells().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Items.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Items().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> CatTb;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JComboBox<String> FiltroTb;
    private javax.swing.JTextField NameTb;
    private javax.swing.JTextField PriceTb;
    private javax.swing.JTable ProductList;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    // End of variables declaration//GEN-END:variables
}
