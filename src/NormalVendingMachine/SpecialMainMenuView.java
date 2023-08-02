package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialMainMenuView class represents the view for the main menu of the special vending machine.
 * It displays buttons for transaction, maintenance, and exit options to interact with the vending machine.
 */
public class SpecialMainMenuView {
    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new SpecialMainMenuView with the main menu buttons.
     * The main menu includes buttons for transaction, maintenance, and exit options.
     */
    public SpecialMainMenuView() {
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("|------ Special Vending Machine ------|");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(255, 0, 40));

        transactionButton = new JButton("Transaction");
        maintenanceButton = new JButton("Maintenance");
        exitButton = new JButton("Exit");

        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(titleLabel);
        panel1.setPreferredSize(new Dimension(500, 30));
        this.frame.add(panel1);

        frame.add(transactionButton);
        frame.add(maintenanceButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }

    /**
     * Sets an action listener for the transaction button.
     *
     * @param listener The ActionListener to be set for the transaction button.
     */
    public void setTransactionButtonListener(ActionListener listener) {
        transactionButton.addActionListener(listener);
    }

    /**
     * Sets an action listener for the maintenance button.
     *
     * @param listener The ActionListener to be set for the maintenance button.
     */
    public void setMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    /**
     * Sets an action listener for the exit button.
     *
     * @param listener The ActionListener to be set for the exit button.
     */
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
