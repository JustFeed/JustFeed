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


/**
 *
 * @author dcuvelie
 */
public class NewUser extends javax.swing.JFrame {

    
    private JFrame myCaller;
    public Database d = new Database();
    public Klant actief = Login.getInstance().getActief();
   
    
    private static final NewUser nu = new NewUser();
    
    public static NewUser getInstance(){
        return nu;
    }
    
    public NewUser() {
        initComponents();
    }
    
      public NewUser (JFrame caller) {
        initComponents();
        myCaller = caller;
    }
      
      private void jButtonAnnulerenActionPerformed(java.awt.event.ActionEvent evt){
          if ( actief == null) {
              Login s = new Login();
              s.setLocationRelativeTo(null);
                s.setVisible(true);
                setVisible(false);
              
          }
          else{
            d.deleteKlant(actief);
            Login s = new Login();
            s.setLocationRelativeTo(null);
            s.setVisible(true);
            setVisible(false);
      }}
    
    
                                         

    private void jButtonRegistrerenActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        String paswoord = jTextFieldSetWachtwoord.getText();
        String paswoordHerhaald = jTextFieldBevestigWachtwoord.getText();
        String gebruikersnaam = jTextFieldKiesGebruikersnaam.getText();
        String naam = jTextFieldNaam.getText();
        String voornaam = jTextFieldVoornaam.getText();
        String mail = jTextFieldEmail.getText();
        int postcode = Integer.parseInt(jTextFieldPostcode.getText());
        int huisnummer = Integer.parseInt(jTextFieldHuisnummer.getText());
        String gsm = jTextFieldGsm.getText();
        String straatnaam = jTextFieldStraatnaam.getText();
        
        if(checkPaswoord(paswoord, gebruikersnaam))
        {
            if(paswoord.equals(paswoordHerhaald))
            {
                Klant k = new Klant(naam, voornaam, gebruikersnaam, mail, postcode, huisnummer, gsm, paswoord, straatnaam);
            
                if(d.checkGebruikersnaam(k.getGebruikersnaam()))
                {
                    JOptionPane.showMessageDialog(null, "Deze gebruikersnaam bestaat al.");
                    jTextFieldKiesGebruikersnaam.setText("");
                    jTextFieldSetWachtwoord.setText("");
                    jTextFieldBevestigWachtwoord.setText("");
                    jTextFieldKiesGebruikersnaam.requestFocus();
                    jTextFieldNaam.setText("");
                     jTextFieldVoornaam.setText("");
                     jTextFieldEmail.setText("");
                    jTextFieldPostcode  .setText("");
                    jTextFieldHuisnummer.setText("");
                    jTextFieldGsm  .setText("");
                    jTextFieldStraatnaam     .setText("");   
                }
                else
                {
                    d.addKlant(k);
                    Login.getInstance().setActief(k);
                    actief = Login.getInstance().getActief();
                    //hier komt joptionpane die zegt aanmalden succes, we verminden u nu door met de lobby
                    JOptionPane.showMessageDialog(null, "Account succesvol aangemaakt, we verbinden u door met de lobby");
                    
                    Lobby lobby = new Lobby(this);
                    lobby.setLocationRelativeTo(null);
                    lobby.setVisible(true);
                    setVisible(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Beide wachtwoorden komen niet overeen.");
                 jTextFieldKiesGebruikersnaam.setText("");
                    jTextFieldSetWachtwoord.setText("");
                    jTextFieldBevestigWachtwoord.setText("");
                    jTextFieldKiesGebruikersnaam.requestFocus();
                    jTextFieldNaam.setText("");
                     jTextFieldVoornaam.setText("");
                     jTextFieldEmail.setText("");
                    jTextFieldPostcode  .setText("");
                    jTextFieldHuisnummer.setText("");
                    jTextFieldGsm  .setText("");
                    jTextFieldStraatnaam     .setText("");   
                jTextFieldSetWachtwoord.requestFocus();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Het wachtwoord moet tussen minstens 8 karakters lang zijn en mag de gebruikersnaam niet bevatten");
             jTextFieldKiesGebruikersnaam.setText("");
                    jTextFieldSetWachtwoord.setText("");
                    jTextFieldBevestigWachtwoord.setText("");
                    jTextFieldKiesGebruikersnaam.requestFocus();
                    jTextFieldNaam.setText("");
                     jTextFieldVoornaam.setText("");
                     jTextFieldEmail.setText("");
                    jTextFieldPostcode  .setText("");
                    jTextFieldHuisnummer.setText("");
                    jTextFieldGsm  .setText("");
                     jTextFieldStraatnaam     .setText("");   
                    jTextFieldSetWachtwoord.requestFocus();
        }
    }    
    
   
    
    public boolean checkPaswoord(String paswoord, String gebruikersnaam)
    {
        int length;
        length = paswoord.length();
        int lengthgebruikersnaam;
        lengthgebruikersnaam = gebruikersnaam.length();
        
        if(length < 8)
        {
            return false;
        }
        
        for(int i = 0; i < paswoord.length()-gebruikersnaam.length();i++)
        {
            if (paswoord.contains(gebruikersnaam))
            {
                return false;
            }           
            return true;
        }
        return true;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        huisnummer = new javax.swing.JLabel();
        jTextFieldKiesGebruikersnaam = new javax.swing.JTextField();
        jTextFieldSetWachtwoord = new javax.swing.JTextField();
        jTextFieldBevestigWachtwoord = new javax.swing.JTextField();
        jTextFieldVoornaam = new javax.swing.JTextField();
        jTextFieldNaam = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldBevestigEmail = new javax.swing.JTextField();
        jTextFieldGsm = new javax.swing.JTextField();
        jTextFieldPostcode = new javax.swing.JTextField();
        jTextFieldGemeente = new javax.swing.JTextField();
        jTextFieldStraatnaam = new javax.swing.JTextField();
        jTextFieldHuisnummer = new javax.swing.JTextField();
        jButtonRegistreren = new javax.swing.JButton();
        jButtonAnnuleren = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("gebruikersnaam");

        jLabel2.setText("geef wachtwoord");

        jLabel3.setText("bevestig wachtwoord");

        jLabel4.setText("voornaam");

        jLabel5.setText("naam");

        jLabel6.setText("email");

        jLabel7.setText("bevestig email");

        jLabel8.setText("gsm");

        jLabel9.setText("postcode");

        jLabel10.setText("gemeente");

        jLabel11.setText("straatnaam");

        huisnummer.setText("huisnummer");

        jButtonRegistreren.setText("Registreren");

        jButtonAnnuleren.setText("Annuleren");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButtonAnnuleren)
                        .addGap(68, 68, 68)
                        .addComponent(jButtonRegistreren)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(89, 89, 89)))
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSetWachtwoord)
                            .addComponent(jTextFieldBevestigWachtwoord)
                            .addComponent(jTextFieldVoornaam)
                            .addComponent(jTextFieldNaam)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldBevestigEmail)
                            .addComponent(jTextFieldGsm)
                            .addComponent(jTextFieldPostcode)
                            .addComponent(jTextFieldKiesGebruikersnaam)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(huisnummer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldGemeente)
                            .addComponent(jTextFieldStraatnaam)
                            .addComponent(jTextFieldHuisnummer))))
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldKiesGebruikersnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSetWachtwoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBevestigWachtwoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldBevestigEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldGsm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldGemeente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldStraatnaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(huisnummer)
                    .addComponent(jTextFieldHuisnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistreren)
                    .addComponent(jButtonAnnuleren))
                .addContainerGap(204, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel huisnummer;
    private javax.swing.JButton jButtonAnnuleren;
    private javax.swing.JButton jButtonRegistreren;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldBevestigEmail;
    private javax.swing.JTextField jTextFieldBevestigWachtwoord;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldGemeente;
    private javax.swing.JTextField jTextFieldGsm;
    private javax.swing.JTextField jTextFieldHuisnummer;
    private javax.swing.JTextField jTextFieldKiesGebruikersnaam;
    private javax.swing.JTextField jTextFieldNaam;
    private javax.swing.JTextField jTextFieldPostcode;
    private javax.swing.JTextField jTextFieldSetWachtwoord;
    private javax.swing.JTextField jTextFieldStraatnaam;
    private javax.swing.JTextField jTextFieldVoornaam;
    // End of variables declaration//GEN-END:variables
}
