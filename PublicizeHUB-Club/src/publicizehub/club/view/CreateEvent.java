/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub.club.view;

import java.sql.*;
import javax.swing.*;
import publicizehub.club.controller.ConnectionBuilder;
/**
 *
 * @author JIL
 */
public class CreateEvent extends javax.swing.JFrame {
    public static int runId=10001;
    private int eventType;
    /**
     * Creates new form CreateEvent
     */
    public CreateEvent() {
        initComponents();
    }
    
    public void newEvent() {
        ConnectionBuilder cb = new ConnectionBuilder();
        cb.connecting();
        Statement s = null;
       
        try {
            s = cb.getConnect().createStatement();
            // SQL Insert
            String sql = "INSERT INTO tb_event"
                    + "(evName,evDescrip,evDate,evEndDate,evTime,evEndTime,evPlace,evTicket,evType,stuId) "
                    + "VALUES ('" 
                    + evName.getText()+ "','"
                    + evDescrip.getText()+ "','"
                    + evDate.getText()+ "','"
                    + evEndDate.getText()+ "','"
                    + evPlace.getText()+ "','"
                    + evTicket.getText()+ "','"
                    + evTime.getText()+ "','"
                    + evEndTime.getText()+ "','"
                    + evType.getText()+ "','"
                    + stuId.getText()+ "') ";
            s.executeUpdate(sql);
            
            evName.setText("");
            evDescrip.setText("");
            evDate.setText("");
            evEndDate.setText("");
            evTime.setText("");
            evEndTime.setText("");
            evPlace.setText("");
            evTicket.setText("");
            evType.setText("");
            stuId.setText("");
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

        cb.logout();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        evName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        evDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        evTime = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        evPlace = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        evTicket = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        evEndDate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        evEndTime = new javax.swing.JTextField();
        stuId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        other = new javax.swing.JRadioButton();
        seminar = new javax.swing.JRadioButton();
        camp = new javax.swing.JRadioButton();
        evType = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        evDescrip = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("สร้างกิจกรรม");

        jLabel2.setText("ชื่อกิจกรรม :");

        jLabel4.setText("รายละเอียด :");

        jLabel5.setText("วันจัดกิจกรรม :");

        evDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evDateActionPerformed(evt);
            }
        });

        jLabel6.setText("เวลาเริ่ม :");

        jLabel7.setText("สถานที่ :");

        evPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evPlaceActionPerformed(evt);
            }
        });

        jLabel8.setText("จำนวนบัตร :");

        cancel.setText("ยกเลิก");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        confirm.setText("ยืนยัน");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        jLabel9.setText("วันสิ้นสุดกิจกรรม :");

        jLabel10.setText("เวลาจบ :");

        stuId.setBackground(new java.awt.Color(240, 240, 240));
        stuId.setBorder(null);

        jLabel3.setText("ประเภทกิจกรรม :");

        buttonGroup1.add(other);
        other.setMnemonic('2');
        other.setText("อื่นๆ");
        other.setActionCommand("0");

        buttonGroup1.add(seminar);
        seminar.setMnemonic('1');
        seminar.setText("สัมมนา");
        seminar.setToolTipText("1");
        seminar.setActionCommand("0");

        buttonGroup1.add(camp);
        camp.setMnemonic('0');
        camp.setText("ค่าย");
        camp.setToolTipText("0");
        camp.setActionCommand("0");

        evType.setEditable(false);
        evType.setBackground(new java.awt.Color(240, 240, 240));
        evType.setForeground(new java.awt.Color(240, 240, 240));
        evType.setBorder(null);

        evDescrip.setColumns(20);
        evDescrip.setRows(5);
        jScrollPane2.setViewportView(evDescrip);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(258, 258, 258))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(evPlace, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(evName)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(evDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(evTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(evEndDate)
                            .addComponent(evEndTime, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                    .addComponent(evTicket)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(confirm)
                                .addGap(39, 39, 39)
                                .addComponent(cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(camp)
                                .addGap(18, 18, 18)
                                .addComponent(seminar)
                                .addGap(18, 18, 18)
                                .addComponent(other)
                                .addGap(26, 26, 26)
                                .addComponent(evType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addComponent(stuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(evName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(evDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(evEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(evTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(evEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(evPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(evTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(camp)
                        .addComponent(seminar)
                        .addComponent(other)
                        .addComponent(evType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(confirm))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        
        if(camp.isSelected()){
            evType.setText("0");
        }else if(seminar.isSelected()){
            evType.setText("1");
        }else if(other.isSelected()){
            evType.setText("2");
        }

        newEvent();
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmActionPerformed

    private void evPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evPlaceActionPerformed

    private void evDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evDateActionPerformed

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
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEvent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton camp;
    private javax.swing.JButton cancel;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField evDate;
    private javax.swing.JTextArea evDescrip;
    private javax.swing.JTextField evEndDate;
    private javax.swing.JTextField evEndTime;
    private javax.swing.JTextField evName;
    private javax.swing.JTextField evPlace;
    private javax.swing.JTextField evTicket;
    private javax.swing.JTextField evTime;
    private javax.swing.JTextField evType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton other;
    private javax.swing.JRadioButton seminar;
    private javax.swing.JTextField stuId;
    // End of variables declaration//GEN-END:variables
}
