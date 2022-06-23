/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieunhap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class QuanLiPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form QuanLiPhieuNhap
     */
    private DefaultTableModel model;   
    private ArrayList<PhieuNhap> dsPhieuNhap;
    private PhieuNhap phieuNhap;
    private String idNV;

    public String getIdNV() {
        return idNV;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }
    
    public QuanLiPhieuNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
    }
    public QuanLiPhieuNhap(String idNV) {
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
        this.idNV = idNV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comb_TimKiem = new javax.swing.JComboBox<>();
        text_TimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lí Phiếu Nhập");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comb_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        comb_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu nhập", "Mã nhân viên" }));
        comb_TimKiem.setToolTipText("");
        getContentPane().add(comb_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        text_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_TimKiemKeyReleased(evt);
            }
        });
        getContentPane().add(text_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 53, 513, -1));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "        Mã phiếu nhập", "         Ngày nhập", "          Mã nhân viên", "    Mã nhà cung cấp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, 560, 324));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/them.png"))); // NOI18N
        addButton.setText("Thêm");
        addButton.setToolTipText("Add");
        addButton.setMaximumSize(new java.awt.Dimension(125, 37));
        addButton.setMinimumSize(new java.awt.Dimension(125, 37));
        addButton.setPreferredSize(new java.awt.Dimension(125, 37));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 130, -1));

        delButton.setBackground(new java.awt.Color(255, 255, 255));
        delButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        delButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/delete2.png"))); // NOI18N
        delButton.setText("Xoá");
        delButton.setToolTipText("Remove");
        delButton.setMaximumSize(new java.awt.Dimension(125, 37));
        delButton.setMinimumSize(new java.awt.Dimension(125, 37));
        delButton.setPreferredSize(new java.awt.Dimension(125, 37));
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });
        getContentPane().add(delButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 130, -1));

        editButton.setBackground(new java.awt.Color(255, 255, 255));
        editButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/edit.png"))); // NOI18N
        editButton.setText("Sửa");
        editButton.setToolTipText("Edit");
        editButton.setMaximumSize(new java.awt.Dimension(125, 37));
        editButton.setMinimumSize(new java.awt.Dimension(125, 37));
        editButton.setPreferredSize(new java.awt.Dimension(125, 37));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 130, -1));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/back.png"))); // NOI18N
        backButton.setText("Trở lại");
        backButton.setToolTipText("Remove");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 130, -1));

        infoButton.setBackground(new java.awt.Color(255, 255, 255));
        infoButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/info1.jpg"))); // NOI18N
        infoButton.setText("Info");
        infoButton.setMaximumSize(new java.awt.Dimension(125, 37));
        infoButton.setMinimumSize(new java.awt.Dimension(125, 37));
        infoButton.setPreferredSize(new java.awt.Dimension(125, 37));
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(infoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 130, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phieunhap/background_formQL.jpg"))); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(520, 320));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 730, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_TimKiemKeyReleased
        // TODO add your handling code here:
        int columnIndex = 0;
        String value = (String) comb_TimKiem.getSelectedItem();
        switch (value) {
            case "Mã phiếu nhập":
            columnIndex = 0;
            break;
            case "Mã nhân viên":
            columnIndex = 2;
            break;
        }
        timKiem(columnIndex);
    }//GEN-LAST:event_text_TimKiemKeyReleased

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        if(this.getPhieuNhap() == null){
            JOptionPane.showMessageDialog(rootPane, "Phải chọn 1 phiếu nhập để sửa thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        SuaPhieuNhap spn = new SuaPhieuNhap(this,rootPaneCheckingEnabled);
        spn.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        FormPhieuNhap fpn = new FormPhieuNhap(this,rootPaneCheckingEnabled);
        fpn.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        phieuNhap = getDataARow();
    }//GEN-LAST:event_jTable1MouseClicked

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        // TODO add your handling code here:
        if(this.getPhieuNhap() == null){
            JOptionPane.showMessageDialog(rootPane, "Phải chọn 1 phiếu nhập để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắn chắn muốn xóa phiếu nhập này?", "Cảnh báo",JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION){
            ConnectionSQL sql = new ConnectionSQL();
            String idPN = phieuNhap.getIdPN();
            try{
                sql.deleteSQL(idPN);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Đã xảy ra lỗi khi xóa phiếu !", "Lỗi", JOptionPane.ERROR_MESSAGE);                        
            }
            loadData();
            JOptionPane.showMessageDialog(rootPane, "Phiếu nhập đã xóa thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);
        }            
    }//GEN-LAST:event_delButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        // TODO add your handling code here:
        if(this.getPhieuNhap() == null){
            JOptionPane.showMessageDialog(rootPane, "Phải chọn 1 phiếu nhập để xem thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
            return;
        }
        ShowCTPN info = new ShowCTPN(this, rootPaneCheckingEnabled);
        info.setVisible(true);
    }//GEN-LAST:event_infoButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    //tim kiem theo ma hoac ten
    private void timKiem(int columnIndex) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(String.format("(?i)%s", text_TimKiem.getText()), columnIndex));
    }
    
    //load du lieu len table
    public void loadData(){
        ConnectionSQL sql = new ConnectionSQL();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        dsPhieuNhap =  sql.getListPN();        
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for (PhieuNhap pn : dsPhieuNhap) {
            Object[] data = {pn.getIdPN(),format1.format(pn.getNgayNhap()),pn.getIdNV(),pn.getIdNCC()};
            model.addRow(data);
        }
    }
    
    //lay du lieu tu 1 hang cua table
    public PhieuNhap getDataARow(){
        PhieuNhap pn = new PhieuNhap();
        try {
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            int i = jTable1.getSelectedRow();
            pn.setIdPN((String) jTable1.getValueAt(i,0));
            pn.setNgayNhap(format1.parse((String) jTable1.getValueAt(i,1)));
            pn.setIdNV((String) jTable1.getValueAt(i,2));
            pn.setIdNCC((String) jTable1.getValueAt(i,3));
        } catch (ParseException ex) {
            Logger.getLogger(QuanLiPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pn;
    } 
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
            java.util.logging.Logger.getLogger(QuanLiPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JComboBox<String> comb_TimKiem;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField text_TimKiem;
    // End of variables declaration//GEN-END:variables
}