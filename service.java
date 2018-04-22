/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Vick
 */
public class service extends JFrame implements ActionListener {

    
    /**Attributs*/
    Jdbcv2018 jdbc = new Jdbcv2018();
    JPanel pan = new JPanel();
    Container content = getContentPane();
    JLabel lab1 = new JLabel("Je souhaite connaitre");
    JLabel lab2 = new JLabel("où");
    JLabel lab3 = new JLabel("Je souhaite connaitre");
    JLabel lab4 = new JLabel("rangé par");
    JLabel lab5 = new JLabel("Je souhaite connaitre");
    
    JRadioButton code,nom,batiment,directeur,code1,nom1,batiment1,directeur1,ASC,DESC,code2,nom2,batiment2,directeur2;
    JTextField rep1 = new JTextField("Batiment = 'A'");
    JButton valid1 = new JButton("valider");
    JTextField rep2 = new JTextField("table1 AND table2");
    JButton valid2 = new JButton("valider");
    JButton valid3 = new JButton("valider");
    
    public service(){
        
        /**Listeners*/
        valid1.addActionListener(new valid1Listener());
        valid2.addActionListener(new valid2Listener());
        valid3.addActionListener(new valid3Listener());
        
        setSize(850, 500);
        setLocationRelativeTo(null);
        pan.setLayout(null);
        setTitle("Service");
        lab1.setBounds(0,30,150,20);
        lab2.setBounds(280,30,20,20);
        lab3.setBounds(0,150,150,20);
        lab4.setBounds(230,150,80,20);
        lab5.setBounds(0,270,150,20);
        
        
        code = new JRadioButton("code");
        nom = new JRadioButton("nom");
        batiment = new JRadioButton("batiment");
        directeur = new JRadioButton("directeur");
        code.setBounds(130,0,150,20);
        nom.setBounds(130,20,150,20);
        batiment.setBounds(130,40,150,20);
        directeur.setBounds(130,60,150,20);
        rep1.setBounds(310,30,300,20);
        valid1.setBounds(620,30,100,20);
        
        code1 = new JRadioButton("code");
        nom1 = new JRadioButton("nom");
        batiment1 = new JRadioButton("batiment");
        directeur1 = new JRadioButton("directeur");
        ASC = new JRadioButton("ASC");
        DESC = new JRadioButton("DESC");
        code1.setBounds(130,110,100,20);
        nom1.setBounds(130,130,100,20);
        batiment1.setBounds(130,150,100,20);
        directeur1.setBounds(130,170,100,20);
        rep2.setBounds(310,150,300,20);
        valid2.setBounds(620,150,100,20);
        ASC.setBounds(730,140,50,20);
        DESC.setBounds(730,160,70,20);
        
        code2 = new JRadioButton("code");
        nom2 = new JRadioButton("nom");
        batiment2 = new JRadioButton("batiment");
        directeur2 = new JRadioButton("directeur");
        code2.setBounds(130,230,150,20);
        nom2.setBounds(130,250,150,20);
        batiment2.setBounds(130,270,150,20);
        directeur2.setBounds(130,290,150,20);
        valid3.setBounds(620,270,100,20);
        
        
        
        /**Methode qui s'informent de la validation des radioButtons*/
        
        
        
        
        pan.add(code);
        pan.add(nom);
        pan.add(batiment);
        pan.add(directeur);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(lab3);
        pan.add(lab4);
        pan.add(lab5);
        pan.add(rep1);
        pan.add(valid1);
        
        pan.add(code1);
        pan.add(nom1);
        pan.add(batiment1);
        pan.add(directeur1);
        pan.add(rep2);
        pan.add(valid2);
        pan.add(ASC);
        pan.add(DESC);
        content.add(pan);
        
        pan.add(code2);
        pan.add(nom2);
        pan.add(batiment2);
        pan.add(directeur2);
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
            String texteUtilisateur = rep1.getText();
            if(code.isSelected()){
                table1 = "code";
                s+=1;
            }
            if(nom.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(batiment.isSelected()){
                table3 = "batiment";
                if(s!=0){
                    table3 = ",batiment";
                }
                s+=1;
            }
            if(directeur.isSelected()){
                table4 = "directeur";
                if(s!=0){
                    table4 = ",directeur";
                }
                s+=1;
            }
            
            jdbc.reqt1(table1,table2,table3,table4,"service",texteUtilisateur);
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
            String texteUtilisateur = rep2.getText();
            if(code1.isSelected()){
                table1 = "code";
                s+=1;
            }
            if(nom1.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(batiment1.isSelected()){
                table3 = "batiment";
                if(s!=0){
                    table3 = ",batiment";
                }
                s+=1;
            }
            if(directeur1.isSelected()){
                table4 = "directeur";
                if(s!=0){
                    table4 = ",directeur";
                }
                s+=1;
            }
            
            if(ASC.isSelected()){
                table5 = " ASC";s+=1;
            }
            
            if(DESC.isSelected()){
                table5 = " DESC";
            }
            
            jdbc.reqt2(table1,table2,table3,table4,"service",texteUtilisateur,table5);
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
            if(code2.isSelected()){
                table1 = "code";
                s+=1;
            }
            if(nom2.isSelected()){
                table2 = "nom";
                if(s!=0){
                    table2 = ",nom";
                }
                s+=1;
            }
            if(batiment2.isSelected()){
                table3 = "batiment";
                if(s!=0){
                    table3 = ",batiment";
                }
                s+=1;
            }
            if(directeur2.isSelected()){
                table4 = "directeur";
                if(s!=0){
                    table4 = ",directeur";
                }
                s+=1;
            }
            
            jdbc.reqt3(table1,table2,table3,table4,"service");
        }
            
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
