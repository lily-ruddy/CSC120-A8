// Resources:
// https://vertex-academy.com/tutorials/en/rounding-numbers-java/
// https://stackoverflow.com/questions/1128723/how-do-i-determine-whether-an-array-contains-a-particular-value-in-java

import java.util.Random;
import java.util.Arrays;
import java.util.List;
public class Duck {

    // Attributes:
    Random rand = new Random();
    private String name; // name of the duck
    private String color; // color of the duck
    private double size = Math.ceil(rand.nextDouble() * 10); // random size of the duck; rounds up so zeros never happen
    private int energy; // energy of the duck
    
   
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
        } else if(4 <= this.size & this.size < 7){
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
        List<String> DIRECTIONS = Arrays.asList("north", "south", "east" , "west"); // possible directions
        direction = direction.toLowerCase(); // converts to all lowercase

        /* Checking to see if direction is in DIRECTIONS */
        if(DIRECTIONS.contains(direction)){
            /* Checks to see if the duck has enough energy to walk */
            if(this.energy >= 1){
                System.out.println(this.name + " is walking " + direction + ". *Quack*");
                this.energy -= 1;
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

        System.out.println("-----------------------------------------------");


        
    }
}
