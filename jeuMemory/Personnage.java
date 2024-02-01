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
public class Personnage {
    
    

 private String famille; // famille du personnage 
 private String nom;  // nom du personnage 
 private int valeur;//  sa valeur dans le jeu 
 private ImageIcon photo;//  sa photo 
 
 // accesseurs

    public String getFamille() {
        return this.famille;
    }

    public String getNom() {
        return this.nom;
    }

    public int getValeur() {
        return this.valeur;
    }

    public ImageIcon getPhoto() {
        return photo;
    }
    
    
    
    
    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
     public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    //  toString  

   

    
    
    public String toString()
    {
        String res = this.nom ;
        res += " est  de la \n Famille :"+this.famille+" \n Valeur: "+this.valeur ;
        return res ; 
    }
 


 // constructeur par defaut 
 public Personnage( ) 
 {this.famille = "anonyme";
 this.nom = "anonyme";
 this.valeur= 0;
 this.photo = new ImageIcon(getClass().getResource("/memory/img/anonyme.png"));
 
 
 }
 // constructeur Standard
 
  public Personnage(String f , String n , int v ) 
 {this.famille = f;
 this.nom = n ;
 this.valeur= v;
 this.photo = new ImageIcon(getClass().getResource("/memory/img/"+n+".jpg"));
 
 
 }
 //       met l'image redimentionner sur le bouton 
 public void setImgBouton(JButton jb) {
 Image img = this.photo.getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
 jb.setIcon(new ImageIcon(img));
 }
}
