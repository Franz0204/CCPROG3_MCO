package NormalVendingMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialVendingMachineView class represents the graphical user interface for the special vending machine.
 * It displays buttons for performing transactions, accessing maintenance options, and exiting the vending machine.
 */
public class SpecialVendingMachineView {

    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new SpecialVendingMachineView and initializes the user interface elements.
     * The view displays buttons for performing transactions, accessing maintenance options, and exiting the vending machine.
     */
    public SpecialVendingMachineView() {
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
}
