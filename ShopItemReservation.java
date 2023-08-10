import java.util.*;
import java.text.*;
import java.io.*;
/**
 * Write a description of class ShopItemReservation here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public class ShopItemReservation
{
    //Stores the reservation number for item 
    private String reservationNo;
    //Stores the items ID
    private String itemID;
    //Stores the customers ID
    private String customerID;
    //Stores the first day of the reservation
    private Date startDate;

    private int noOfDays;

    /**
     * Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays) 
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }
    
    /**
     * empty Constructor for objects of class ShopItemReservation
     */
    public ShopItemReservation() 
    {
    }
    
    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
    
     /**
     * 
     * This section of code prints out all the information that the variables currently hold
     * the user is able to access this through the method printDetails()
     */
    public void printDetails()
    {
        System.out.println("Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID + 
        "; Date of hire: " + startDate + "; Hire duration: " + noOfDays);
    }

    public void readData(Scanner lineScanner) throws IllegalArgumentException, ParseException
    {
        // Call readData method of superclass to read its fields
        reservationNo = lineScanner.next();
        itemID = lineScanner.next();
        customerID = lineScanner.next();
        startDate = DateUtil.convertStringToDate(lineScanner.next());
        noOfDays = lineScanner.nextInt();
    }
    
    public void writeData(PrintWriter pWriter) 
    {
      pWriter.println(reservationNo +" , "+ itemID + ", " + customerID + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
    }

    public String toString() 
    {
        return "Reservation No: " + reservationNo + "; Item ID: " + itemID + "; Customer ID: " + customerID +
        "; Reservation Date: " + startDate + "; Hire duration: " + noOfDays;
    }
}
