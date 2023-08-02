package NormalVendingMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The NameController class is responsible for handling user interactions and business logic related to client names in the Regular Vending Machine.
 * It receives inputs from the associated NameView, validates the user input, and updates the RegularVendingMachine model accordingly.
 */
public class NameController {
    private RegularVendingMachine model;
    private NameView view;

    private boolean nameEntered; // Variable to keep track of whether the name has been entered or not

    /**
     * Creates a new NameController with the provided RegularVendingMachine model and NameView.
     * Initializes the nameEntered flag to false.
     *
     * @param model The RegularVendingMachine model associated with this controller.
     * @param view  The NameView associated with this controller.
     */
    public NameController(RegularVendingMachine model, NameView view) {
        this.model = model;
        this.view = view;
        this.nameEntered = false;

        // Adding action listener for the submit button
        this.view.setSubmitButtonListener(new SubmitButtonListener());
    }

    /**
     * Checks if the name has been entered.
     *
     * @return true if the name has been entered, false otherwise.
     */
    public boolean isNameEntered() {
        return nameEntered;
    }

    /**
     * Private ActionListener class to handle the "Submit" button click.
     */
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getClientName();

            if (!name.isEmpty()) {
                Client client = new Client(name);
                model.setName(name);
                view.showMessage("Hello, " + name + "!");
                nameEntered = true;
            } else {
                view.showMessage("Please enter a valid name.");
            }

        }
    }
}
