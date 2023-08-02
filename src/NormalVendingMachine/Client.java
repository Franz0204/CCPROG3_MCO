package NormalVendingMachine;

import java.util.ArrayList;
import java.util.List;
/**
 * The Client class represents the user that will be interacting with the vending machine.
 * It contains information about the name of the user and the amount of money he holds.
 */

public class Client {
    private final String name;
    private ArrayList<Money> wallet;
    /**
      * Constructs a new instance of the Client class with the specified name and his wallet 
      *
      * @param name The name of the user.
      */
    public Client(String name) {
        this.name = name;
        this.wallet = new ArrayList<Money>();

        // Add pre-made list of money (1000, 500, 100, 50, 20, 10, 5, 1) with quantity 10
        List<Integer> denominations = List.of(1000, 500, 100, 50, 20, 10, 5, 1);
        for (int denomination : denominations) {
            Money money = new Money(String.valueOf(denomination), denomination, 10);
            wallet.add(money);
        }
    }
    /**
      * Constructs a new instance of the Client class where the user can view the amount of money in their wallet 
      *
      */
    public int checkWallet() {
        int total = 0;

        for (Money i : wallet) {
            total += i.getValue() * i.getQuantity();
        }

        return total;
    }
    /**
      * Constructs a new instance of the Client class where the user can add funds to the user's wallet
      *
      * @param value The total amount of money added to the users wallet
      */
    public void addToWallet(int value) {
        for (Money i : wallet) {
            if (i.getValue() == value)
                i.setQuantity(i.getQuantity() + 1);
        }
    }
    /**
     * Returns the name of the user.
     *
     * @return The user's name as an String.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Returns the wallet of the user.
     *
     * @return The wallet of the user as an ArrayList.
     */
    public ArrayList<Money> getWallet() {
        return this.wallet;
    }
}
