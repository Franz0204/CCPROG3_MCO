package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The RegularMainMenuView class represents the main menu view of a Regular Vending Machine.
 * It provides buttons for performing transactions, accessing maintenance options, and exiting the program.
 */
public class RegularMainMenuView {
    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new RegularMainMenuView with the main menu options.
     * Initializes the main menu GUI components and displays the frame.
     */
    public RegularMainMenuView() {
        frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        JLabel titleLabel = new JLabel("|------ Regular Vending Machine ------|");
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
     * Sets the action listener for the transaction button.
     *
     * @param listener The ActionListener to be notified when the transaction button is clicked.
     */
    public void setTransactionButtonListener(ActionListener listener) {
        transactionButton.addActionListener(listener);
    }

    /**
     * Sets the action listener for the maintenance button.
     *
     * @param listener The ActionListener to be notified when the maintenance button is clicked.
     */
    public void setMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    /**
     * Sets the action listener for the exit button.
     *
     * @param listener The ActionListener to be notified when the exit button is clicked.
     */
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
