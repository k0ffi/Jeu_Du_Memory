/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

/**
 *
 * @author lenovo
 */
public class Bataille extends Action {
    
    // attributs
    
    private Joueur adversaire ; 
    
    // constructeur  
    
    public Bataille ( Joueur jc , Joueur adv)
    {
        super(jc, "Bataille(Fight)");
        this.adversaire =adv ; 
    }
    
    // getteur
    
    public Joueur getAdversaire()
    {
        return this.adversaire ; 
    }
    
    
    // methodes permettant l'execution de l'action 
    public int execute()
    {
        int res = -1; // resultats initialiser a -1
        Personnage c1 ; // premier perso du joueur courant 
        Personnage c2 ; // ... adversaire
        LesPersonnages p1 = this.getJoueurCourant().getPaquet(); // les personnage du joueur courant 
        LesPersonnages p2 = this.adversaire.getPaquet() ; //... de l'adversaire 
        if(p1.getTaille()>0 && p2.getTaille()>0)
        {
            // recuperation des cartes 
            c1=p1.getPerso(0) ; // ... du premier personnage 
            c2 = p2.getPerso(0) ; 
            
            // supprimer les cartes 
            
            p1.retirePerso(c1);
            p1.retirePerso(c2);
            // Comparaisons des vateurs 
            
            
            if(c1.getValeur()==c2.getValeur())
            {
                res = 0 ; 
                // rajouter les cartes a chacuns des joueurs
                p1.ajoutePerso(c1);
                p2.ajoutePerso(c2);
                
            }else if( c1.getValeur()>c2.getValeur())
            {
                res=1 ; 
                // le joueur courant prend les deux cartes 
                p1.ajoutePerso(c1);
                p1.ajoutePerso(c2);
            }else
            {
                res=2;
                 // l'adversaire prend les deux cartes 
                p2.ajoutePerso(c1);
                p2.ajoutePerso(c2);
            }
            if(p1.getTaille()==0  || p2.getTaille()==0 )
            {
                String s = "Bataille# "+this.getJoueurCourant().getPseudo()+" Contre "+ this.adversaire.getPseudo();
                if(res==1)
                {
                    s+= " Gagnée \n";
                }
                if(res==2)
                {
                    s+= " Perdu \n" ; 
                }
                
                this.setDeroulement(s); // deroulement de tout la Bataille 
            }
            
            
        }
        return res ; 
    }
    
}
