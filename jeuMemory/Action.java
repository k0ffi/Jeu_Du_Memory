/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
 abstract public class Action {
     // attributs
     
    protected  Joueur j  ; //
   protected String descriptif ;
   protected String deroulement  ; 
   
   
   // accesseur

    public void setJoueurCourant(Joueur j) {
        this.j = j;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }

    public Joueur getJoueurCourant() {
        return this.j;
    }

    public String getDescriptif() {
        return this.descriptif;
    }

    public String getDeroulement() {
        return this.deroulement;
    }
    
    
    // constructeur 
    
    public Action (Joueur j , String desc)
    {
        setJoueurCourant(j) ;
        setDescriptif(desc) ; 
    }
    
    abstract public int execute() ; // classe abtraite ( a implémenter dans les classes filles ) 
    
    
    //  toString  ( a completer )
    
    
    public String toString() 
    { String s ="";
       s+= "Action effectuée par "+this.j.getPseudo()+"\n" ; 
       s+= "Descriptif: "+this.descriptif + "\n" ; 
       s+= "Deroulement: "+this.deroulement+"n" ; 
        return s;
    }
    
   
    
    
   
   
   
   
    
}
