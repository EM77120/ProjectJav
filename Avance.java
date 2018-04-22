/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Vick
 */
public class Avance extends JFrame implements ActionListener {

    
    /**Atributs*/
    String conditions = "";
    int s = 0;
    
    Jdbcv2018 jdbc = new Jdbcv2018();
    
    JPanel pan = new JPanel();
    JTextField rep1,rep2,rep3,tab1,tab2;
    JLabel lab1 = new JLabel("Je souhaite connaitre");
    JLabel lab3 = new JLabel("et");
    JLabel lab2 = new JLabel("dans les tables");
    JLabel lab6 = new JLabel("ex: hospitalisation.LIT, malade.PRENOM, malade.NOM, malade.MUTUELLE");
    JLabel lab4 = new JLabel("de la table");
    JLabel lab = new JLabel("Informations générales: ");
    JLabel lab5 = new JLabel("Je souhaite connaitre le");
    JButton v1 = new JButton("Valider");
    JLabel lab7 = new JLabel("de");
    
    
    JRadioButton code2,No_chambre2,surveillant2,nb_lits2;
    JTextField rep11;
    JButton v2 = new JButton("valider");
    JTextField rep22;
    
    
    public Avance(){
        setSize(1200,800);
        setLocationRelativeTo(null);
        pan.setLayout(null);
        Container content = getContentPane();
        rep1 = new JTextField("table1.champ1, table2.champ2, table2.champ3");
        rep2 = new JTextField("table1");
        rep3 = new JTextField("table2");
        rep11 = new JTextField("Salaire");
        rep22 = new JTextField("Infirmier");
        
        infos();
        lab.setBounds(0,80,350,20);
        lab1.setBounds(10,200,150,20);
        lab2.setBounds(570,200,100,20);
        lab3.setBounds(790,200,20,20);
        lab4.setBounds(630,470,150,20);
        lab5.setBounds(10,470,200,20);
        lab7.setBounds(370,470,20,20);
        lab6.setBounds(150,180,420,20);
        rep1.setBounds(160,200,400,20);
        rep2.setBounds(680,200,100,20);
        rep3.setBounds(820,200,100,20);
        rep11.setBounds(400,470,200,20);
        rep22.setBounds(760,470,200,20);
        v1.setBounds(1000,200,100,20);
        
        v1.addActionListener(new v1Listener());
        v2.addActionListener(new v2Listener());
        
        code2 = new JRadioButton("Maximum");
        No_chambre2 = new JRadioButton("Minimum");
        surveillant2 = new JRadioButton("Moyenne");
        nb_lits2 = new JRadioButton("Somme");
        code2.setBounds(230,430,100,20);
        No_chambre2.setBounds(230,450,100,20);
        surveillant2.setBounds(230,470,100,20);
        nb_lits2.setBounds(230,490,100,20);
        v2.setBounds(1000,470,100,20);
        
        pan.add(rep1);
        pan.add(rep2);
        pan.add(rep3);
        pan.add(rep11);
        pan.add(rep22);
        pan.add(lab);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(lab3);
        pan.add(lab4);
        pan.add(lab6);
        pan.add(lab7);
        pan.add(lab5);
        pan.add(v1);
        
        pan.add(code2);
        pan.add(No_chambre2);
        pan.add(surveillant2);
        pan.add(nb_lits2);
        pan.add(v2);
        
        content.add(pan);
        setTitle("Recherches avancées");
        setVisible(true);
    }
    
    /**Action du bouton "v1"*/
    class v1Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            
            String r1 = rep1.getText();
            String r2 = rep2.getText();
            String r3 = rep3.getText();
            
            if(r2.equals("service")){
                if((r3.equals("hospitalisation"))||(r3.equals("chambre"))||(r3.equals("infirmier"))){
                    conditions = "service.code="+r3+".code_service";
                    s+=1;
                }
                if(r3.equals("docteur")){
                    conditions = "service.nom="+r3+".specialite";
                    s+=1;
                }
            }
            
            if(r2.equals("chambre")){
                if(r3.equals("hospitalisation")){
                    conditions = "chambre.no_chambre="+r3+".no_chambre";
                    s+=1;
                }
                if(r3.equals("infirmier")){
                    conditions = "chambre.code_service="+r3+".code_service";
                    s+=1;
                }
            }
            
            if(r2.equals("employe")){
                if((r3.equals("docteur"))||(r3.equals("infirmier"))){
                    conditions = "employe.numero="+r3+".numero";
                    s+=1;
                } 
            }
            
            if(r2.equals("docteur")){
                if((r3.equals("employe"))||(r3.equals("infirmier"))){
                    conditions = "docteur.numero="+r3+".numero";
                    s+=1;
                }
                if(r3.equals("service")){
                    conditions = "docteur.specialite="+r3+".nom";
                    s+=1;
                }
            }
            
            if(r2.equals("infirmier")){
                if((r3.equals("employe"))||(r3.equals("docteur"))){
                    conditions = "infirmier.numero="+r3+".numero";
                    s+=1;
                }
                if((r3.equals("hospitalisation"))||(r3.equals("chambre"))){
                    conditions = "infirmier.code_service="+r3+".code_service";
                    s+=1;
                }
                if(r3.equals("service")){
                    conditions = "infirmier.code_service="+r3+".code";
                    s+=1;
                }
            }
            
            if(r2.equals("malade")){
                if((r3.equals("hospitalisation"))||(r3.equals("soigne"))){
                    conditions = "malade.numero="+r3+".no_malade";
                    s+=1;
                }
                
            }
            
            if(r2.equals("hospitalisation")){
                if(r3.equals("soigne")){
                    conditions = "hospitalisation.no_malade="+r3+".no_malade";
                    s+=1;
                }
                if((r3.equals("infirmier"))||(r3.equals("chambre"))){
                    conditions = "hospitalisation.code_service="+r3+".code_service";
                    s+=1;
                }
                if(r3.equals("service")){
                    conditions = "hospitalisation.code_service="+r3+".code";
                    s+=1;
                }
                if(r3.equals("malade")){
                    conditions = "hospitalisation.no_malade="+r3+".numero";
                    s+=1;
                }
            }
            
            if(r2.equals("soigne")){
                if(r3.equals("hospitalisation")){
                    conditions = "soigne.no_malade="+r3+".no_malade";
                    s+=1;
                }
                if(r3.equals("docteur")){
                    conditions = "soigne.no_docteur="+r3+".numero";
                    s+=1;
                }
                if(r3.equals("malade")){
                    conditions = "soigne.no_malade="+r3+".numero";
                    s+=1;
                }
            }
            
            if(s!=0) jdbc.re1(r1,r2,r3,conditions);
            
            
        }
            
    }
    
    /**Action du bouton "valid1"*/
    class v2Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            int s = 0;
            String table1 = "";
            String r1 = rep11.getText();
            String r2 = rep22.getText();
            if(code2.isSelected()){
                table1 = "MAX";
                s+=1;
            }
            if(No_chambre2.isSelected()){
                table1 = "MIN";
                s+=1;
            }
            if(surveillant2.isSelected()){
                table1 = "AVG";
                s+=1;
            }
            if(nb_lits2.isSelected()){
                table1 = "SUM";
                s+=1;
            }
            
            if(s!=0) jdbc.re2(table1,r1,r2);
        }
            
    }
    
    
    public void infos(){
        JLabel texte2 = new JLabel();
        JLabel texte3 = new JLabel();
        JLabel texte4 = new JLabel();
        JLabel texte5 = new JLabel();
        JLabel texte6 = new JLabel();
        JLabel texte7 = new JLabel();
        JLabel texte8 = new JLabel();
        JLabel texte9 = new JLabel();
        pan.add(texte2);
        pan.add(texte3);
        pan.add(texte4);
        pan.add(texte5);
        pan.add(texte6);
        pan.add(texte7);
        pan.add(texte8);
        pan.add(texte9);
        texte2.setBounds(150,0,350,20);
        texte3.setBounds(150,20,400,20);
        texte4.setBounds(150,40,350,20);
        texte5.setBounds(150,60,350,20);
        texte6.setBounds(150,80,350,20);
        texte7.setBounds(150,100,400,20);
        texte8.setBounds(150,120,420,20);
        texte9.setBounds(150,140,350,20);
        
        for(int i = 0; i < 8; i++)
            {
                
                texte2.setText("SERVICE (CODE, NOM, BATIMENT, DIRECTEUR)");
                texte3.setText("CHAMBRE (NO_CHAMBRE, #CODE_SERVICE, SURVEILLANT, NB_LITS)");
                texte4.setText("EMPLOYE (NUMERO, NOM, PRENOM, TEL, ADRESSE)");
                texte5.setText("DOCTEUR (#NUMERO, SPECIALITE)");
                texte6.setText("INFIRMIER (#NUMERO, #CODE_SERVICE, ROTATION, SALAIRE)");
                texte7.setText("MALADE (NUMERO, NOM, PRENOM, TEL, ADRESSE, MUTUELLE)");
                texte8.setText("HOSPITALISATION (NO_MALADE, #CODE_SERVICE, #NO_CHAMBRE, LIT)");
                texte9.setText("SOIGNE (#NO_DOCTEUR, #NO_MALADE)");
            }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
