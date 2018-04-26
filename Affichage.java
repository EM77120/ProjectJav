/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import com.mysql.jdbc.Statement;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controleur.Jdbcv2018;
import Modèle.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;


/**
 *
 * @author Vick
 */
public class Affichage extends JFrame implements ActionListener {

    
    
    /**Création des menus*/
    private JMenuBar menuB = new JMenuBar();
    private JMenu menu1 = new JMenu("Menu");

    /**Création des items*/
    private JMenuItem item1 = new JMenuItem("Mise à jour des données");
    private JMenuItem item2 = new JMenuItem("Reporting");
    private JMenuItem item3 = new JMenuItem("Recherche d'informations");

   /**Création de panneaux*/
    JPanel pan = new JPanel();
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pan4 = new JPanel();
    JPanel pan6 = new JPanel();

    /**Création container*/
    Container contentPane = getContentPane();

    /**Création des boutons*/
    JButton req = new JButton("Requetes prédéfinies");
    JButton recherche = new JButton("Recherches simples");
    JButton recha = new JButton("Recherches avancées");

    JButton del = new JButton("Supprimer");
    JButton update = new JButton("Modifier");
    JButton insert = new JButton("Insérer");

    JButton valider = new JButton("Valider");
    JButton ok = new JButton("Accepter");

    JButton texte2 = new JButton("SERVICE");
    JButton texte3 = new JButton("CHAMBRE");
    JButton texte4 = new JButton("EMPLOYE");
    JButton texte5 = new JButton("DOCTEUR");
    JButton texte6 = new JButton("INFIRMIER");
    JButton texte7 = new JButton("MALADE");
    JButton texte8 = new JButton("HOSPITALISATION");
    JButton texte9 = new JButton("SOIGNE");
    
    JButton stat1 = new JButton("Repartition docteur specialite");
    JButton stat2 = new JButton("Repartition malade service");
    JButton stat3 = new JButton("Repartition rotation infirmier");

    

    JButton rech_stat = new JButton("Recherche");
    JButton stat_predef = new JButton("Quelques statistique");
    
    ImageIcon icon = new ImageIcon("HOPITAL.jpg");

    /**Création de labels*/
    JLabel text = new JLabel();
    JLabel texte1 = new JLabel();
    JLabel img = new JLabel(icon);

    /**Création de la zone de texet pour l'utilisateur*/
    private JTextField reponse = new JTextField("SERVICE");


    Jdbcv2018 jdbc = new Jdbcv2018();



    public Affichage(){
        /**Affichage général de l'interface*/
        setTitle("Interface graphique");
        setSize(650, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ferme l'interface quand on appuie sur la croix rouge
        pan.setLayout(null);
        pan.add(img);
        img.setBounds(0,0,650,600);
        
        contentPane.add(pan,BorderLayout.CENTER);

        /**Ajout des différents composants du menu*/
        menuB.add(menu1);
        setJMenuBar(menuB);
        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);

        setVisible(true);

        /**Listener*/
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        del.addActionListener(new deleteListener());
        update.addActionListener(new modifierListener());
        insert.addActionListener(new insererListener());
        req.addActionListener(new predefinieListener());
        recherche.addActionListener(new rechercheListener());
        recha.addActionListener(new avanceListener());
        
        valider.addActionListener(new validerListener());
        ok.addActionListener(new accpeterListener());

        texte2.addActionListener(new serviceListener());
        texte3.addActionListener(new chambreListener());
        texte4.addActionListener(new employeListener());
        texte5.addActionListener(new docteurListener());
        texte6.addActionListener(new infirmierListener());
        texte7.addActionListener(new maladeListener());
        texte8.addActionListener(new hospitalisationListener());
        texte9.addActionListener(new soigneListener());

        stat_predef.addActionListener(new stat_predefListener());
        stat1.addActionListener(new rep_spe_docListener());
        stat2.addActionListener(new rep_malade_servListener());
        stat3.addActionListener(new rep_rot_infirmListener());

    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==item1){
            pan.removeAll();
            pan.setSize(650,600);
            pan3.add(del);
            pan3.add(update);
            pan3.add(insert);
            pan.add(pan3);
            pan3.setBounds(0,0,600,50);
            contentPane.add(pan);
            setVisible(true);
        }
        
         if(e.getSource()==item2){
            pan.removeAll();
            pan.setSize(650,600);
            pan4.add(rech_stat);
            pan4.add(stat_predef);
            pan.add(pan4);
            pan4.setBounds(0,0,600,50);
            contentPane.add(pan);
            setVisible(true);
        }

        if(e.getSource()==item3){
            pan.removeAll();
            pan.setSize(650,600);
            pan1.removeAll();
            pan1.add(req);
            pan1.add(recherche);
            pan1.add(recha);
            pan.add(pan1);
            pan1.setBounds(0,0,600,50);
            contentPane.add(pan);
            setVisible(true);
        }

        

    }

    /**Action du bouton "recherches simples" */
    class rechercheListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            infos();

            text.setText("Données présentes");
            text.setBounds(250,200,200,50);
            pan.add(text);
            reponse.setBounds(150,470,200,30);
            valider.setBounds(360,470,100,30);
            pan.add(reponse);
            //pan.add(texte1);
            pan.add(valider);
            setVisible(true);

        }

    }


    /**Action du bouton "requetes prédéfinies" */
    class predefinieListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            affichetable();
            setVisible(true);
        }

    }



    /**Action du bouton "recherches avancées" */
    class avanceListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            Avance av = new Avance();
        }

    }


    /**Action du bouton "Supprimer" */
    public class deleteListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        @Override
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            Delete supp = new Delete();
            //affichetable();
            setVisible(true);
        }
    }

    /**Action du bouton "Modifier" */
    public class modifierListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        @Override
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            affichetable();
            setVisible(true);
        }
    }

    /**Action du bouton "Insérer" */
    public class insererListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        @Override
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            affichetable();
            setVisible(true);
        }
    }

    /**Action du bouton "valider"*/
    class validerListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            String texteUtilisateur = reponse.getText();
            jdbc.recherchesimple(texteUtilisateur);
        }

    }
    
    public class accpeterListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed
        public void actionPerformed(ActionEvent arg0) {        
        getTable();
        setVisible(true);
        }
    }

    /**Action du bouton "service" */
    class serviceListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            service Ser = new service();
        }

    }

    /**Action du bouton "chambre" */
    class chambreListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            chambre ch = new chambre();
        }

    }

    /**Action du bouton "employe" */
    class employeListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            employe emp = new employe();
        }

    }

    /**Action du bouton "docteur" */
    class docteurListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            docteur doc = new docteur();
        }

    }

    /**Action du bouton "infirmier" */
    class infirmierListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            infirmier inf = new infirmier();
        }

    }

    /**Action du bouton "malade" */
    class maladeListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            malade mal = new malade();
        }

    }

    /**Action du bouton "hospitalisation" */
    class hospitalisationListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            hospitalisation hos = new hospitalisation();
        }

    }

    /**Action du bouton "soigne" */
    class soigneListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            soigne soi = new soigne();
        }

    }

     /**Action du bouton "stat_predef" */
    class stat_predefListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            pan.setSize(650,600);
            pan6.add(stat1);
            pan6.add(stat2);
            pan6.add(stat3);
            pan.add(pan6);
            pan6.setBounds(0,0,600,50);
            contentPane.add(pan);
            setVisible(true);
            
        }
    }
    
     class rep_malade_servListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            rep_malade_serv malserv = new rep_malade_serv();
            
        }
    }
    
    class rep_rot_infirmListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            rep_rot_infirm rotinf = new rep_rot_infirm();
        }
    }
    
    class rep_spe_docListener implements ActionListener{
        //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent e) {
            pan.removeAll();
            rep_spe_doc spedoc = new rep_spe_doc();
            
        }
    }
    
    
    

    /**Méthode qui demande à l'utilisateur quelle table il souhaite afficher*/
    public void affichetable(){

        JLabel text1 = new JLabel();
        pan.add(text1);
        text1.setBounds(100,50,350,200);
        text1.setText("Dans quelle table souhaitez-vous travailler ?");


        pan.add(texte2);
        pan.add(texte3);
        pan.add(texte4);
        pan.add(texte5);
        pan.add(texte6);
        pan.add(texte7);
        pan.add(texte8);
        pan.add(texte9);
        texte2.setBounds(100,200,150,20);
        texte3.setBounds(100,220,150,20);
        texte4.setBounds(100,240,150,20);
        texte5.setBounds(100,260,150,20);
        texte6.setBounds(100,280,150,20);
        texte7.setBounds(100,300,150,20);
        texte8.setBounds(100,320,150,20);
        texte9.setBounds(100,340,150,20);


        JLabel text2 = new JLabel();
        JLabel text3 = new JLabel();
        JLabel text4 = new JLabel();
        JLabel text5 = new JLabel();
        JLabel text6 = new JLabel();
        JLabel text7 = new JLabel();
        JLabel text8 = new JLabel();
        JLabel text9 = new JLabel();
        pan.add(text2);
        pan.add(text3);
        pan.add(text4);
        pan.add(text5);
        pan.add(text6);
        pan.add(text7);
        pan.add(text8);
        pan.add(text9);
        text2.setBounds(270,110,350,200);
        text3.setBounds(270,130,400,200);
        text4.setBounds(270,150,350,200);
        text5.setBounds(270,170,350,200);
        text6.setBounds(270,190,350,200);
        text7.setBounds(270,210,400,200);
        text8.setBounds(270,230,420,200);
        text9.setBounds(270,250,350,200);

        for(int i = 0; i < 8; i++)
            {

                text2.setText("(CODE, NOM, BATIMENT, DIRECTEUR)");
                text3.setText("(NO_CHAMBRE, #CODE_SERVICE, SURVEILLANT, NB_LITS)");
                text4.setText("(NUMERO, NOM, PRENOM, TEL, ADRESSE)");
                text5.setText("(#NUMERO, SPECIALITE)");
                text6.setText("(#NUMERO, #CODE_SERVICE, ROTATION, SALAIRE)");
                text7.setText("(NUMERO, NOM, PRENOM, TEL, ADRESSE, MUTUELLE)");
                text8.setText("(NO_MALADE, #CODE_SERVICE, #NO_CHAMBRE, LIT)");
                text9.setText("(#NO_DOCTEUR, #NO_MALADE)");
            }

    }

    /**Méthode qui informe l'utilisateur sur les tables*/
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
        texte2.setBounds(150,200,350,200);
        texte3.setBounds(150,220,400,200);
        texte4.setBounds(150,240,350,200);
        texte5.setBounds(150,260,350,200);
        texte6.setBounds(150,280,350,200);
        texte7.setBounds(150,300,400,200);
        texte8.setBounds(150,320,420,200);
        texte9.setBounds(150,340,350,200);

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


   
    
    
    /**Getter qui récupère les valeurs rentrées par l'utilisateur */
    public JTextField getreponse(){
	return reponse;
    } 


}








