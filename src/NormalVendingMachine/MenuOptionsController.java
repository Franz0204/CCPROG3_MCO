package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// import javax.swing.JOptionPane;

/**
 * The MenuOptionsController class is responsible for handling user interactions with the menu options view
 * in the Special Vending Machine.
 * It connects the GUI view (MenuOptionsView) with the model (SpecialVendingMachine) and implements the logic for
 * handling actions such as adding money, making a purchase, and canceling a transaction.
 */
public class MenuOptionsController {
    private SpecialVendingMachine model;
    private MenuOptionsView view;

    /**
     * Creates a new MenuOptionsController with the provided SpecialVendingMachine model and MenuOptionsView view.
     *
     * @param model The SpecialVendingMachine model representing the vending machine.
     * @param view  The MenuOptionsView representing the GUI view for menu options.
     * 
     */
    public MenuOptionsController(SpecialVendingMachine model, MenuOptionsView view) {
        this.model = model;
        this.view = view;
        
        // Get the list of meals from the SpecialVendingMachine model
        List<Meal> meals = model.getMenu();
        
        // Pass the list of meals to the MenuOptionsView to add them to the combo box
        view.addMealsToComboBox(meals);
        
        // Display the pre-made menu items in the combo box
        updateMenuItemsComboBox();

        view.setAddMoneyButtonListener(new AddMoneyButtonListener());
        view.setMakePurchaseButtonListener(new MakePurchaseButtonListener());
        view.setCancelTransactionButtonListener(new CancelTransactionButtonListener());
    }

    /**
     * Updates the menu items combo box in the view based on the menu items available in the model.
     */
    private void updateMenuItemsComboBox() {
        List<String> menuItems = new ArrayList<>();
        for (Meal meal : model.getMenu()) {
            menuItems.add(meal.getName());
        }
        view.setMenuItems(menuItems);
    }

    /**
     * ActionListener for the "Add Money" button in the view.
     */
    private class AddMoneyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the "Add Money" button action here
            // Implement your logic here to add money to the current amount
            int amountToAdd = view.showAddMoneyInputDialog(); // Get the amount to add from the user
            if (amountToAdd > 0) {
                model.addMoney(amountToAdd); // Add the entered amount to the model (SpecialVendingMachine)
                view.setCurrentAmount(model.getCurrentAmount()); // Update the current amount in the view
            } else {
                view.showErrorMessage("Invalid amount. Please enter a valid amount.");
            }
        }
    }   

    /**
     * ActionListener for the "Make Purchase" button in the view.
     */
    private class MakePurchaseButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedMenuItem = view.getSelectedMenuItem();
            if (selectedMenuItem == null) {
                view.showErrorMessage("Please select a menu item.");
                return;
            }

            Meal chosenMeal = null;
            for (Meal meal : model.getMenu()) {
                if (meal.getName().equals(selectedMenuItem)) {
                    chosenMeal = meal;
                    break;
                }
            }

            if (chosenMeal == null) {
                view.showErrorMessage("Selected menu item not found.");
                return;
            }

            int clientBalance = model.getTotalInput();
            int itemPrice = chosenMeal.getTotalPrice();

            if (clientBalance < itemPrice) {
                view.showErrorMessage("Insufficient balance. Please add more money.");
            } else {
                int change = clientBalance - itemPrice;
                model.dispenseMeal(chosenMeal);
                model.dispenseChange(change, null);
                model.printReceipt(clientBalance, itemPrice, change, null);
                view.showSuccessMessage("Purchase successful! Enjoy your meal.");
            }
        }
    }

    private class CancelTransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the "Cancel Transaction" button action here
            SpecialOrderView specialOrderView = new SpecialOrderView();
            SpecialOrderController specialOrderController = new SpecialOrderController();
        }
    }

}