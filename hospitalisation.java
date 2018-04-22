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
public class hospitalisation extends JFrame implements ActionListener {

    
    /**Attributs*/
    Jdbcv2018 jdbc = new Jdbcv2018();
    JPanel pan = new JPanel();
    Container content = getContentPane();
    JLabel lab1 = new JLabel("Je souhaite connaitre");
    JLabel lab2 = new JLabel("où");
    JLabel lab3 = new JLabel("Je souhaite connaitre");
    JLabel lab4 = new JLabel("rangé par");
    JLabel lab5 = new JLabel("Je souhaite connaitre");
    
    //(NO_MALADE, #CODE_SERVICE, #NO_CHAMBRE, LIT
    JRadioButton code,nom,no_chambre,lit,code1,nom1,no_chambre1,lit1,ASC,DESC,code2,nom2,no_chambre2,lit2;
    JTextField rep1 = new JTextField("Lit = '1'");
    JButton valid1 = new JButton("valider");
    JTextField rep2 = new JTextField("table1 AND table2");
    JButton valid2 = new JButton("valider");
    JButton valid3 = new JButton("valider");
    
    public hospitalisation(){
        
        /**Listeners*/
        valid1.addActionListener(new valid1Listener());
        valid2.addActionListener(new valid2Listener());
        valid3.addActionListener(new valid3Listener());
        
        setSize(850, 500);
        setLocationRelativeTo(null);
        pan.setLayout(null);
        setTitle("Hospitalisation");
        lab1.setBounds(0,30,150,20);
        lab2.setBounds(280,30,20,20);
        lab3.setBounds(0,150,150,20);
        lab4.setBounds(230,150,80,20);
        lab5.setBounds(0,270,150,20);
        
        
        code = new JRadioButton("code_service");
        nom = new JRadioButton("no_malade");
        no_chambre = new JRadioButton("no_chambre");
        lit = new JRadioButton("lit");
        code.setBounds(130,0,150,20);
        nom.setBounds(130,20,150,20);
        no_chambre.setBounds(130,40,150,20);
        lit.setBounds(130,60,150,20);
        rep1.setBounds(310,30,300,20);
        valid1.setBounds(620,30,100,20);
        
        code1 = new JRadioButton("code_service");
        nom1 = new JRadioButton("no_malade");
        no_chambre1 = new JRadioButton("no_chambre");
        lit1 = new JRadioButton("lit");
        ASC = new JRadioButton("ASC");
        DESC = new JRadioButton("DESC");
        code1.setBounds(130,110,150,20);
        nom1.setBounds(130,130,100,20);
        no_chambre1.setBounds(130,150,100,20);
        lit1.setBounds(130,170,100,20);
        rep2.setBounds(310,150,300,20);
        valid2.setBounds(620,150,100,20);
        ASC.setBounds(730,140,50,20);
        DESC.setBounds(730,160,70,20);
        
        code2 = new JRadioButton("code_service");
        nom2 = new JRadioButton("no_malade");
        no_chambre2 = new JRadioButton("no_chambre");
        lit2 = new JRadioButton("lit");
        code2.setBounds(130,230,150,20);
        nom2.setBounds(130,250,150,20);
        no_chambre2.setBounds(130,270,150,20);
        lit2.setBounds(130,290,150,20);
        valid3.setBounds(620,270,100,20);
        
        
        
        /**Methode qui s'informent de la validation des radioButtons*/
        
        
        
        
        pan.add(code);
        pan.add(nom);
        pan.add(no_chambre);
        pan.add(lit);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(lab3);
        pan.add(lab4);
        pan.add(lab5);
        pan.add(rep1);
        pan.add(valid1);
        
        pan.add(code1);
        pan.add(nom1);
        pan.add(no_chambre1);
        pan.add(lit1);
        pan.add(rep2);
        pan.add(valid2);
        pan.add(ASC);
        pan.add(DESC);
        content.add(pan);
        
        pan.add(code2);
        pan.add(nom2);
        pan.add(no_chambre2);
        pan.add(lit2);
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
                table1 = "code_service";
                s+=1;
            }
            if(nom.isSelected()){
                table2 = "no_malade";
                if(s!=0){
                    table2 = ",no_malade";
                }
                s+=1;
            }
            if(no_chambre.isSelected()){
                table3 = "no_chambre";
                if(s!=0){
                    table3 = ",no_chambre";
                }
                s+=1;
            }
            if(lit.isSelected()){
                table4 = "lit";
                if(s!=0){
                    table4 = ",lit";
                }
                s+=1;
            }
            
            jdbc.reqt1(table1,table2,table3,table4,"hospitalisation",texteUtilisateur);
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
                table1 = "code_service";
                s+=1;
            }
            if(nom1.isSelected()){
                table2 = "no_malade";
                if(s!=0){
                    table2 = ",no_malade";
                }
                s+=1;
            }
            if(no_chambre1.isSelected()){
                table3 = "no_chambre";
                if(s!=0){
                    table3 = ",no_chambre";
                }
                s+=1;
            }
            if(lit1.isSelected()){
                table4 = "lit";
                if(s!=0){
                    table4 = ",lit";
                }
                s+=1;
            }
            
            if(ASC.isSelected()){
                table5 = " ASC";s+=1;
            }
            
            if(DESC.isSelected()){
                table5 = " DESC";
            }
            
            jdbc.reqt2(table1,table2,table3,table4,"hospitalisation",texteUtilisateur,table5);
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
                table1 = "code_service";
                s+=1;
            }
            if(nom2.isSelected()){
                table2 = "no_malade";
                if(s!=0){
                    table2 = ",no_malade";
                }
                s+=1;
            }
            if(no_chambre2.isSelected()){
                table3 = "no_chambre";
                if(s!=0){
                    table3 = ",no_chambre";
                }
                s+=1;
            }
            if(lit2.isSelected()){
                table4 = "lit";
                if(s!=0){
                    table4 = ",lit";
                }
                s+=1;
            }
            
            jdbc.reqt3(table1,table2,table3,table4,"hospitalisation");
        }
            
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


