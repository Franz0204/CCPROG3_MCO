package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SpecialOrderView class represents the view for displaying special order options in the vending machine.
 * It provides buttons for ordering from the menu, making a custom order, and exiting the special order section.
 */
public class SpecialOrderView {
    private JFrame frame;
    private JButton orderFromMenuButton;
    private JButton customOrderButton;
    private JButton exitButton;

    /**
     * Creates a new SpecialOrderView and initializes the user interface elements.
     */
    public SpecialOrderView() {
        initialize();
    }

    /**
     * Initializes the user interface elements of the SpecialOrderView.
     * It creates the JFrame and sets the button labels and layout.
     */
    private void initialize() {
        frame = new JFrame("Order Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(2, 1));

        orderFromMenuButton = new JButton("Order from Menu");
        customOrderButton = new JButton("Custom Order");
        exitButton = new JButton("Exit");        
        
        frame.add(exitButton);
        frame.add(orderFromMenuButton);
        frame.add(customOrderButton);

        frame.setVisible(true);
    }

    /**
     * Sets the action listener for the "Order from Menu" button.
     * @param listener The action listener to be set for the button.
     */
    public void setOrderFromMenuButtonListener(ActionListener listener) {
        orderFromMenuButton.addActionListener(listener);
    }

    /**
     * Sets the action listener for the "Custom Order" button.
     * @param listener The action listener to be set for the button.
     */
    public void setCustomOrderButtonListener(ActionListener listener) {
        customOrderButton.addActionListener(listener);
    }

    /**
     * Sets the action listener for the "Exit" button.
     * @param listener The action listener to be set for the button.
     */
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
    
    /**
     * Closes the SpecialOrderView JFrame.
     */
    public void closeFrame() {
        frame.dispose();
    }
}
