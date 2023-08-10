import java.util.*;
import java.io.*;
/**
 * Write a description of class Customer here.
 * 
 * @author (Du'a Riaz) 
 * @version (version1)
 */
public class Customer
{
    //Stores the customer ID for the customer 
    private String customerID;
    //Stores the surname of the customer
    private String surname;
    //Stores the first name of the customer
    private String firstName;
    //Stores the customers initials
    private String otherInitials;
    //Stores the title of the customer
    private String title;

    /**
     * Constructor for objects of class
     */
    public Customer(String customerID, String surname, String firstName, String otherInitials, String title)
    {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }
    
    public Customer()
    {
        
    }

    /**
     * Accessor method for value stored in the private field customerID
     * 
     * @return customerID - <code>String</code> the customer ID for the Customer is 
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Accessor method for value stored in the private field surname
     * 
     * @return surname- <code>String</code> the surname for the Customer is 
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Accessor method for value stored in the private field firstName
     * 
     * @return firstName - <code>String</code> the firstName for the Customer is 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor method for value stored in the private field otherInitials
     * 
     * @return otherInitials - <code>String</code> otherInitials for the Customer is 
     */
    public String getOtherInitials() {
        return otherInitials;
    }

    /**
     * Accessor method for value stored in the private field title
     * 
     * @return title - <code>String</code> title for the Customer is 
     */
    public String getTitle() {
        return title;
    }

    /**
     * mutator method to set customerID for the Customer
     * 
     * @param customerID <code>String</code> customerID for the Customer is
     */
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    /**
     * mutator method to set surname for the Customer
     * 
     * @param lastName <code>String</code> surname for the Customer is
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * mutator method to set firstName for the Customer
     * 
     * @param firstName <code>String</code> firstName for the Customer is
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     /**
     * mutator method to set otherInitials for the Customer
     * 
     * @param otherInitials <code>String</code> otherInitials for the Customer is
     */
    public void setOtherInitials(String otherInitials) {
        this.otherInitials = otherInitials;
    }

    /** mutator method to set title for the Customer
     * 
     * @param title <code>String</code> title for the Customer is
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    //this methods prints the detail stored in the fields to the terminal
    public void printDetails() {
        System.out.println("Customer ID: " + customerID + "; Surname: " + surname + "; First name: " + firstName + "; Other initials: " + otherInitials + "; Title: " + title);
    }

    public void readData(Scanner scanner) throws IllegalArgumentException {
        customerID = scanner.next();
        surname = scanner.next();
        firstName = scanner.next();
        otherInitials = scanner.next();
        title = scanner.next();        
    }
    
    /**
     * Write the customer data to the provided PrintWriter object
     * @param writer The PrintWriter object to write the data to
     */
    public void writeData(PrintWriter pWriter)
    {
       pWriter.println(customerID +", "+ surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }
}
