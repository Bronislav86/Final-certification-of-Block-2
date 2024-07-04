package Animals.Pets;

import Animals.BaseAnimal;

public abstract class Pets extends BaseAnimal {

    public Pets(String name, String type, long birthDate, String commands) {
        super(name, type, birthDate, commands);
    }
    
    public Pets(){
    }
}
