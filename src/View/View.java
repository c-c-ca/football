package View;

import java.util.ArrayList;

public class View
{
    
    private InitialFrame initialFrame;

    public View()
    {

    }

    public void basicDisplay(String s)
    {
        System.out.println(s);
    }

    public void basicDisplay(ArrayList<String> a)
    {
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public void linesDisplay(ArrayList<ArrayList<String>> lines)
    {
        for (ArrayList<String> line: lines) {
            basicDisplay(line);
        }
    }
    
    public void CenterInitialSetup(int rows, int cols) {
        initialFrame = new InitialFrame();
        initialFrame.getInitialPanel().getCp().setGridDimensions(rows,cols);
    }
    
    public void CenterUpdate (ArrayList<ArrayList<String>> table, ArrayList<String> headers) {
        initialFrame.getInitialPanel().getCp().row(headers);
        initialFrame.getInitialPanel().getCp().table(table);
        
        initialFrame.validate();
        initialFrame.repaint();
    }
    
    public InitialFrame getInitialframe () {
        return initialFrame;
    }

}
