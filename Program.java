import java.util.Arrays;
import java.util.Scanner;

import Animals.BaseAnimal;
import Animals.Animal;
import Animals.PackAnimals.Camel;
import Animals.PackAnimals.Donkey;
import Animals.PackAnimals.Horse;
import Animals.Pets.Cat;
import Animals.Pets.Dog;
import Animals.Pets.Humster;
import Menu.Menu;
import Menu.IOData;


public class Program {

    public static void main(String[] args) {

        // BaseAnimal animal1 = new Cat("Booch", "Cat", 2000, 01, 02, "Down");

        // System.out.println(animal1.toString());
        // System.out.println(animal1.toWrite());

        StringBuilder stringIn = new StringBuilder();
        stringIn.append("Potter,Cat,1999-1-15,Fly");
        String[] string = (stringIn.toString()).split(",");
        
        System.out.println(Arrays.toString(string));


        // Menu menu = new Menu();
        // menu.startMenu();
        // Scanner scan = new Scanner(System.in);
        // boolean work = true;
        // while (work) {
        //     int menuNum = Integer.parseInt(scan.nextLine());

        //     if (menuNum == 1) {
        //             IOData writer = new IOData();
        //             writer.addData(addNewAnimal());
        //             menu.startMenu();
        //         }else if (menuNum == 2){
        //             //toPrintAll();
        //             menu.startMenu();
        //         }else if (menuNum == 3) {
                
        //         }else if (menuNum == 4) {
                
        //         }else if (menuNum == 6) {
        //             System.out.println("До новых встреч!");
        //             work = false;
        //         }
        //         else{
        //             System.out.println("Команда не распознана. " + 
        //                                 "Выберите один из пунктов меню:\n");
        //             menu.startMenu();
        //     }
        // }
        // scan.close();
    }

    private static void toPrintAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toPrintAll'");
    }

    private static BaseAnimal addNewAnimal(){
        System.out.println("To add a new animal, enter the data following the instructions.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of a new animal: \n");
        String name = scanner.nextLine();
        System.out.println("Enter type of a new animal. Choose and enter one of the suggested options: \n Cat, Dog, Humster, Camel, Donkey, Horse.");
        String type = scanner.nextLine();
        System.out.println("Enter Year of birth of a new animal: \n");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Month of birth of a new animal: \n");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Day of birth of a new animal: \n");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter commands of a new animal separated by commas: \n");
        String commands = scanner.nextLine();

        BaseAnimal newAnimal = new Animal();

        if (type.equals("Cat")) {
            newAnimal = new Cat(name, type, year, month, day, commands);
        } else if (type.equals("Dog")) {
            newAnimal = new Dog(name, type, year, month, day, commands);
        } else if (type.equals("Humster")) {
            newAnimal = new Humster(name, type, year, month, day, commands);
        } else if (type.equals("Camel")) {
            newAnimal = new Camel(name, type, year, month, day, commands);
        } else if (type.equals("Donkey")) {
            newAnimal = new Donkey(name, type, year, month, day, commands);
        } else {
            newAnimal = new Horse(name, type, year, month, day, commands);
        }
        System.out.println("\nНовый питомец успешно дабвлен в базу.\n");
        return newAnimal;
    }
}