import NormalVendingMachine.RegularVendingMachine;




public class App {

    public static void main(String[] args) {
   // /* 
        RegularVendingMachine vendingMachine = new RegularVendingMachine("My Vending Machine");

       //vendingMachine.transaction(); 
       //vendingMachine.maintenance();
       vendingMachine.runVendingMachine();
    //*/
    /*    
        // Create a RegularVendingMachine object
        RegularVendingMachine vendingMachine = new RegularVendingMachine("Vending Machine");
        Sides Chips = new Sides("Chips", 200);
        Sides onionRings = new Sides("Onion Rings", 300);
        // Test addSlot() method
        boolean slotAdded = vendingMachine.addSlot(Chips, 50,  10);
        vendingMachine.addSlot(onionRings, 70, true, 5);
        System.out.println("Slot added: " + slotAdded); // Expected output: true
        vendingMachine.displayItems();
        // Test removeSlot() method
        boolean slotRemoved = vendingMachine.removeSlot(2);
        System.out.println("Slot removed: " + slotRemoved); // Expected output: true
        vendingMachine.displayItems();
        // Test newClient() method
        Client client = vendingMachine.newClient("John");
        System.out.println("Client name: " + client.checkWallet()); // Expected output: "John"

        // Test displayItems() method
        vendingMachine.displayItems(); // Expected output: Slot 1: Chips [150 pesos] [200 calories]

        boolean slotAdded2 = vendingMachine.addSlot(Chips, 50, true, 10);
        System.out.println("Slot added: " + slotAdded2); // Expected output: true

        // Test receiveUserMoney() method
        boolean moneyReceived = vendingMachine.receiveUserMoney(client, 1000);
        System.out.println("Money received: " + moneyReceived); // Expected output: true

        vendingMachine.displayItems();

        // Test chooseSlot() method
        Slot chosenSlot = vendingMachine.chooseSlot(1);
        System.out.println("Chosen slot: " + vendingMachine.chooseSlot(1).getSides().getName()); // Expected output: "Chips"

        // Test dispenseChange() method
        boolean changeDispensed = vendingMachine.dispenseChange(1000000, client);
        System.out.println("Change dispensed: " + changeDispensed); // Expected output: true

        // Test dispenseProduct() method
        vendingMachine.dispenseProduct(chosenSlot);
        System.out.println("Slot supply: " + chosenSlot.getSupply()); // Expected output: 9

        // Test printReceipt() method
        vendingMachine.printReceipt(chosenSlot.getSlotNo(), 1, 0);
        // Expected output:
        // -------- Receipt --------
        // Item: Chips
        // Quantity: 1
        // Total: 150 pesos
        // Change: 0 pesos
        // --------------------------

        // Test getCalories() method
        int calories = vendingMachine.getCalories(chosenSlot.getSlotNo());
        System.out.println("Calories: " + calories); // Expected output: 200

        // Test cancelPurchase() method
        vendingMachine.cancelPurchase(client);
        System.out.println("Input size: " + vendingMachine.getTotalInput()); // Expected output: 0

        // Test slotCount() method
        int count = vendingMachine.slotCount();
        System.out.println("Slot count: " + count); // Expected output: 0

        // Test salesReport() method
        vendingMachine.salesReport(); // Expected output: (no output)

        // Test getTotalInput() method
        int totalInput = vendingMachine.getTotalInput();
        System.out.println("Total input: " + totalInput); // Expected output: 0

        // Test getTotalMoney() method
        int totalMoney = vendingMachine.getTotalMoney();
        System.out.println("Total money: " + totalMoney); // Expected output: 0

        // Test getLowestPrice() method
        int lowestPrice = vendingMachine.getLowestPrice();
        System.out.println("Lowest price: " + lowestPrice); // Expected output: Integer.MAX_VALUE
        */ 
    }
}
