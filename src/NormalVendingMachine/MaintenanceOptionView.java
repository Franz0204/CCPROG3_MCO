package NormalVendingMachine;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * The MaintenanceOptionView class represents the GUI view for maintenance options in the vending machine.
 * It provides buttons for various maintenance actions such as restocking, setting slot price, replenishing money, withdrawing money,
 * checking money, displaying items, and returning to the main menu.
 */
public class MaintenanceOptionView {
    private JFrame frame;
    private JButton restockButton;
    private JButton setSlotPriceButton;
    private JButton replenishMoneyButton;
    private JButton withdrawMoneyButton;
    private JButton checkMoneyButton;
    private JButton displayItemsButton;
    private JButton returnToMainMenuButton;

    /**
     * Creates a new MaintenanceOptionView with a JFrame containing buttons for maintenance options.
     * The view is initially set to visible.
     */
    public MaintenanceOptionView() {
        frame = new JFrame("Maintenance Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(7, 1));

        // Add buttons for maintenance options
        restockButton = new JButton("Restock");
        setSlotPriceButton = new JButton("Set Slot Price");
        replenishMoneyButton = new JButton("Replenish Money");
        withdrawMoneyButton = new JButton("Withdraw Money");
        checkMoneyButton = new JButton("Check Money");
        displayItemsButton = new JButton("Display Items");
        returnToMainMenuButton = new JButton("Return to Main Menu");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(restockButton);
        buttonPanel.add(setSlotPriceButton);
        buttonPanel.add(replenishMoneyButton);
        buttonPanel.add(withdrawMoneyButton);
        buttonPanel.add(checkMoneyButton);
        buttonPanel.add(displayItemsButton);
        buttonPanel.add(returnToMainMenuButton);

        frame.add(buttonPanel);
        frame.setVisible(true);
    }

    // Getter methods for the buttons

    /**
     * Returns the restock button in the maintenance options view.
     *
     * @return the restock button
     */
    public JButton getRestockButton() {
        return restockButton;
    }

    /**
     * Returns the set slot price button in the maintenance options view.
     *
     * @return the set slot price button
     */
    public JButton getSetSlotPriceButton() {
        return setSlotPriceButton;
    }

    /**
     * Returns the replenish money button in the maintenance options view.
     *
     * @return the replenish money button
     */
    public JButton getReplenishMoneyButton() {
        return replenishMoneyButton;
    }

    /**
     * Returns the withdraw money button in the maintenance options view.
     *
     * @return the withdraw money button
     */
    public JButton getWithdrawMoneyButton() {
        return withdrawMoneyButton;
    }

    /**
     * Returns the check money button in the maintenance options view.
     *
     * @return the check money button
     */
    public JButton getCheckMoneyButton() {
        return checkMoneyButton;
    }

    /**
     * Returns the display items button in the maintenance options view.
     *
     * @return the display items button
     */
    public JButton getDisplayItemsButton() {
        return displayItemsButton;
    }

    /**
     * Returns the return to the main menu button in the maintenance options view.
     *
     * @return the return to main menu button
     */
    public JButton getReturnToMainMenuButton() {
        return returnToMainMenuButton;
    }
}