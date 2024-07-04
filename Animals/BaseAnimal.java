package Animals;


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


    public void setCommands(String commands) {
        this.commands = commands;
    }


    @Override
    public String toString() {
        return "Animal [Name=" + name + ", Type=" + type + ", BirthDate=" + birthDate + ", Commands=" + commands + "]";
    }

    
}
