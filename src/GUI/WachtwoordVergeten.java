/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import Database.*;
import Logica.*;
import javax.swing.JOptionPane;

public class WachtwoordVergeten extends javax.swing.JFrame {

   private JFrame myCaller;
    public Database d = new Database();
    
    private static final WachtwoordVergeten wwv = new WachtwoordVergeten();
    
     public static WachtwoordVergeten getInstance(){
        return wwv;
    }
    
    
    public WachtwoordVergeten() {
        initComponents();
    }
    
    public WachtwoordVergeten (JFrame caller) {
        initComponents();
        myCaller = caller;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAnnuleren = new javax.swing.JButton();
        jButtonSendRecoveryMail = new javax.swing.JButton();
        jTextFieldGebruikersnaamVergeten = new javax.swing.JTextField();
        jTextFieldEmailVergeten = new javax.swing.JTextField();
        jTextFieldBeveiligingsvraag = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Geef gebruikersnaam of e-mail");

        jLabel2.setText("Gebruikersnaam");

        jLabel3.setText("E-mail");

        jLabel4.setText("1e Huisdier");

        jButtonAnnuleren.setText("Annuleren");
        jButtonAnnuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerenActionPerformed(evt);
            }
        });

        jButtonSendRecoveryMail.setText("Verzenden");
        jButtonSendRecoveryMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendRecoveryMailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAnnuleren)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSendRecoveryMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldGebruikersnaamVergeten)
                            .addComponent(jTextFieldEmailVergeten)
                            .addComponent(jTextFieldBeveiligingsvraag))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldGebruikersnaamVergeten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmailVergeten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldBeveiligingsvraag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuleren)
                    .addComponent(jButtonSendRecoveryMail))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerenActionPerformed
        setVisible(false);
              Login s = new Login();
              s.setLocationRelativeTo(null);
                s.setVisible(true);
    }//GEN-LAST:event_jButtonAnnulerenActionPerformed

    private void jButtonSendRecoveryMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendRecoveryMailActionPerformed
        String mail = jTextFieldEmailVergeten.getText();
        String gebruikersnaam =  jTextFieldGebruikersnaamVergeten.getText();
        String huisdier = jTextFieldBeveiligingsvraag.getText();
        
        if (d.checkGebruikersnaam(gebruikersnaam))
        {
            if (d.checkBeveiliging(huisdier))
            {
                JOptionPane.showMessageDialog(null, "Gebruikersnaam : " + gebruikersnaam + "\t Wachtwoord: " + d.getWachtwoord(gebruikersnaam));
                setVisible(false);
              Lobby lobby = new Lobby();
              lobby.setLocationRelativeTo(null);
                lobby.setVisible(true);    
            }
            else {
                JOptionPane.showMessageDialog(null, "antwoord beveiligingsvraag is foutief");
                        
                          jTextFieldBeveiligingsvraag.setText("");
                    jTextFieldBeveiligingsvraag.requestFocus();
                 
            }
            
            
        }
        else if(d.checkMail(mail))  {
            if (d.checkBeveiliging(huisdier))
            {
                String gebruiker = d.getGebruikersnaam(mail);
                JOptionPane.showMessageDialog(null, "Gebruikersnaam : " + gebruiker + "\t Wachtwoord: " + d.getWachtwoord(gebruiker));
                  
                
                setVisible(false);
              Lobby lobby = new Lobby();
              lobby.setLocationRelativeTo(null);
                lobby.setVisible(true);
            } 
            
            else {
                JOptionPane.showMessageDialog(null, "antwoord beveiligingsvraag is foutief");
                   jTextFieldBeveiligingsvraag.setText("");
                    jTextFieldBeveiligingsvraag.requestFocus();
            }
            
            
            
             }
        
        else { JOptionPane.showMessageDialog(null, "Gebruikersnaam en of mail bestaan niet");
                 jTextFieldEmailVergeten.setText("");
                 jTextFieldGebruikersnaamVergeten.setText("");
                    jTextFieldBeveiligingsvraag.setText("");
        }
        
    }//GEN-LAST:event_jButtonSendRecoveryMailActionPerformed

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
            java.util.logging.Logger.getLogger(WachtwoordVergeten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WachtwoordVergeten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WachtwoordVergeten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WachtwoordVergeten.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WachtwoordVergeten().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuleren;
    private javax.swing.JButton jButtonSendRecoveryMail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldBeveiligingsvraag;
    private javax.swing.JTextField jTextFieldEmailVergeten;
    private javax.swing.JTextField jTextFieldGebruikersnaamVergeten;
    // End of variables declaration//GEN-END:variables
}
