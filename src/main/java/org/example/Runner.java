package org.example;


import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        Animal.animalsByDefault();
        Cage.cagesByDefault();

        Menu.menu();
    }
}
