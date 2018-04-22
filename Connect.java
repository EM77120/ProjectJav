/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vick
 */
public class Connect extends JFrame implements ActionListener {
    
    /**Attributs*/
    JPanel pan = new JPanel();
    Container content = getContentPane();
    JLabel lab1,lab2,lab3;
    JTextField rep1,rep2;
    JButton valid1,valid2;
    Connexion con;
    
    
    public Connect(){
        setTitle("Connexion");
        setSize(1100,80);
        setLocationRelativeTo(null);
        pan.setLayout(new GridLayout());
        
        lab1 = new JLabel();
        lab2 = new JLabel();
        lab3 = new JLabel();
        rep1 = new JTextField();
        rep2 = new JTextField();
        valid1 = new JButton();
        
        
        lab1.setText("Rentrez votre identifiant :");
        lab2.setText("Rentrez votre mot de passe :");
        lab3.setText("Bruuuh ! Try Again my friend ;)");
        valid1.setText("Valider");
        
        pan.add(lab1);
        pan.add(rep1);
        pan.add(lab2);
        pan.add(rep2);
        pan.add(valid1);
        
        valid1.addActionListener(new valid1Listener());
        
        content.add(pan);
        setVisible(true);
              
    }
    
    /**Action du bouton "valid1"*/
    class valid1Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            int s=1;
            String r1 = rep1.getText();
            String r2 = rep2.getText();
            try {
                con = new Connexion("hopital",r1,r2);
                
            } catch (SQLException ex) {
                //Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
                pan.add(lab3);
                setVisible(true);
                s=0;
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                s=0;
            }
            if(s==1){
                Affichage aff=new Affichage();
            }
        }
            
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
