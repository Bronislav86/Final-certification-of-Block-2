package Menu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Animals.BaseAnimal;

public class IOData {

    public IOData (){}

    public void addData (BaseAnimal animal){        // метод записывает созданный экземпляр класса в файл

        StringBuilder stringOut = new StringBuilder();
        stringOut.append(animal.toWrite());
        File file = new File("Animals_DB.csv");
        
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(stringOut.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder readData (){                     // проверить какой нужен будет тип данных на выходе в дальнейшем
        File file = new File("Animals_DB.csv");
        StringBuilder stringIn = new StringBuilder();

        try (FileReader reader = new FileReader(file)) {
            stringIn.append(reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] string = stringIn.toString().split(",");
        
        System.out.println(string);
        return stringIn;
    }


}
