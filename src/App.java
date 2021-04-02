import Controller.Controller;
import Model.Model;
import View.View;

public class App {
    
    public static void main (String[] argv) {
        new Controller(new View(),new Model());
    }
   
}
