import java.util.Random;
public class Duck {

    // Attributes:
    Random rand = new Random();
    private String name; // name of the duck
    private String color; // color of the duck
    private float size = Math.round(rand.nextFloat() * 10); // size of the duck

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
    public float getSize(){
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


    public static void main(String[] args) {
        Duck ducky = new Duck("Ducky", "orange");
        System.out.println(ducky);
        Duck mrDuck = new Duck("Mr Duck", "yellow");
        System.out.println(mrDuck);
        
    }
}
