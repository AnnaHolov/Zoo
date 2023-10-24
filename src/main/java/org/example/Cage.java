package org.example;

import java.util.HashMap;

public class Cage {
    public static HashMap<Integer, Cage> storageCage = new HashMap<>();

    int id;
     CageSize size;

    public Cage(CageSize size) {
        this.id = size.capacity;
        this.size = size;
    }

    enum CageSize {


        SMALL(2),
        MEDIUM(5),
        BIG(10);

        CageSize(int capacity) {
            this.capacity = capacity;
        }

        int capacity;

        public int getCapacity() {
            return capacity;
        }
    }
    public static void cagesByDefault(){
        Cage small = new Cage(CageSize.SMALL);
        Cage medium = new Cage(CageSize.MEDIUM);
        Cage big = new Cage(CageSize.BIG);
        storageCage.put(small.id, small);
        storageCage.put(medium.id, medium);
        storageCage.put(big.id, big);


    }

}
