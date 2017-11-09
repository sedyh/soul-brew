
package com.ampersand.soulbrew;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Launcher extends javax.swing.JFrame {

    private int width, height;
    
    public Launcher() {
        initLAF();
        initComponents();
        setLocationRelativeTo(null);
	setTitle("Soul Brew: By Sedykh Artem aka sedyh");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jLabel4.setText(String.valueOf(screenSize.width)+"x"+String.valueOf(screenSize.height));
        jLabel4.setEnabled(false);
        jTextField1.setEnabled(false);
        jLabel3.setEnabled(false);
        jTextField2.setEnabled(false);
        jComboBox1.setEnabled(true);
	System.out.println(new File("/fonts/slkscr.ttf").exists());
    }

    public void initLAF() {
        try {
          String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
          // устанавливаем LookAndFeel
          UIManager.setLookAndFeel(systemLookAndFeelClassName);
        } catch (UnsupportedLookAndFeelException e) {
          System.err.println("Can't use the specified look and feel on this platform.");
        } catch (Exception e) {
          System.err.println("Couldn't get specified look and feel, for some reason.");
      }
    }

    @SuppressWarnings("unchecked")
 // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
 private void initComponents() {
  java.awt.GridBagConstraints gridBagConstraints;

  buttonGroup1 = new javax.swing.ButtonGroup();
  jPanel1 = new javax.swing.JPanel();
  jLabel2 = new javax.swing.JLabel();
  filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  jComboBox1 = new javax.swing.JComboBox<>();
  jRadioButton1 = new javax.swing.JRadioButton();
  filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  jRadioButton2 = new javax.swing.JRadioButton();
  jRadioButton3 = new javax.swing.JRadioButton();
  filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  jTextField1 = new javax.swing.JTextField();
  jLabel3 = new javax.swing.JLabel();
  filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  jTextField2 = new javax.swing.JTextField();
  jLabel4 = new javax.swing.JLabel();
  filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12), new java.awt.Dimension(12, 12));
  jButton1 = new javax.swing.JButton();

  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  setTitle("Soul Brew Launcher");
  setMinimumSize(new java.awt.Dimension(390, 248));

  jPanel1.setLayout(new java.awt.GridBagLayout());

  jLabel2.setText("Разрешение:");
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 2;
  gridBagConstraints.gridwidth = 5;
  jPanel1.add(jLabel2, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 19;
  jPanel1.add(filler2, gridBagConstraints);

  jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "800x600", "1024x768", "1280x720", "1280x800", "2048x1536", "3840x2160" }));
  jComboBox1.setFocusable(false);
  jComboBox1.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    jComboBox1ActionPerformed(evt);
   }
  });
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 3;
  gridBagConstraints.gridy = 19;
  gridBagConstraints.gridwidth = 3;
  jPanel1.add(jComboBox1, gridBagConstraints);

  buttonGroup1.add(jRadioButton1);
  jRadioButton1.setText("Fullscreen");
  jRadioButton1.setFocusPainted(false);
  jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    jRadioButton1ActionPerformed(evt);
   }
  });
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 12;
  gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
  jPanel1.add(jRadioButton1, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 0;
  gridBagConstraints.gridy = 14;
  jPanel1.add(filler3, gridBagConstraints);
  jPanel1.add(filler4, new java.awt.GridBagConstraints());

  buttonGroup1.add(jRadioButton2);
  jRadioButton2.setSelected(true);
  jRadioButton2.setText("Option");
  jRadioButton2.setFocusPainted(false);
  jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    jRadioButton2ActionPerformed(evt);
   }
  });
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 19;
  gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
  jPanel1.add(jRadioButton2, gridBagConstraints);

  buttonGroup1.add(jRadioButton3);
  jRadioButton3.setText("Any resolution");
  jRadioButton3.setFocusPainted(false);
  jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    jRadioButton3ActionPerformed(evt);
   }
  });
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 23;
  jPanel1.add(jRadioButton3, gridBagConstraints);
  jPanel1.add(filler5, new java.awt.GridBagConstraints());

  jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
  jTextField1.setMaximumSize(new java.awt.Dimension(60, 30));
  jTextField1.setMinimumSize(new java.awt.Dimension(60, 30));
  jTextField1.setPreferredSize(new java.awt.Dimension(60, 30));
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 3;
  gridBagConstraints.gridy = 23;
  jPanel1.add(jTextField1, gridBagConstraints);

  jLabel3.setText(" x ");
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 4;
  gridBagConstraints.gridy = 23;
  jPanel1.add(jLabel3, gridBagConstraints);
  jPanel1.add(filler6, new java.awt.GridBagConstraints());
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 22;
  jPanel1.add(filler7, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 14;
  jPanel1.add(filler8, gridBagConstraints);
  jPanel1.add(filler9, new java.awt.GridBagConstraints());
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 0;
  gridBagConstraints.gridy = 24;
  jPanel1.add(filler11, gridBagConstraints);

  jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
  jTextField2.setMaximumSize(new java.awt.Dimension(60, 30));
  jTextField2.setMinimumSize(new java.awt.Dimension(60, 30));
  jTextField2.setPreferredSize(new java.awt.Dimension(60, 30));
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 5;
  gridBagConstraints.gridy = 23;
  jPanel1.add(jTextField2, gridBagConstraints);

  jLabel4.setText("N/A");
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 3;
  gridBagConstraints.gridy = 12;
  gridBagConstraints.gridwidth = 3;
  jPanel1.add(jLabel4, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 6;
  gridBagConstraints.gridy = 26;
  jPanel1.add(filler12, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 7;
  jPanel1.add(filler10, gridBagConstraints);
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 7;
  jPanel1.add(filler13, gridBagConstraints);

  jButton1.setText("Launch");
  jButton1.setFocusPainted(false);
  jButton1.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    jButton1ActionPerformed(evt);
   }
  });
  gridBagConstraints = new java.awt.GridBagConstraints();
  gridBagConstraints.gridx = 1;
  gridBagConstraints.gridy = 25;
  gridBagConstraints.gridwidth = 5;
  gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
  jPanel1.add(jButton1, gridBagConstraints);

  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
  );
  layout.setVerticalGroup(
   layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
   .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
  );

  pack();
 }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jLabel4.setEnabled(true);
        jTextField1.setEnabled(false);
        jLabel3.setEnabled(false);
        jTextField2.setEnabled(false);
        jComboBox1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jLabel4.setEnabled(false);
        jTextField1.setEnabled(false);
        jLabel3.setEnabled(false);
        jTextField2.setEnabled(false);
        jComboBox1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jLabel4.setEnabled(false);
        jTextField1.setEnabled(true);
        jLabel3.setEnabled(true);
        jTextField2.setEnabled(true);
        jComboBox1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jRadioButton1.isSelected()) {
         Game game = new Game("Soul Brew", 800, 600, true);
         game.start();
        } else if(jRadioButton2.isSelected()) {
         String[] arr = jComboBox1.getSelectedItem().toString().split("x");
         Game game = new Game("Soul Brew", Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), false);
         game.start();
        } else if(jRadioButton3.isSelected()) {
         Game game = new Game("Soul Brew", Integer.parseInt(jTextField1.getText()), Integer.parseInt(jTextField2.getText()), false);
         game.start();
        }
	setVisible(false); //you can't see me!
        dispose(); //Destroy the JFrame object
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Launcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launcher().setVisible(true);
            }
        });
    }

 // Variables declaration - do not modify//GEN-BEGIN:variables
 private javax.swing.ButtonGroup buttonGroup1;
 private javax.swing.Box.Filler filler10;
 private javax.swing.Box.Filler filler11;
 private javax.swing.Box.Filler filler12;
 private javax.swing.Box.Filler filler13;
 private javax.swing.Box.Filler filler2;
 private javax.swing.Box.Filler filler3;
 private javax.swing.Box.Filler filler4;
 private javax.swing.Box.Filler filler5;
 private javax.swing.Box.Filler filler6;
 private javax.swing.Box.Filler filler7;
 private javax.swing.Box.Filler filler8;
 private javax.swing.Box.Filler filler9;
 private javax.swing.JButton jButton1;
 private javax.swing.JComboBox<String> jComboBox1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JLabel jLabel3;
 private javax.swing.JLabel jLabel4;
 private javax.swing.JPanel jPanel1;
 private javax.swing.JRadioButton jRadioButton1;
 private javax.swing.JRadioButton jRadioButton2;
 private javax.swing.JRadioButton jRadioButton3;
 private javax.swing.JTextField jTextField1;
 private javax.swing.JTextField jTextField2;
 // End of variables declaration//GEN-END:variables
}
