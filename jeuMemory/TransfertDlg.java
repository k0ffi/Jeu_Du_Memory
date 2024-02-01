/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class TransfertDlg extends javax.swing.JDialog {

 private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
 private int indj; //indice joueur courant
 // private Transfert tc; // cette classe sera étudiée ultérieurement – laisser l’attribut en commentaire
 private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
 private int indjs; //indice du joueur sélectionné dans la liste déroulante
 private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné
private Transfert tc ; 

    private TransfertDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
 
 // getteurs
    public boolean isOk() {
        return ok;
    }

    public Transfert getTransfert() {
        return tc;
    }
// constructeur
    public TransfertDlg(java.awt.Frame parent, boolean modal,LesJoueurs lj , int indj) {
        super(parent, modal);
        initComponents();
        
        
        this.lj = lj;
 this.indj = indj ;
 // this.tc=null;
 this.ok=false;
 this.fs=null;
 this.tc =null;
 
 this.indjs = 0;
 Message.setText("Le joueur "+this.lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète !");
 initCombo(); // méthode pour remplir la liste déroulante
 Infos.setText("Personnages de "+this.lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
    }

  // construction de la combo box par les pseudo des joueurs
    
      private void initCombo() {
       
        for(int i=0 ;i< this.lj.getNbJoueurs();i++) 
        {
             ComboJoueurs.addItem(this.lj.getJoueur(i).getPseudo());
        }
    }
      // Constructeur du panneau de gauche 
      
       private void initPanneau() {
       
            PanneauG.removeAll(); // suppretion de tous les composant du tableau
            this.repaint(); //reaffichage de la boite de dialogue 
            this.indjs = ComboJoueurs.getSelectedIndex() ; 
            LesPersonnages lcs = this.lj.getJoueur(this.indjs).getPaquet(); // recupere le paquet du joueur selectionné
            int t = lcs.getTaille();
              int n = 1+(t-1)/4;
            PanneauG.setLayout(new java.awt.GridLayout(4, n));
            for (int i= 0 ; i<  t ; i++ ) 
                
            {
               

                ButtonImage bt = new ButtonImage() ;
               //Graphics g = new jb.getGraphics() ; 
                Joueur j= lj.getJoueur(i);
                bt.setName(lcs.getPerso(i).getFamille());
                // ajout d'un ecouteur au bouton 
                bt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                  boutonActionPerformed(evt); 
                }
                });
                
               PanneauG.add(bt); // ajout du bouton  au panneau
                        
                     }
            this.pack();
            
 }

      // affichage du  des personnage dans les panneauG 
    private void affichePanneau() {
      
        for( int i =0  ; i< this.lj.getJoueur(this.indjs).getPaquet().getTaille()  ; i++)
        {
            // on recupere le ieme bouton 
            
            JButton jb = (JButton)PanneauG.getComponent(i);
          //  Joueur j = this.lj.getJoueur(i); // recuperer le joueur d'indice i ;
             Personnage p = this.lj.getJoueur(this.indjs).getPaquet().getPerso(i);
             p.setImgBouton(jb);
        }  
        
    }
    
    public void creePanneau(JPanel jp , LesPersonnages lc)
    {
         
              int n = 1+(lc.getTaille()-1)/4;
            jp.setLayout(new java.awt.GridLayout(4, n));
        
          for (int i= 0 ; i<lc.getTaille(); i++ ) 
                
            {
               

                ButtonImage bt = new ButtonImage() ; // crée le bouton 
                bt.setName(lc.getPerso(i).getFamille()); // on le nomme 
               
               jp.add(bt) ; // ont l'ajoute au panneau 
                }
            
            }
    
    
    
    
    
    public void dessinePanneau(JPanel jp , LesPersonnages lc )
    {
       for( int i =0  ; i<lc.getTaille()  ; i++)
        {
            // on recupere le ieme bouton 
            
            JButton jb = (JButton)jp.getComponent(i);// on recupere le bouton 
            Personnage p = lc.getPerso(i); // on recupere le personnage 
             p.setImgBouton(jb); // on l'affiche l'icone du personnage
        }  
       
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        PanneauG.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauG);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.GridLayout(4, 1));
        jPanel4.add(Message);
        jPanel4.add(jLabel2);
        jPanel4.add(jLabel3);

        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel4.add(ComboJoueurs);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel6.add(jScrollPane1);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel7.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel7.add(Fermer);

        jPanel5.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel5);

        getContentPane().add(jPanel1);

        PanneauD.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   // clic sur un personnage du joueurs selectionner 
    private void boutonActionPerformed(ActionEvent evt)
 {
 LesPersonnages lp = lj.getJoueur(indjs).getPaquet();// paquet du joueur selectioner
 int t = lp.getTaille();
 JButton bt=(JButton) evt.getSource();
 this.fs = bt.getName(); // on recupere le nom de la famille du personnage selectionner par le nom du bouton    
 for(int i = 0; i < t; i++) {
 JButton b = (JButton)(PanneauG.getComponent(i));
 if (b.getName().equals(fs))
 b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0))); // metre une bordure
 else
 b.setBorder(null);
 }
 LesPersonnages lps = lp.getPersosFamille(fs);// on recupere tous les personnage de la meme famille 
 Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps);
 }

    
    
    
    
    
    
    
    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
       
        
       
 this.indjs = ComboJoueurs.getSelectedIndex(); // recuperation de l'indice du joueurs selectionner
 if (indjs != -1)// Si un joueur est selectionner !
 
 {
 if (this.indjs == this.indj) // si c'est le meme que le joueur courant 
 {
 Infos.setText("Sélectionnez un joueur différent du joueur courant !");
 PanneauG.removeAll();// On vide le panneau de Gauche 
 PanneauG.repaint();// on redessone le panneau 
 }
 else 
 {
 Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());
 initPanneau();
 affichePanneau();
 }
 }
 
    }//GEN-LAST:event_ComboJoueursActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
       setVisible(false); // fermeture de la fenetre
        dispose() ;       
        
    }//GEN-LAST:event_FermerActionPerformed

    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
         /*     
        if(this.indjs!=-1 && this.fs!=null)
        {
            
            //creation d'une instance pour l'attribut tc
            this.tc = new Transfert(this.lj.getJoueur(this.indj), this.lj.getJoueur(this.indjs) , this.fs)  ; 
            int res = this.tc.execute() ; // appele de la methode execute 
           if( res>0)// le transfert s'est bien passer 
           {
               // recuperation  des carte transferés
               LesPersonnages carteTransf= this.tc.getCartesTransferees();
               creePanneau(PanneauD,carteTransf) ; // creation du panneau
               dessinePanneau(PanneauD,carteTransf) ; // affichage des personnages 
               LesPersonnages pjs = this.lj.getJoueur(this.indjs).getPaquet() ; 
               creePanneau(PanneauG ,pjs) ;
               dessinePanneau(PanneauG,pjs) ;
               
               this.ok = true ; 
               Transfert.setEnabled(false);
               
           }
        }
         else
            Infos.setText( " Vous devez selectionné un joueur qui a au moins une carte ");
       */
         
         if( this.indjs!=-1 && this.fs!=null ) 
         {
             this.tc= new Transfert(this.lj.getJoueur(indj), this.lj.getJoueur(indjs) , this.fs )  ; 
        int res = this.tc.execute() ; 
        if(res>0)
        {
            LesPersonnages persoTransf = this.tc.getCartesTransferees() ; 
            creePanneau(PanneauD , persoTransf); 
            dessinePanneau(PanneauD , persoTransf); 
LesPersonnages pjs = this.lj.getJoueur(indjs).getPaquet() ; 
creePanneau(PanneauG , persoTransf) ; 
dessinePanneau(PanneauG ,  persoTransf) ; 

this.ok = true ; 
Transfert.setEnabled(false) ; 
        }
         
         }else 
              Infos.setText( " Vous devez selectionné un joueur qui a au moins une carte ");
        
    }//GEN-LAST:event_TransfertActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   

  
}
