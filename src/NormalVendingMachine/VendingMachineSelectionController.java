package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The VendingMachineSelectionController class handles the user selection of vending machines.
 * It listens for button clicks on the Regular Vending Machine and Special Vending Machine options.
 * Depending on the user's choice, it creates and initializes the corresponding vending machine and its main menu view.
 */
public class VendingMachineSelectionController {
    private VendingMachineSelectionView view;
    private RegularVendingMachine model1;
    private SpecialVendingMachine model2;
    
    /**
     * Creates a new VendingMachineSelectionController and initializes the user interface elements.
     * It sets action listeners for the Regular Vending Machine and Special Vending Machine buttons.
     */
    public VendingMachineSelectionController() {
        view = new VendingMachineSelectionView();
        view.setRegularVendingMachineButtonListener(new RegularVendingMachineListener());
        view.setSpecialVendingMachineButtonListener(new SpecialVendingMachineListener());
    }

    /**
     * ActionListener for the Regular Vending Machine button.
     * Creates and initializes a new RegularVendingMachine and its main menu view.
     */
    private class RegularVendingMachineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model1 = new RegularVendingMachine("Regular Vending Machine");
            RegularMainMenuView regularMainMenuView = new RegularMainMenuView();
            RegularMainMenuController mainMenuController = new RegularMainMenuController(model1, regularMainMenuView);
        }
    }

    /**
     * ActionListener for the Special Vending Machine button.
     * Creates and initializes a new SpecialVendingMachine and its main menu view.
     */
    private class SpecialVendingMachineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model2 = new SpecialVendingMachine("Special Vending Machine");
            SpecialMainMenuView specialMainMenuView = new SpecialMainMenuView();
            SpecialMainMenuController specialMainMenuController = new SpecialMainMenuController(model2, specialMainMenuView);
        }
    }
}
