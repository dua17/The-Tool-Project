import java.util.Scanner;
/**
 * Write a description of class Workwear here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public class Workwear extends Accessory
{
    //Stores the manufacturing standard for a workwear accessory
    private String manufacturingStandard;
    //Stores the colour for a workwear accessory
    private String colour;
    //Stores the size for a workwear accessory
    private String size;

    /**
     * Constructor for objects of class Workwear
     */
    public Workwear()
    {
       
    }

    /**
     * mutator method to set manufacturingStandard for Workwear accessory
     * 
     * @param newStandard <code>String</code> manufacturingStandard for the Workwear accessory is
     */
    public void SetManufacturingStandard(String manufacturingStandard) 
    {
        this.manufacturingStandard = manufacturingStandard;
    }

    /**
     * mutator method to set colour for Workwear accessory
     * 
     * @param addColour <code>String</code> colour for the Workwear accessory is
     */
    public void setColour(String colour) 
    {
        this.colour = colour;
    }
    
    /**
     * mutator method to set size for Workwear accessory
     * 
     * @param addSize <code>String</code> size for the Workwear accessory is
     */
    public void setSize(String size) 
    {
        this.size = size;
    }
    
    /**
     * Accessor method for value stored in the private field manufacturingStandard
     * 
     * @return manufacturingStandard - <code>String</code> the manufacturingStandard for the Workwear accessory is 
     */
    public String getManufacturingStandard()
    {
          return manufacturingStandard;
    }
    
    /**
     * Accessor method for value stored in the private field colour
     * @return colour - <code>String</code> the colour for the Workwear accessory is 
     */
    public String getColour()
    {
          return colour;
    }
    
    /**
     * Accessor method for value stored in the private field size
     * @return size - <code>String</code> the size for the Workwear accessory is 
     */
    public String getSize()
    {
          return size;
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.println("manufacturingStandard: " + manufacturingStandard);
        System.out.println("colour: " + colour);
        System.out.println("size: " + size);
        System.out.println("");
    }

    @Override
    public void readData(Scanner lineScanner) throws IllegalArgumentException
    {
     super.readData(lineScanner); // Call readData method of superclass to read its fields
     manufacturingStandard = lineScanner.next();
     colour = lineScanner.next();
     size = lineScanner.next();
    }
}