import java.io.*;
import java.awt.*;
import java.util.*;
import java.text.*;
import java.util.List;
/**
 * Write a description of class Shop here.
 * 
 * @author (Du'a Riaz) 
 * @version (version 1)
 */
public class Shop 
{
    //private ArrayList<ShopItem> itemList;
    //private ArrayList<Customer> customerList;
    
    // New declarations changing ArrayList type to List
    // private List<Customer> customerList;
    //private List<ShopItem> itemsList;
    
    //Stores a key object of the type String and value object of the type ShopItem
    private Map<String, ShopItem> itemsMap;
    //Stores a key object of the type String and value object of the type Customer
    private Map<String, Customer> customerMap;
    //Stores a key object of the type String and value object of the type ShopItemReservation
    private Map<String, ShopItemReservation> itemReservationMap;
    //helps to generate random numbers 
    private Random randomGenerator;
    //Stores last reservation number
    private int reservationCounter;
    //Stores diary object
    private Diary diary;
    

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        //customerList = new ArrayList<Customer>();
        //itemsList = new ArrayList<ShopItem>();
        // Instantiate customerMap and itemsMap as HashMaps
        customerMap = new HashMap<String, Customer>();
        itemsMap = new HashMap<String, ShopItem>();
        // Instantiate itemReservationMap as a HashMap
        itemReservationMap = new HashMap<String, ShopItemReservation>();
        reservationCounter = 0;
        
        randomGenerator = new Random();
        
        diary = new Diary();
    }
    
    /**
     * this method receives the value stored in the field customer
     * 
     */
    public Customer getCustomer(String customerId) 
    { 
      Customer customer = customerMap.get(customerId);
      if(customer != null )
      {
        return customer;
      }
      else 
      {
        return null ;
      }
    }
    
    /**
     * This method receives the value stored in the field Item
     * 
     */
    public ShopItem getItem(String itemId) 
    {
        ShopItem item = itemsMap.get(itemId);
        if(item != null )
        {
            return item;
        }
        else 
        {
            return null ;
        }
    }
    
    /**
     * This method stores an item Object in the itemsMap
     * 
     */
    public void storeItem (ShopItem item)
    {
        //itemList.add(item);
        itemsMap.put(item.getItemCode(), item);
    }
    
    /**
     * This method stores a Customer Object in the customerList arraylist
     * 
     */
    public void storeCustomer(Customer customer) 
    {
        if (customer.getCustomerID().equals("unknown")) 
        {
            String newID = generateCustomerID("AB-", 6);
            customer.setCustomerID(newID);
        }
        customerMap.put(customer.getCustomerID(), customer);
        //customerList.add(customer);
    }
    
    /**
     * This method stores a the reervation and the reseravtionNo as key and value inputs in the itemreservationMap
     * 
     */
    public void storeItemReservation(ShopItemReservation shopItemReservation) 
    {
        //itemList.add(item);
        itemReservationMap.put(shopItemReservation.getReservationNo(), shopItemReservation);
        diary.addReservation(shopItemReservation);
    }
    
    /**
     * This method generates a uniqe reservationNo
     * It saves the previous no to a file so it can't be generated twice & so it isn't lost
     */
    public String generateReservationNo()
    {
        String fileName = "lastReservation.txt";
        File file = new File(fileName);
        Scanner scanner = null;

        if(file.exists())
        {
            try {
                scanner = new Scanner(file);
            }
            catch (FileNotFoundException exception) {
                System.out.println("Error - File has not been found");
                return null;
            }

            if(scanner.hasNextLine())
            {
                String fileReservationNo = scanner.nextLine().trim();
                reservationCounter = Integer.parseInt(fileReservationNo);
            }
            scanner.close();
        }
        else{
            try
            {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("File : " + fileName + " has been created");
                } else {
                    System.out.println("File : " + fileName + " has not been created");
                }
            }
            catch(IOException e)
            {
                System.out.println("There is an Error creating File : " + fileName);
            }
        }

        reservationCounter++;
        String reservationNo = String.format("%06d", reservationCounter);
        PrintWriter writer = null;

        try{
            writer = new PrintWriter(fileName);
            writer.write(reservationNo);
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Can't write to file");
        }

        return reservationNo;
    }
    
    /**
     * This method retrieves the value stored in the accessor method getItemReservation
     * 
     */
    public ShopItemReservation getItemReservation(String reservationNo) 
    {
        ShopItemReservation reservation = itemReservationMap.get(reservationNo);
        if (reservation != null)
        {
            return reservation;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * This method makes a unique Item Reseravtion upon checking all the inputted fields are corrct
     * 
     */
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays) {
       if (customerID == null || itemID == null || startDate == null || noOfDays < 0) {
         System.out.println("Invalid input.");
         return false;
       }

       ShopItem item = getItem(itemID);
       if (item == null) {
        System.out.println("Item not found.");
        return false;
        }

       Customer customer = getCustomer(customerID);
       if (customer == null) {
        System.out.println("Customer not found.");
        return false;
       }

       String reservationNumber = generateReservationNo();

       ShopItemReservation reservation = new ShopItemReservation(reservationNumber, itemID, customerID, startDate, noOfDays);
       storeItemReservation(reservation);
       return true;
    }

    /**
     * generates a Unique customerID using the Random object class
     * 
     */
    public String generateCustomerID(String prefix, int numDigits) 
    {
      String customerID;
      boolean uniqueID = false;
      int maxNum = (int) Math.pow(10, numDigits) - 1;
      Set<String> existingIDs = new HashSet<String>();
      for (Customer customer : customerMap.values()) 
      {
        existingIDs.add(customer.getCustomerID());
      }

      while (!uniqueID) 
      {
        int randomNumber = randomGenerator.nextInt(maxNum);
        customerID = prefix + String.format("%0" + numDigits + "d", randomNumber);
        if (!existingIDs.contains(customerID)) {
            uniqueID = true;
            return customerID;
        }
      }
      return null;
    }
    
    //displays all the items stored in the itemsMap
    /**
     * This method uses a for each loop to loop throught the HashMap ItemsMap and print all its values
     * 
     */
    public void printAllItems()
    {
       if (itemsMap.size() > 0) //(itemList.size() > 0) 
        {
            int counter = 1;
            for (ShopItem item : itemsMap.values())//(ShopItem item: itemList) 
            {
                System.out.println("Item - " + counter);
                item.printDetails();
                counter++;
            }
        }
        else {
            System.out.println("The list is empty currently, please add items");
        }
    }
    
    /**
     * This method uses a for each loop to loop throught the HasMap CustomersMap and print all its values
     * 
     */
    public void printAllCustomers() 
    {
       if  (customerMap.size() > 0) //(customerList.size() > 0) 
        {
            int counter = 1;
            for (Customer customer: customerMap.values())//(Customer customer: customerList) 
            {
                System.out.println("Customer - " + counter);
                customer.printDetails();
                counter++;
            }
        }
        else {
            System.out.println("The list is empty currently, please add a customer");
        }
    }
    
    /**
     * This method uses a for each loop to loop throught the HashMap ItemsReservationMap and print all its values
     * 
     */
    public void printItemReservations() 
    {
       if (itemReservationMap.size() > 0)
        {
           int counter = 1;
           for (ShopItemReservation reservation : itemReservationMap.values())
           {
               System.out.println("Reservation - " + counter);
               reservation.printDetails();
               counter++;
            }
        }
        else {
            System.out.println("There are currently no reseravtions booked, please add some");
        }
    }
    
    /**
     * This method asks the user to input two String fields - startDate and endDate
     * Converts String data types into Date types
     */
    public void printDiaryEntries(String startDate, String endDate) 
    { 
        Date initialDate = DateUtil.convertStringToDate(startDate);
        Date finalDate = DateUtil.convertStringToDate(startDate);
        
        diary.printEntries(initialDate, finalDate);
    }
    
    /**
     * This method writes reservationItemData into the filename that is passed
     * 
     */
    public void writeItemReservationData(String fileName) 
    {
      try {
        PrintWriter pWriter = new PrintWriter(fileName);
        for (ShopItemReservation reservation : itemReservationMap.values()) 
        {
            reservation.writeData(pWriter);
        }
        pWriter.close();
      } catch (IOException e) 
      {
        System.out.println("Error writing to file: " + e);
      }
     }
    
    public void readItemReservationData() 
    {
      Frame frame = null;
      FileDialog fileDialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
      fileDialog.setDirectory(".");
      fileDialog.setVisible(true);
      File selectedFile = new File(fileDialog.getDirectory(), fileDialog.getFile());
      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
      File dataFile = selectedFile;
      
      try {
        Scanner scanner = new Scanner(dataFile);
        ShopItemReservation reservation;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); 
            if (!line.isEmpty())  
            { 
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                reservation = new ShopItemReservation();
                try {
                    reservation.readData(lineScanner);
                } catch (ParseException e) {
                    System.out.println("Error parsing date: " + e.getMessage());
                    continue; // skip to the next line
                }
                reservation.printDetails();
                storeItemReservation(reservation);
            }
        }
        scanner.close();
        printItemReservations();
       } catch (FileNotFoundException e) {
        System.out.println("Error reading customer data file: " + e.getMessage());
       }
    }
    
    /**
     * This method uses a Scanner object to read Item data to the terminal
     * 
     */
    public void readItemData() 
    {
      Frame frame = null;
      FileDialog fileDialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
      fileDialog.setDirectory(".");
      fileDialog.setVisible(true);
      File selectedFile = new File(fileDialog.getDirectory(), fileDialog.getFile());
      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
     //Check if the user selected a file
      if (fileDialog.getFile() != null) 
       {
          try {
              Scanner scanner = new Scanner(selectedFile);
              ShopItem item;
              String typeOfData = ""; // initialize to an empty string
              while (scanner.hasNextLine()) {
               String lineOfText = scanner.nextLine().trim(); // trim whitespace from the beginning and end of the line
                 // Ignore lines starting with "//"
               if (lineOfText.startsWith("//")) {
                 continue; // ignore comment or blank lines
                }else if (lineOfText.isEmpty()){
                 continue;
               } else if (lineOfText.startsWith("[")) {
                 typeOfData = lineOfText; // set typeOfData to the current flag
               } else {
                 // Create a new ElectricTool object and add it to the toolList
                 Scanner lineScanner = new Scanner(lineOfText);
                 lineScanner.useDelimiter("\\s*,\\s*");
                 if (typeOfData.equals("[ElectricTool data]")) {
                        item = new ElectricTool();
                        item.readData(lineScanner);
                        //item.printDetails();
                    } else if (typeOfData.equals("[electricTool data]")) {
                        item = new ElectricTool();
                        item.readData(lineScanner);
                        //item.printDetails();
                    }
                     else if (typeOfData.equals("[HandTool data]")) {
                        item = new HandTool();
                        item.readData(lineScanner);
                        //item.printDetails();
                    } 
                     else if (typeOfData.equals("[Perishable data]")) {
                        item = new Perishable();
                        item.readData(lineScanner);
                        //item.printDetails();
                    }
                     else if (typeOfData.equals("[Workwear data]")) {
                        item = new Workwear();
                        item.readData(lineScanner);
                        //item.printDetails();
                    }
                   else {
                        System.out.println("Unexpected flag encountered: " + typeOfData);
                        continue;
                    }
                 storeItem(item);
               }
              }
              scanner.close();
              printAllItems();
            }
            catch (FileNotFoundException e) {
            System.out.println("The selected file was not found: " + e.getMessage());}
          }
        
        else 
         {
            System.out.println("No file selected.");
         }
     }
     
    /**
     * This method uses a Scanner object to read customer data to the terminal
     * 
     */
    public void readCustomerData() 
     {
      Frame frame = null;
      FileDialog fileDialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
      fileDialog.setDirectory(".");
      fileDialog.setVisible(true);
      File selectedFile = new File(fileDialog.getDirectory(), fileDialog.getFile());
      System.out.println("Selected file: " + selectedFile.getAbsolutePath());
      File dataFile = selectedFile;
      
      try {
        Scanner scanner = new Scanner(dataFile);
        Customer customer;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim(); 
            if (!line.isEmpty() && !line.startsWith("//"))  
            { 
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(", ");
                customer = new Customer();
                customer.readData(lineScanner);
                customer.printDetails();
                
                storeCustomer(customer);
            }
        }
        scanner.close();
        printAllCustomers();
     } catch (FileNotFoundException e) {
        System.out.println("Error reading customer data file: " + e.getMessage());
     }
    }
    
    /**
     * This method uses PrintWriter object to write customer data to a file
     * 
     */
    public void writeCustomerData(String fileName) 
    {
      try{
        PrintWriter pWriter = new PrintWriter(fileName);
        for (Customer customer : customerMap.values()) //( Customer customer : customerList)
        {
          customer.writeData(pWriter);
        }
        pWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("There is an error when writing in file : " + fileName);
        }
     }
    
    /**
     * This method deletes an Item Reservation
     * 
     */
    public void deleteItemReservation(String reservationNumber) {
        // Find the reservation with the given reservation number
        ShopItemReservation reservationToDelete = null;
        for (ShopItemReservation reservation : itemReservationMap.values()) {
            if (reservation.getReservationNo() == reservationNumber) {
                reservationToDelete = reservation;
                break;
            }
        }
        
        if (reservationToDelete != null) {
            itemReservationMap.remove(reservationToDelete.getItemID());
            System.out.println("Reservation with number " + reservationNumber + " has been deleted.");
        } else {
            System.out.println("No reservation found with number " + reservationNumber);
        }
    }
}