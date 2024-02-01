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
    public class PlateauJeu {
 private int tab [ ][ ];
 private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
 private int nblig; // nombre de ligne du  plateau de jeu 
 private int nbcol; // nombre de colone du plateau de jeu 

 // constructeur standard 
 public PlateauJeu(int n)
 { this. nbp=n;
 this.nblig=(int)(Math.sqrt(nbp*2)) ;
 this.nbcol=(this.nbp*2)/this.nblig;
 this.tab=new int [this.nblig][this.nbcol];
 initPlateauJeu();
 }
// costructeur par defaut
 public PlateauJeu() { this(4); }
 // getteurs 
 public int getNblig() { return this.nblig; }
 public int getNbcol() { return this.nbcol; }
 public int getNbp() { return this.nbp; }
 public int getCase(int l, int c) { return tab[l][c]; }
 public int getNbc() { return this.nblig*this.nbcol/2; }

 
 // construction du plateau de jeu
 public void initPlateauJeu()
 { int k=0;
 for(int i=0; i<this.nblig; i++)
 for(int j=0; j<this.nbcol; j++)
 tab[i][j]=(k++)%this.nbp;
 melange();
 }

 
 //  elle est apeller quand on a retourner deux cartes identiques
 public void invalide(int l1, int c1, int l2, int c2)
 {
 tab[l1][c1]=-1;
 tab[l2][c2]=-1;
 nbp--;
 }
 
 
 // methode melange des cattes 
 
 public void melange()
 {
     for(int i =1 ; i<=1000 ; i++ )
     {
         int l1 = (int)(Math.random()*this.nblig); 
         int c1 = (int)(Math.random()*this.nbcol);
         int l2 = (int)(Math.random()*this.nblig);
         int c2 = (int)(Math.random()*this.nbcol);
         int temp = this.tab[l1][c1];
         this.tab[l1][c1]=tab[l2][c2];
         tab[l2][c2] = temp ;
     }
 }
 
 // verifie si un element du tableau est valide ou pas 
 public boolean estValide(int l , int c )
 {
     return this.tab[l][c]!=-1 ; 
 }
 
 // verifie si le jeu est vide ou pas 
 
 public boolean JeuVide()
 {
     return this.nbp==0 ; 
 }
 
 //  vide le plateau de jeu 
  
 public void termineJeu()
 {
     for(int i = 0 ; i<this.nblig ;i++)
     {
         for( int  j= 0 ; j< this.nbcol ; j++)
         {
             invalide(i,j,i,j);
         }
     }
     this.nbp=0; 
 }
 
 
    }
