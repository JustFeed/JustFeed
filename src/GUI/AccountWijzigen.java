/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author dcuvelie
 */
public class AccountWijzigen extends javax.swing.JPanel {

    /**
     * Creates new form AccountWijzigen
     */
    public AccountWijzigen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonWachtwoorWijzigen = new javax.swing.JButton();
        jButtonAdresWijzigen = new javax.swing.JButton();
        GsmWijzigen = new javax.swing.JButton();
        jButtonMailWijzigen = new javax.swing.JButton();
        jButtonAccountVerwijderen = new javax.swing.JButton();
        jButtonNaarLobby = new javax.swing.JButton();

        jButtonWachtwoorWijzigen.setText("Wachtwoord Wijzigen");

        jButtonAdresWijzigen.setText("Adres wijzigen");

        GsmWijzigen.setText("Gsm nummer wijzigen");

        jButtonMailWijzigen.setText("E-mail wijzigen");

        jButtonAccountVerwijderen.setText("Account Verwijderen");

        jButtonNaarLobby.setText("Terug naar Lobby");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonNaarLobby)
                    .addComponent(jButtonAccountVerwijderen)
                    .addComponent(jButtonMailWijzigen)
                    .addComponent(GsmWijzigen)
                    .addComponent(jButtonAdresWijzigen)
                    .addComponent(jButtonWachtwoorWijzigen))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonWachtwoorWijzigen)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdresWijzigen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GsmWijzigen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMailWijzigen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAccountVerwijderen)
                .addGap(18, 18, 18)
                .addComponent(jButtonNaarLobby)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GsmWijzigen;
    private javax.swing.JButton jButtonAccountVerwijderen;
    private javax.swing.JButton jButtonAdresWijzigen;
    private javax.swing.JButton jButtonMailWijzigen;
    private javax.swing.JButton jButtonNaarLobby;
    private javax.swing.JButton jButtonWachtwoorWijzigen;
    // End of variables declaration//GEN-END:variables
}
