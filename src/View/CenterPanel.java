package View;

import java.awt.*;
import javax.swing.*; 
import java.util.ArrayList;

public class CenterPanel extends JPanel {
    
    private ArrayList<JLabel> headers;
    private ArrayList<ArrayList<JButton>> table;
    
    public CenterPanel() {
        super();
        
        headers = new ArrayList<>();
        table = new ArrayList<>();
        
        setVisible(true);
    }
    
    public void row (ArrayList<String> playerAttributeNames) {
        for (int i = 0; i < playerAttributeNames.size(); i++) {
            headers.get(i).setText(playerAttributeNames.get(i));
        }
        validate();
        repaint();
    }
    
    public ArrayList<JLabel> getHeaders () {
        return headers;
    }
    
    public void table (ArrayList<ArrayList<String>> lines) {
        for (int i = 0; i < table.size(); i++) {
            ArrayList<JButton> row = table.get(i);
            ArrayList<String> line = lines.get(i);
            for (int j = 0; j < row.size(); j++) {
                row.get(j).setText(line.get(j));
            }    
        }
        
        validate();
        repaint();
    }
    
    public void setGridDimensions(int rows, int cols) {
        setLayout(new GridLayout(rows + 1, cols)); // add 1 for header - may change later
        
        for (int i = 0; i < cols; i++) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.LIGHT_GRAY);
            label.setForeground(Color.BLACK);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Courier", Font.ITALIC, 12));
            add(label);
            headers.add(label);
        }
        
        for (int i = 0; i < rows; i++) {
            ArrayList<JButton> row = new ArrayList<JButton>();
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton();
                add(button);
                row.add(button);
            }
            table.add(row);
        }
        
        validate();
    }
}
