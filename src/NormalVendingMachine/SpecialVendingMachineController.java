import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialVendingMachineController {

    private SpecialVendingMachineMenuView view;
    private SpecialVendingMachine model;

    public SpecialVendingMachineController(SpecialVendingMachineMenuView view, SpecialVendingMachine model) {
        this.view = view;
        this.model = model;

        view.getTransactionButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Transaction button click
                // Your code here for transaction logic
            }
        });

        view.getMaintenanceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Maintenance button click
                // Your code here for maintenance logic
            }
        });

        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Exit button click
                System.exit(0);
            }
        });
    }
}
