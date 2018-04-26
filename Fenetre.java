/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controleur.Connexion;
import Controleur.Jdbcv2018;

/**
 *
 * @author Vick
 */
public class Fenetre extends JPanel implements ActionListener{
    Jdbcv2018 jdbcf = new Jdbcv2018();
    private JTextField textField;
    private static JTextArea textArea;
    private final static String newline = "\n";
    private static Connexion conn = null;
    
    /** Creéation containeur*/
    //Container conn = getContentPane();
    
    /**Création JPanel*/
    JPanel panel = new JPanel();
    
    /**Création du JLabel*/
    private JLabel lab = new JLabel();
    
    public Fenetre(){
        super(new GridBagLayout());
        
         
        textField = new JTextField(40);
        textField.addActionListener(this);
 
        textArea = new JTextArea(50, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
 
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.1;
        c.weighty = 0.1;
        add(scrollPane, c);
 
        c.fill = GridBagConstraints.HORIZONTAL;
        //add(textField, c);
        
        
        //jdbcf.afficherLignes(table);
        panel.add(lab);
        //conn.add(panel);
        setVisible(true);
    }
    
    
    
    
    /**getter du Label*/
    public JLabel getlab(){
        return lab;
    }
    
    public JTextArea gettextArea(){
        return textArea;
    }
    
    public JTextField gettextField(){
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String text = textField.getText();
        //textArea.append(text + newline);
        //textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        
    }
    
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Résultat de votre recherche");
        frame.setSize(50,50);
        frame.setLocation(500,10);
        
        //Ajout dans la fenetre
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void run() {
    	javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    
}
