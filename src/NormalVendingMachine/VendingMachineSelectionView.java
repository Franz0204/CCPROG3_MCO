package NormalVendingMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The VendingMachineSelectionView class represents the view for selecting the type of vending machine.
 * It displays buttons to choose between a Regular Vending Machine and a Special Vending Machine.
 */
public class VendingMachineSelectionView {
    private JFrame frame;
    private JButton regularVendingMachineButton;
    private JButton specialVendingMachineButton;

    /**
     * Creates a new VendingMachineSelectionView and initializes the user interface elements.
     * It sets up the JFrame and the Regular Vending Machine and Special Vending Machine buttons.
     */
    public VendingMachineSelectionView() {
        initialize();
    }

    /**
     * Initializes the user interface elements of the VendingMachineSelectionView.
     * It creates the JFrame, sets the title, and configures the layout and buttons.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Select Vending Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("|------------ Vending Machine ------------|");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(255, 0, 40));
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel1.add(titleLabel);
        panel1.setPreferredSize(new Dimension(500, 30));
        this.frame.add(panel1);

        regularVendingMachineButton = new JButton("Regular Vending Machine");
        specialVendingMachineButton = new JButton("Special Vending Machine");

        frame.add(regularVendingMachineButton);
        frame.add(specialVendingMachineButton);

        frame.setVisible(true);
    }

    /**
     * Sets the action listener for the Regular Vending Machine button.
     * @param listener The action listener to be set for the Regular Vending Machine button.
     */
    public void setRegularVendingMachineButtonListener(ActionListener listener) {
        regularVendingMachineButton.addActionListener(listener);
    }

    /**
     * Sets the action listener for the Special Vending Machine button.
     * @param listener The action listener to be set for the Special Vending Machine button.
     */
    public void setSpecialVendingMachineButtonListener(ActionListener listener) {
        specialVendingMachineButton.addActionListener(listener);
    }
}
