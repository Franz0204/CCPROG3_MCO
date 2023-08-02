package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The MainMenuView class represents the main menu of the vending machine application.
 * It provides a graphical user interface (GUI) for the main menu, allowing users to choose between transaction and maintenance options.
 */
public class MainMenuView {
    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

    /**
     * Creates a new MainMenuView to display the main menu options.
     * The main menu is presented as a JFrame with transaction, maintenance, and exit buttons.
     */
    public MainMenuView() {
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
     * Sets an ActionListener for the transaction button in the main menu view.
     *
     * @param listener the ActionListener to be set for the transaction button
     */
    public void setTransactionButtonListener(ActionListener listener) {
        transactionButton.addActionListener(listener);
    }

    /**
     * Sets an ActionListener for the maintenance button in the main menu view.
     *
     * @param listener the ActionListener to be set for the maintenance button
     */
    public void setMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    /**
     * Sets an ActionListener for the exit button in the main menu view.
     *
     * @param listener the ActionListener to be set for the exit button
     */
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}
