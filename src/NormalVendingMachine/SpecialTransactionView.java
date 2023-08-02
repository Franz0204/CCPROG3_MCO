package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;

public class SpecialTransactionView {
    private JFrame frame;
    private JButton[] slotButtons;
    private JLabel displayLabel;
    private JButton addMoneyButton;
    private JButton cancelTransactionButton;


    public SpecialTransactionView() {
        initialize();
    }

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

    // Add a new method to display an input dialog for adding money
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

    public void displayReceipt(int slotNumber, String itemName, int quantity, int totalCost, int change, int supply) {
        String receiptMessage = "-------- Receipt --------\n"
                + "Item: " + itemName + "\n"
                + "Slot Number: " + slotNumber + "\n"
                + "Quantity: " + quantity + "\n"
                + "Supply:" + supply + "\n"
                + "Total Cost: " + totalCost + " pesos\n"
                + "Change: " + change + " pesos\n"
                + "-------------------------";

        JOptionPane.showMessageDialog(frame, receiptMessage, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setDisplay(String message) {
        displayLabel.setText(message);
    }

    public JButton[] getSlotButtons() {
        return slotButtons;
    }

    public JButton getAddMoneyButton() {
        return addMoneyButton;
    }

    public JButton getCancelTransactionButton() {
        return cancelTransactionButton;
    }

    public void closeFrame() {
        frame.dispose();
    }

}
