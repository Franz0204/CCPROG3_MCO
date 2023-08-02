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
    private SpecialVendingMachine model;
    private JFrame frame;
    private JComboBox<String> menuItemsComboBox;
    private JButton addMoneyButton;
    private JButton makePurchaseButton;
    private JButton cancelTransactionButton;

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
     * Sets the ActionListener for the "Add Money" button in the view.
     *
     * @param listener The ActionListener to be set for the "Add Money" button.
     */
    public void setAddMoneyButtonListener(ActionListener listener) {
        addMoneyButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the "Make Purchase" button in the view.
     *
     * @param listener The ActionListener to be set for the "Make Purchase" button.
     */
    public void setMakePurchaseButtonListener(ActionListener listener) {
        makePurchaseButton.addActionListener(listener);
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
}
