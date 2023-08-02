package NormalVendingMachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialVendingMachineMenuView {

    private JFrame frame;
    private JButton transactionButton;
    private JButton maintenanceButton;
    private JButton exitButton;

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

    public void addTransactionButtonListener(ActionListener listener) {
        transactionButton.addActionListener(listener);
    }

    public void addMaintenanceButtonListener(ActionListener listener) {
        maintenanceButton.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    public JButton getTransactionButton() {
        return transactionButton;
    }

    public JButton getMaintenanceButton() {
        return maintenanceButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
