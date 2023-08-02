package NormalVendingMachine;


/**
 * The Sides class represents a side item available in a vending machine.
 * It contains information about the name and calorie content of the side item.
 */
public class Sides {
    
    private final String name;
    private final int calories;

    /**
     * Constructs a new instance of the Sides class with the specified name and calorie content.
     *
     * @param name The name of the side item.
     * @param calories The calorie content of the side item.
     */
    public Sides(String name, int calories){
        this.name = name;
        this.calories = calories;
    }

    /**
     * Returns the name of the side item.
     *
     * @return The name of the side item as a String.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the calorie content of the side item.
     *
     * @return The calorie content of the side item as an integer.
     */
    public int getCalories(){
        return this.calories;
    }
}
