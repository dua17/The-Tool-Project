import java.util.Scanner;
/**
 * Write a description of class HandTool here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public class HandTool extends Tool
{
    //whether that tool is able to be sharpened 
    private boolean sharpenable;

    /**
     * Default constructor for objects of class HandTool
     */
     public HandTool() 
    {
        
    }
    
    /**
     * Accessor method for value stored in the private field sharpenable
     * 
     * @return sharpenable - <code>boolean</code> whether that tool is able to be sharpened 
     */
    public boolean getSharpenable() 
    {
        return sharpenable;
    }
    
    /**
     * mutator method to set sharpenable for HandTool
     * 
     * @param isSharpenable <code>boolean</code> sharpenable for the HandTool is
     */
    public void setSharpenable(boolean sharpenable) 
    {
        this.sharpenable = sharpenable;
    }
    
    public void printDetails() 
    {
        super.printDetails();
        System.out.println("Sharpenable: " + sharpenable);
        System.out.println("");
    }

    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {
        super.readData(lineScanner);
        sharpenable = lineScanner.nextBoolean();
    }
}
