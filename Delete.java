/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import Controleur.Connect;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import Vue.*;
import Controleur.*;

/**
 *
 * @author Elnathan
 */
public class Delete extends JFrame implements ActionListener {
    
    Connect MyConn = new Connect();
    
    String[] nomTable1 = {"Service", "Chambre", "Docteur","Malade","Employe","Soigne","Infirmier","Hospitalisation"};
    
    JRadioButton table0 =new JRadioButton(nomTable1[0]);
    JRadioButton table1 =new JRadioButton(nomTable1[1]);
    JRadioButton table2 =new JRadioButton(nomTable1[2]);
    JRadioButton table3 =new JRadioButton(nomTable1[3]);
    JRadioButton table4 =new JRadioButton(nomTable1[4]);
    JRadioButton table5 =new JRadioButton(nomTable1[5]);
    JRadioButton table6 =new JRadioButton(nomTable1[6]);
    JRadioButton table7 =new JRadioButton(nomTable1[7]);
    
    JButton ok = new JButton("Accepter");
    
    
    JPanel panTable = new JPanel();
    JPanel panCondition = new JPanel();
    
    private JTextField rep = new JTextField(" ");
    
    //Permet et autorise la mise à jour des données 
    Statement state = MyConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
        
       /** Méthode permettant de supprimer une ligne de la table*/
    public void Supprimer(){
        
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setSize(650,600);
        f.setBounds(0,0,650,600);
        f.add(panTable);

        ButtonGroup tbg = new ButtonGroup();
        panTable.setBackground(Color.white);
        panTable.setPreferredSize(new Dimension(320,160));
        panTable.setBorder(BorderFactory.createTitledBorder("Choisissez la table"));


        tbg.add(table0);
        tbg.add(table1);
        tbg.add(table2);
        tbg.add(table3);
        tbg.add(table4);
        tbg.add(table5);
        tbg.add(table6);
        tbg.add(table7);
        
        ok.addActionListener(new accpeterListener());

        table0.setSelected(true);
        panTable.add(table0);
        panTable.add(table1);
        panTable.add(table2);
        panTable.add(table3);
        panTable.add(table4);
        panTable.add(table5);
        panTable.add(table6);
        panTable.add(table7);
        panTable.add(ok);
        panTable.add(panCondition);
        this.setVisible(true);
        
        if (table0.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("code, nom, batiment, directeur");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table1.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("cservie, nb_chambre, surveillant, nb_lits");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table2.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("numero,specialite");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table3.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("numero,nom,prenom,adresse,tel,mutuelle");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table4.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("numero,nom,prenom,adresse,tel");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table5.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("nb_docteur,nb_malade");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table6.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("numero,cservice,rotation,salaire");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
        
        if (table7.isSelected()){
            panCondition.setLayout(null);
            panCondition.add(rep);
            JLabel label = new JLabel ("nb_malade,cservice,nbchambre,lit");
            rep.setBounds(300,300,100,100);
            PreparedStatement prep = this.MyConn.prepareStatement("DELETE FROM" + getTable() + "WHERE" + getRep());
        }
    }
    
    public String getTable(){
        return (table0.isSelected()) ? table0.getText():
                (table1.isSelected()) ? table1.getText():
                (table2.isSelected()) ? table2.getText():
                (table3.isSelected()) ? table3.getText():
                (table4.isSelected()) ? table4.getText():
                (table5.isSelected()) ? table5.getText():
                (table6.isSelected()) ? table6.getText():
                (table7.isSelected()) ? table7.getText():
                table0.getText();
    }
     
     public JTextField getRep(){
         return rep;
     }
     
     public class accpeterListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed
        public void actionPerformed(ActionEvent arg0) {        
        getTable();
        setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
 }

