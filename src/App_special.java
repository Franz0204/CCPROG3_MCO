import java.util.ArrayList;
import java.util.List;

import NormalVendingMachine.Slot;
import NormalVendingMachine.Sides;
import NormalVendingMachine.Meal;
import NormalVendingMachine.SpecialVendingMachine;

public class App_special {

    public static void main(String[] args) {
        SpecialVendingMachine specialVendingMachine = new SpecialVendingMachine("Pizza Vending Machine");

        // Create and add some side items to the vending machine

        // Display the available side items in the vending machine
        /* 
        System.out.println("Available Side Items in the " + specialVendingMachine.getName());
        System.out.println("-----------------------------------------\n");
        specialVendingMachine.displayItems();

        System.out.println("Available Ingredients in the " + specialVendingMachine.getName());
        System.out.println("-----------------------------------------\n");
        specialVendingMachine.displayIngredients();
         */
        //List<Sides> sides = new ArrayList<>();
        List<Slot> sides2 = new ArrayList<>();
        //specialVendingMachine.addMeal("Pepperoni Pizza", sides2);
        specialVendingMachine.getLowestMenuPrice();
        //Meal meal = specialVendingMachine.chooseMenu(0);
       //specialVendingMachine.displayRecipe(meal);
        specialVendingMachine.runVendingMachine();

       
    }
}