package NormalVendingMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialVendingMachineMenuView class represents the graphical user interface for the special vending machine menu.
 * It displays buttons for performing transaction, accessing maintenance options, and exiting the menu.
 */
public class SpecialVendingMachineMenuView {

    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new SpecialVendingMachineMenuView and initializes the user interface elements.
     * The menu view displays buttons for performing transaction, accessing maintenance options, and exiting the menu.
     */
    public SpecialVendingMachineMenuView() {
        frame = new JFrame("Special Vending Machine Menu");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        transactionButton = new JButton("Transaction");
        maintenanceButton = new JButton("Maintenance");
        exitButton = new JButton("Exit");

        buttonPanel.add(transactionButton);
        buttonPanel.add(maintenanceButton);
        buttonPanel.add(exitButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Adds an action listener for the "Transaction" button.
     * @param listener The action listener to be added.
     */
    public void addTransactionButtonListener(ActionListener listener) {
        transactionButton.addActionListener(listener);
    }

    /**
     * Adds an action listener for the "Maintenance" button.
     * @param listener The action listener to be added.
     */
    public void addMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    /**
     * Adds an action listener for the "Exit" button.
     * @param listener The action listener to be added.
     */
    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    /**
     * Returns the "Transaction" button.
     * @return The "Transaction" button.
     */
    public JButton getTransactionButton() {
        return transactionButton;
    }

    /**
     * Returns the "Maintenance" button.
     * @return The "Maintenance" button.
     */
    public JButton getMaintenanceButton() {
        return maintenanceButton;
    }

    /**
     * Returns the "Exit" button.
     * @return The "Exit" button.
     */
    public JButton getExitButton() {
        return exitButton;
    }
}
