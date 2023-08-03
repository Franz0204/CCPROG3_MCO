package NormalVendingMachine;

import java.util.ArrayList;

public class ClientTest {
    public static void main(String[] args) {
        // Create a new client
        Client client = new Client("John");

        // Test the checkWallet() method
        int initialTotal = client.checkWallet();
        System.out.println("Initial wallet total: " + initialTotal);  // Expected output: 10000

        // Test the addToWallet() method
        client.addToWallet(100);
        int updatedTotal = client.checkWallet();
        System.out.println("Updated wallet total: " + updatedTotal);  // Expected output: 10100

        // Test the getName() method
        String clientName = client.getName();
        System.out.println("Client name: " + clientName);  // Expected output: John

        // Test the getWallet() method
        ArrayList<Money> wallet = client.getWallet();
        System.out.println("Wallet contents: " + wallet);  // Expected output: [Money{name='1000', value=1000, quantity=10}, Money{name='500', value=500, quantity=10}, ...]

        // Verify the quantity of a specific denomination
        Money money1000 = wallet.get(0);
        System.out.println("Quantity of 1000 denomination: " + money1000.getQuantity());  // Expected output: 10
    }
}