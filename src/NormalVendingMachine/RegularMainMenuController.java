package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularMainMenuController {
    private RegularVendingMachine model;
    private MainMenuView view;

    public RegularMainMenuController(RegularVendingMachine model, RegularMainMenuView view) {
        this.model = model;
        this.view = new MainMenuView();

        this.view.setTransactionButtonListener(new TransactionButtonListener());
        this.view.setMaintenanceButtonListener(new MaintenanceButtonListener());
        this.view.setExitButtonListener(new ExitButtonListener());
    }

    private class TransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Code to handle Transaction button click
            // Replace this with the logic to show the transaction frame
            System.out.println("Transaction button clicked");
            RegularVendingMachine vendingMachine = new RegularVendingMachine("Regular Vending Machine");
            RegularTransactionController controller = new RegularTransactionController(vendingMachine);
    }
        }

    // ActionListener for the maintenance button
    public class MaintenanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the maintenance button action here
            // Open the MaintenanceOptionView for maintenance options
            MaintenanceOptionView maintenanceOptionView = new MaintenanceOptionView();
            MaintenanceOptionController maintenanceOptionController = new MaintenanceOptionController(model, maintenanceOptionView);
        }
    }


    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exiting the program...");
            VendingMachineSelectionController controller = new VendingMachineSelectionController();
        }
    }
}