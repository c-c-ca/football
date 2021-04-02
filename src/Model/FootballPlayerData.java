package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FootballPlayerData extends FootballPlayer implements TableData, Displayable {
    
    private final static int DEFAULT_TABLE_SIZE = 10;

    private ArrayList<TableMember> players;
    private int firstLineToDisplay;
    private int linesBeingDisplayed;
    private int lineToHighlight;


    public FootballPlayerData()
    {
        players = new ArrayList<>();
        firstLineToDisplay = 0;
        linesBeingDisplayed = DEFAULT_TABLE_SIZE;
        lineToHighlight = -1;
        loadTable();
    }
    
    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }
    
    @Override
    public int getLineToHighlight() {
        return lineToHighlight;
    }
    
    @Override
    public int getLastLineToDisplay() {
      return (firstLineToDisplay + linesBeingDisplayed - 1);
    }
    
    @Override
    public int getLinesBeingDisplayed() {
      return linesBeingDisplayed;
    }
  
    @Override
    public void setFirstLineToDisplay(int firstLine) {
        if (firstLine < 0) {
            firstLine = 0;
        } else if (firstLine > players.size() - linesBeingDisplayed) {
            firstLine = players.size() - linesBeingDisplayed;
        }
      firstLineToDisplay = firstLine;
    }
  
    @Override
    public void setLineToHighlight(int highlightedLine) {
      lineToHighlight = highlightedLine;
    }
  
    @Override
    public void setLastLineToDisplay(int lastLine) {
      linesBeingDisplayed = lastLine - firstLineToDisplay + 1;
    }
  
    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
      linesBeingDisplayed = numberOfLines;
    }

    @Override
    public void loadTable()
    {
        ReadPlayersFromXML();
    }
    
    @Override
    public ArrayList<TableMember> getTable() {
        return players;
    }
    
    @Override
    public ArrayList<String> getHeaders() {
        return players.get(0).getAttributeNames();
    }
    
    @Override
    public ArrayList<String> getLine(int line) {
        return players.get(line).getAttributes();
    }
    
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        for (int i = firstLine; i <= lastLine; i++) {
            ArrayList<String> line = players.get(i).getAttributes();
            if (line == null) {
            break;
        }
            lines.add(line);
        }
        return lines;
        }

    
    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }

}
