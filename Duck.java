// Resources:
// https://vertex-academy.com/tutorials/en/rounding-numbers-java/
// https://www.w3schools.com/java/ref_string_hashcode.asp
// https://stackoverflow.com/questions/23047309/prompt-for-user-yes-or-no-input-in-java


import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Duck {

    // Attributes:
    private String name; // name of the duck
    private String color; // color of the duck
    private double size; // size of the duck
    private int energy; // energy of the duck
    public static Scanner input = new Scanner(System.in); // scanner for user's input

    /* Interactions */
    private List<String> objects = Arrays.asList("bucket hat", "propeller hat", "mustache"); // list of all the available objects 
    private String inventory; // when an object is in the duck's inventory it wears it
    
    // Constructor:
    /**
     * Creates a randomly sized duck with your choice of name and color. The size of the duck corresponds to its energy amount that is used to perform various tasks. 
     * For example, the duck has the ability to shrink and grow its size and interact with objects. 
     * 
     * @param name Name of the duck  
     * @param color Color of the duck
     */
    public Duck(String name, String color){
        this.name = name; 
        this.color = color;

        Random rand = new Random(); // randomly assigns 
        rand.setSeed(this.name.hashCode()); // sets the seed so the weight of the duck is tied to its name
        this.size = Math.ceil(rand.nextDouble() * 10); // random size of the duck; rounds up so zeros never happen

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

    // Methods:
    /**
     * Nicely prints out a description of the duck.
     * @return description of duck
     */
    public String toString(){
        return this.name + " is a " + this.size + "-lbs " + this.color + " duck. "+ this.name + " has " + this.energy + " energy points to use.";
    }

    /**
     * Shrinks the duck so they are 1 pound lighter. If they are already 1 pound or not enough energy they remain the same weight.
     * @return size; weight of the duck in lbs
     */
    public Number shrink(){
        /* Check to see if there is enough energy */
        if(this.energy >= 1){
            /* If the duck is 1 lbs */
            if(this.size == 1){
                System.out.println("Sorry, " + this.name + " can't shrink any smaller.");
                return this.size;

            } else{
                this.energy -= 1;
                System.out.println(this.name + " shrunk to be " + (this.size -1) + " lbs. {Energy level: " + this.energy + "}");
                return this.size -= 1;
            }

        } else{
            System.out.println("Sorry, " + this.name + " is too tired to shrink.");
            return this.size;
        }  
    }

    /**
     * Grows the duck so they are 1 pound heavier. If they are already 10 pounds they remain the same weight.
     * @return size; weight of the duck in lbs
     */
    public Number grow(){
        /* Check to see if there is enough energy */
        if(this.energy >= 1){
            /* If the duck is 10 lbs */
            if(this.size == 10){
                System.out.println("Sorry, " + this.name + " can't grow any bigger.");
                return this.size;
            } else{
                this.energy -= 1;
                System.out.println(this.name + " grew to be " + (this.size +1) + " lbs. {Energy level: " + this.energy + "}");
                return this.size += 1;
            }

        } else {
            System.out.println("Sorry, " + this.name + " is too tired to grow.");
            return this.size;
        }
    }

    /**
     * Duck walks in the direction provided. Decrease 1 energy as a result. Also there is a chance that the duck can encounter an object to interact with.
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
                this.energy -= 1;
                System.out.println(this.name + " is walking " + direction + ". {Energy level: " + this.energy + "}");

                /* Object Encounter */
                if(randEncounter == 0){
                    System.out.println(this.name +" stumbled upon a " + objects.get(randObject) + "!");
                    
                    /* Decision to pick up object */
                    boolean yn = true; // answer to if the user wants to grab or not
                    String decision; 

                    /* While loop so that the user inputs correct format */
                    while(yn){
                        System.out.println("Do you want to pick up " + objects.get(randObject) + "? (yes or no)");
                        decision = input.nextLine();

                        /* User's response */
                        switch(decision.toLowerCase()){
                            case "yes": // yes, wants to pick up
                                yn = false;
                                this.grab(objects.get(randObject)); // goes directly to grabbing the object
                                break;
                            case "no": // no, don't want to pick up
                                yn = false;
                                break;
                            default: // any other response will repeat the question until correct format
                                yn = true;
                        }
                    }
                } else{
                    System.out.println("*Quack* *Quack*");
                }
                return true; // Duck can walk in the direction, doesn't give information on whether the duck can interact with an object

            /* Not enough energy */
            } else{
                System.out.println("Sorry, "+ this.name + " can't walk. Please rest to refill their energy.");
                return false; // Duck doesn't have enough energy to walk 
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
            System.out.println("ZZZZZZZZ... "+this.name + " rested. {Energy level: " + this.energy + "}");

        /* Medium ducks have 5 energy */    
        } else if(this.size < 7){
            this.energy = 5;
            System.out.println("ZZZZZZZZ... "+this.name + " rested. {Energy level: " + this.energy + "}");

        /* Large ducks have the most energy */
        } else{
            this.energy = 7;
            System.out.println("ZZZZZZZZ... "+this.name + " rested. {Energy level: " + this.energy + "}");
        }
    }

    /**
     * The duck can pick up/grab the object if they have 1 energy point. Adds the item to their inventory. 
     * @param item; Item that the duck adds to their inventory
     */
    public void grab(String item){
        /* Check to see if the duck has enough energy to grab the item*/
        if(this.energy >= 1){
            this.energy -= 1; // subtracts 1 energy
            this.inventory = item; // adds the item to inventory
            System.out.println(this.name + " grabbed a " + item + ". {Energy level: " + this.energy + "}");
        } else{
            System.out.println("Sorry, "+ this.name + " is too tired to grab " + item +". Please rest to refill their energy.");
        }
    }
    
    // accessories: bucket hat, spinner hat, mustache, 
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------");
        Duck ducky = new Duck("Ducky", "orange");
        System.out.println(ducky);
        ducky.shrink();
        ducky.walk("southeast");
        ducky.walk("west");
        ducky.walk("west");
        ducky.shrink();
        ducky.rest();

        System.out.println("------------------------------------------------------------------");
        Duck mrDuck = new Duck("Mr Duck", "yellow");
        System.out.println(mrDuck);
        mrDuck.grow();
        mrDuck.walk("north");

        System.out.println("------------------------------------------------------------------");
        System.out.println(mrDuck.inventory);
        System.out.println(ducky.inventory);
       
    }
}
