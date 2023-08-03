package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MaintenanceOptionController class is responsible for handling user actions and events in the maintenance options view.
 * It provides event listeners for various maintenance actions such as restocking, setting slot price, replenishing money, withdrawing money, checking money, displaying items, and returning to the main menu.
 */
public class MaintenanceOptionController {
    private RegularVendingMachine model;
    private MaintenanceOptionView view;

    /**
     * Creates a new MaintenanceOptionController with the specified model and view.
     * This constructor sets up action listeners for various maintenance buttons in the MaintenanceOptionView.
     *
     * @param model the RegularVendingMachine model that contains the vending machine data
     * @param view  the MaintenanceOptionView representing the maintenance options GUI
     */
    public MaintenanceOptionController(RegularVendingMachine model, MaintenanceOptionView view) {
        this.model = model;
        this.view = view;

        // Adding action listeners for the maintenance options buttons
        this.view.getRestockButton().addActionListener(new RestockButtonListener());
        this.view.getSetSlotPriceButton().addActionListener(new SetSlotPriceButtonListener());
        this.view.getReplenishMoneyButton().addActionListener(new ReplenishMoneyButtonListener());
        this.view.getWithdrawMoneyButton().addActionListener(new WithdrawMoneyButtonListener());
        this.view.getCheckMoneyButton().addActionListener(new CheckMoneyButtonListener());
        this.view.getDisplayItemsButton().addActionListener(new DisplayItemsButtonListener());
        this.view.getReturnToMainMenuButton().addActionListener(new ReturnToMainMenuButtonListener());
    }

    /**
     * ActionListener for the restock button in the maintenance options view.
     * This listener is called when the restock button is clicked.
     * It performs actions for restocking slots in the vending machine.
     */
    private class RestockButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for restocking
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the set slot price button in the maintenance options view.
     * This listener is called when the set slot price button is clicked.
     * It performs actions for setting prices for slots in the vending machine.
     */
    private class SetSlotPriceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for setting slot price
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the replenish money button in the maintenance options view.
     * This listener is called when the replenish money button is clicked.
     * It performs actions for replenishing money in the vending machine.
     */
    private class ReplenishMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for replenishing money
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the withdraw money button in the maintenance options view.
     * This listener is called when the withdraw money button is clicked.
     * It performs actions for withdrawing money from the vending machine.
     */
    private class WithdrawMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for withdrawing money
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the check money button in the maintenance options view.
     * This listener is called when the check money button is clicked.
     * It performs actions for checking the current money in the vending machine.
     */
    private class CheckMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for checking money
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the display items button in the maintenance options view.
     * This listener is called when the display items button is clicked.
     * It performs actions for displaying items and their details in the vending machine.
     */
    private class DisplayItemsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform actions for displaying items
            // Implement your logic here
        }
    }

    /**
     * ActionListener for the return to main menu button in the maintenance options view.
     * This listener is called when the return to main menu button is clicked.
     * It closes the current MaintenanceOptionsView and shows the MainMenuView again.
     */
    private class ReturnToMainMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close the current MaintenanceOptionsView


            // Show the MainMenuView again
            MainMenuView mainMenuView = new MainMenuView();
            MainMenuController mainMenuController = new MainMenuController(model, mainMenuView);
        }
    }
}
