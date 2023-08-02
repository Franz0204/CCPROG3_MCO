package NormalVendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The NameView class represents the GUI view for the Regular Vending Machine name input feature.
 * It displays a JFrame where the user can enter their name and submit it.
 * The view provides methods to set an action listener for the submit button,
 * retrieve the client name entered, and show messages to the user via JOptionPane.
 */
public class NameView {
    private JFrame frame;
    private JTextField nameField;
    private JButton submitButton;

    /**
     * Creates a new NameView, initializing the JFrame and its components.
     * The JFrame displays a text field for the user to enter their name and a submit button to submit the name.
     */
    public NameView() {
        frame = new JFrame("Enter Your Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("What is your name?");
        nameField = new JTextField(20);
        submitButton = new JButton("Submit");

        JLabel titleLabel = new JLabel("|------------ Vending Machine ------------|");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(255, 0, 40));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(titleLabel);
        panel1.setPreferredSize(new Dimension(500, 30));
        this.frame.add(panel1);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel2.add(nameLabel);
        panel2.setPreferredSize(new Dimension(500, 30));
        this.frame.add(panel2);

        frame.add(nameField);
        frame.add(submitButton);

        frame.setVisible(true);
    }

    /**
     * Sets an ActionListener for the submit button.
     *
     * @param listener The ActionListener to be set for the submit button.
     */
    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Retrieves the client name entered in the name text field.
     *
     * @return The client name entered as a String.
     */
    public String getClientName() {
        return nameField.getText();
    }

    /**
     * Shows a message to the user using a JOptionPane dialog.
     *
     * @param message The message to be displayed to the user.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
