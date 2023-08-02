package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineSelectionController {
    private VendingMachineSelectionView view;
    private RegularVendingMachine model1;
    private SpecialVendingMachine model2;
    
    public VendingMachineSelectionController() {
        view = new VendingMachineSelectionView();
        view.setRegularVendingMachineButtonListener(new RegularVendingMachineListener());
        view.setSpecialVendingMachineButtonListener(new SpecialVendingMachineListener());
    }

    private class RegularVendingMachineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model1 = new RegularVendingMachine("Regular Vending Machine");
            RegularMainMenuView RegularMainMenuView = new RegularMainMenuView();
            RegularMainMenuController mainMenuController = new RegularMainMenuController(model1, RegularMainMenuView);
        }
    }

    private class SpecialVendingMachineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model2 = new SpecialVendingMachine("Special Vending Machine");
            SpecialMainMenuView specialMainMenuView = new SpecialMainMenuView();
            SpecialMainMenuController specialMainMenuController = new SpecialMainMenuController(model2, specialMainMenuView);
        }
    }
}
