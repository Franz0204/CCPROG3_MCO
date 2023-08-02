package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialOrderController {
    private SpecialOrderView view;
    private SpecialVendingMachine model2;

    public SpecialOrderController() {
        view = new SpecialOrderView();
        view.setOrderFromMenuButtonListener(new OrderFromMenuButtonListener());
        view.setCustomOrderButtonListener(new CustomOrderButtonListener());
        view.setExitButtonListener(new ExitButtonListener());
    }

    private class OrderFromMenuButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the "Order from Menu" button action here
            // Show the MenuOptionsView for ordering from the menu
            MenuOptionsView menuOptionsView = new MenuOptionsView();
            MenuOptionsController menuOptionsController = new MenuOptionsController(model2, menuOptionsView);
            view.closeFrame();
        }
    }

    private class CustomOrderButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle the "Custom Order" button action here
            // Show the CustomOrderOptionsView for making a custom order
           // CustomOrderOptionsView customOrderOptionsView = new CustomOrderOptionsView();
           // CustomOrderOptionsController customOrderOptionsController = new CustomOrderOptionsController(customOrderOptionsView);
            view.closeFrame();
        }
    }

        private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model2 = new SpecialVendingMachine("Special Vending Machine");
            SpecialMainMenuView specialMainMenuView = new SpecialMainMenuView();
            SpecialMainMenuController specialMainMenuController = new SpecialMainMenuController(model2, specialMainMenuView);
        }
    }
}
