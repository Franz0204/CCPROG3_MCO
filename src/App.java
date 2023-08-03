import NormalVendingMachine.RegularVendingMachine;
import NormalVendingMachine.SpecialVendingMachine;
import java.util.Scanner;
public class App {

    public static void main(String[] args) { 
        RegularVendingMachine vendingMachine = new RegularVendingMachine("My Vending Machine");
        SpecialVendingMachine specialVendingMachine = new SpecialVendingMachine("Pizza Vending Machine");
        Scanner scanner = new Scanner(System.in);

        int sentinel = 0;

        do{
            int choice = 0;
            System.out.println("Which Vending Machine?");
            System.out.println("1. Regular Vending Machine");
            System.out.println("2. Special Vending Machine");
            System.out.println("3. Exit");
            System.out.print("> ");
            choice = scanner.nextInt();
            
            switch (choice){
                case 1:
                    vendingMachine.runVendingMachine();
                    break;
                case 2:
                    specialVendingMachine.runVendingMachine();
                    break;
                case 3:
                    sentinel = 1;
                    scanner.close();
                    break;
                default:
                    scanner.close();
                    break;
            }
        } while (sentinel == 0);
    }
}
