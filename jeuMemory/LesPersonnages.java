/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

/**
 *
 * @author kd974491
 */

    
    
    
    
    

import java.util.ArrayList;

public class LesPersonnages {
    
    private ArrayList<Personnage> persos; // liste des personnages
  
    // getteur 
    public ArrayList<Personnage> getPersos() {
        return persos;
    }
    
    // constructeur par defaut 
    public LesPersonnages() {
      this.persos = new ArrayList<Personnage>();
     }
     // restitue la taille de la liste  
     public int getTaille() { 
         return this.persos.size(); 
     }
     // restitue la somme des scores de tous les personnage
    public int getScore(){   
        int sc = 0;
        for(int i=0; i<getTaille(); i++)
           sc+=getPerso(i).getValeur();
        return sc;
    }
    // elle retourne la reference (address) du ieme Personnage 
    public Personnage getPerso(int i){
        if (i>=0 && i<this.persos.size())
             return this.persos.get(i);
        else return null;
    }
    
    // retourne une liste de personnage de meme famille 
    
    public LesPersonnages getPersosFamille(String f)
    {   LesPersonnages lp = new LesPersonnages();
        for(int i=0; i<getTaille(); i++)
            if(getPerso(i).getFamille().equals(f))
                lp.ajoutePerso(getPerso(i));
        return lp;
    }
    
     // restitue  la liste de tous les familles de la liste de personnages
   
    public ArrayList<String> getFamilles()
    { ArrayList<String> lst = new ArrayList<String>();
        for (int j=0; j<this.persos.size(); j++)
        { Personnage p = this.persos.get(j);
            boolean trouve = false;
            for (int i=0; i< lst.size(); i++)
                if (lst.get(i).equals(p.getFamille()))
                    trouve = true;
            if (!trouve) lst.add(p.getFamille());    
        }
        return lst;
    }
    
    
    // Ajouter des personnages
    
    public void ajoutePerso (Personnage p) 
    {
        persos.add(p);
    }
    
    // ajouter une liste de personnage 
    public void ajoutePersos(LesPersonnages lp)
    {for( int i=0 ; i < lp.getTaille(); i++)
    {
        this.persos.add(lp.getPerso(i));
    }
        
    }
    
    
    // retire le personnage passé en parametre  de toute la  liste (courante)
    public void retirePerso(Personnage p)
    { 
        int i=0; 
        boolean trouve = false;
        while(i<getTaille() && !trouve){
          if (getPerso(i).getNom().equals(p.getNom())){
              this.persos.remove(i);  
              trouve = true;
          }
          else i++;
        }      
    
    }
    
    // restitue une nouvelle liste (sous liste ) de la liste courante
   public LesPersonnages retirePersos(int n)
    { LesPersonnages lcr = new LesPersonnages();
        for (int i=0; i<=n; i++)
        {
            lcr.ajoutePerso(getPerso(0));
            this.persos.remove(0);  
        }
        return lcr;
    } 
  
    
   
   
   //  restitue un nouvelle liste contenant les elements de meme famille ( renter en parametre ) 
    public LesPersonnages retirePersosFamille(String f)
    { 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)) {
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }
     
    // Efface toute la liste 
    public void retireCartes()
    { 
           persos.clear();
    }
    
	@Override
    public String toString() {
        String s = "";
        for(int i=0; i<getTaille(); i++)
            s+="["+(i+1)+"]"+"\n- "+getPerso(i).toString();
       return s;
    }
	// constructeur avec parametre (niveau) pour selection de personnage 
    public LesPersonnages(int nc) {
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }
}
    

