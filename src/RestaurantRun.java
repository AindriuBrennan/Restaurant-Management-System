import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 * 
 * 
 * @class RestaurantRun<E> 
 * create a generic LinkedList class for storing various object types.
 * an interator was implemented on this list.
 * 
 *  ============================================================
 *  Known Bugs
 *  ============================================================
 *   - Unable to add bookings to a table
 *   - Lacking a GUI.
 *   - Calculating the total purchases for a booking does not operate as expected.
 *   - When adding a purchase it prints the menu choice twice 
 *   - The line for telling the user they can reset all the lists wont print.
 *  
 *  
 * 
 */

public class RestaurantRun<E> {

	private Scanner input;
	int tableId;
	int seats;
	
	private boolean isActive;
	RestaurantList<E> restaurantList = new RestaurantList<>();
	RestaurantList<Table> tableList = new RestaurantList<>();
	RestaurantList<Booking> bookingList = new RestaurantList<>();
	RestaurantList<MenuItem> menuList = new RestaurantList<>();
	RestaurantList<Purchase> purchaseList = new RestaurantList<>();

	public static <E> void main(String[] args) {
		new RestaurantRun<E>();

	}

	public RestaurantRun() {
		input = new Scanner(System.in); 
		restaurantRun();

	}
	

	/**
	 * 
	 * @mainMenu() 
	 * this method displays a list of options and  reads the user input and displays back the information of their choice
	 */
	//fix the purchase check out situation
	
	private int mainMenu() {
		
		System.out.println("Restaurant Start");
		System.out.println("----------");
		System.out.println("  1)   Add a table");
		System.out.println("  2)   List all tables");
		System.out.println("  3)   Remove a table (by index)");
		System.out.println("  4)   Number of tables in the Restaurant");
		System.out.println("  5)   Save Tables to XML");
		System.out.println("  6)   Load  Tables from XML");
		System.out.println("----------");
		System.out.println("  7)   Add a Booking");
		System.out.println("  8)   List Bookings");
		System.out.println("  9)   Delete Booking");
		System.out.println("  10)  Change booking status");
		System.out.println("  11)  Save Bookings to XML");
		System.out.println("  12)  Load Bookings from XML");
		System.out.println("----------");
		System.out.println("  13)  Add purchase to Booking");
		System.out.println("  14)  List purchases");
		System.out.println("  15)  Delete a purchase");
		System.out.println("----------");
		System.out.println("  16)  Add Item to Menu");
		System.out.println("  17)  Remove Item from Menu");
		System.out.println("  18)  Change Item Price");
		System.out.println("  19)  List Items on the menu");
		System.out.println("  20)  Save Menu to XML");
		System.out.println("  21)  Load Menu from XML");
		System.out.println("----------");
		System.out.println("  22)  Clear all Lists");
		System.out.println("  0)   Exit");
		System.out.println("====>");
		int option = input.nextInt();
		return option;	
	}
	
	/**
	 * @restaurantRun
	 * switch statement for taking in user input
	 */
	private void restaurantRun() {
		int option = mainMenu();
		while (option != 0) {
			switch (option) {
			case 1:		addTable();
			break;
			case 2:		System.out.println(tableList.show());
			break;
			case 3:		tableList.deleteAt(input.nextInt());
			break;
			case 4:		System.out.println(tableList.getCount());
			break;
			case 5:    try {
				saveTables();
			}
			catch (Exception e) {
				System.err.println("Error writing to file: " + e);
			}
			break;
			case 6:    try {
				loadTables();
			}
			catch (Exception e) {
				System.err.println("Error reading from file: " + e);
			}
			break;
			case 7:		addBooking();
			break;
			case 8:		System.out.println(bookingList.show());
			break;
			case 9:		System.out.println("which booking would you like to delete? \n");
						System.out.println(bookingList.show());
						bookingList.deleteAt(input.nextInt());
						
						
			break;
			case 10:		bookingStatus();
						if(checkIn() == true) {
							purchaseItem();
						}
			break;
			case 11:    try {
				saveBookings();
			}
			catch (Exception e) {
				System.err.println("Error writing to file: " + e);
			}
			break;
			case 12:    try {
				loadBookings();
			}
			catch (Exception e) {
				System.err.println("Error reading from file: " + e);
			}
			break;
			case 13:    	purchaseItem();
			break;
			case 14:    System.out.println(purchaseList.show());
			break;
			case 15:	System.out.println(purchaseList.show());
						System.out.println("which purchase would you like to delete? \n");
						purchaseList.deleteAt(input.nextInt());
			break;
			case 16:	addItem();
			break;
			case 17:	System.out.print("which Item would you like to delete? \n");
						System.out.println(menuList.show());
						menuList.deleteAt(input.nextInt());
			break;
			case 18:	changeItemPrice();
			break;
			case 19:    System.out.println(menuList.show());
			break;
			case 20:    try {
				saveMenu();
			}
			catch (Exception e) {
				System.err.println("Error writing to file: " + e);
			}
			break;
			case 21:    try {
				loadMenu();
			}
			catch (Exception e) {
				System.err.println("Error reading from file: " + e);
			}
			break;
			default:   System.out.println("Invalid option entered: " + option);
			break;
			case 22:    resetList();
			break;
			}
			//pause the program so that the user can read what was printed
			System.out.println("\nPress any key to continue...");
			input.nextLine();
			//display the main menu again
			option = mainMenu();
		}
		
	
		//the user chose option 0, so exit the program
				System.out.println("Exiting... bye");
				System.exit(0);
	}
	
	
	
	

	

	/********** TABLE METHODS **************/
	
	//add a table to the tableList
	/**
	 * @addTable
	 * 
	 * Method for adding a table to the tableList linked list
	 * 
	 */
	private void  addTable() {

		System.out.print("Enter a Table No  \n");
		this.tableId = input.nextInt();

		System.out.print("How many seats for this table?  \n");
		this.seats = input.nextInt();

		//System.out.print("Add a booking to this table? yes/no");
		//input.nextLine(); 

		Table newTable = new Table(seats, tableId);
		tableList.insert(newTable);

	}

	
	
	
	
	/*********** BOOKING METHODS **********/
	
	/**
	 * @addBooking
	 * 
	 * Method for adding bookings to the bookingList linkedList
	 */
	private void addBooking() {

		System.out.print("Enter Booking name \n");
		input.nextLine();
		String bookingName = input.nextLine();
		
		System.out.print("Enter Group Size  \n");
		int bookingSize = input.nextInt();

	
		System.out.print("Enter the time the booking is for  (between 4 pm and 10 pm) \n");
		double bookingTime = input.nextDouble();

		System.out.print("How long is the booking for? \n");
		double bookingLength = input.nextDouble();

		
		String bookingStatus = "no change in status"; 
		
		
		Booking newBooking = new Booking(bookingName, bookingSize, bookingTime, bookingLength, bookingStatus);
		bookingList.insert(newBooking);
	}

	

	/**
	 * 
	 * @bookingStatus
	 * method for updating the status of a booking from inactivity to activity
	 * and vice versa. when the bookings activity is changed it calls the purchase method and adds purchases to the booking
	 * when the status of the booking is changed to check out it calculates the total purchases on the booking
	 */
	public String bookingStatus() {
		System.out.println("which bookings status would you like to change?");
		System.out.println(bookingList.show());
		bookingList.get(input.nextInt());
		System.out.print("what would you like to do with this booking?..  check in/check out/cancel/leave/...\n");
		String checkStatus = input.nextLine();
		input.nextLine();
		for(Booking booking : bookingList) {
		
		if (checkStatus == "check in") {
			booking.setStatus(checkStatus);
			isActive = true;
			checkIn();
		

		} else if (checkStatus == "check out") {
			booking.setStatus(checkStatus);
			isActive = false;
			checkOut();
		}

		else if (checkStatus == "cancel") {
			booking.setStatus(checkStatus);
			return checkStatus;
		}
		else return "no change in status";	
		}
		return checkStatus;	
	}
	

	/**
	 * @selectBooking
	 * Method for selecting a booking from the bookingList
	 */
	public void selectBooking() {
		System.out.print("please select a booking"+"\n");
		int userInput = input.nextInt();
		System.out.println(bookingList.show());
		bookingList.get(userInput);
		//System.out.print("what would you like to do with this booking?");	
	}
	
	
	/**
	 * 
	 * @checkIn
	 * method for activating a booking based on the status of the booking
	 * when the booking is set to be checked in items can be purchased and added to the booking
	 * 
	 */
	public boolean checkIn() {
		isActive = false;
		// System.out.print("check in this booking?");
		for (Booking booking : bookingList) {
			if (booking.getBookingStatus() == "check in") {
				return isActive = true;
			}
			purchaseItem();
		}
		return isActive;
	}

	/**
	 * 
	 * @checkOut
	 * when the status of a booking is change to check out, a total is generated for 
	 * all the items purchased on that booking.
	 */
	public boolean checkOut() {
		isActive = false;
		for (Booking booking : bookingList) {
			if (booking.getBookingStatus() == "check out") {
				return isActive = false;
			}
			purchaseListTotal();
		}
		return isActive;

	}

	/**
	 * @cancelBooking
	 *  
	 *  Method for cancelling a booking
	 *  not properly implemented.
	 */
	public void cancelBooking() {
		for (Booking booking : bookingList) {
			if (booking.getBookingStatus() == "cancel") {
				bookingList.show();
				bookingList.deleteAt(input.nextInt());
			}
		}

	}

	
	/*********** MENU METHODS *************/
	
	/**
	 * @addItem
	 * adds a menu item to the menuList linked list
	 * 
	 */
	
	public void addItem() {
		input.nextLine();
		System.out.print("Enter item Name..\n");
		String itemName = input.nextLine();
		
		System.out.print("Enter a price for this item..\n");
		double itemValue = input.nextDouble();
		
		System.out.print("Enter an item code..\n");
		int itemCode = input.nextInt();
		
		MenuItem newMenuItem = new MenuItem(itemName, itemValue, itemCode);
		menuList.insert(newMenuItem);
		
	}
	

	/**
	 * @changeItemPrice
	 * 
	 * method for changing the price of items in the menuList
	 * 
	 */
	public void changeItemPrice() {
		for(MenuItem menuItem : menuList) {
		int choice = input.nextInt();
		System.out.print("which item would you like to edit? \n");
	    System.out.print("-----------------------------------");
	    System.out.print(menuList.show());
	    menuList.get(choice);
	    System.out.print("what is the new price?");
	    double newPrice = input.nextDouble();
	    menuItem.setItemPrice(newPrice);
		}
	}

	/**
	 * 
	 * @listMenuItems
	 * 
	 * method for listing all the Item objects added to the menuList
	 * linked list
	 */
	public String listMenuItems() {

		String itemMenu = "";
		for (MenuItem menuItem : menuList) {
			itemMenu = menuItem + ": " + menuList.toString() + "\n;";
		}
		if (itemMenu.equals("")) {
			return " no items on menu";
		} else {
			return itemMenu;
		}
	}

	
	/**
	 * @removeMenuItem
	 * 
	 * removes menuItems from the menuList
	 */
	public void removeMenuItem() { // remove items from the menu at user input index

		System.out.print(listMenuItems());
		if (menuList.getCount() != 0) {
			System.out.print("which item would you like to remove from the menu? \n");
			int index = input.nextInt();

			if (index < menuList.getCount()) {
				menuList.deleteAt(index);
			}
		}

	}

	
	/*********** PURCHASE METHODS **********/

	/**
	 * @purchaseItem
	 * 
	 * Method for adding menuItems to a purchaseList
	 */
	public void purchaseItem() {
		System.out.print("which item would you like to purchase? \n");
		System.out.print(menuList.show());
			int choice = input.nextInt();
			Purchase newPurchase = new Purchase(menuList.get(choice),itemQuantity(), purchaseValue());
			purchaseList.insert(newPurchase); 
			}
			
	
	/**
	 * 
	 * @itemQuantity
	 * 
	 * Method for choosing how many menuItem objects will be added
	 * to the purchaseList, this value cant be greater than or less than 
	 * the set ammount of seats for a table
	 */
	public int itemQuantity() {
		
		System.out.print("how much would you like to buy? \n");
		int ammount;
		input.nextInt();
		ammount = input.nextInt();
		if ((ammount >= 1) || (ammount <= 12)) {
			return ammount;
		}
		else {
			System.out.print("Enter a valid quantity \n");
			ammount = input.nextInt();
		}
		return ammount;
	}

	/**
	 * 
	 * @purchaseValue
	 * method for calculating the value of the item purchased
	 */
	public double purchaseValue() {
		double total = 0;
		for (MenuItem menuItem : menuList) { 
			total = (menuItem.getItemPrice() * itemQuantity());
			return total;
			//menuItem.setPurchaseValue(total);
		}
		return total;  //purchaseValue();
	}
	
	/**
	 * @purchaseListTotal
	 * Method for calculating the total cost of a purchaseList
	 */
	public double purchaseListTotal() {
		double listTotal = 0.0;
		for(Purchase menuItem : purchaseList) {
			listTotal = (menuItem.getItemQuantity()*purchaseValue());
			return listTotal;
		}
		return listTotal;
	}
	

	
	public void resetList() {
		tableList.reset();
		bookingList.reset();
		menuList.reset();
		purchaseList.reset();
	}
	
	
/******serialise-and-deserialize******/
	
	/**
	 * @saveMenu
	 * @saveBookingList
	 * @saveTableList
	 * 
	 * these methods save their respective lists to XML
	 * 
	 * 
	 */
	
	 /**
	 * 
	 * @loadMenu
	 * @loadBookingList
	 * @loadTableList
	 * these methods load their respective lists from XML
	 * 
	 */
	
	
	  /**
	   * 
	   * @save
	   * save data to the xml file
	   */

	    public void saveMenu() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("menuList.xml"));
	        out.writeObject(menuList);
	        out.close();    
	    }
	/**
	 * 
	 * @load  load data saved to the xml file
	 */
	
	
	  @SuppressWarnings("unchecked")
	    public void loadMenu() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("menuList.xml"));
	        menuList = (RestaurantList<MenuItem>) is.readObject();
	        is.close();
	    }
	
		
	  /**
	   * 
	   * @save
	   * save data to the xml file
	   */

	    public void saveBookings() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("bookingList.xml"));
	        out.writeObject(bookingList);
	        out.close();    
	    }
	/**
	 * 
	 * @load  load data saved to the xml file
	 */
	
	
	  @SuppressWarnings("unchecked")
	    public void loadBookings() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("bookingList.xml"));
	        bookingList = (RestaurantList<Booking>) is.readObject();
	        is.close();
	    }
	
		
	
	  /**
	   * 
	   * @save
	   * save data to the xml file
	   */

	    public void saveTables() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("tableList.xml"));
	        out.writeObject(tableList);
	        out.close();    
	    }
	/**
	 * 
	 * @load  load data saved to the xml file
	 */
	
	
	  @SuppressWarnings("unchecked")
	    public void loadTables() throws Exception
	    {
	        XStream xstream = new XStream(new DomDriver());
	        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("tableList.xml"));
	        tableList = (RestaurantList<Table>) is.readObject();
	        is.close();
	    }
	


}
