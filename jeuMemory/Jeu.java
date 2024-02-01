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
public class Jeu {
    
    // attributs 
    
    private LesPersonnages lesPers; 
    private  PlateauJeu monP ; 
    private LesJoueurs lesJ ; 
    private int indC ; // indice du joueur courant 
    private Action act  ;
    
    
    //constructeur 
    public Jeu(LesPersonnages lp, LesJoueurs lj , int nbc)
    {
        this.lesPers  =lp;
        this.lesJ = lj ; 
        this.indC = 0 ; 
        this.monP =  new PlateauJeu(nbc) ;
        this.act = null ;         
    }
    // accesseurs 

    public LesPersonnages getLesPers() {
        return this.lesPers;
    }

    public PlateauJeu getPlateau() {
        return this.monP;
    }

    public LesJoueurs getLesJ() {
        return this.lesJ;
    }

    public int getIndC() {
        return this.indC;
    }

    public Action getAct() {
        return this.act;
    }
    
    
    public Joueur getJoueurCourant()
    {
        return this.lesJ.getJoueur(this.indC) ; 
    }
   
    
    public int getIndSuivant(int ic)// retourne l'indice du joueur suivant avec l'indice du joueur courant en parametre 
    {
        return (ic+1)%this.lesJ.getNbJoueurs() ; // quand on est au dernier joueur on reviens au premier 
    }
    public void setJoueurCourant(int n )  // indice 
    {
       this.indC = n ; 
    }
    
    public boolean finJeu()
    {
        return this.monP.JeuVide() ;
    } 
    
    
    // methodes
    /*
    public   int TraiterTour(Joueur j   , int indP ) 
    {
        int bonus =- 1  ; 
        
        // recuperation du personnge gagné 
        Personnage p = this.lesPers.getPerso(indP) ;
        // ajout du personnage dans le paquet du joueur
        
        j.getPaquet().ajoutePerso(p);
        
        // recuperation de la famille du personnage 
          String f  =  p.getFamille();  
          
          
          // recuperation du nombre de personnage de cette fammille dans le paquet du joueur 
          
          int npj = j.getPaquet().getPersosFamille(f).getTaille();
          // recuperation du nombe de personnage de cette famille dans  tous les personnage cree  
          int npl = this.lesPers.getPersosFamille(f).getTaille() ; 
        
    }
*/
    }
