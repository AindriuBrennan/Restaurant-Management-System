/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 *
 */


/**
 * 
 * @Table
 * 
 * Table class is created and defined here
 *
 */

public class Table {
	
	private int tableId;
	private int seats;
	private RestaurantList<Booking> bookingList = new RestaurantList<>();


	public Table(int seats, int tableId) {
		if((seats >= 1) && (seats <= 12)) {
			this.seats = seats;
		}
		if((tableId >= 0) && (tableId <= 99999)) {
			this.tableId = tableId;
		}	
	}
		
	
		
		

	
	@Override
	public String toString() {
		return "Table No  = " + tableId + "\n" + "Seats     = " + seats + "\n" + "---------------" + "\n" ;
	}






	/*****************Getters*************/
	
	public int getSeats() {
		return seats;
	}
	
	public int getTableId() {
		return tableId;
	}
	
	public RestaurantList<Booking> getBookingList() {
		return bookingList;
	}
	

	
	
	/*****************Setters*************/
	
	public void setTableId(int tableId) {
		if((tableId >= 0) && (tableId <= 99999)) {
			this.tableId = tableId;
		}
	}

	public void setSeats(int seats) {
		if((seats >= 1) && (seats <= 12)) {
			this.seats = seats;
		}
	}

	public void setBookingList(RestaurantList<Booking> bookingList) {
		this.bookingList = bookingList;
	}
	
	
		
	
	
	
	
}
