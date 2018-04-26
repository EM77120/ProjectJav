/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import Controleur.Connexion;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author tlemc
 */
public class rep_spe_doc {
        
    /** Attributs*/
    final String url = "jdbc:mysql://localhost/";
    final String utilisateur = "root";
    final String motDePasse = "";
    final Connexion con = null;
    

    public void rep_spe_doc() throws SQLException{
        
        
        try{
            
            String requete = "SELECT  specialite COUNT(numero) FROM docteur GROUP BY specialite";

            JDBCPieDataset dataset = new JDBCPieDataset((Connection) con);

            dataset.executeQuery(requete);
    /*
            JFreeChart chart = ChartFactory.createPieChart("stat", liste_valeure, true, true, true);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            ApplicationFrame f = new ApplicationFrame("Chart");
            f.setContentPane(chartPanel);
            f.pack();
            f.setVisible(true);
    */

            JFreeChart chart = ChartFactory.createPieChart("stat", dataset, true, true, false);
            ChartFrame frame = new ChartFrame("stat", chart);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            frame.setContentPane(chartPanel);
            frame.pack();
            frame.setVisible(true);
        }
        
        catch (SQLException e) {
               JOptionPane.showMessageDialog(null,e);
        }
    }
}

