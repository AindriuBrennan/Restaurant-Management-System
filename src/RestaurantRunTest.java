import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RestaurantRunTest {
	
	RestaurantList<Table> tableList = new RestaurantList<>();
	RestaurantList<Booking> bookingList = new RestaurantList<>();
	RestaurantList<MenuItem> menuList = new RestaurantList<>();
	RestaurantList<Purchase> purchaseList = new RestaurantList<>();
	
	@BeforeAll 
		
	public void setUp() {
		tableList.insert(   new Table(5, 40));
		bookingList.insert( new Booking("bob", 4, 6.00, 2.00, "no change in status"));
		menuList.insert(    new MenuItem("pizza", 5.5, 123));
		purchaseList.insert(new Purchase( null, 2, 11.00));
		
		
	}
	
	private void addTable() {
		tableList.insert(   new Table(4, 20));
		
		
	}

	@Test
	void testAddTable() {
		assert(new Table(4,20) , addTable());
	}

}
