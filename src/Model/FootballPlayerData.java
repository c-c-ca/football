package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

public class FootballPlayerData extends FootballPlayer implements TableData, Displayable, Sortable {
    
    private final static int DEFAULT_TABLE_SIZE = 10;
    private final static int NUM_ATTRIBUTES = 7;
    
    private final static int NUMBER = 0;
    private final static int POSITION = 1;
    private final static int NAME = 2;
    private final static int HEIGHT = 3;
    private final static int WEIGHT = 4;
    private final static int HOMETOWN = 5;
    private final static int HIGH_SCHOOL = 6;
    
    private ArrayList<TableMember> players;
    private Comparator<TableMember>[] orders;
    private Map<String, FootballPlayer>[] hashMaps;
    private int firstLineToDisplay;
    private int linesBeingDisplayed;
    private int lineToHighlight;
    private int sortField;
    private int searchFieldIndex;
    private boolean searchResultFound;
    private int foundIndex;


    public FootballPlayerData()
    {
        players = new ArrayList<TableMember>();
        firstLineToDisplay = 0;
        linesBeingDisplayed = DEFAULT_TABLE_SIZE;
        lineToHighlight = -1;
        sortField = NUMBER;
        searchFieldIndex = NUMBER;
        searchResultFound = false;
        loadTable();
        initOrders();
        initHashMaps();
        sort();
    }
    
    private void initOrders () {
        orders = new Comparator[NUM_ATTRIBUTES];
    }
    
    private void initHashMaps() {
        hashMaps = new HashMap[NUM_ATTRIBUTES];
        for (int i = 0; i < NUM_ATTRIBUTES; i++) {
            hashMaps[i] = new HashMap<String, FootballPlayer>();
            for (TableMember player : players) {
                FootballPlayer fp = (FootballPlayer) player;
                hashMaps[i].put(fp.getAttribute(i), fp);
                if (i == 0) {
                    System.out.println(fp.getAttribute(i));
                }
            }
        }
        System.out.println("Hash maps initialized");
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
    
    private void initSortByNumber () {
        orders[NUMBER] = new Comparator<TableMember>() {
            @Override
            public int compare(TableMember fp1, TableMember fp2) {
                return ((FootballPlayer) fp1).getNumber() -
                       ((FootballPlayer) fp2).getNumber();
            }
        };
    }
    
    private void initSortByHeight () {
        orders[HEIGHT] = new Comparator<TableMember>() {
            @Override
            public int compare(TableMember fp1, TableMember fp2) {
                Height h1 = ((FootballPlayer) fp1).getHeight();
                Height h2 = ((FootballPlayer) fp2).getHeight();
                return h1.compareTo(h2);
            }
        };
    }
    
    public void sort () {
        if (orders[sortField] == null) {
            initSortField(sortField);
        }
        Collections.sort(players, orders[sortField]);
    }
    
    
    
    private void initSortField (int sortField) {
        switch (sortField) {
            case NUMBER:
                initSortByNumber();
                break;
            case POSITION:
                System.out.println("Position");
                break;
            case NAME:
                System.out.println("Name");
                break;
            case HEIGHT:
                initSortByHeight();
                System.out.println("Height");
                break;
            case WEIGHT:
                System.out.println("Weight");
                break;
            case HOMETOWN:
                System.out.println("Hometown");
                break;
            case HIGH_SCHOOL:
                System.out.println("High School");
                break;
            default:
                System.out.println("Field not recognized.");
                break;
        }
    }
    
    public int getSortField() {
        return sortField;
    }
    
    public void setSortField (int sortField) {
        this.sortField = sortField;
    }
    
    public boolean search (String searchTerm) {
        int searchByField = getSearchByField();
        System.out.println("Search by field: " + searchByField);
        FootballPlayer player = hashMaps[searchByField].get(searchTerm);
        System.out.println("Found player: " + player);
        setFound(player != null);
        setFoundIndex(players.indexOf((TableMember) player));
        return getFound();
    }

    public int getFoundIndex() {
        return foundIndex;
    }

    public void setFoundIndex(int tableMemberIndex) {
        foundIndex = tableMemberIndex;
    }

    public boolean getFound() {
        return searchResultFound;
    }

    public void setFound(boolean searchResult) {
        searchResultFound = searchResult;
    }

    public int getSearchByField() {
        return searchFieldIndex;
    }

    public void setSearchByField(int fieldIndex) {
        searchFieldIndex = fieldIndex;
    }

}
