/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import javax.swing.*; 

/**
 *
 * @author adam-carter
 */
public class NorthPanel extends JPanel {
    
    private JTextField searchField;
    
    public NorthPanel () {
        setBackground(Color.BLACK);
        searchField = new JTextField();
        searchField.setColumns(10);
        add(searchField);
    }
    
    public JTextField getSearchField () {
        return searchField;
    }
    
}
