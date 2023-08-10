import java.util.Scanner;
/**
 * Write a description of class ElectricTool here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1
 */

public class Perishable extends Accessory 
{
    //Stores whether a perishable accessory is an irritant
    private boolean isIrritant;
    //Stores the use by date for a perishable accessory
    private String useByDate;
    //Stores the volume for the perishable accessory
    private String volume;
    
    /**
     * default Constructor for objects of class ElectricTool with no parameters
     *
     */
    public Perishable() 
    {
    }

    public void setIsIrritant(boolean isIrritant) 
    {
        this.isIrritant = isIrritant;
    }

    public void setUseByDate(String useByDate) 
    {
        this.useByDate = useByDate;
    }
    
    public void setVolume(String volume) 
    {
        this.volume = volume;
    }
    
    /**
    * Accessor method to return the value stored in the private field isIrritant
    * 
    */
    public boolean getIsIrritant()
    {
          return isIrritant;
    }
    
    /**
    * Accessor method to return the value stored in the private field weight
    * 
    */
    public String getUseByDate()
    {
          return useByDate;
    }
    
    /**
    * Accessor method to return the value stored in the private field weight
    * 
    */
    public String getVolume()
    {
          return volume;
    }

    public void printDetails()
    {
        super.printDetails();
        System.out.println("isIrritant: " + isIrritant);
        System.out.println("useByDate: " + useByDate);
        System.out.println("volume: " + volume);
        System.out.println("");
    }

    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {
     super.readData(lineScanner); // Call readData method of superclass to read its fields
     isIrritant = lineScanner.nextBoolean();
     useByDate = lineScanner.next();
     volume = lineScanner.next();
    }
}