import java.util.Scanner;
import java.util.*;
/**
 * Write a description of class Tool here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public abstract class Tool extends ShopItem
{
    //stores how many times an item has been borrowed
    protected int timesBorrowed;
    //stores weight of a tool in grams
    protected boolean onLoan;
    //stores whether an item has been borrowed or not
    protected int weight;
    
    /**
     * default Constructor for objects of class Tool with no parameters
     *
     */
    public Tool() 
    {
    }
    
    /**
     * Accessor method for value stored in the private field timesBorrowed  
     * 
     * @return timesBorrowed  - <code>int</code> the number of timesBorrowed  for the Tool is 
     */
    public int getTimesBorrowed()
    {
          return timesBorrowed;
    }
    
    /**
     * Accessor method for value stored in the private field onLoan 
     * 
     * @return onLoan  - <code>boolean</code> onLoan for the Tool is 
     */
    public boolean getOnLoan()
    {
          return onLoan;
    }
    
    /**
     * Accessor method for value stored in the private field weight 
     * 
     * @return weight - <code>int</code> the weight for the Tool is 
     */
    public int getWeight()
    {
          return weight;
    }
    
    /**
     * mutator method to set timesBorrowed for Tool
     * 
     * @param timeBorrowed <code>int</code> timesBorrowed for the Tool is
     */
    
    public void setTimesBorrowed(int timesBorrowed)
    {
        this.timesBorrowed = timesBorrowed;
    }
    
    /**
     * mutator method to set onLoan for Tool
     * 
     * @param isOnLoan <code>boolean</code> onLoan for the Tool is
     */
    
    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }
    
    /**
     * mutator method to set weight for Tool
     * 
     * @param toolWeight <code>int</code> weight for the Tool is
     */
    
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    
     /**
     * 
     * This section of code prints out all the information that the variables currently hold
     * the user is able to access this through the method printDetails()
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("timesBorrowed: " + timesBorrowed);
        System.out.println("onLoan: " + onLoan);
        System.out.println("weight: " + weight);
    }
    
    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {
        super.readData(lineScanner);
        timesBorrowed = lineScanner.nextInt();
        onLoan = lineScanner.nextBoolean();   
        weight = lineScanner.nextInt();
    }   
}