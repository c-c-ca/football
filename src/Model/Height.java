package Model;

import java.util.ArrayList;

public class Height implements Comparable  {
    private int feet;
    private int inches;
    
    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }
    
    public Height() {
        this.feet = 0;
        this.inches = 0;
}
    public int getFeet() {
        return feet;
    }
    public int getInches() {
        return inches;
    }
    public void setFeet(int feet) {
        this.feet = feet;
    }
    public void setInches(int inches) {
        this.inches = inches;
    }
    
    public int compareTo (Object o) {
        Height other = (Height) o;
        if (this.feet != other.feet) {
            return this.feet - other.feet;
        }
        
        return this.inches - other.inches;
    }
    
    @Override
    public String toString() { 
        return feet + "'" + inches + "\"";
    }
}
