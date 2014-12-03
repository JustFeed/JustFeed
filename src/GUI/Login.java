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
public class Login extends javax.swing.JFrame {

        private JFrame myCaller;
        Klant k = null;
       
        public Database d = new Database();
        
        private static final Login login = new Login();
        
        public static Login getInstance (){
            return login;
        }
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public Login (JFrame caller){
        initComponents();
        myCaller = caller;
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldGebruikersnaam = new javax.swing.JTextField();
        jTextFieldWachtwoord = new javax.swing.JTextField();
        jButtonAanmelden = new javax.swing.JButton();
        jButtonToNewuser = new javax.swing.JButton();
        jButtonWWvergeten = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gebruikersnaam");

        jLabel2.setText("Wachtwoord");

        jButtonAanmelden.setText("Aanmelden");
        jButtonAanmelden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAanmeldenActionPerformed(evt);
            }
        });

        jButtonToNewuser.setText("Nieuwe gebruiker");
        jButtonToNewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonToNewuserActionPerformed(evt);
            }
        });

        jButtonWWvergeten.setText("Wachtwoord Vergeten");
        jButtonWWvergeten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWWvergetenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(jTextFieldGebruikersnaam, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonWWvergeten)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonToNewuser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldWachtwoord)
                                .addComponent(jButtonAanmelden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldGebruikersnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldWachtwoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonAanmelden)
                .addGap(18, 18, 18)
                .addComponent(jButtonToNewuser)
                .addGap(18, 18, 18)
                .addComponent(jButtonWWvergeten)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAanmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAanmeldenActionPerformed
       
        String gebruikersnaam = jTextFieldGebruikersnaam.getText();
        String wachtwoord = jTextFieldWachtwoord.getText();
        
        if(d.checkGebruikersnaam(gebruikersnaam)){
            if (wachtwoord.equals(d.getKlant(gebruikersnaam).getWachtwoord())){
                k = d.getKlant(gebruikersnaam);
                login.setLocationRelativeTo(null);
                this.setVisible(false);
                Lobby lobby = new Lobby(this);
                lobby.setLocationRelativeTo(null);
                lobby.setVisible(true);
                
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Incorrect paswoord. Probeer opnieuw het wachtwoord in te vullen.");
                jTextFieldWachtwoord.setText("");
                jTextFieldWachtwoord.requestFocus(); 
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Deze gebruiker bestaat nog niet, je kan hem aanmaken via de knop 'Nieuwe gebruiker'.");
            jTextFieldGebruikersnaam.setText("");
            jTextFieldWachtwoord.setText("");
            jTextFieldGebruikersnaam.requestFocus();
        }
       
    }//GEN-LAST:event_jButtonAanmeldenActionPerformed

    private void jButtonToNewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonToNewuserActionPerformed
       
        this.setVisible(false);
        NewUser nu = new NewUser(this);
        nu.setVisible (true);
        
    }//GEN-LAST:event_jButtonToNewuserActionPerformed

    private void jButtonWWvergetenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWWvergetenActionPerformed
        this.setVisible(false);
        WachtwoordVergeten ww = new WachtwoordVergeten();
        ww.setVisible(true);
    }//GEN-LAST:event_jButtonWWvergetenActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAanmelden;
    private javax.swing.JButton jButtonToNewuser;
    private javax.swing.JButton jButtonWWvergeten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldGebruikersnaam;
    private javax.swing.JTextField jTextFieldWachtwoord;
    // End of variables declaration//GEN-END:variables
}
