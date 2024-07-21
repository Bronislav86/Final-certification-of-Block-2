package Menu;

import Animals.BaseAnimal;
import Animals.PackAnimals.Camel;
import Animals.PackAnimals.Donkey;
import Animals.PackAnimals.Horse;
import Animals.Pets.Cat;
import Animals.Pets.Dog;
import Animals.Pets.Humster;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class InterfaceData extends AnimalIndex {
    private final AnimalIndex index;
    private final Map<Integer, BaseAnimal> animals;

    public InterfaceData() {
        this.index = new AnimalIndex();
        this.animals = new HashMap<Integer, BaseAnimal>();
    }


    /**
     * @return "Метод возвращает новое животное"
     */
    public void addNewAnimal (BaseAnimal animal){

        StringBuilder stringBuilder = new StringBuilder();
        animals.put(index.getIndex(), animal);
        this.index.upIndex();
    }

    /**
     * @return "Метод возвращает строку со списком всех живтоных в питомнике"
     */
    public StringBuilder showAllAnimals (){
        String dbToString = animals.toString();
        String pureString = dbToString.replace("{", "").replace("}", "").replace(",", "").replace("=", ": ");
        String[] splittedString = pureString.split(" ;");
        StringBuilder resultString = new StringBuilder();
        for (String s : splittedString) {
            resultString.append(s);
            resultString.append("\n");
        }
        resultString.append("\n");
        return resultString;
    }

    /**
     * @return "Метод возвращает строку с информацией о всех командах живтоного"
     */
    public String showCommands() {
        System.out.println("Команды какого питомца вы хотите узнать?\n" +
                "Введите порядковый номер питомца: ");
        Scanner scan = new Scanner(System.in);
        BaseAnimal animal = animals.get(Integer.parseInt(scan.nextLine()));
        return "Команды, которые умеет выполнять " + animal.getName() + " : " + animal.getCommands();
    }

    /**
     * @return "Метод создает базу данных животных"
     */
    public Map<Integer, BaseAnimal> animalDBCreator (){
        BaseAnimal animal1 = new Cat("Booch", "Cat", 2000, 01, 02, "Frrr");
        BaseAnimal animal2 = new Dog("Booch", "Dog", 2000, 01, 02, "Sit");
        BaseAnimal animal3 = new Humster("Booch", "Humster", 2000, 01, 02, "Stay");
        BaseAnimal animal4 = new Camel("Booch", "Camel", 2000, 01, 02, "Run");
        BaseAnimal animal5 = new Donkey("Booch", "Donkey", 2000, 01, 02, "Fly");
        BaseAnimal animal6 = new Horse("Booch", "Horse", 2000, 01, 02, "Maugh");
        BaseAnimal animal7 = new Cat("Booch", "Cat", 2000, 01, 02, "Meaw");

        animals.put(index.getIndex(), animal1);
        index.upIndex();
        animals.put(index.getIndex(), animal2);
        index.upIndex();
        animals.put(index.getIndex(), animal3);
        index.upIndex();
        animals.put(index.getIndex(), animal4);
        index.upIndex();
        animals.put(index.getIndex(), animal5);
        index.upIndex();
        animals.put(index.getIndex(), animal6);
        index.upIndex();
        animals.put(index.getIndex(), animal7);
        index.upIndex();
        return animals;
    }

    /**
     * @return "Метод обучает животное новым командам"
     */
    public void learnAnimal() {
        System.out.println("Какой питомец вы хотите обучить?\n" +
                "Введите порядковый номер питомца: ");
        Scanner scan = new Scanner(System.in);
        BaseAnimal animal = animals.get(Integer.parseInt(scan.nextLine()));
        System.out.println("Введите команду, которую вы хотите добавить: ");
        String command = scan.nextLine();
        animal.setCommands(command);
        System.out.println("Команда успешно добавлена!" +
                "Теперь у " + animal.getName() + " есть команды: " + animal.getCommands());
    }

    /**
     * @return "Метод возвращает индекс последнего добавленного животного"
     */
    @Override
    public int getIndex() {
        return index.getIndex() - 1;
    }
}
