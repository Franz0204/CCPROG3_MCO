package NormalVendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegularVendingMachine {
    
    private String name;
    private List<Slot> slots;
    private List<Money> money; 
    private List<Money> input;

    /**
     * Constructs a RegularVendingMachine object with the specified name.
     * Initializes the slots, money, and input lists.
     * Also adds a pre-made list of money denominations with quantity 10.
     *
     * @param name the name of the vending machine
     */
    public RegularVendingMachine(String name) {
        this.name = name;
        this.slots = new ArrayList<>();
        this.money = new ArrayList<>();
        this.input = new ArrayList<>();

        // Add pre-made list of money (1000, 500, 100, 50, 20, 10, 5, 1) with quantity 10
        List<Integer> denominations = List.of(1000, 500, 100, 50, 20, 10, 5, 1);
        for (int denomination : denominations) {
            Money money = new Money(String.valueOf(denomination), denomination, 10);
            this.money.add(money);
        }
        // adding regular sides
        Sides frenchFries = new Sides("French Fries", 200);
        Sides onionRings = new Sides("Onion Rings", 300);
        Sides mozzarellaSticks = new Sides("Mozzarella Sticks", 400);
        Sides salad = new Sides("Fresh Salad", 150);
        Sides soda = new Sides("Soda", 200);
        Sides chickenTenders = new Sides("Chicken Tenders", 350);
        Sides garlicBread = new Sides("Garlic Bread", 250);
        Sides iceCream = new Sides("Ice Cream", 500);

        addSlot(frenchFries, 50, true, 10,slots);
        addSlot(onionRings, 70, true, 5,slots);
        addSlot(mozzarellaSticks, 90, true, 8,slots);
        addSlot(salad, 105, true, 10,slots);
        addSlot(soda, 30, true, 5,slots);
        addSlot(chickenTenders, 140, true, 5,slots);
        addSlot(garlicBread, 80, true, 7,slots);
        addSlot(iceCream, 50, true, 4,slots);
    }

    /**
    * Adds a slot to the vending machine with the specified parameters.
    * 
    * @param sides the sides of the slot
    * @param price the price of the slot
    * @param availability the availability of the slot
    * @param supply the supply of the slot
    * @return true if the slot is successfully added, false otherwise
    */
    public boolean addSlot(Sides sides, int price, boolean availability, int supply, List<Slot> slots){
        if (sides.getName() != null){
            int slotNum = slots.size() + 1;
            Slot slot = new Slot(sides, price, availability, slotNum, supply);
            slots.add(slot);
            return true;
        }
        else return false;
    }

    /**
    * Adds a slot to the vending machine with the specified parameters.
    * 
    * @param sides the sides of the slot
    * @param price the price of the slot
    * @param supply the supply of the slot
    * @return true if the slot is successfully added, false otherwise
    */
    public boolean addSlot(Sides sides, int price, int supply, List<Slot> slots){
        if (sides.getName() != null){
            int slotNum = slots.size() + 1;
            Slot slot = new Slot(sides, price, slotNum, supply);
            slots.add(slot);
            return true;
        }
        else return false;
    }
    
    /**
    * Removes the slot with the specified slot number from the vending machine.
    * 
    * @param slotNo the slot number of the slot to be removed
    * @return true if the slot is successfully removed, false otherwise
    */
    public boolean removeSlot(int slotNo){
        
        if (slotNo > 0 && slotNo <= slots.size() + 1){
            slotNo -= 1;
            slots.remove(slotNo);
            return true;
        }
        else return false;
    }

    /**
    * Creates a new client with the specified name.
    * 
    * @param name the name of the client
    * @return a new Client object
    */
     public Client newClient(String name) {
        Client client = new Client(name);
        return client;
    }

    /**
    * Displays the items available in the vending machine.
    * Prints the slot number, item name, price, and calories for each item.
    */
    public void displayItems(){
        System.out.println("---------------------------------------------------------------");
        for (Slot slot : slots){
            System.out.format("|Slot %d: %s [%d pesos] [%d calories] [%d left]%n",slot.getSlotNo() ,slot.getSides().getName(), 
                slot.getPrice(), slot.getSides().getCalories(), slot.getSupply());
        }
        System.out.println("---------------------------------------------------------------");
    }

    /**
     * Receives user's money and adds it to the vending machine's input.
     * 
     * @param client the client making the payment
     * @param input the amount of money being inserted (-1 to indicate payment is done)
     * @return true if the money is successfully received, false otherwise
     */
    public boolean receiveUserMoney(Client client, int input) {
        Money insert = null;
        int value = 0;

        if (input == -1) {
            System.out.println("Done Paying");
            return false;
        }

        switch (input) {
            case 1000:
                value = 1000;
                break;
            case 500:
                value = 500;
                break;
            case 100:
                value = 100;
                break;
            case 50:
                value = 50;
                break;
            case 20:
                value = 20;
                break;
            case 10:
                value = 10;
                break;
            case 5:
                value = 5;
                break;
            case 1:
                value = 1;
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                return false;
        }

        for (Money m : client.getWallet()) {
            if (m.getValue() == value && m.getQuantity() > 0) {
                insert = m;
                this.input.add(m);
                m.setQuantity(m.getQuantity() - 1);
                break;
            }
        }

        if (insert == null) {
            System.out.println("Not enough money");
            return false;
        }

        // Create a copy of the input list
        List<Money> inputCopy = new ArrayList<>(this.input);

        // Add all the same types of money to the money list
        for (Money m : inputCopy) {
            if (m.getValue() == value) {
                for (Money existingMoney : money) {
                    if (existingMoney.getValue() == value) {
                        existingMoney.setQuantity(existingMoney.getQuantity() + 1);
                        break;
                    }
                }
            }
        }

        return true;
    }

    /**
     * Chooses a slot from the vending machine based on the slot number and the client's balance.
     * 
     * @param slotNo the slot number of the chosen slot
     * @return the chosen Slot object, or null if no suitable slot is found
     */
    public Slot chooseSlot(int slotNo) {
        int clientBalance = getTotalInput();

        for (Slot slot : this.slots) {
            if (slot.getSlotNo() == slotNo && slot.getPrice() <= clientBalance) {
                return slot;
            }
        }
        return null;
    }

    /**
     * Dispenses change to the client after a successful transaction.
     * 
     * @param change the amount of change to be dispensed
     * @param recipient the client who will receive the change
     * @return true if the change is successfully dispensed, false otherwise
     */
    public boolean dispenseChange(int change, Client recipient) {
        int remainingChange = change;
        List<Integer> denominations = List.of(1000, 500, 100, 50, 20, 10, 5, 1);

        int totalMoney = getTotalMoney();

        if (remainingChange > totalMoney) {
            return false;
        }

        System.out.println("Change:");

        do {
            for (Integer denomination : denominations) {
                if (denomination <= remainingChange) {
                    for (Money j : money) {
                        if (denomination.equals(j.getValue()) && j.getQuantity() > 0) {
                            while (j.getValue() <= remainingChange && j.getQuantity() > 0) {
                                recipient.addToWallet(j.getValue());
                                j.setQuantity(j.getQuantity() - 1);
                                remainingChange -= j.getValue();
                                System.out.println(j.getValue() + " pesos");
                            }
                        }
                    }
                }
            }
        } while (remainingChange > 0);

        return true;
    }


    /**
     * Deducts supply from the chosen slot and runs another method to deduct the input list
     * 
     * @param slot slot to deduct supply from
     * @return true if the change is successfully dispensed, false otherwise
     */
    public void dispenseProduct(Slot slot) {
        if (slot != null && slot.getSides().getName() != null) {
            int price = slot.getPrice();
            slot.setSupply(slot.getSupply() - 1);
            slot.setNoSold(slot.getNoSold() + 1);
            deductFromInput(price);
        }
    }

    /**
     * Deducts the specified amount from the input money list.
     * 
     * @param amount the amount to deduct from the input
     */
    private void deductFromInput(int amount) {
        List<Money> toRemove = new ArrayList<>();
        for (Money money : this.input) {
            if (amount <= 0) {
                break;
            }
            if (money.getValue() <= amount) {
                amount -= money.getValue();
                toRemove.add(money);
            }
        }
        this.input.removeAll(toRemove);
    }

    /**
     * Prints a receipt for a purchase transaction.
     * 
     * @param slotNo the slot number of the purchased item
     * @param quantity the quantity of the purchased item
     * @param change the amount of change given to the client
     */
    public void printReceipt(int slotNo, int quantity, int change) {
        if (slotNo >= 1 && slotNo <= slots.size()) {
            Slot slot = slots.get(slotNo - 1);
            int total = slot.getPrice() * quantity;

            System.out.println("-------- Receipt --------");
            System.out.println("Item: " + slot.getSides().getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total: " + total + " pesos");
            System.out.println("Change: " + change + " pesos");
            System.out.println("--------------------------\n");
        }
    }
    /**
     * Retrieves the calories of an item from the specified slot.
     * 
     * @param slotNo the slot number of the item
     * @return the number of calories of the item
     */
    public int getCalories(int slotNo){
        return slots.get(slotNo).getSides().getCalories();
    }

    /**
     * Cancels the ongoing purchase and clears the input money list.
     * 
     * @param name the name of the client
     */
    public void cancelPurchase(Client name) {
        System.out.println("YOU HAVE CANCELLED THE TRANSACTION");
        input.clear();
    } 

    /**
     * Returns the number of slots in the vending machine.
     * 
     * @return the number of slots
     */
    public int slotCount(){
        return slots.size();
    }

    /**
     * Prints a sales report that includes information about each slot's sales and revenue.
     */
    public void salesReport(){
        int totalGained = 0;

        for (Slot slot : this.slots){
            int gained = slot.getNoSold() * slot.getPrice();
            int startingInventory = slot.getSupply() + slot.getNoSold();
            System.out.format("Slot: %d | Item: %s | Starting Inventory: %d | Current Supply: %d | Sold: %d | Gained: %d pesos%n", slot.getSlotNo(), slot.getSides().getName(),
                startingInventory, slot.getSupply(), slot.getNoSold(), gained);
            totalGained += gained;
        }
        System.out.format("<Total Gained: %d pesos>%n", totalGained);

        for (Slot slot : slots){
            slot.setNoSold(0);
        }
    }

    /**
     * Returns the total sum of the user input.
     * 
     * @return the total sum of the input list
     */
    public int getTotalInput(){
        int total = 0;
        for (Money m : this.input){
            total += m.getValue();
        }
        return total;
    }

    /**
     * Returns the total sum of the vending machines currency.
     * 
     * @return the total sum of the money list
     */
    public int getTotalMoney(){
        int total = 0;
        for (Money m : this.money){
            total += m.getValue() * m.getQuantity();
        }
        return total;
    }

    /**
     * Retrieves the lowest price among all slots in the vending machine.
     * 
     * @return the lowest price
     */
    public int getLowestSlotPrice() {
        int lowest = Integer.MAX_VALUE;
        for (Slot slot : this.slots) {
            if (slot.getPrice() < lowest) {
                lowest = slot.getPrice();
            }
        }
        return lowest;
    }

    /**
     * Displays the quantity of each type of currency in the vending machine.
     */
    public void checkMoney(){
        System.out.println("[Vending Machine Currency] ");
        for (Money m : this.money){
            System.out.format("[%s] quantity:%d%n", m.getName(), m.getQuantity());
        }
    }

    /**
     * Replenishes the quantity of a specific type of currency in the vending machine.
     * 
     * @param value the value of the currency to replenish
     * @param quantity the quantity to set for the currency
     */
    public void replenishMoney(int value, int quantity){
        for (Money m : this.money){
            if (m.getValue() ==  value){
                m.setQuantity(quantity);
            }
        }
    }

    /**
     * Withdraws money from the vending machine based on a certain percentage of the total money available.
     */
    public void withdrawMoney() {
        double gained = getTotalMoney() * 0.6;
        double copy = gained;

        List<Integer> denominations = List.of(1000, 500, 100, 50, 20, 10, 5, 1);
        do {
            for (Integer denomination : denominations) {
                if (denomination <= gained) {
                    for (Money j : money) {
                        if (denomination.equals(j.getValue()) && j.getQuantity() > 0) {
                            while (denomination <= gained && j.getQuantity() > 0) {
                                j.setQuantity(j.getQuantity() - 1);
                                gained -= denomination;
                                System.out.println("+[" + denomination + " pesos]\n");
                            }
                        }
                    }
                }
            }
        } while (gained > 0);
        System.out.println("Gained: " + copy + " pesos\n");
    }

    
    /**
     * Runs the vending machine program, consisting of the transaction process and maintenance.
     */
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
                    System.out.println("Hello Fellow Customer, Welcome To The <Regular Vending Machine>");
                    System.out.println("Here we serve various side dishes for <Pizza>");
                    System.out.println("---------------------------------------------------------------");
                    displayItems();
                    System.out.println("---------------------------------------------------------------");

                    int sentinel = 0;
                    List<Money> copy = null;

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

                            if (getTotalInput() < getLowestSlotPrice()) {
                                System.out.println("No items to afford. Please add more money or cancel the transaction.");
                            } else {
                                break;
                            }
                        } while (true);

                        copy = getInput();
                        Slot s = null;

                        do {
                            // Asks for a slot
                            System.out.println("Choose a slot:");
                            choice = scanner.nextInt();
                            Slot chosenSlot = chooseSlot(choice);
                            if (chosenSlot != null) {
                                s = chosenSlot;
                                break;
                            } else {
                                System.out.println("Invalid Slot");
                            }
                        } while (true);

                        int itemPrice = s.getPrice();

                        if (getTotalInput() < itemPrice) {
                            System.out.println("Insufficient change in the vending machine. Transaction cancelled.");
                            cancelPurchase(client);
                            scanner.close();
                            return;
                        }

                        System.out.println("<Dispensing Product>\n");
                        dispenseProduct(s);
                        System.out.println("Received " + s.getSides().getName() + "\n");

                        int change = getTotalInput() - itemPrice;
                        System.out.println("<Dispensing Change>\n");
                        dispenseChange(change, client);
                        printReceipt(choice, 1, change);
                        this.input.clear(); //removes current input, since change has been given
                        choice = 0;
                        do {
                            System.out.println("Do you wish to make another purchase? type 1 - yes | 0 - no");
                            choice = scanner.nextInt();
                            if (choice == 0) sentinel = 1;
                        } while ((choice != 1) && (choice != 0));
                    } while (sentinel == 0);

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
                                for (Slot slot : slots){
                                    System.out.format("Slot %d: [%d]%n", slot.getSlotNo(), slot.getSupply());
                                }
                                System.out.println("Enter slot number: ");
                                int slotNumber1 = scanner.nextInt();

                                if (slotNumber1 >= 1 && slotNumber1 <= this.slots.size()) {
                                    System.out.println("Enter quantity: ");
                                    int quantity = scanner.nextInt();
                                    boolean restocked = this.slots.get(slotNumber1 - 1).restock(quantity);

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

                                if (slotNumber2 >= 1 && slotNumber2 <= this.slots.size()) {
                                    System.out.println("Enter Price: ");
                                    int price = scanner.nextInt();
                                    this.slots.get(slotNumber2 - 1).setPrice(price);
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

                            case 6: // Display Items
                                displayItems();
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
     * Returns the name of the client.
     * @return the name of the client
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the users recieved money.
     * @return a the input list
     */
    public List<Money> getInput() {
        return this.input;
    }
    /**
     * Returns slots.
     * @return a copy of the input list
     */
    public List<Slot> getSlots() {
        return this.slots;
    }
    /**
     * Sets the name of the client.
     * @param name the name of the client
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Resets Input.
     */
    public void resetInput() {
        this.input.clear();
    }
}
