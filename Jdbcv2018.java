/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Vick
 */
public class Jdbcv2018 {

    /**
     * @param args the command line arguments
     */
    /** Attributs*/
   
    private static Connexion con = null;
    private static Fenetre fen;
    public static int choix;
    
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**Connection*/
        Connect co = new Connect();
        //con = new Connexion("hopital","root","506532");
        
    }
    
    
    
    /**
     * Inspiré du code de Monsieur Segado dans sa classe Fenetre
     * Afficher les lignes de la table sélectionnée
     */
    public static void afficherLignes(String nomTable) {
        
        try {
            ArrayList<String> liste;
            // recuperer la liste de la table sélectionnée
            String requeteSelectionnee = "select * from " + nomTable + ";";
            liste = con.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            
            String[] tab = new String[liste.size()];
            for(int i = 0; i < liste.size(); i++)
            {
                tab[i] = liste.get(i);
                //System.out.println(liste.get(i));
                System.out.println(tab[i]);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    
    public static void recherchesimple(String nomTable) {
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "select * from " + nomTable + ";";
            fen = new Fenetre();
            fen.run();
            liste = con.remplirChampsTable(nomTable);
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void reqt1(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable1, String nomTable6) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + " FROM " + nomTable1 + " WHERE " + nomTable6 + ";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
     
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();

        }
    }
    
     public static void reqt11(String nomTable2, String nomTable3, String nomTable4, String nomTable5,String nomTable7, String nomTable1, String nomTable6) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable7 + " FROM " + nomTable1 + " WHERE " + nomTable6 + ";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
     
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
     
     public static void reqt111(String nomTable2, String nomTable3, String nomTable4, String nomTable5,String nomTable7, String nomTable8, String nomTable1, String nomTable6) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable7 + nomTable8 + " FROM " + nomTable1 + " WHERE " + nomTable6 + ";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
     
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();

        }
    }
    
    
    public static void reqt2(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable1, String nomTable6, String nomTable7) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + " FROM " + nomTable1 + " ORDER BY " + nomTable6 + nomTable7 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void reqt22(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable8, String nomTable1, String nomTable6, String nomTable7) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable8 + " FROM " + nomTable1 + " ORDER BY " + nomTable6 + nomTable7 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void reqt222(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable8, String nomTable9, String nomTable1, String nomTable6, String nomTable7) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable8 + nomTable9 + " FROM " + nomTable1 + " ORDER BY " + nomTable6 + nomTable7 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void reqt3(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable1) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + " FROM " + nomTable1 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void reqt33(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable6, String nomTable1) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable6 + " FROM " + nomTable1 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void reqt333(String nomTable2, String nomTable3, String nomTable4, String nomTable5, String nomTable6, String nomTable7, String nomTable1) {
        
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "SELECT " + nomTable2 + nomTable3 + nomTable4 + nomTable5 + nomTable6 + nomTable7 + " FROM " + nomTable1 +";";
            
            liste = con.remplirChampsTable(nomTable1);
            fen = new Fenetre();
            fen.run();
            fen.gettextArea().append(liste.get(0) + "\n");
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void re1(String nomTable1,String nomTable2,String nomTable3, String condition) {
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "select " + nomTable1 + " FROM " + nomTable2 + " INNER JOIN " + nomTable3 + " ON " + condition + ";";
            fen = new Fenetre();
            fen.run();
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void re2(String nomTable1,String nomTable2,String nomTable3) {
        try {
            ArrayList<String> liste;
            String requeteSelectionnee = "select " + nomTable1 + "(" + nomTable2 + ") FROM " + nomTable3 + ";";
            fen = new Fenetre();
            fen.run();
            liste = con.remplirChampsRequete(requeteSelectionnee);
            for(int i = 0; i < liste.size(); i++)
            {
                fen.gettextArea().append(liste.get(i) + "\n");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}