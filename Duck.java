// Resources:
// https://vertex-academy.com/tutorials/en/rounding-numbers-java/

import java.util.Random;
public class Duck {

    // Attributes:
    Random rand = new Random();
    private String name; // name of the duck
    private String color; // color of the duck
    private double size = Math.ceil(rand.nextDouble() * 10); // random size of the duck; rounds up so zeros never happen
    //private float size = 1;

    // Constructor:
    /**
     * Creates a Duck class. 
     * @param name; Name of the duck  
     * @param color; Color of the duck
     */
    public Duck(String name, String color){
        this.name = name;
        this.color = color;
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
     * @return s; Size of the duck
     */
    public double getSize(){
      return this.size;
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


    public static void main(String[] args) {
        Duck ducky = new Duck("Ducky", "orange");
        System.out.println(ducky);
        ducky.grow();
        Duck mrDuck = new Duck("Mr Duck", "yellow");
        System.out.println(mrDuck);
        mrDuck.shrink();


        
    }
}
