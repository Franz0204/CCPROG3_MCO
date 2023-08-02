package NormalVendingMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * SpecialVendingMachine class represents a special vending machine that sells pizzas and other items.
 * It extends the RegularVendingMachine class and provides additional functionality for managing pizza ingredients and recipes.
 */
public class SpecialVendingMachine extends RegularVendingMachine {

    private List<Slot> ingredients;
    private List<Meal> menu;

    /**
     * Creates a new SpecialVendingMachine with the given name.
     *
     * @param name The name of the vending machine
     */
    public SpecialVendingMachine(String name) {
        super(name);
        this.ingredients = new ArrayList<>();
        this.menu = new ArrayList<>();

        // Adding ingredients
        addSlot(new Sides("Tomato Sauce", 50), 20, true, 10, ingredients);
        addSlot(new Sides("White Sauce", 70), 40, true, 10, ingredients);
        addSlot(new Sides("Chocolate Sauce", 100), 60, true, 10, ingredients);

        addSlot(new Sides("Thin Crust", 120), 150, true, 10, ingredients);
        addSlot(new Sides("Thick Crust", 150), 160, true, 10, ingredients);
        addSlot(new Sides("Wood-fired Crusts", 200), 200, true, 10, ingredients);

        addSlot(new Sides("Mozzarella Cheese", 90), 30, true, 10, ingredients);
        addSlot(new Sides("Provolone Cheese", 80), 40, true, 10, ingredients);
        addSlot(new Sides("Goat Cheese", 110), 50, true, 10, ingredients);
        addSlot(new Sides("Blue Cheese", 100), 60, true, 10, ingredients);
        addSlot(new Sides("Cheddar Cheese", 85), 70, true, 10, ingredients);
        addSlot(new Sides("Feta Cheese", 95), 80, true, 10, ingredients);
        addSlot(new Sides("Parmesan Cheese", 70), 90, true, 10, ingredients);

        addSlot(new Sides("Pepperoni Meat", 60), 90, true, 10, ingredients);
        addSlot(new Sides("Salami Meat", 65), 100, true, 10, ingredients);
        addSlot(new Sides("Sausage Meat", 75), 110, true, 10, ingredients);
        addSlot(new Sides("Chicken Meat", 90), 120, true, 10, ingredients);
        addSlot(new Sides("Hamburger Meat", 80), 130, true, 10, ingredients);

        addSlot(new Sides("Pineapple Fruit", 50), 10, true, 10, ingredients);
        addSlot(new Sides("Peach Fruit", 55), 10, true, 10, ingredients);
        addSlot(new Sides("Apple Fruit", 45), 10, true, 10, ingredients);
        addSlot(new Sides("Pear Fruit", 50), 10, true, 10, ingredients);
        addSlot(new Sides("Orange Fruit", 30), 10, true, 10, ingredients);
        addSlot(new Sides("Apricot Fruit", 40), 20, true, 10, ingredients);
        addSlot(new Sides("Mango Fruit", 70), 10, true, 10, ingredients);
        addSlot(new Sides("Banana Fruit", 35), 10, true, 10, ingredients);
        addSlot(new Sides("Strawberry Fruit", 25), 20, true, 10, ingredients);

        addSlot(new Sides("Green pepper Vegetables", 30), 20, true, 10, ingredients);
        addSlot(new Sides("Onion Vegetables", 10), 20, true, 10, ingredients);
        addSlot(new Sides("Olives Vegetables", 40), 30, true, 10, ingredients);
        addSlot(new Sides("Spinach Vegetables", 25), 20, true, 10, ingredients);
        addSlot(new Sides("Tomato Vegetables", 30), 30, true, 10, ingredients);
        addSlot(new Sides("Broccoli Vegetables", 35), 20, true, 10, ingredients);
        addSlot(new Sides("Corn Vegetables", 35), 30, true, 10, ingredients);
        addSlot(new Sides("Mushroom Vegetables", 40), 20, true, 10, ingredients);
        
        // Adding meals
        List<Slot> pepperoniPizza = findSlotsByIngredient("Tomato Sauce", "Thin Crust", "Mozzarella Cheese", "Pepperoni Meat");
        addMeal("Pepperoni Pizza", pepperoniPizza);

        List<Slot> hawaiianPizzaRecipe = findSlotsByIngredient("Tomato Sauce", "Thin Crust", "Hamburger Meat", "Pineapple Fruit", "Mozzarella Cheese");
        addMeal("Hawaiian Pizza", hawaiianPizzaRecipe);

        List<Slot> fourCheesePizzaRecipe = findSlotsByIngredient("Tomato Sauce", "Thin Crust", "Mozzarella Cheese", "Provolone Cheese", "Parmesan Cheese", "Feta Cheese");
        addMeal("4-Cheese Pizza", fourCheesePizzaRecipe);

        List<Slot> fruitPizzaRecipe = findSlotsByIngredient("Chocolate Sauce", "Thick Crust", "Banana Fruit", "Apple Fruit", "Pear Fruit", "Orange Fruit");
        addMeal("Fruit Pizza", fruitPizzaRecipe);
    }

    /**
     * Displays the items available in the vending machine.
     * Prints the slot number, item name, price, and calories for each item.
     */
    public void displayIngredients() {
        for (Slot slot : ingredients) {
            System.out.format("|Slot %d: %s [%d pesos] [%d calories] [%d left]%n", slot.getSlotNo(), slot.getSides().getName(),
                    slot.getPrice(), slot.getSides().getCalories(), slot.getSupply());
        }
        System.out.println("--------------------------------------\n");
    }

    /**
     * Displays the menu of available meals in the vending machine.
     * Prints the menu number, meal name, price, calories, and ingredients for each meal.
     */
    public void displayMenu() {
        System.out.println("Menu:");
        for (Meal meal : menu) {
            System.out.format("|Menu No: %d%n", meal.getMenuNo());
            System.out.format("|Name: %s%n", meal.getName());
            System.out.format("|Price: %d pesos%n", meal.getTotalPrice());
            System.out.format("|Calories: %d calories%n", meal.getTotalCalories());
            System.out.println("Ingredients:");
            for (Slot slot : meal.getIngredients()) {
                System.out.format("|Slot %d: %s [%d pesos] [%d calories] [%d left]%n", slot.getSlotNo(), slot.getSides().getName(),
                        slot.getPrice(), slot.getSides().getCalories(), slot.getSupply());
            }
            System.out.println("--------------------------------------\n");
        }
    }

    /**
     * Displays the recipe of a specific meal.
     *
     * @param meal The meal whose recipe will be displayed
     */
    public void displayRecipe(Meal meal) {
        System.out.print("Ingredients:");
        for (Slot slot : meal.getIngredients()) {
            System.out.print(" [" + slot.getSides().getName() + ("] "));
        }
        System.out.print(" [" + meal.getTotalPrice() + ("] pesos") + (" [") + meal.getTotalCalories() + ("] calories"));
        System.out.println("\n");
    }

    /**
     * Displays the step-by-step process of preparing a specific meal.
     *
     * @param meal the meal to be prepared
     */
    public void displayProcess(Meal meal) {
        System.out.println("Preparing " + meal.getName() + "...\n");
        List<Slot> ingredients = meal.getIngredients();

        for (Slot slot : ingredients) {
            String ingredientName = slot.getSides().getName();

            if (ingredientName.contains("Meat")) {
                System.out.println("Adding " + ingredientName + " on the pizza...");
            } else if (ingredientName.contains("Fruit")) {
                System.out.println("Adding " + ingredientName + " on the pizza...");
            } else if (ingredientName.contains("Vegetables")) {
                System.out.println("Adding " + ingredientName + " on the pizza...");
            } else if (ingredientName.contains("Sauce")) {
                System.out.println("Spreading " + ingredientName + " sauce on the pizza...");
            } else if (ingredientName.contains("Crust")) {
                System.out.println("Placing the " + ingredientName + " as the base...");
            } else if (ingredientName.contains("Cheese")) {
                System.out.println("Sprinkling " + ingredientName + " on the pizza...");
            } else {
                System.out.println("Adding " + ingredientName + " on the pizza...");
            }
        }

        System.out.println("Baking the pizza...");
        System.out.println("Pizza Done!");
    }

    /**
     * Adds a meal to the vending machine with the specified name and ingredients.
     *
     * @param name        the name of the meal to be added
     * @param ingredients the ingredients of the meal (a list of Slot objects)
     * @return true if the meal is successfully added, false otherwise
     */
    public boolean addMeal(String name, List<Slot> ingredients) {
        if (name != null) {
            int mealNum = menu.size() + 1;
            Meal meal = new Meal(name, mealNum, ingredients);
            this.menu.add(meal);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds and returns a list of slots that contain the specified ingredients.
     *
     * @param ingredient an array of ingredient names to search for
     * @return a list of slots containing the specified ingredients
     */
    public List<Slot> findSlotsByIngredient(String... ingredient) {
        List<Slot> slots = new ArrayList<>();
        for (String name : ingredient) {
            boolean ingredientAlreadyAdded = false;
            for (Slot slot : ingredients) {
                if (slot.getSides().getName().equals(name)) {
                    for (Slot s : slots) {
                        if (s.getSides().getName().equals(name)) {
                            ingredientAlreadyAdded = true;
                            break;
                        }
                    }
                    if (!ingredientAlreadyAdded) {
                        slots.add(slot);
                    }
                }
            }
        }
        return slots;
    }
    

    /**
     * Handles the user's menu choice and performs the actions accordingly.
     *
     * @param choice the menu choice made by the user
     */
    public Meal chooseMenu(int choice) {
        int clientBalance = getTotalInput();
        if (choice >= 1 && choice <= menu.size()) {
            for (Meal meal : menu) {
                if (meal.getMenuNo() == choice && meal.getTotalPrice() <= clientBalance) {
                    return meal;
                } 
            }      
        }
        return null;
    }
    
    /**
     * Dispenses a meal by dispensing the ingredients of the given Meal object.
     * This method iterates through the list of ingredients in the Meal and dispenses each ingredient
     * by calling the dispenseProduct method for each ingredient Slot.
     *
     * @param meal The Meal object representing the meal to be dispensed.
     */
    public void dispenseMeal(Meal meal){
        for (Slot slot : meal.getIngredients()) {
            dispenseProduct(slot);
        }
    }

    /**
     * Prints a receipt for a purchase transaction.
     * 
     * @param MenuNo the menu number of the purchased item
     * @param quantity the quantity of the purchased item
     * @param change the amount of change given to the client
     */
    @Override
    public void printReceipt(int menuNo, int quantity, int change) {
        if (menuNo >= 1 && menuNo <= menu.size()) {
            Meal meal = menu.get(menuNo - 1);
            int total = meal.getTotalPrice() * quantity;

            System.out.println("-------- Receipt --------");
            System.out.println("Item: " + meal.getName());
            for (Slot slot : meal.getIngredients()) {
                System.out.format("|%s: [%d pesos] [%d calories]\n", slot.getSides().getName(), slot.getPrice(), slot.getSides().getCalories());
            }
            System.out.println("Quantity: " + quantity);
            System.out.println("Total: " + total + " pesos");
            System.out.println("Change: " + change + " pesos");
            System.out.println("--------------------------\n");
        }
    }

    /**
     * Runs the vending machine program, consisting of the transaction process and maintenance.
     */
    @Override
    public void runVendingMachine() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Ask for name
        System.out.print("What is your name?\n>");
        String name = scanner.nextLine();
        System.out.println("");
        Client client = new Client(name);

        System.out.println("Hello, " + name + "!");
        
        do {
            System.out.println("Menu Options:");
            System.out.println("1. Transaction");
            System.out.println("2. Maintenance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("");
            switch (choice) {
                case 1:
                    System.out.println("Hello Fellow Customer, Welcome To The " + getName());
                    System.out.println("Available Ingredients");
                    displayIngredients();
                    System.out.println("Available Menu Items");
                    displayMenu();
                    int sentinel = 0;

                    int orderC = 0;
                    System.out.println("How would you like to order?");
                    System.out.println("1. Order from the Menu");
                    System.out.println("2. Custom Order");
                    System.out.println("3. Exit");
                    System.out.print("> ");
                    orderC = scanner.nextInt();
                        switch (orderC) {
                            case 1:
                                do {
                                    do {
                                        do {
                                            // Asks for cash
                                            System.out.print("Please Insert Cash To Proceed (Enter -1 when done, Enter 0 to cancel transaction): ");
                                            choice = scanner.nextInt();

                                            if (choice == -1) {
                                                // Stop adding money and proceed to choose a slot
                                                break;
                                            } else if (choice == 0) {
                                                // Cancel the transaction
                                                cancelPurchase(client);
                                                System.out.println("Transaction Cancelled");
                                                scanner.close();
                                                return;
                                            } else {
                                                receiveUserMoney(client, choice);
                                                System.out.format("Total Input: %d pesos%n", getTotalInput());
                                            }
                                        } while (true);
                                        if (getTotalInput() < getLowestMenuPrice()) {
                                            System.out.println("No items to afford. Please add more money or cancel the transaction.");
                                        } else {
                                             break;
                                        }
                                    } while (true);
                
                                    Meal m = null;
                                    do {
                                        System.out.println("Choose a Menu item:");
                                        choice = scanner.nextInt();
                                        Meal chosenMeal = chooseMenu(choice);
                                        if (chosenMeal != null) {
                                            m = chosenMeal;
                                            break;
                                        } else {
                                            System.out.println("Invalid Slot");
                                        }                                           
                                    } while (true);

                                    int itemPrice = m.getTotalPrice();

                                    if (getTotalInput() < itemPrice) {
                                        System.out.println("Insufficient change in the vending machine. Transaction cancelled.");
                                        cancelPurchase(client);
                                        scanner.close();
                                        return;
                                    }
                                    
                                    displayProcess(m);
                                    dispenseMeal(m);

                                    int change = getTotalInput() - itemPrice;
                                    System.out.println("<Dispensing Change>\n");
                                    dispenseChange(change, client);
                                    printReceipt(choice, 1, change);
                                    getInput().clear();
                                    choice = 0;
                                    do {
                                        System.out.println("Do you wish to make another purchase? type 1 - yes | 0 - no");
                                        choice = scanner.nextInt();
                                        if (choice == 0) sentinel = 1;
                                    } while ((choice != 1) && (choice != 0));
                                } while (sentinel == 0);

                                break;

                            case 2:
                                System.out.println("Hello Fellow Customer, Welcome To The " + getName());
                                System.out.println("Available Ingredients");
                                displayIngredients();
                                System.out.println("Available Menu Items");
                                displayMenu();
                                int sentinel2 = 0;

                                do {
                                    Meal m = null;
                            
                                        System.out.println("Custom Order:");
                                    
                                        List<Slot> customIngredients = new ArrayList<>();
                                        int slot;
                                    
                                        // Sauce
                                        do {
                                            System.out.println("Choose a sauce:");
                                            displayIngredientsByCategory(1); // Display ingredients in the "Crusts" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 1)) {
                                                Slot sauceSlot = ingredients.get(slot - 1);
                                                customIngredients.add(sauceSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid crust slot. Please try again.");
                                            }
                                        } while (true);

                                        // Crust
                                        do {
                                            System.out.println("Choose a crust:");
                                            displayIngredientsByCategory(2); // Display ingredients in the "Crusts" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 2)) {
                                                Slot crustSlot = ingredients.get(slot - 1);
                                                customIngredients.add(crustSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid crust slot. Please try again.");
                                            }
                                        } while (true);
                                    
                                        // Cheese
                                        do {
                                            System.out.println("Choose a cheese:");
                                            displayIngredientsByCategory(3); // Display ingredients in the "Cheeses" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 3)) {
                                                Slot cheeseSlot = ingredients.get(slot - 1);
                                                customIngredients.add(cheeseSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid cheese slot. Please try again.");
                                            }
                                        } while (true);
                                    
                                        // Meat
                                        do {
                                            System.out.println("Choose a meat:");
                                            displayIngredientsByCategory(4); // Display ingredients in the "Meats" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 4)) {
                                                Slot meatSlot = ingredients.get(slot - 1);
                                                customIngredients.add(meatSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid meat slot. Please try again.");
                                            }
                                        } while (true);
                                    
                                        // Fruit
                                        do {
                                            System.out.println("Choose a fruit:");
                                            displayIngredientsByCategory(5); // Display ingredients in the "Fruits" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 5)) {
                                                Slot fruitSlot = ingredients.get(slot - 1);
                                                customIngredients.add(fruitSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid fruit slot. Please try again.");
                                            }
                                        } while (true);
                                    
                                        // Vegetable
                                        do {
                                            System.out.println("Choose a vegetable:");
                                            displayIngredientsByCategory(6); // Display ingredients in the "Vegetables" category
                                            slot = scanner.nextInt();
                                    
                                            if (isValidIngredientChoice(slot, 6)) {
                                                Slot vegetableSlot = ingredients.get(slot - 1);
                                                customIngredients.add(vegetableSlot);
                                                break;
                                            } else {
                                                System.out.println("Invalid vegetable slot. Please try again.");
                                            }
                                        } while (true);
                            
                                        String customName = "Custom Pizza"; 
                                        Meal customMeal = new Meal(customName, menu.size() + 1, customIngredients);
                                        menu.add(customMeal);
                                    
                                        System.out.println("--------------------------------------\n");
                                        displayRecipe(customMeal);
                                        System.out.println("--------------------------------------\n");

                                        m = customMeal;

                                    do {
                                        do {
                                            // Asks for cash
                                            System.out.print("Please Insert Cash To Proceed (Enter -1 when done, Enter 0 to cancel transaction): ");
                                            choice = scanner.nextInt();

                                            if (choice == -1) {
                                                // Stop adding money and proceed to choose a slot
                                                break;
                                            } else if (choice == 0) {
                                                // Cancel the transaction
                                                cancelPurchase(client);
                                                System.out.println("Transaction Cancelled");
                                                scanner.close();
                                                return;
                                            } else {
                                                receiveUserMoney(client, choice);
                                                System.out.format("Total Input: %d pesos%n", getTotalInput());
                                            }
                                        } while (true);
                                        
                                        if (getTotalInput() < m.getTotalPrice()) {
                                            System.out.println("No items to afford. Please add more money or cancel the transaction.");
                                        } else {
                                            break;
                                        }
                                    } while (true);

                                    int itemPrice = m.getTotalPrice();

                                    if (getTotalInput() < itemPrice) {
                                        System.out.println("Insufficient change in the vending machine. Transaction cancelled.");
                                        cancelPurchase(client);
                                        scanner.close();
                                        return;
                                    }
                                    
                                    displayProcess(m);
                                    dispenseMeal(m);

                                    int change = getTotalInput() - itemPrice;
                                    System.out.println("<Dispensing Change>\n");
                                    dispenseChange(change, client);
                                    printReceipt(menu.size() - 1, 1, change);
                                    getInput().clear();
                                    menu.remove(menu.size() - 1);
                                    do {
                                        System.out.println("Do you wish to make another purchase? Type 1 - yes | 0 - no");
                                        choice = scanner.nextInt();
                                        if (choice == 0) {
                                            sentinel2 = 1;
                                            break;
                                        }
                                    } while (choice != 1);
                                } while (sentinel2 == 0);
                            
                            case 3:
                                System.out.println("Exiting the transaction...");
                                break;
                        }
                    break;

                case 2:                   
                    int maintenanceChoice;

                    do {
                        System.out.println("Maintenance Options:");
                        System.out.println("1. Restock");
                        System.out.println("2. Set Slot Price");
                        System.out.println("3. Replenish Money");
                        System.out.println("4. Withdraw Money");
                        System.out.println("5. Check Money");
                        System.out.println("6. Display Items");
                        System.out.println("7. Return to Main Menu");
                        System.out.print("Enter your choice: ");
                        maintenanceChoice = scanner.nextInt();
                        System.out.println("");
                        switch (maintenanceChoice) {
                            case 1: // Restock
                                displayIngredients();
                                System.out.println("Enter slot number: ");
                                int slotNumber1 = scanner.nextInt();

                                if (slotNumber1 >= 1 && slotNumber1 <= getSlots().size()) {
                                    System.out.println("Enter quantity: ");
                                    int quantity = scanner.nextInt();
                                    boolean restocked = ingredients.get(slotNumber1 - 1).restock(quantity);

                                    if (restocked) {
                                        System.out.println("Restocked successfully for slot " + slotNumber1);
                                    } else {
                                        System.out.println("Restocking failed. Exceeded maximum supply limit for slot " + slotNumber1);
                                    }
                                } else {
                                    System.out.println("Invalid slot number. Please try again.");
                                }
                                break;

                            case 2: // Set Price
                                System.out.println("Enter slot number: ");
                                int slotNumber2 = scanner.nextInt();

                                if (slotNumber2 >= 1 && slotNumber2 <= ingredients.size()) {
                                    System.out.println("Enter Price: ");
                                    int price = scanner.nextInt();
                                    ingredients.get(slotNumber2 - 1).setPrice(price);
                                    System.out.println("Price set successfully for slot " + slotNumber2);
                                } else {
                                    System.out.println("Invalid slot number. Please try again.");
                                }
                                break;

                            case 3: // Replenish Money
                                System.out.println("Enter money value: ");
                                int moneyValue = scanner.nextInt();
                                System.out.println("Enter quantity: ");
                                int quantity = scanner.nextInt();

                                replenishMoney(moneyValue, quantity);
                                System.out.println("Money replenished successfully.");
                                break;

                            case 4: // Withdraw Money
                                System.out.println("Sales Report:");
                                salesReport();
                                withdrawMoney();
                                System.out.println("Money withdrawn successfully.");
                                break;

                            case 5: // Check Money
                                checkMoney();
                                break;

                            case 6: // Display Ingredients
                                displayIngredients();
                                break;

                            case 7: // Return to Main Menu
                                System.out.println("Returning to main menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }

                        System.out.println("\n");
                    } while (maintenanceChoice != 7);

                    break;

                case 3:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println("\n");
        } while (choice != 3);

        scanner.close();
    }

    /**
     * Displays the ingredients of a specific category by printing their details to the console.
     * For each ingredient in the selected category, its slot number, name, price, calories, and remaining supply are printed.
     *
     * @param category The category of ingredients to display.
     *                 Use a numeric value to represent the category (e.g., 1 for vegetables, 2 for meats, etc.).
     *                 The category value should correspond to the values returned by the getIngredientCategory method.
     */
    public void displayIngredientsByCategory(int category) {
        System.out.println("Ingredients in Category " + category + ":");
        for (Slot slot : ingredients) {
            if (getIngredientCategory(slot.getSides().getName()) == category) {
                System.out.format("|Slot %d: %s [%d pesos] [%d calories] [%d left]%n",
                        slot.getSlotNo(), slot.getSides().getName(), slot.getPrice(), slot.getSides().getCalories(), slot.getSupply());
            }
        }
    }

    /**
     * Gets the category of an ingredient based on its name.
     * If the ingredient name contains "Sauce," it is categorized as 1.
     * If it contains "Crust," it is categorized as 2.
     * If it contains "Cheese," it is categorized as 3.
     * If it contains "Meat," it is categorized as 4.
     * If it contains "Fruit," it is categorized as 5.
     * If it contains "Vegetable," it is categorized as 6.
     * For any other ingredient names that do not match any of the specified categories, the method returns 0.
     *
     * @param ingredientName The name of the ingredient whose category needs to be determined.
     * @return The numeric category value of the ingredient. See the documentation for the specific category values.
     *
    */
    public int getIngredientCategory(String ingredientName) {
        if (ingredientName.contains("Sauce")) {
            return 1;
        } else if (ingredientName.contains("Crust")) {
            return 2;
        } else if (ingredientName.contains("Cheese")) {
            return 3;
        } else if (ingredientName.contains("Meat")) {
            return 4;
        } else if (ingredientName.contains("Fruit")) {
            return 5;
        } else if (ingredientName.contains("Vegetable")) {
            return 6;
        } else {
            return 0; 
        }
    }

    /**
     * Checks if the provided choice of ingredient is valid within the specified category.
     * The method validates if the given choice is within the range of available ingredients.
     * If the choice is valid, it further checks whether the selected ingredient belongs to the specified category.
     *
     * @param choice   The user's choice of ingredient, represented as a numeric value (e.g., 1 for the first ingredient).
     * @param category The category of ingredients to validate against.
     *                 Use a numeric value to represent the category (e.g., 1 for vegetables, 2 for meats, etc.).
     *                 The category value should correspond to the values returned by the getIngredientCategory method.
     * @return true if the choice is valid and belongs to the specified category, false otherwise.
     */
    public boolean isValidIngredientChoice(int choice, int category) {
        if (choice >= 1 && choice <= ingredients.size()) {
            Slot selectedSlot = ingredients.get(choice - 1);
            return getIngredientCategory(selectedSlot.getSides().getName()) == category;
        }
        return false;
    }

    /**
     * Retrieves the lowest price among all slots in the vending machine.
     * 
     * @return the lowest price
     */
    public int getLowestMenuPrice() {
        int lowest = Integer.MAX_VALUE;
        for (Meal meal : this.menu) {
            if (meal.getTotalPrice() < lowest) {
                lowest = meal.getTotalPrice();
            }
        }
        return lowest;
    }
    /**
     * 
     * @return The menu list
     */
    public List<Meal> getMenu(){
        return this.menu;
    }

}

