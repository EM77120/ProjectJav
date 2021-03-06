/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import Controleur.Connexion;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author tlemc
 */
public class rep_malade_serv {
    /** Attributs*/
    final String url = "jdbc:mysql://localhost/";
    final String utilisateur = "root";
    final String motDePasse = "";
    final Connexion con = null;
    
    public void rep_malade_serv() throws SQLException{
        
        try{
            
            String requete = "SELECT  service.nom, COUNT(malade.numero) FROM (malade JOIN hospitalisation ON malade.numero=hospitalisation.no_malade) JOIN service ON service.code=hospitalisation.code_service) GROUP BY service.code";
            JDBCCategoryDataset dataset = new JDBCCategoryDataset((Connection) con);
            dataset.executeQuery(requete);

            JFreeChart chart = ChartFactory.createBarChart("Repartition des malades dans les differents services", "malade", "service", dataset, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            ChartFrame frame = new ChartFrame("", chart);
            frame.setSize(450,675);
            frame.setVisible(true);
            
            /*
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 270));
            frame.setContentPane(chartPanel);
            frame.pack();
            frame.setVisible(true);*/
        }
        
        catch (SQLException e) {
               JOptionPane.showMessageDialog(null,e);
        }
    }
    
}
