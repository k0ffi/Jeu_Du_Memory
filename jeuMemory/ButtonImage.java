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
import java.awt.*;
import javax.swing.*;
public class ButtonImage extends JButton {
    // attribut 
    private Image img;
    // constructeur 
    public ButtonImage()
    {
        super();
        this.img=null;
    }
    public ButtonImage( Image img)
    {
        super();
        this.img =img ; 
        
    }
// accesseurs
    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    // surharge de la methode paint de JButton 
    public void paint(Graphics g)
    {
        super.paint(g);
        if(this.img!=null)
        { 
            Image imgB = this.img.getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(imgB));
            repaint();
        }
        
    }
    
    
    
}
