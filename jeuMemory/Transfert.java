/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

/**
 *
 * @author lenovo
 *///


public class Transfert extends Action  {
    
    
   private Joueur cible ; // Joueur cible 
   
   private String fp ; // famille selectionner
    private  LesPersonnages cartesTransferees ; // les carte a transferer   
   
   // accesseurs

    public Joueur getCible() {
        return this.cible;
    }

    public String getFp() {
        return this.fp;
    }
    
       public LesPersonnages getCartesTransferees() {
        return this.cartesTransferees;
        
    }
    
    
    
   // constructeur 
    public Transfert(Joueur jc  ,Joueur c ,  String f)
    { super(jc,"Transfert de cartes") ; 
       this.cible  = c ; 
       this.fp = f ; 
       this.cartesTransferees = new LesPersonnages() ; 
    }

 
    
    
    // methodes execute
    public int execute() 
    {  //initialisation de res 
        int res = 0 ;        
        if(this.fp!=null)
        {
            // retire les personnage de la famille fp du paquet u joueur cible
            this.cible.getPaquet().retirePersosFamille(this.fp) ; 
            this.cartesTransferees.ajoutePersos(this.cible.getPaquet().getPersosFamille(this.fp)); // reuperation des personnages enlever 
            // ajout des personnage retirer dans le paquet du joueurs courant
            this.j.getPaquet().ajoutePersos(this.cartesTransferees);
            //initialise deroulement
            this.deroulement = "\n Les Personnages   ["+this.cartesTransferees.toString()+"]\n "+" du Joueur "
                    + this.cible.getPseudo()+"\n sont transférées a "+this.j.getPseudo();
              res = this.cartesTransferees.getTaille() ; // le nombre de carte transferer
                    
        }
        
        return res ; 
    }
}
