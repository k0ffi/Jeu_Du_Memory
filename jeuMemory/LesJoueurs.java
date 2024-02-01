/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package jeuMemory;
import java.util.* ;
/**
 *
 * @author kd974491
 */
public class LesJoueurs {
    
     private ArrayList<Joueur> lstJ; // liste des joueurs
     
     // constructeur par defaut 
     
     public LesJoueurs()
     {
         this.lstJ = new ArrayList<Joueur>();
     }
     
     
     
     // restitue un joueur
     public Joueur getJoueur(int i)
     {
          if (i>=0 && i<this.lstJ.size())
             return this.lstJ.get(i);
        else return null;
     }
    
     
     //restitue l indice du joueur passer en parrametre 
     
     public int getIndiceJoueur(Joueur j) 
     {
         return lstJ.indexOf(j);
     }
     
   
   
     
     // restitue le nombre de jour 
     
     
     public int getNbJoueurs()
     {
         return lstJ.size() ;
     }
     
     
     
     // l’ajout du joueur donné en paramètre
     public void ajouteJoueur(Joueur j)
     {
           lstJ.add(j);
     }
     
     // ajoute une liste de joueurs 
      public void ajouteJoueurs(LesJoueurs lj)
    {for( int i=0 ; i < lj.getNbJoueurs(); i++)
    {
        this.lstJ.add(lj.getJoueur(i));
    }
    }
     
     //retourne  le  joueur  dont  le  pseudo  est  donné  en paramètre, ou null s’il n’existe pas.
     
     public  Joueur  rechJoueur(String  p){
         
         Joueur j = new Joueur() ;
         for(int i= 0 ; i < lstJ.size(); i++ )
         {
             if(this.getJoueur(i).getPseudo().equals(p))
             {
                 j = getJoueur(i); 
             }
         }
         return j ;
     }
     
    // qui  supprime  le  joueur  dont  le  pseudo  est  égal  à  celui du joueur passé en paramètre
     
     
     public  void  supprimeJoueur(Joueur  j)
     { int i=0; 
        boolean trouve = false;
        while(i<lstJ.size() && !trouve){
          if (getJoueur(i).getPseudo().equals(j.getPseudo())){
              this.lstJ.remove(i);  
              trouve = true;
          }
          else i++;
        }      
    
     }
     // supprime tous les joueurs
      public  void  supprimeJoueurs()
      {
          for ( int i =  0 ;i<this.lstJ.size() ; i++)
                  {
                      this.lstJ.remove(this.lstJ.get(i));
                  }
      }
     // toString   
     public String toString()
     {
         String res= ""; 
         for(int i = 0 ; i < this.lstJ.size() ;  i++)
             res+= "Joueur : N°"+(i+1)+"   "+this.lstJ.get(i).toString()+" \n";
         return res; 
     }
     
     
     // // // retourne la liste des gagnants  
     public LesJoueurs getGagnants(){ 
         
         int max=getJoueur(0).getScore(); // le max est lescore du premier joueur 
         for(int i=1; i<getNbJoueurs();i++)
           if (getJoueur(i).getScore()>max)
                  max=this.getJoueur(i).getScore(); // trie par ordre croissant 
               
          LesJoueurs lst=new LesJoueurs(); // Creaztion d'une nouvelle listre
          
          for(int i=0; i<getNbJoueurs();i++)
                    if (getJoueur(i).getScore()==max)
                        lst.ajouteJoueur(getJoueur(i));// ajoute a la nouvelle liste les joueurs qui on le score maximal
          
         return lst;
     }
     
     
     
    
}
