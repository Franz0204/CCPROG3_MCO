package NormalVendingMachine;

/**
 * The Slot class represents the space where each side resides in the vending machine.
 * It contains information about the sides itself, the price of each side, when it is available, the slot label, the amount of sides
 * in a slot and the number of sides sold.
 */

public class Slot {
    
    private Sides sides;
    private int price;
    private boolean avaiability;
    private int slotNo;
    private int supply;
    private int noSold;

    /**
     * Constructs a Slot object with the specified sides, price, availability, slot number, and supply.
     * 
     * @param sides The sides (product) available in the slot
     * @param price The price of the sides in the slot
     * @param availability The availability status of the slot
     * @param slotNo The slot number
     * @param supply The initial supply of sides in the slot
     */
    public Slot(Sides sides, int price, boolean avaiability, int slotNo, int supply){
        this.sides = sides;
        this.price = price;
        this.avaiability = avaiability;
        this.slotNo = slotNo;
        this.supply = supply;
        this.noSold = 0;
    }
    /**
     * Constructs a Slot object with the specified sides, price, availability, slot number, and supply.
     * 
     * @param sides The sides (product) available in the slot
     * @param price The price of the sides in the slot
     * @param slotNo The slot number
     * @param supply The initial supply of sides in the slot
     */
    public Slot(Sides sides, int price, int slotNo, int supply){
        this.sides = sides;
        this.price = price;
        this.avaiability = true;
        this.slotNo = slotNo;
        this.supply = supply;
        this.noSold = 0;
    }

    /**
     * Restocks the slot with the specified quantity of sides.
     * The supply is incremented by the quantity, up to a maximum of 10.
     * 
     * @param quantity the quantity of sides to be restocked
     * @return true if the restock is successful, false otherwise
     */
    public boolean restock(int quantity){
        // add a condition to check that it doesnt exceed more than 10 supply
        int refill  = this.supply + quantity;
        if (refill <= 10){           
            this.supply = refill;
            return true;
        }
        else return false;
    }

    /**
     * Returns the sides available in the slot.
     * 
     * @return the sides available in the slot
     */
    public Sides getSides(){
        return this.sides;
    }

    /**
     * Returns the availability status of the slot.
     * 
     * @return true if the slot is available, false otherwise
     */
    public boolean getAvaiability(){
        return this.avaiability;
    }

    /**
     * Returns the price of the sides in the slot.
     * 
     * @return the price of the sides
     */
    public int getPrice(){
        return this.price;
    }
    
    /**
     * Returns the slot number.
     * 
     * @return the slot number
     */
    public int getSlotNo(){
        return this.slotNo;
    }

    /**
     * Returns the current supply of sides in the slot.
     * 
     * @return the current supply of sides
     */
    public int getSupply(){
        return this.supply;
    }

    /**
     * Returns the number of items sold from the slot.
     * 
     * @return the number of items sold
     */
    public int getNoSold(){
        return this.noSold;
    }

    /**
     * Sets the price of the sides in the slot.
     * 
     * @param price the new price of the sides
     */
    public void setPrice(int price){
        this.price = price;
    }

    /**
     * Sets the slot number.
     * 
     * @param slotNo the new slot number
     */
    public void setSlotNo(int slotno){
        this.slotNo = slotno;
    }

   /**
     * Sets the supply of sides in the slot.
     * 
     * @param supply the new supply of sides
     */
    public void setSupply(int supply){
        this.supply = supply;
    }

    /**
     * Sets the number of items sold from the slot.
     * 
     * @param noSold the new number of items sold
     */
    public void setNoSold(int noSold){
        this.noSold = noSold;
    }

}
