package Model;

import java.util.ArrayList;

public class Person
{
    private String name;
    private Height height;
    private int weight;
    private String hometown;
    private String highSchool;

    
    public Person(String name, Height height, int weight, String hometown, String highSchool) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hometown = hometown;
        this.highSchool = highSchool;
    }

    public Person() {
        this.name = "";
        this.height = new Height();
        this.weight = 0;
        this.hometown = "N/A";
        this.highSchool = "N/A";
    }
    
    public String getName() {
    return name;
        }

    public int getWeight() {
        return weight;  
        }

    public String getHometown() {
        return hometown;
        }
  
    public Height getHeight() {
        return height;
        }

    public void setName(String name) {
        this.name = name;  
        }

    public String getHighSchool() {
        return highSchool;
        }

    public void setWeight(int weight) {
        this.weight = weight;  
        }

    public void setHometown(String hometown) {
        this.hometown = hometown;
        }

    public void setHighSchool(String highSchool) {   
        this.highSchool = highSchool;
        }

    public void setHeight(Height height) {   
        this.height = height;
        }


    @Override
    public String toString() {
        return "Person{" + "name=" + name +  ", height=" + height +  ", weight=" + weight + ", hometown=" + hometown + ", highSchool=" + highSchool + '}';
    }
}

