package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
     * @throws IllegalArgumentException if the model is null.
     */
    public MenuOptionsController(SpecialVendingMachine model, MenuOptionsView view) {
        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null.");
        }

        this.model = model;
        this.view = view;

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
            int amountToAdd = view.showAddMoneyInputDialog();
            if (amountToAdd > 0) {
                model.checkMoney();
                view.showSuccessMessage("Successfully added " + amountToAdd + " pesos.");
            } else if (amountToAdd == 0) {
                view.showErrorMessage("Please enter a valid amount to add.");
            } else {
                view.showErrorMessage("Invalid amount. Please enter a positive integer.");
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
                model.printReceipt(chosenMeal.getMenuNo(), 1, change);
                view.showSuccessMessage("Purchase successful! Enjoy your meal.");
            }
        }
    }

    /**
     * ActionListener for
