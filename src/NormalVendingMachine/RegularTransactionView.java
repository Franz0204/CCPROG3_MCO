package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;

/**
 * The RegularTransactionView class represents the GUI view for the regular vending machine's transaction process.
 * It displays the available slots, buttons for adding money and canceling the transaction, and the current money display.
 */
public class RegularTransactionView {
    private JFrame frame;
    private JButton[] slotButtons;
    private JLabel displayLabel;
    private JButton addMoneyButton;
    private JButton cancelTransactionButton;

    /**
     * Creates a new RegularTransactionView to display the transaction GUI for the regular vending machine.
     * Initializes and sets up the GUI components.
     */
    public RegularTransactionView() {
        initialize();
    }

    /**
     * Initializes and sets up the GUI components of the RegularTransactionView.
     * Creates the main frame, buttons for each slot, display label, add money button, and cancel transaction button.
     */
    private void initialize() {
        frame = new JFrame("Regular Vending Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));

        slotButtons = new JButton[8];
        for (int i = 0; i < slotButtons.length; i++) {
            slotButtons[i] = new JButton("Slot " + (i + 1));
            buttonPanel.add(slotButtons[i]);
        }

        displayLabel = new JLabel("Insert Money:", SwingConstants.CENTER);

        addMoneyButton = new JButton("Add Money");
        cancelTransactionButton = new JButton("Cancel Transaction");

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(addMoneyButton);
        bottomPanel.add(cancelTransactionButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(displayLabel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    /**
     * Displays an input dialog for adding money to the vending machine.
     *
     * @param currentAmount The current total amount of money inserted by the client.
     * @return The amount to add as an integer, or -1 if the input is invalid.
     */
    public int showAddMoneyInputDialog(int currentAmount) {
        String inputAmount = JOptionPane.showInputDialog(frame, "Enter the amount to add (in pesos):",
                "Add Money", JOptionPane.QUESTION_MESSAGE);
        try {
            int amountToAdd = Integer.parseInt(inputAmount);
            return amountToAdd;
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    /**
     * Displays a receipt message in a dialog with details of the purchased item and transaction.
     *
     * @param slotNumber The slot number of the purchased item.
     * @param itemName   The name of the purchased item.
     * @param quantity   The quantity of the purchased item.
     * @param totalCost  The total cost of the purchase in pesos.
     * @param change     The change returned to the client in pesos.
     * @param supply     The remaining supply of the purchased item in the slot.
     */
    public void displayReceipt(int slotNumber, String itemName, int quantity, int totalCost, int change, int supply) {
        String receiptMessage = "-------- Receipt --------\n"
                + "Item: " + itemName + "\n"
                + "Slot Number: " + slotNumber + "\n"
                + "Quantity: " + quantity + "\n"
                + "Supply: " + supply + "\n"
                + "Total Cost: " + totalCost + " pesos\n"
                + "Change: " + change + " pesos\n"
                + "-------------------------";

        JOptionPane.showMessageDialog(frame, receiptMessage, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Sets the display text to show the current state of the transaction or inserted money.
     *
     * @param message The message to be displayed.
     */
    public void setDisplay(String message) {
        displayLabel.setText(message);
    }

    /**
     * Retrieves an array of JButtons representing the slots in the regular vending machine.
     *
     * @return An array of JButtons for each slot in the vending machine.
     */
    public JButton[] getSlotButtons() {
        return slotButtons;
    }

    /**
     * Retrieves the "Add Money" JButton.
     *
     * @return The "Add Money" JButton.
     */
    public JButton getAddMoneyButton() {
        return addMoneyButton;
    }

    /**
     * Retrieves the "Cancel Transaction" JButton.
     *
     * @return The "Cancel Transaction" JButton.
     */
    public JButton getCancelTransactionButton() {
        return cancelTransactionButton;
    }

    /**
     * Closes the view's frame.
     */
    public void closeFrame() {
        frame.dispose();
    }
}
