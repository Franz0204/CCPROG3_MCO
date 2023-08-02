package NormalVendingMachine;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    
    private List<Slot> ingredients; 
    private String name;
    private int menuNo;
    
    public Meal(String name, int menuNo, List<Slot> ingredients){
        this.name = name;
        this.menuNo = menuNo;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        
        for (Slot slot: this.ingredients) {
            if (slot != null) {
                totalPrice += slot.getPrice();
            }
        }
        
        return totalPrice;
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        
        for (Slot slot : this.ingredients) {
            if (slot != null) {
                totalCalories += slot.getSides().getCalories();
            }
        }
        
        return totalCalories;
    }

    public List<Slot> getIngredients(){
        return new ArrayList<>(ingredients);
    }

    public int getMenuNo(){
        return this.menuNo;
    }
    
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    

}
