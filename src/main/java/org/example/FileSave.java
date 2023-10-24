package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class FileSave {

    public static void save() {
        try (
                FileWriter writer = new FileWriter("out.txt", false)) {
            String text = Animal.listAnimals();
            writer.write(text);

            writer.append('\n');
            writer.append('E');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
