package NormalVendingMachine;

/**
 * The Money class represents the currency that will be exchanged for sides in the vending machine.
 * It Represents a type of currency used in a vending machine and how much of it will be used.
 */
public class Money {

    private String name;
    private int value;
    private int quantity;
   /**
     * Constructs a new Money object with the specified name, value, and quantity.
     *
     * @param name     the name of the currency
     * @param value    the value of the currency
     * @param quantity the initial quantity of this type of currency available
     */
    public Money(String name, int value, int quantity){
        this.name = name;
        this.value = value;
        this.quantity = quantity;
    }
    /**
     * Returns the name of the currency.
     *
     * @return the name of the currency
     */
    public String getName(){
        return this.name;
    }
    /**
     * Returns the value of the currency.
     *
     * @return the value of the currency
     */
    public int getValue(){
        return this.value;
    }
    /**
     * Returns the quantity of this type of currency available.
     *
     * @return the quantity of this type of currency available
     */
    public int getQuantity(){
        return this.quantity;
    }
    /**
     * Sets the name of the currency.
     *
     * @param name the new name of the currency
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Sets the value of the currency.
     *
     * @param value the new value of the currency
     */
    public void setValue(int value){
        this.value = value;
    }
    /**
     * Sets the quantity of this type of currency available.
     *
     * @param quantity the new quantity of this type of currency available
     */
    public void setQuantity(int quantity){
        this.quantity += quantity;
    }
}
