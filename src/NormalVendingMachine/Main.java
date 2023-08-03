package NormalVendingMachine;

public class Main {
    public static void main(String[] args) {
         RegularVendingMachine model = new RegularVendingMachine("My Vending Machine");

         NameView nameView = new NameView();
         NameController nameController = new NameController(model, nameView);

         while (!nameController.isNameEntered()) {
             try {
             Thread.sleep(1000); 
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

        VendingMachineSelectionView VendingMachineSelectionView = new VendingMachineSelectionView();
        VendingMachineSelectionController controller = new VendingMachineSelectionController();
    }
}

