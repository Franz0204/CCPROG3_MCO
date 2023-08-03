package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The MenuOptionsView class represents the graphical user interface (GUI) view for menu options in the Special Vending Machine.
 * It displays the available menu items in a combo box and provides buttons for adding money, making a purchase, and canceling a transaction.
 */
public class MenuOptionsView {
    private JFrame frame;
    private JComboBox<String> menuItemsComboBox;
    private JButton addMoneyButton;
    private JButton makePurchaseButton;
    private JButton cancelTransactionButton;
    private JLabel displayLabel;
    /**
     * Creates a new MenuOptionsView with the default frame title and sets up the GUI components.
     */
    public MenuOptionsView() {
        frame = new JFrame("Menu Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("|------ Menu Options ------|");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(255, 0, 40));
        topPanel.add(titleLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuItemsComboBox = new JComboBox<>();
        centerPanel.add(menuItemsComboBox);
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        addMoneyButton = new JButton("Add Money");
        makePurchaseButton = new JButton("Make Purchase");
        cancelTransactionButton = new JButton("Cancel Transaction");
        bottomPanel.add(addMoneyButton);
        bottomPanel.add(makePurchaseButton);
        bottomPanel.add(cancelTransactionButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        displayLabel = new JLabel("Insert Money:", SwingConstants.CENTER);
        frame.add(displayLabel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    /**
     * Sets the menu items in the combo box based on the provided list of menu items.
     *
     * @param menuItems The list of menu items to be displayed in the combo box.
     */
    public void setMenuItems(List<String> menuItems) {
        menuItemsComboBox.removeAllItems();
        for (String menuItem : menuItems) {
            menuItemsComboBox.addItem(menuItem);
        }
    }
        /**
     * Adds meals to the menu items combo box.
     *
     * @param meals The list of meals to be added to the combo box.
     */
    public void addMealsToComboBox(List<Meal> meals) {
        menuItemsComboBox.removeAllItems();
        for (Meal meal : meals) {
            menuItemsComboBox.addItem(meal.getName());
        }
    }
    int currentAmount = 0;
    public void setAddMoneyButtonListener(ActionListener listener) {
        addMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask the user to input the amount to add
                String inputAmount = JOptionPane.showInputDialog(frame, "Enter the amount to add (in pesos):",
                        "Add Money", JOptionPane.QUESTION_MESSAGE);

                try {
                    // Parse the input amount and add it to the current amount
                    int amountToAdd = Integer.parseInt(inputAmount);
                    currentAmount =+ amountToAdd;
                    // Update the display label to show the current amount
                    displayLabel.setText("Insert Money: " + currentAmount + " pesos");
                } catch (NumberFormatException ex) {
                    // Handle invalid input (e.g., non-numeric input)
                    showErrorMessage("Invalid input. Please enter a valid amount.");
                }
            }
        });
    }
    public void updateDisplayLabel() {
        displayLabel.setText("Insert Money: " + currentAmount + " pesos");
    }
/**
    * Sets the ActionListener for the "Make Purchase" button in the view.
    *
    * @param listener The ActionListener to be set for the "Make Purchase" button.
    */
    public void setMakePurchaseButtonListener(ActionListener listener) {
        makePurchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected menu item from the combo box
                String selectedMenuItem = (String) menuItemsComboBox.getSelectedItem();
                if (selectedMenuItem == null || selectedMenuItem.isEmpty()) {
                    // If no item is selected, show an error message
                    showErrorMessage("Please select a menu item before making a purchase.");
                } else {
                    // Call the listener to handle the "Make Purchase" button action
                    listener.actionPerformed(e);

                                
                }
            }
        });
    }

    public void printReceipt(String itemName, int totalCost, int change) {
        String receiptMessage = "-------- Receipt --------\n"
                + "Item: " + itemName + "\n"
                + "Total Cost: " + totalCost + " pesos\n"
                + "Change: " + change + " pesos\n"
                + "-------------------------";

        JOptionPane.showMessageDialog(frame, receiptMessage, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Sets the ActionListener for the "Cancel Transaction" button in the view.
     *
     * @param listener The ActionListener to be set for the "Cancel Transaction" button.
     */
    public void setCancelTransactionButtonListener(ActionListener listener) {
        cancelTransactionButton.addActionListener(listener);
    }
    /**
     * Gets the selected menu item from the combo box.
     *
     * @return The selected menu item as a String.
     */
    public String getSelectedMenuItem() {
        return (String) menuItemsComboBox.getSelectedItem();
    }

    /**
     * Displays an error message in a dialog box with the specified message.
     *
     * @param message The error message to be displayed.
     */
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message in a dialog box with the specified message.
     *
     * @param message The success message to be displayed.
     */
    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays an input dialog box to prompt the user for the amount of money to be added.
     *
     * @return The amount of money to be added as an integer, or -1 if the input is invalid.
     */
    public int showAddMoneyInputDialog() {
        String inputAmount = JOptionPane.showInputDialog(frame, "Enter the amount to add (in pesos):",
                "Add Money", JOptionPane.QUESTION_MESSAGE);
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int amount) {
        currentAmount = amount;
    }
}
