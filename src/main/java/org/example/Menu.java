package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static void menu() throws IOException {
        System.out.println("Input number of operation:");
        System.out.println("1-Add animal");
        System.out.println("2-Animal info");
        System.out.println("3-List of all animals");
        System.out.println("4-Edit animal");
        System.out.println("5-Transfer animal");
        System.out.println("6- Delete animal");
        System.out.println("7- Save file");
        System.out.println("8- Exit program");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        switch (x) {
            case 1:
                Animal.addAnimal();
                break;
            case 2:
                Animal.animalInfo();
                break;
            case 3:
                Animal.listAnimals();
                break;
            case 4:
                Animal.editAnimal();
                break;
            case 5:
                Animal.transferAnimal();
                break;
            case 6:
                Animal.deleteAnimal();
                break;
            case 7:
                FileSave.save();
                break;
            case 8:
                exitProgram();
            default:
                System.out.println("Wrong number");
                break;
        }
    }
    public static void exitProgram() {

        System.exit(0);



    }
}
