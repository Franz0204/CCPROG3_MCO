package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialMainMenuController class represents the controller for the special vending machine's main menu view.
 * It handles user interactions with the main menu buttons, such as the transaction button, maintenance button, and exit button.
 */
public class SpecialMainMenuController {
    private SpecialVendingMachine model;
    private SpecialMainMenuView view;

    /**
     * Creates a new SpecialMainMenuController with the specified model and view.
     *
     * @param model The SpecialVendingMachine model to interact with.
     * @param view  The SpecialMainMenuView to handle user interactions with the main menu buttons.
     */
    public SpecialMainMenuController(SpecialVendingMachine model, SpecialMainMenuView view) {
        this.model = model;
        this.view = view;

        // Set action listeners for the main menu buttons
        this.view.setTransactionButtonListener(new TransactionButtonListener());
        this.view.setMaintenanceButtonListener(new MaintenanceButtonListener());
        this.view.setExitButtonListener(new ExitButtonListener());
    }

    /**
     * ActionListener for the transaction button.
     * This method is executed when the transaction button is clicked.
     * Replace the default logic with the actual implementation to show the transaction frame.
     */
    private class TransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Transaction button clicked");
            // TODO: Implement the logic to show the transaction frame for special vending machine.
             SpecialVendingMachine vendingMachine = new SpecialVendingMachine("Special Vending Machine");
             SpecialOrderController controller = new SpecialOrderController();
        }
    }

    /**
     * ActionListener for the maintenance button.
     * This method is executed when the maintenance button is clicked.
     * Replace the default logic with the actual implementation to handle the maintenance button action.
     * Open the MaintenanceOptionView for maintenance options.
     */
    public class MaintenanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Maintenance button clicked");
            // TODO: Implement the logic to handle the maintenance button action.
            // Open the MaintenanceOptionView for maintenance options.
            // MaintenanceOptionView maintenanceOptionView = new MaintenanceOptionView();
            // MaintenanceOptionController maintenanceOptionController = new MaintenanceOptionController(model, maintenanceOptionView);
        }
    }

    /**
     * ActionListener for the exit button.
     * This method is executed when the exit button is clicked.
     * Replace the default logic with the actual implementation to exit the program or navigate to the vending machine selection view.
     */
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exiting the program...");
            // TODO: Implement the logic to exit the program or navigate to the vending machine selection view.
            VendingMachineSelectionController controller = new VendingMachineSelectionController();
        }
    }
}
