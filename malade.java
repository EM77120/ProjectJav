/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;


import Controleur.Jdbcv2018;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Vick
 */
public class malade extends JFrame implements ActionListener {

    
    /**Attributs*/
    Jdbcv2018 jdbc = new Jdbcv2018();
    JPanel pan = new JPanel();
    Container content = getContentPane();
    JLabel lab1 = new JLabel("Je souhaite connaitre");
    JLabel lab2 = new JLabel("où");
    JLabel lab3 = new JLabel("Je souhaite connaitre");
    JLabel lab4 = new JLabel("rangé par");
    JLabel lab5 = new JLabel("Je souhaite connaitre");
    
    
    JRadioButton numero,nom,prenom,adresse,tel,mutuelle,numero1,nom1,prenom1,adresse1,tel1,mutuelle1,ASC,DESC,numero2,nom2,prenom2,adresse2,tel2,mutuelle2;
    JTextField rep1 = new JTextField("Mutuelle = 'MAAF'");
    JButton valid1 = new JButton("valider");
    JTextField rep2 = new JTextField("Numero");
    JButton valid2 = new JButton("valider");
    JButton valid3 = new JButton("valider");
    
    public malade(){
        
        /**Listeners*/
        valid1.addActionListener(new valid1Listener());
        valid2.addActionListener(new valid2Listener());
        valid3.addActionListener(new valid3Listener());
        
        setSize(850, 500);
        setLocationRelativeTo(null);
        pan.setLayout(null);
        setTitle("Malade");
        lab1.setBounds(0,30,150,20);
        lab2.setBounds(280,30,20,20); 
        lab3.setBounds(0,180,150,20);
        lab4.setBounds(230,180,80,20);
        lab5.setBounds(0,320,150,20);
        
        
        numero = new JRadioButton("numero");
        nom = new JRadioButton("nom");
        prenom = new JRadioButton("prenom");
        adresse = new JRadioButton("adresse");
        tel = new JRadioButton("tel");
        mutuelle = new JRadioButton("mutuelle");
        numero.setBounds(130,0,150,20);
        nom.setBounds(130,20,150,20);
        prenom.setBounds(130,40,150,20);
        adresse.setBounds(130,60,150,20);
        tel.setBounds(130,80,150,20);
        mutuelle.setBounds(130,100,150,20);
        rep1.setBounds(310,30,300,20);
        valid1.setBounds(620,30,100,20);
        
        numero1 = new JRadioButton("numero");
        nom1 = new JRadioButton("nom");
        prenom1 = new JRadioButton("prenom");
        adresse1 = new JRadioButton("adresse");
        tel1 = new JRadioButton("tel");
        mutuelle1 = new JRadioButton("mutuelle");
        ASC = new JRadioButton("ASC");
        DESC = new JRadioButton("DESC");
        numero1.setBounds(130,140,100,20);
        nom1.setBounds(130,160,100,20);
        prenom1.setBounds(130,180,100,20);
        adresse1.setBounds(130,200,100,20);
        tel1.setBounds(130,220,100,20);
        mutuelle1.setBounds(130,240,100,20);
        rep2.setBounds(310,180,300,20);
        valid2.setBounds(620,180,100,20);
        ASC.setBounds(730,170,50,20);
        DESC.setBounds(730,190,70,20);
        
        numero2 = new JRadioButton("numero");
        nom2 = new JRadioButton("nom");
        prenom2 = new JRadioButton("prenom");
        adresse2 = new JRadioButton("adresse");
        tel2 = new JRadioButton("tel");
        mutuelle2 = new JRadioButton("mutuelle");
        numero2.setBounds(130,280,150,20);
        nom2.setBounds(130,300,150,20);
        prenom2.setBounds(130,320,150,20);
        adresse2.setBounds(130,340,150,20);
        tel2.setBounds(130,360,150,20);
        mutuelle2.setBounds(130,380,150,20);
        valid3.setBounds(620,320,100,20);
        
        
        
        /**Methode qui s'informent de la validation des radioButtons*/
        
        
        
        
        pan.add(numero);
        pan.add(nom);
        pan.add(prenom);
        pan.add(adresse);
        pan.add(tel);
        pan.add(mutuelle);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(lab3);
        pan.add(lab4);
        pan.add(lab5);
        pan.add(rep1);
        pan.add(valid1);
        
        pan.add(numero1);
        pan.add(nom1);
        pan.add(prenom1);
        pan.add(adresse1);
        pan.add(tel1);
        pan.add(mutuelle1);
        pan.add(rep2);
        pan.add(valid2);
        pan.add(ASC);
        pan.add(DESC);
        content.add(pan);
        
        pan.add(numero2);
        pan.add(nom2);
        pan.add(prenom2);
        pan.add(adresse2);
        pan.add(tel2);
        pan.add(mutuelle2);
        pan.add(valid3);
        
        setVisible(true);
    
    }
    
    /**Action du bouton "valid1"*/
    class valid1Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            int s = 0;
            String table1 = "";
            String table2 = "";
            String table3 = "";
            String table4 = "";
            String table5 = "";
            String table6 = "";
            String texteUtilisateur = rep1.getText();
            if(numero.isSelected()){
                table1 = "numero";
                s+=1;
            }
            if(nom.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(prenom.isSelected()){
                table3 = "prenom";
                if(s!=0){
                    table3 = ",prenom";
                }
                s+=1;
            }
            if(adresse.isSelected()){
                table4 = "adresse";
                if(s!=0){
                    table4 = ",adresse";
                }
                s+=1;
            }
            
            if(tel.isSelected()){
                table5 = "tel";
                if(s!=0){
                    table5 = ",tel";
                }
                s+=1;
            }
            if(mutuelle.isSelected()){
                table6 = "mutuelle";
                if(s!=0){
                    table6 = ",mutuelle";
                }
                s+=1;
            }
            
            jdbc.reqt111(table1,table2,table3,table4,table5,table6,"malade",texteUtilisateur);
        }
            
    }
    
    /**Action du bouton "valid2"*/
    class valid2Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            int s = 0;
            String table1 = "";
            String table2 = "";
            String table3 = "";
            String table4 = "";
            String table5 = "";
            String table6 = "";
            String table7 = "";
            String texteUtilisateur = rep2.getText();
            if(numero1.isSelected()){
                table1 = "numero";
                s+=1;
            }
            if(nom1.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(prenom1.isSelected()){
                table3 = "prenom";
                if(s!=0){
                    table3 = ",prenom";
                }
                s+=1;
            }
            if(adresse1.isSelected()){
                table4 = "adresse";
                if(s!=0){
                    table4 = ",adresse";
                }
                s+=1;
            }
            
            if(tel1.isSelected()){
                table6 = "tel";
                if(s!=0){
                    table6 = ",tel";
                }
                s+=1;
            }
            if(mutuelle1.isSelected()){
                table7 = "mutuelle";
                if(s!=0){
                    table7 = ",mutuelle";
                }
                s+=1;
            }
            
            if(ASC.isSelected()){
                table5 = " ASC";s+=1;
            }
            
            if(DESC.isSelected()){
                table5 = " DESC";
            }
            
            jdbc.reqt222(table1,table2,table3,table4,table6,table7,"malade",texteUtilisateur,table5);
        }
            
    }
    
    /**Action du bouton "valid3"*/
    class valid3Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            int s = 0;
            String table1 = "";
            String table2 = "";
            String table3 = "";
            String table4 = "";
            String table5 = "";
            String table6 = "";
            if(numero2.isSelected()){
                table1 = "numero";
                s+=1;
            }
            if(nom2.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(prenom2.isSelected()){
                table3 = "prenom";
                if(s!=0){
                    table3 = ",prenom";
                }
                s+=1;
            }
            if(adresse2.isSelected()){
                table4 = "adresse";
                if(s!=0){
                    table4 = ",adresse";
                }
                s+=1;
            }
            if(tel2.isSelected()){
                table5 = "tel";
                if(s!=0){
                    table5 = ",tel";
                }
                s+=1;
            }
            if(mutuelle2.isSelected()){
                table6 = "mutuelle";
                if(s!=0){
                    table6 = ",mutuelle";
                }
                s+=1;
            }
            
            jdbc.reqt333(table1,table2,table3,table4,table5,table6,"malade");
        }
            
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


