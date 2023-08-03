package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MainMenuController class is responsible for handling user interactions with the main menu view
 * and coordinating the actions with the underlying RegularVendingMachine model.
 * It listens for button clicks on the main menu view and performs the corresponding actions.
 */
public class MainMenuController {
    private RegularVendingMachine model;
    private MainMenuView view;

    /**
     * Creates a new MainMenuController with the given RegularVendingMachine model and MainMenuView view.
     *
     * @param model the RegularVendingMachine model associated with this controller
     * @param view  the MainMenuView associated with this controller
     */
    public MainMenuController(RegularVendingMachine model, MainMenuView view) {
        this.model = model;
        this.view = view;

        this.view.setTransactionButtonListener(new TransactionButtonListener());
        this.view.setMaintenanceButtonListener(new MaintenanceButtonListener());
        this.view.setExitButtonListener(new ExitButtonListener());
    }

    /**
     * ActionListener implementation for the transaction button in the main menu view.
     * Handles the action when the transaction button is clicked.
     */
    private class TransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Transaction button clicked");
            RegularVendingMachine vendingMachine = new RegularVendingMachine("Regular Vending Machine");
            RegularTransactionController controller = new RegularTransactionController(vendingMachine);
        }
    }

    /**
     * ActionListener implementation for the maintenance button in the main menu view.
     * Handles the action when the maintenance button is clicked.
     */
    public class MaintenanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MaintenanceOptionView maintenanceOptionView = new MaintenanceOptionView();
            MaintenanceOptionController maintenanceOptionController = new MaintenanceOptionController(model, maintenanceOptionView);
        }
    }

    /**
     * ActionListener implementation for the exit button in the main menu view.
     * Handles the action when the exit button is clicked.
     */
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }
}
