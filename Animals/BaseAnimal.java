package Animals;


public abstract class BaseAnimal {

    protected String name;
    protected String type;
    protected int year;
    protected int month;
    protected int day;
    protected String commands;


    
    public BaseAnimal(String name, String type, int year, int month, int day, String commands) {
        this.name = name;
        this.type = type;
        this.year = year;
        this.month = month;
        this.day = day;
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

    public StringBuilder getBirthDay(){
        StringBuilder st = new StringBuilder();
        st.append(year).append("-").append(month).append("-").append(day);
    return st;
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
        return "Name=" + name + ", Type=" + type + ", BirthDate=" + getBirthDay() + ", Commands=" + commands;
    }

    
}
