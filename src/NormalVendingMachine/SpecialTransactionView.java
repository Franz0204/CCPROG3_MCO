package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;

/**
 * The SpecialTransactionView class represents the view for displaying the special vending machine's transaction screen.
 * It provides buttons for the available slots, add money, cancel transaction, and displays transaction-related information.
 */
public class SpecialTransactionView {
    private JFrame frame;
    private JButton[] slotButtons;
    private JLabel displayLabel;
    private JButton addMoneyButton;
    private JButton cancelTransactionButton;

    /**
     * Creates a new SpecialTransactionView and initializes the user interface elements.
     */
    public SpecialTransactionView() {
        initialize();
    }

    /**
     * Initializes the user interface elements of the SpecialTransactionView.
     * It creates the JFrame and sets the button labels and layout.
     */
    private void initialize() {
        frame = new JFrame("Special Vending Machine - Transaction");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(4, 5));

        slotButtons = new JButton[36];
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
     * @param currentAmount The current total amount of money inserted by the client.
     * @return The amount of money to be added as entered by the client.
     *         Returns -1 if the input is invalid.
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
     * Displays the receipt of the transaction.
     * @param slotNumber The slot number of the selected item.
     * @param itemName The name of the selected item.
     * @param quantity The quantity of items purchased.
     * @param totalCost The total cost of the transaction.
     * @param change The amount of change given to the client.
     * @param supply The remaining supply of the item in the selected slot.
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
     * Sets the display message on the transaction screen.
     * @param message The message to be displayed on the screen.
     */
    public void setDisplay(String message) {
        displayLabel.setText(message);
    }

    /**
     * Gets the array of slot buttons on the transaction screen.
     * @return The array of slot buttons.
     */
    public JButton[] getSlotButtons() {
        return slotButtons;
    }

    /**
     * Gets the "Add Money" button on the transaction screen.
     * @return The "Add Money" button.
     */
    public JButton getAddMoneyButton() {
        return addMoneyButton;
    }

    /**
     * Gets the "Cancel Transaction" button on the transaction screen.
     * @return The "Cancel Transaction" button.
     */
    public JButton getCancelTransactionButton() {
        return cancelTransactionButton;
    }

    /**
     * Closes the SpecialTransactionView JFrame.
     */
    public void closeFrame() {
        frame.dispose();
    }
}
