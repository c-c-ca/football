package View;

import java.awt.*;
import javax.swing.*; 

public class InitialFrame extends JFrame {
    
    private InitialPanel initialPanel;
    
    public InitialFrame() {
        super("Football Data");
        
        initialPanel = new InitialPanel();
        add(initialPanel);
        setSize(600, 400);
        setVisible(true);
    }
    
    public InitialPanel getInitialPanel () {
        return initialPanel;
    }

    
    public void setInitialPanel (InitialPanel initialPanel) {
        this.initialPanel = initialPanel;
    }
    
}
