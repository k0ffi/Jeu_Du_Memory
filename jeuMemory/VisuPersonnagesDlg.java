/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class VisuPersonnagesDlg extends javax.swing.JDialog {

    // attributs 
     private Joueur j ; // 
     
     // constructeur 
    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal, Joueur j) {
        super(parent, modal);
        initComponents(); // construction de l'interface 
        this.j=  j  ; // innitialisation de l'attribut j 
         initPanneau(); // construction du panneau
         Score.setText("Score: "+this.j.getScore()); // affichge du Score
         NomJoueur.setText("Carte du Joueur:"+this.j.getPseudo());// affichage du pseudo du joueur
         
         
    }

    private VisuPersonnagesDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    // Metodes pour afficher les cartes dans la trombi
         private void AfficheCartes()
         {
               for( int i =0  ; i< this.j.getPaquet().getTaille() ; i++)
        {
            // on recupere le ieme bouton 
            
            JButton jb = (JButton)PanneauCartes.getComponent(i);
            Personnage p = this.j.getPaquet().getPerso(i); // recuperer le personnage d'indice i ;
             p.setImgBouton(jb);
        }
         }
         
         // construction du panneau 
    
      private void initPanneau() {
          PanneauCartes.setLayout(new GridLayout(2,this.j.getPaquet().getTaille()));
       for (int i=0 ; i< this.j.getPaquet().getTaille() ; i++)
       {
            JButton jb = new JButton() ;
           jb.setName(""+i);
            PanneauCartes.add(jb);
       }
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NomJoueur = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PanneauCartes = new javax.swing.JPanel();
        Score = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(NomJoueur, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        PanneauCartes.setMinimumSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout PanneauCartesLayout = new javax.swing.GroupLayout(PanneauCartes);
        PanneauCartes.setLayout(PanneauCartesLayout);
        PanneauCartesLayout.setHorizontalGroup(
            PanneauCartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanneauCartesLayout.setVerticalGroup(
            PanneauCartesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(PanneauCartes, java.awt.BorderLayout.CENTER);
        jPanel1.add(Score, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Annuler.setText("Afficher");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        getContentPane().add(Annuler, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here
        AfficheCartes(); // affichage des cartes 
        
        
    }//GEN-LAST:event_AnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuPersonnagesDlg dialog = new VisuPersonnagesDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setSize(400,200);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JLabel NomJoueur;
    private javax.swing.JPanel PanneauCartes;
    private javax.swing.JLabel Score;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

  
}
