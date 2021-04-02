package View;

import java.awt.*;
import javax.swing.*; 

public class InitialPanel extends JPanel {
    
    private CenterPanel cp;
    
    public InitialPanel() {
        super();
        cp = new CenterPanel();
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(cp, "Center");
    }
    
    public CenterPanel getCp() {
        return cp;
    }
    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }
    
}
