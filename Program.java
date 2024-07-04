import Animals.BaseAnimal;
import Animals.Pets.Cat;

public class Program {

    public static void main(String[] args) {

        BaseAnimal cat1 = new Cat("Whiskers", "Cat", 2020-01-01, "");
        cat1.setCommands("Down");
        cat1.setCommands("Stay");
        cat1.setCommands("Fetch");
        System.out.println(cat1.getCommands());
        System.out.println(cat1.toString());
        

    }
    
    
    
}