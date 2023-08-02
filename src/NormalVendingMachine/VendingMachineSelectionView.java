package NormalVendingMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineSelectionView {
    private JFrame frame;
    private JButton regularVendingMachineButton;
    private JButton specialVendingMachineButton;

    public VendingMachineSelectionView() {
        initialize();
    }

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

    public void setRegularVendingMachineButtonListener(ActionListener listener) {
        regularVendingMachineButton.addActionListener(listener);
    }

    public void setSpecialVendingMachineButtonListener(ActionListener listener) {
        specialVendingMachineButton.addActionListener(listener);
    }

}
