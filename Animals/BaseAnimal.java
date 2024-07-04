package Animals;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAnimal {

    protected String name;
    protected String type;
    protected long birthDate;
    protected String commands;


    public BaseAnimal(String name, String type, long birthDate, String commands) {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = commands;
    }
    public BaseAnimal (){
    }


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public long getBirthDate() {
        return birthDate;
    }


    public String getCommands() {
        return commands;
        // for (String string : commands) {
        //     System.out.println(string);
        // }
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setType(String type) {
        this.type = type;
    }


    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }


    public void setCommands(String newCommand) {
        if (commands.isEmpty()){
            this.commands = commands + newCommand;
        } else{
            this.commands = commands + ", ";
            this.commands = commands + newCommand;
        }            
    }


    @Override
    public String toString() {
        return "Name=" + name + ", Type=" + type + ", BirthDate=" + birthDate + ", Commands=" + commands;
    }

    
}
