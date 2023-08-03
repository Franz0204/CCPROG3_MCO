package NormalVendingMachine;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Meal in a vending machine, consisting of various ingredients in slots.
 */
public class Meal {
    
    private List<Slot> ingredients; 
    private String name;
    private int menuNo;
    
    /**
     * Constructs a new Meal object with the given name, menu number, and ingredients.
     * 
     * @param name The name of the meal.
     * @param menuNo The menu number of the meal.
     * @param ingredients The list of Slot objects representing the ingredients of the meal.
     */
    public Meal(String name, int menuNo, List<Slot> ingredients){
        this.name = name;
        this.menuNo = menuNo;
        this.ingredients = new ArrayList<>(ingredients);
    }

    /**
     * Calculates the total price of the meal by summing up the prices of all ingredients.
     * 
     * @return The total price of the meal.
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        
        for (Slot slot: this.ingredients) {
            if (slot != null) {
                totalPrice += slot.getPrice();
            }
        }
        
        return totalPrice;
    }

    /**
     * Calculates the total calories of the meal by summing up the calories of all ingredients.
     * 
     * @return The total calories of the meal.
     */
    public int getTotalCalories() {
        int totalCalories = 0;
        
        for (Slot slot : this.ingredients) {
            if (slot != null) {
                totalCalories += slot.getSides().getCalories();
            }
        }
        
        return totalCalories;
    }

    /**
     * Returns a copy of the list of ingredients in the meal.
     * 
     * @return A copy of the list of ingredients in the meal.
     */
    public List<Slot> getIngredients(){
        return new ArrayList<>(ingredients);
    }

    /**
     * Gets the menu number of the meal.
     * 
     * @return The menu number of the meal.
     */
    public int getMenuNo(){
        return this.menuNo;
    }
    
    /**
     * Gets the name of the meal.
     * 
     * @return The name of the meal.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets the name of the meal.
     * 
     * @param name The new name for the meal.
     */
    public void setName(String name){
        this.name = name;
    }
    
}
