package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialVendingMachineController class is responsible for handling user interactions with the SpecialVendingMachineMenuView.
 * It listens for button clicks on the view and performs the corresponding actions for the Transaction, Maintenance, and Exit buttons.
 */
public class SpecialVendingMachineController {

    private SpecialVendingMachineMenuView view;
    private SpecialVendingMachine model;

    /**
     * Creates a new SpecialVendingMachineController with the provided SpecialVendingMachineMenuView and SpecialVendingMachine model.
     * @param view The SpecialVendingMachineMenuView to be controlled by this controller.
     * @param model The SpecialVendingMachine model representing the vending machine.
     */
    public SpecialVendingMachineController(SpecialVendingMachineMenuView view, SpecialVendingMachine model) {
        this.view = view;
        this.model = model;

        // Add action listener for the Transaction button
        view.getTransactionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransactionButtonClick();
            }
        });

        // Add action listener for the Maintenance button
        view.getMaintenanceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleMaintenanceButtonClick();
            }
        });

        // Add action listener for the Exit button
        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExitButtonClick();
            }
        });
    }

    /**
     * Handles the action when the Transaction button is clicked.
     * It should contain the logic for processing transactions in the vending machine.
     */
    private void handleTransactionButtonClick() {
        // Your code here for transaction logic
    }

    /**
     * Handles the action when the Maintenance button is clicked.
     * It should contain the logic for accessing and managing maintenance options for the vending machine.
     */
    private void handleMaintenanceButtonClick() {
        // Your code here for maintenance logic
    }

    /**
     * Handles the action when the Exit button is clicked.
     * It exits the program by terminating the Java Virtual Machine.
     */
    private void handleExitButtonClick() {
        System.exit(0);
    }
}
