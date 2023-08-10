import java.util.Scanner;
/**
 * Write a description of class ShopItem here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public abstract class ShopItem 
{
    //stores code of the name for each item
    protected String itemName;
    //stores code of the item to identify each item
    protected String itemCode;
    //stores cost of a brand new item in pounds 
    public int cost;

    /**
     * Constructor for objects of class ShopItem
     */
    public ShopItem()
    {
        // initialise instance variables
       
    }
    
     /**
    * Accessor method to return the value stored in the private field toolName
    * 
    */
    public String getItemName()
    {
          return itemName;
    }
    
     /**
    * Accessor method to return the value stored in the private field itemCode
    * 
    */
    public String getItemCode()
    {
          return itemCode;
    }
    
     /**
    * Accessor method to return the value stored in the private field cost
    * 
    */
    public int getCost()
    {
          return cost;
    }
    
     /**
     * 
     * method for setting the variable toolName 
     * 
     */
    
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    /**
     * mutator method to set itemCode for ShopItem
     * 
     * @param code <code>String</code> itemCode for the ShopItem is
     */
    
    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }
    
    /**
     * mutator method to set cost for ShopItem
     * 
     * @param price <code>int</code> cost for the ShopItem is
     */
    
    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
     /**
     * 
     * This section of code prints out all the information that the variables currently hold
     * the user is able to access this through the method printDetails()
     */
    public void printDetails()
    {
        System.out.println("name : " + itemName);
        System.out.println("itemCode : " + itemCode);
        System.out.println("cost : " + cost);
    }

    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {
        // Call readData method of superclass to read its fields
        itemName = lineScanner.next();
        itemCode = lineScanner.next();
        cost = lineScanner.nextInt();
    }
}
