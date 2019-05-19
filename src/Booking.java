/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 *
 */

/**
 * 
 * @Booking
 * 
 * This is the booking class
 * The booking object is created and defined here.
 *
 */
public class Booking {
	
	/*****************Instance Fields*******************/
	
	private RestaurantList<Table> tableList;
	
	
	private String bookingName;
	private int    bookingSize;   //why does this need to be static
	private int    bookedTableNo;
	private double bookingTime;
	private double bookingLength;
	private boolean isActive;
    private String status;
    private RestaurantList<Purchase> purchaseList = new RestaurantList<>();
    
    
	
	/*********Constructor**********/
    
    public Booking() {
    	
    }
	
	public Booking (String bookingName, int bookingSize, double bookingTime, double bookingLength, String status) {
		
		if(bookingName.length() > 30) {
			this.bookingName= bookingName.substring(0,30);
		}
		else {
		
		this.bookingName = bookingName;
		}
		
		if((bookingSize >= 1) && (bookingSize <= 12)) {
			
			this.bookingSize = bookingSize;
		}
		
		if((bookingTime >= 04.00 ) && (bookingTime <= 10.00)) {
			
			this.bookingTime = bookingTime;
		}
		
		if((bookingLength >= 01.00) && (bookingLength <= 03.00)) {
			
			this.bookingLength = bookingLength;
		}
		this.status = status;
		
		purchaseList = new RestaurantList<Purchase>();
	
		
	}
	
	
	
	
	/**********Methods************/
	
	
	
	
      public String listTables() {
    	  
    	  return tableList.show();
    	  
      }
      
      
      
      /**
       * @toString 
       * 
       * creates a toString of the booking object
       */
	public String toString() {
		return "Booking Name    = " + bookingName + "\n" + "Booking Size    = " + bookingSize + "\n" + "Booking Time    = " + bookingTime + "\n" + "Booking Length  = " + bookingLength + "\n" + "--------------------------- \n";
	}

      

	/*****************Getters***************/
	
	public String getBookingName() {
		
		return bookingName;
	}
	
	
	public int getBookingSize() {
		
		return bookingSize;
	}
	
	public int getBookedTableNo() {
		
		return bookedTableNo;
	}
	
	public double getBookingTime() {
		
		return bookingTime;
	}
	
	public double getBookingLength() {
		
		return bookingLength;
	}
	
	public String getBookingStatus() {
		
		return status;
	}

	
	public RestaurantList<Purchase> getPurchaseList() {
		return purchaseList;
	}

	
	
	
	/*****************Setters**************/
	
	public void setBookingName(String bookingName) {
		if(bookingName.length() > 30) {
			this.bookingName= bookingName.substring(0,30);
		}
		else {
		
		this.bookingName = bookingName;
		}
	}
	
	public void setBookingSize(int bookingSize) {
		if((bookingSize >= 1) && (bookingSize <= 12)) {
		
			this.bookingSize = bookingSize;
		}
	}
	
	public void setBookedTableNo(int bookedTableNo) {
		
		this.bookedTableNo = bookedTableNo;
	}

	public void setBookingTime(double bookingTime) {
		if((bookingTime >= 16.00 ) && (bookingTime <= 22.00)) {
		
			this.bookingTime = bookingTime;
		}
	}

	public void setBookingLength(double bookingLength) {
		if((bookingLength >= 01.00) && (bookingLength <= 03.00)) {
			
			this.bookingLength = bookingLength;
		}
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void setPurchaseList(RestaurantList<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
	
	


	
}
