/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class VisuJoueursDlg extends javax.swing.JDialog {

    
    
    /**
     * Creates new form VisuJoueursDlg
     */
    
    // attributs 
    private LesJoueurs lj ; // joueurs a afficher 
    // constructeur 
    public VisuJoueursDlg(java.awt.Frame parent, boolean modal, LesJoueurs lesj) {
        super(parent, modal);
        initComponents();
        this.lj = lesj ; 
        // appel de la methodes de creation des boutos 
        //pour les photos 
        initTrombi();
        
    }

    private VisuJoueursDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        // affichage du joueur 

    private void AfficheInfosJoueur(java.awt.event.ActionEvent evt) 
    {  
        JButton jb = new ButtonImage();
        jb = (ButtonImage)evt.getSource() ; 
        
        Edition.setText(lj.getJoueur(Integer.parseInt(jb.getName())).toString());
        
      
    }
    
    
    
    // construction de la trombinoscope des joueurs avec les boutons cliquablent 
private void initTrombi()
{ int nb = this.lj.getNbJoueurs();
 Panneau.setLayout(new GridLayout(1, nb));
 for (int i=0; i< nb; i++)
 {
 ButtonImage jb = new ButtonImage() ;
//Graphics g = new jb.getGraphics() ; 
 Joueur j= lj.getJoueur(i);
 jb.setName(""+i);
 jb.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent evt) {
 AfficheInfosJoueur(evt);
 }
 });
 Panneau.add(jb);
 //jb.paint(g);
 }
 this.pack();
}
    
    // afficage sur les buttons 
    
    
    private void afficheTrombi()
    {
        for( int i =0  ; i< this.lj.getNbJoueurs() ; i++)
        {
            // on recupere le ieme bouton 
            
            JButton jb = (JButton)Panneau.getComponent(i);
            Joueur j = this.lj.getJoueur(i); // recuperer le joueur d'indice i ;
              j.setImgBouton(jb);
        }
        
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Afficher = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choisissez un joueur pour voir ses Caracteristiques");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        Panneau.setLayout(new java.awt.GridLayout(1, 3));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel3.add(Afficher);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.GridLayout());

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane2.setViewportView(Edition);

        jPanel2.add(jScrollPane2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        // TODO add your handling code here:
        afficheTrombi();
    }//GEN-LAST:event_AfficherActionPerformed

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
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuJoueursDlg dialog = new VisuJoueursDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
