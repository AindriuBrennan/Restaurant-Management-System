import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestaurantListTest {

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setup() throws Exception{
		RestaurantList<Table> rl = new RestaurantList<>();
		rl.insert( new Table(5,50));
		rl.insert(new Table(2,20));
		
	
	}
	
	@Test
	void testGetCount() {
		RestaurantList<Table> rl = new RestaurantList<>();
		rl.insert( new Table(5,50));
		rl.insert(new Table(2,20));
		assertEquals(rl.getCount(), 2);
	}
	
	
	@Test
	void testAddElementAtStart() {
		RestaurantList<Table> rl = new RestaurantList<>();
		rl.insert( new Table(5,50));
		rl.insert(new Table(2,20));
		rl.addElementAtStart(new Table(3,5));
		
		assertEquals(rl.get(0), 0);
	}
	
	

	

}
