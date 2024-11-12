// Resources:
// https://vertex-academy.com/tutorials/en/rounding-numbers-java/
// https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java

import java.util.Random;
import java.util.Arrays;
import java.util.List;
public class Duck {

    // Attributes:
    Random rand = new Random();
    /* Duck characteristics */
    private String name; // name of the duck
    private String color; // color of the duck
    private double size = Math.ceil(rand.nextDouble() * 10); // random size of the duck; rounds up so zeros never happen
    private int energy; // energy of the duck

    /* Interactions */
    private List<String> objects = Arrays.asList("bucket hat", "propeller hat", "mustache"); // list of all the available objects 
    private String inventory; // when an object is in the duck's inventory it wears it
    private String potentialObject; // when a duck encounters an object it'll be assigned to potentialObject, the duck can then grab it or leave it
    
   
    // Constructor:
    /**
     * Creates a Duck class. 
     * @param name; Name of the duck  
     * @param color; Color of the duck
     */
    public Duck(String name, String color){
        this.name = name; 
        this.color = color;

        /* Smaller ducks only have 3 energy to use */
        if(this.size < 4){
            this.energy = 3;

        /* Medium ducks have 5 energy */    
        } else if(this.size < 7){
            this.energy = 5;

        /* Large ducks have the most energy */
        } else{
            this.energy = 7;
        }
    }

    // Getters:
    /**
     * Getter for the name of the duck.
     * @return name; Name of the duck
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter for the color of the duck.
     * @return color; Color of the duck
     */
    public String getColor(){
        return this.color;
    }

    /**
     * Getter for the size of the duck.
     * @return size; Size of the duck
     */
    public double getSize(){
      return this.size;
    }

    /**
     * Getter for the duck's energy.
     * @return energy; Energy of the duck
     */
    public int getEnergy(){
        return this.energy;
    } 

    /**
     * Getter for the available objects the duck can interact with
     * @return objects; Objects of the duck
     */
    public List<String> getObjects(){
        return this.objects;
    }

    /**
     * Getter for the duck's inventory.
     * @return inventory; Duck's inventory
     */
    public String getInventory(){
        return this.inventory;
    }

    /**
     * Getter for the duck's potential object
     * @return object; Object that the duck can choose what to do with
     */
    public String getPotentialObject(){
        return this.potentialObject;
    }

    // Methods:
    /**
     * Nicely prints out a description of the duck.
     * @return description of duck
     */
    public String toString(){
        return this.name + " is a " + this.size + "-lbs " + this.color + " duck.";
    }

    /**
     * Shrinks the duck so they are 1 pound lighter. If they are already 1 pound they remain the same weight.
     * @return size; weight of the duck in lbs
     */
    public Number shrink(){
        /* If the duck is 1 lbs */
        if(this.size == 1){
            System.out.println("Sorry, " + this.name + " can't shrink any smaller.");
            return this.size;

        } else{
            System.out.println(this.name + " shrunk to be " + (this.size -1) + " lbs.");
            return this.size -= 1;
        }
    }

    /**
     * Grows the duck so they are 1 pound heavier. If they are already 10 pounds they remain the same weight.
     * @return size; weight of the duck in lbs
     */
    public Number grow(){
        /* If the duck is 10 lbs */
        if(this.size == 10){
            System.out.println("Sorry, " + this.name + " can't grow any bigger.");
            return this.size;
        } else{
            System.out.println(this.name + " grew to be " + (this.size +1) + " lbs.");
            return this.size += 1;
        }
    }

    /**
     * Duck walks in the direction provided. Decrease 1 energy as a result. 
     * @param direction; Direction the duck walks in
     * @return booleam; True = Duck is able to walk in the given direction, False = Duck either doesn't have enough energy or can't walk in the provided direction
     */
    public boolean walk(String direction){
        /* Directions */
        List<String> directionsList = Arrays.asList("north", "south", "east" , "west"); // possible directions
        direction = direction.toLowerCase(); // converts to all lowercase

        /* Objects */
        Random rand = new Random();  
        int randEncounter = rand.nextInt(3); // 1/3 chance of encountering an object
        int randObject = rand.nextInt(objects.size()); // randomly chooses the object the duck encounters

        /* Checking to see if direction is in DIRECTIONS */
        if(directionsList.contains(direction)){
            /* Checks to see if the duck has enough energy to walk */
            if(this.energy >= 1){
                /* Walks */
                System.out.println(this.name + " is walking " + direction + ". -1 energy point");
                this.energy -= 1;

                /* Object Encounter */
                if(randEncounter == 0){
                    System.out.println(this.name +" stumbled upon a " + objects.get(randObject) + "!");
                    potentialObject = objects.get(randObject);

                } else{
                    System.out.println("*Quack* *Quack*");
                }


                return true;

            /* Not enough energy */
            } else{
                System.out.println("Sorry, "+ this.name + " can't walk. Please rest to refill their energy.");
                return false;
            }
            
        } else{
            System.out.println("Please give a valid direction. The options include: \n * North\n * South\n * East \n * West");
            return false;
        }
    }

    /** 
     * Resest the duck's energy level to its original value.
     */
    public void rest(){
        /* Small ducks have 3 energy */
        if(this.size < 4){
            this.energy = 3;
            System.out.println("ZZZZZZZZ..."+this.name + " rested. They now have an energy level of " + this.energy +".");

        /* Medium ducks have 5 energy */    
        } else if(this.size < 7){
            this.energy = 5;
            System.out.println("ZZZZZZZZ..."+this.name + " rested. They now have an energy level of " + this.energy +".");

        /* Large ducks have the most energy */
        } else{
            this.energy = 7;
            System.out.println("ZZZZZZZZ..."+this.name + " rested. They now have an energy level of " + this.energy +".");
        }
    }

    public void grab(String item){
        if(potentialObject == null){
            System.out.println("Sorry, " +this.name + " has nothing to grab.");
        } else if(item.toLowerCase() != potentialObject){
            System.out.println("Sorry, that wasn't the object " + this.name + " encountered. They found " + potentialObject + ".");
        } 
    }

    // accessories: bucket hat, spinner hat, mustache, 
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        Duck ducky = new Duck("Ducky", "orange");
        System.out.println(ducky);
        ducky.grow();
        ducky.walk("southeast");

        System.out.println("-----------------------------------------------");
        Duck mrDuck = new Duck("Mr Duck", "yellow");
        System.out.println(mrDuck);
        mrDuck.shrink();
        mrDuck.walk("north");
        mrDuck.walk("north");
        mrDuck.rest();


        


        
    }
}
