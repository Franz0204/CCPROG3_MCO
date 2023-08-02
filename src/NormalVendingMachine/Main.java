package NormalVendingMachine;

public class Main {
    public static void main(String[] args) {
        RegularVendingMachine model = new RegularVendingMachine("My Vending Machine");

        NameView nameView = new NameView();
        NameController nameController = new NameController(model, nameView);

        // Wait until the user enters the name and clicks submit
        while (!nameController.isNameEntered()) {
            try {
                Thread.sleep(1000); // Wait for a short duration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Once the user enters the name, show the MainMenuView
        VendingMachineSelectionView VendingMachineSelectionView = new VendingMachineSelectionView();
        VendingMachineSelectionController controller = new VendingMachineSelectionController();

        
    }
}

