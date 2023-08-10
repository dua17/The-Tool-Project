import java.util.Scanner;
/**
 * Write a description of class ElectricTool here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1
 */

public class ElectricTool extends Tool 
{
    //Stores whether tool is rechargeable
    private boolean rechargeable;
    //Stores the power of the tool
    private String power;
    
    /**
     * default Constructor for objects of class ElectricTool with no parameters
     *
     */
    public ElectricTool() 
    {
    }

    /**
     * Accessor method for value stored in the private field power
     * 
     * @return power - <code>String</code> the power of the electric tool is
     */
    public String getPower()
    {
        return power;
    }

    /**
     * Accessor method for value stored in the private field rechargeable
     * 
     * @return rechargeable - <code>boolean</code> whether that tool is able to be sharpened 
     */
    public boolean getRechargeable()
    {
        return rechargeable;
    }

    /**
     * mutator method to set power for ElectricTool
     * 
     * @param newPower <code>boolean</code> power for the ElectricTool is
     */
    public void setPower(String power) 
    {
        this.power = power;
    }

    /**
     * mutator method to set rechargeable for ElectricTool
     * 
     * @param isRechargeable <code>boolean</code> rechargeable for the ElectricTool is
     */
    public void setRechargeable(boolean rechargeable) 
    {
        this.rechargeable = rechargeable;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Rechargeable: " + rechargeable);
        System.out.println("Power: " + power);
        System.out.println("");
    }

    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {            
        super.readData(lineScanner);
        rechargeable = lineScanner.nextBoolean();
        power = lineScanner.next();
    }
}