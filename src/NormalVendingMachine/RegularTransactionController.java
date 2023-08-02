package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

/**
 * The RegularTransactionController class is responsible for handling the user interactions and business logic
 * related to the regular vending machine's transaction process.
 * It communicates with the RegularVendingMachine model and the RegularTransactionView to manage the transaction flow.
 */
public class RegularTransactionController {
    private RegularVendingMachine vendingMachine;
    private RegularTransactionView view;

    /**
     * Creates a new RegularTransactionController to manage the regular vending machine's transaction process.
     *
     * @param vendingMachine The RegularVendingMachine model representing the vending machine.
     */
    public RegularTransactionController(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.view = new RegularTransactionView();

        // ActionListener for the "Cancel Transaction" button
        this.view.getCancelTransactionButton().addActionListener(new CancelTransactionButtonListener());

        List<Slot> slots = vendingMachine.getSlots();

        // ActionListener for each slot button
        for (int i = 0; i < view.getSlotButtons().length; i++) {
            final int slotNumber = i + 1;

            Slot slot = slots.get(i);

            // Update the button text to include item name, price, and nutritional value
            String buttonText = String.format("<html>%s<br>Price: %d pesos<br>Calories: %d</html>",
                    slot.getSides().getName(), slot.getPrice(), slot.getSides().getCalories());
            view.getSlotButtons()[i].setText(buttonText);

            view.getSlotButtons()[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Perform actions for the selected slot
                    Slot slot = vendingMachine.chooseSlot(slotNumber);
                    if (slot != null) {
                        int price = slot.getPrice();

                        // Check if the client has sufficient balance
                        if (vendingMachine.getTotalInput() >= price) {
                            // Calculate change and receipt details before dispensing
                            int change = vendingMachine.getTotalInput() - price;
                            vendingMachine.dispenseProduct(slot);
                            vendingMachine.dispenseChange(change, new Client(vendingMachine.getName()));

                            // Print receipt
                            view.displayReceipt(slotNumber, slot.getSides().getName(), 1, price, change, slot.getSupply());

                            view.setDisplay("Insert Money: " + vendingMachine.getTotalInput() + " pesos");

                            // Reset inserted money to zero after successful transaction
                            vendingMachine.resetInput();
                        } else {
                            view.setDisplay("Insufficient balance!");
                        }
                    } else {
                        view.setDisplay("Invalid slot!");
                    }
                }
            });
        }

        // ActionListener for the "Add Money" button
        view.getAddMoneyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show input dialog to add money
                int currentAmount = vendingMachine.getTotalInput();
                int amountToAdd = view.showAddMoneyInputDialog(currentAmount);
                if (amountToAdd >= 0) {
                    vendingMachine.receiveUserMoney(new Client(vendingMachine.getName()), amountToAdd);
                    view.setDisplay("Insert Money: " + vendingMachine.getTotalInput() + " pesos");
                } else {
                    view.setDisplay("Invalid input. Please enter a valid amount.");
                }
            }
        });

        // ActionListener for the "Cancel Transaction" button
        view.getCancelTransactionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cancel the current transaction
                vendingMachine.cancelPurchase(new Client(vendingMachine.getName()));
                view.setDisplay("Transaction cancelled.");
            }
        });
    }

    /**
     * ActionListener for the "Cancel Transaction" button in the RegularTransactionView.
     * Performs necessary actions when the user cancels the transaction and returns to the main menu view.
     */
    private class CancelTransactionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Perform any necessary actions when canceling the transaction
            vendingMachine.cancelPurchase(new Client(vendingMachine.getName()));

            // Close the current RegularVendingMachineView
            view.closeFrame();

            // Show the MainMenuView again
            MainMenuView mainMenuView = new MainMenuView();
            MainMenuController mainMenuController = new MainMenuController(vendingMachine, mainMenuView);
        }
    }
}
