/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuMemory;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author kd974491
 */

// atributs
public class Joueur {
    private String pseudo ; // nom du joueur
    private String famille ; // famille du joueur 
    private LesPersonnages paquet; // personnage que possede le joueur
    private ImageIcon photo ;  // photo
    
    
    // accesseurs
    public String getPseudo() {
        return this.pseudo;
    }

    public String getFamille() {
        return this.famille;
    }

    public LesPersonnages getPaquet() {
        return this.paquet;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setPaquet(LesPersonnages paquet) {
        this.paquet = paquet;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    
   //--------------- constructeur  standard 

    public Joueur(String pseudo, String famille) {
        this.pseudo = pseudo;
        this.famille = famille;
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/memory/img/joueurDefaut.png"));
    }
    
    
    //----------------constructeur par defaut 
    public Joueur() {
        this.pseudo = "anonyme";
        this.famille ="anonyme";
        this.paquet = new LesPersonnages();
        this.photo = new ImageIcon(getClass().getResource("/memory/img/joueurDefaut.png"));
    }
    
    
    // toString 

    
    public String toString()
    {
        
         String res = ""+this.pseudo+"\n Famille  préféré :  "+this.famille+"  \n en possesion des Personnages : \n "+ paquet.toString()+" Score : "+this.getScore();
        return res ; 
    }
    
    
   //  retourne le score du joueur
    public int getScore()
    {
        int s=0 ; 
        for(int i=0 ; i<this.paquet.getTaille() ; i++)
        {
            s+= this.paquet.getPerso(i).getValeur(); 
        }
        return s ; 
    }   
    
    
    
    // ajoute un personnage dans le paquet du joueur
    public void ajoutePersoPaquet(Personnage p) {
 this.paquet.ajoutePerso(p);
 }
    
    // construction du paquet pour  le test 
public void initPaquetTest(){
 ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
 ajoutePersoPaquet(new Personnage("communs", "commando", 20));
 ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
 }


//       met l'image redimentionner sur le bouton 
 public void setImgBouton(JButton jb) {
 Image img = this.photo.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
 jb.setIcon(new ImageIcon(img));
 }
}
