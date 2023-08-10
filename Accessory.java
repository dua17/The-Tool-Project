import java.util.Scanner;
import java.util.*;
/**
 * Write a description of class Accessory here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public abstract class Accessory extends ShopItem
{
    //Stores whether an accessory is recycleable 
    protected boolean isRecyclable;
    
    /**
     * default Constructor for objects of class Tool with no parameters
     *
     */
    public Accessory() 
    {
    }

    /**
     * Accessor method for value stored in the private field isRecycleable
     * 
     * @return isRecycleable - <code>boolean</code> whether the accessory is recycleable
     */
    public boolean getIsRecyclable()
    {
          return isRecyclable;
    }
    
    /**
     * mutator method to set isRecycleable for Accessory
     * 
     * @param recycleable <code>boolean</code> isRecycleable for the Accessory is
     */
    
    public void setIsRecyclable(boolean isRecyclable)
    {
        this.isRecyclable = isRecyclable;
    }
    
     /**
     * 
     * This section of code prints out all the information that the variables currently hold
     * the user is able to access this through the method printDetails()
     */
    public void printDetails() 
    {
        System.out.println("Recyclable: " + isRecyclable);
        super.printDetails();
    } 
    
    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {        
        isRecyclable = lineScanner.nextBoolean();
        super.readData(lineScanner);
     }
}