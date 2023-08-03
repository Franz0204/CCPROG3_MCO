package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialOrderController class handles user interactions and actions related to special orders in the vending machine.
 * It listens to the buttons in the SpecialOrderView and performs actions accordingly.
 */
public class SpecialOrderController {
    private SpecialOrderView view;
    private SpecialVendingMachine model2;

    /**
     * Creates a new SpecialOrderController and initializes the SpecialOrderView.
     * It sets action listeners for the buttons in the view.
     */
    public SpecialOrderController() {
        model2 = new SpecialVendingMachine(null);
        view = new SpecialOrderView();
        view.setOrderFromMenuButtonListener(new OrderFromMenuButtonListener());
        view.setCustomOrderButtonListener(new CustomOrderButtonListener());
        view.setExitButtonListener(new ExitButtonListener());
    }

    /**
     * ActionListener for the "Order from Menu" button in the SpecialOrderView.
     * It handles the action when the button is clicked and shows the MenuOptionsView for ordering from the menu.
     */
    private class OrderFromMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuOptionsView menuOptionsView = new MenuOptionsView();
            MenuOptionsController menuOptionsController = new MenuOptionsController(model2, menuOptionsView);
            view.closeFrame();
        }
    }

    /**
     * ActionListener for the "Custom Order" button in the SpecialOrderView.
     * It handles the action when the button is clicked and closes the current view.
     */
    private class CustomOrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.closeFrame();
        }
    }

    /**
     * ActionListener for the "Exit" button in the SpecialOrderView.
     * It handles the action when the button is clicked and returns to the main menu view.
     */
    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model2 = new SpecialVendingMachine("Special Vending Machine");
            SpecialMainMenuView specialMainMenuView = new SpecialMainMenuView();
            SpecialMainMenuController specialMainMenuController = new SpecialMainMenuController(model2, specialMainMenuView);
        }
    }
}
