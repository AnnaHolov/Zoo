package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public  class Animal {
    static HashMap<Integer, Animal> storage = new HashMap<>();
    String name;
    String type;
    int age;
    int animalNumber;

    public Animal(String name, String type, int age, int animalNumber, Cage cage) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.animalNumber = animalNumber;
        this.cage = cage;
    }

    Cage cage;

    public static void animalsByDefault(){
        Animal lion = new Animal("Simba","lion",12,1,new Cage(Cage.CageSize.SMALL));
        Animal wolf = new Animal("Auf","wolf",4,2,new Cage(Cage.CageSize.SMALL));
        Animal crocodile = new Animal("Tik-Tak","crocodile",7,3,new Cage(Cage.CageSize.SMALL));
        Animal duck = new Animal("Donald","duck",3,4,new Cage(Cage.CageSize.BIG));
        Animal sheep = new Animal("Schon","sheep",1,5,new Cage(Cage.CageSize.MEDIUM));
        Animal hippo = new Animal("Gloria","hippo",10,6,new Cage(Cage.CageSize.SMALL));
        Animal panda = new Animal("Go","panda",8,7,new Cage(Cage.CageSize.MEDIUM));
        storage.put(lion.animalNumber, lion);
        storage.put(wolf.animalNumber, wolf);
        storage.put(crocodile.animalNumber, crocodile);
        storage.put(duck.animalNumber, duck);
        storage.put(sheep.animalNumber, sheep);
        storage.put(hippo.animalNumber, hippo);
        storage.put(panda.animalNumber, panda);

    }

    public static void addAnimal() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a name: ");
        String name = sc.next();

        System.out.println("Enter a age: ");
        int age = sc.nextInt();

        System.out.println("Enter a id: ");
        int animalNumber = sc.nextInt();

        System.out.println("Type: ");
        String type = sc.next();

        System.out.println("Enter a cage size (small, medium, big): ");
        String cageName = sc.next();

        Cage cage = null;
        switch (cageName){
            case "small":
                cage = Cage.storageCage.get(Cage.CageSize.SMALL);
            case "medium":
                cage = Cage.storageCage.get(Cage.CageSize.MEDIUM);
            case "big":
                cage = Cage.storageCage.get(Cage.CageSize.BIG);
        }

        Animal animal = new Animal(name, type, age, animalNumber, cage);



        System.out.println("Animal " + animal.name + " " + animal.age +
                " " + animal.type + " added");
        storage.put(animal.animalNumber, animal);
        Menu.menu();
    }
    public static void animalInfo() throws IOException {
        Set<Integer> animalNumbers = storage.keySet();
        System.out.println(animalNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose animal id: ");
        int animalId = sc.nextInt();
        Animal currentAnimal = storage.get(animalId);
        System.out.println("Animal number: " + currentAnimal.animalNumber);
        System.out.println("Animal name: " + currentAnimal.name);
        System.out.println("Animal age: " + currentAnimal.age);
        System.out.println("Animal type: " + currentAnimal.type);
        Menu.menu();

    }
    public static void listAnimal(Animal animal){

       System.out.println("Animal name:"+animal.name);
       System.out.println("Animal age:"+animal.age);
       System.out.println("Animal type:"+animal.type);
    }
    public static String listAnimals(){

        System.out.println(storage.values());
        return storage.values().toString();
    }
    public String toString() {
        return "Animal{"
                + "Name='" + name + '\''
                + ", age=" + age
                + ", Type=" + type
                + '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    public static void editAnimal () throws IOException {
        Set<Integer> animalNumbers = storage.keySet();
        System.out.println(animalNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to edit animal information");
        int animalId = sc.nextInt();
        Animal currentAnimal = storage.get(animalId);
        System.out.println("Enter a name: ");
        String name = sc.next();
        currentAnimal.setName(name);

        System.out.println("Enter age: ");
        int age = sc.nextInt();
        currentAnimal.setAge(age);

        System.out.println("Enter a type: ");
        String type = sc.next();
        currentAnimal.setType(type);

        System.out.println("Enter a cage size (small, medium, big): ");
        String cage = sc.next();
        switch (cage){
            case "small":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.SMALL.capacity));
            case "medium":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.MEDIUM.capacity));
            case "big":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.BIG.capacity));
        }


        System.out.println("Animal edited.");
        Menu.menu();
    }
    public static void transferAnimal () throws IOException {
        Set<Integer> animalNumbers = storage.keySet();
        System.out.println(animalNumbers);

        Scanner sc = new Scanner(System.in);
        System.out.println("Input number to transfer animal: ");
        int animalId = sc.nextInt();
        Animal currentAnimal = storage.get(animalId);
        System.out.println("Enter a cage size (small, medium, big): ");
        String cage = sc.next();
        switch (cage){
            case "small":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.SMALL.capacity));
            case "medium":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.MEDIUM.capacity));
            case "big":
                currentAnimal.setCage(Cage.storageCage.get(Cage.CageSize.BIG.capacity));
        }
System.out.println("Animal transferred.");
        Menu.menu();

    }
    public static void deleteAnimal() throws IOException {

        Set<Integer> animalNumbers = storage.keySet();
        System.out.println(animalNumbers);


        System.out.println("Input number to delete animal.");

        Scanner in = new Scanner(System.in);
        int index = in.nextInt();

        storage.remove(index);
        System.out.println("Animal animal.");
        Menu.menu();
    }


}
