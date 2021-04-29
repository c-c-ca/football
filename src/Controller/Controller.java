package Controller;

import Model.*;
import View.View;

import java.awt.*;
import javax.swing.*; 
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Controller {
    
    Model model;
    View view;
    
    public Controller(View v, Model m)
    {
        model = m;
        view = v;

        view.CenterInitialSetup(
                model.getFpData().getLinesBeingDisplayed(), 
                model.getFpData().getHeaders().size());
        
        updateView();
        
        this.addListeners();
    }
    
    private void addListeners () {
        addMouseWheelListener();
        addHeaderListeners();
        addSearchListener();
    }
    
    private void addMouseWheelListener () {
        view.getInitialframe().getInitialPanel().getCp().addMouseWheelListener(
                new MouseWheelListener()
                {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent e)
                    {   
                        model.getFpData().setFirstLineToDisplay(
                                model.getFpData().getFirstLineToDisplay() + 
                                (e.getUnitsToScroll() < 0 ? -1 : 1));
                        
                        updateView();
                    }
                    
                }
        );
    }
    
    private void addHeaderListeners () {
        ArrayList<JLabel> headers = view.getInitialframe()
                .getInitialPanel().getCp().getHeaders();
        
        for (JLabel header: headers) {
            header.addMouseListener(
                    new MouseAdapter() {
                        @Override
                        public void mouseClicked (MouseEvent e) {
                            for (JLabel header: headers) {
                                header.setBackground(Color.LIGHT_GRAY);
                                header.setForeground(Color.BLACK);
                            }
                            JLabel header = (JLabel) e.getSource();
                            header.setBackground(Color.DARK_GRAY);
                            header.setForeground(Color.WHITE);
                            
                            FootballPlayerData fpData = model.getFpData();
                            int idx = headers.indexOf(header);
                            fpData.setSortField(idx);
                            fpData.setSearchByField(idx);
                            fpData.sort();
                            updateView();
                        }
                    }
            );
        }
    }
    
    private void addSearchListener () {
        view.getInitialframe()
                .getInitialPanel()
                .getNp()
                .getSearchField()
                .addActionListener(new ActionListener () {
                    public void actionPerformed (ActionEvent e) {
                        JTextField searchField = (JTextField) e.getSource();
                        searchField.setBackground(
                                searchResultFound(searchField) ?
                                        Color.WHITE :
                                        Color.RED
                        );
                    }
                });
    }
    
    private boolean searchResultFound (JTextField searchField) {
        return model.getFpData().search(searchField.getText());
    }
    
    private void updateView () {
        view.CenterUpdate(
                model.getFpData().getLines(
                        model.getFpData().getFirstLineToDisplay(),
                        model.getFpData().getLastLineToDisplay()), 
                model.getFpData().getHeaders());
    }
}
