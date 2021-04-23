package Model;

import java.util.ArrayList;

public class FootballPlayer extends Person implements TableMember {
    private int number;
    private String position;
    
    
    public FootballPlayer(String name, Height height, int weight, String hometown, String highschool, int number, String position) {
        super(name,height,weight,hometown,highschool);
        this.number = number;
        this.position = position;
    }
    
    public FootballPlayer() {
        super();
        number = 0;
        position = "N/A";
    }

    @Override
    public String getAttribute(int n) {
        switch (n) { 
            case 0: 
                return String.valueOf(this.number) + "";
            case 1:
                return this.position + "";
            case 2:
                return super.getName() + "";
            case 3: 
                return super.getHeight().toString() + "";
            case 4:
                return String.valueOf(super.getWeight()) + "";
            case 5:
                return super.getHometown() + "";
            case 6:
                return super.getHighSchool() + "";
            default:
                return ("invalid input parameter");
        }
    }
    
    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> getAttributes = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            getAttributes.add(getAttribute(i));
        }
        
        return getAttributes;
    }
    
    @Override
    public String getAttributeName(int n) {
        switch (n) {
            case 0: 
                return "number ";
            case 1:
                return "position ";
            case 2:
                return "name ";
            case 3: 
                return "height ";
            case 4: 
                return "weight ";
            case 5:
                return "hometown ";
            case 6:
                return "highSchool ";
            default:
                return ("invalid input parameter");
        }
    }
    
    @Override
    public ArrayList<String> getAttributeNames() {
        ArrayList<String> getAttributeNames = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            getAttributeNames.add(getAttributeName(i));
        }
        return getAttributeNames;
    }
    
    public int getNumber() {
        return number;
    }
    public String getPosition() {
        return position;
    }
    public void setNumber(int number) {
        this.number=number;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString() {
        return super.toString() + " FootballPlayer {number=" + number + ", position=" + position + "}";
    }
}
