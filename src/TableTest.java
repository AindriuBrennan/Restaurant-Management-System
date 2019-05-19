import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {
	
	Table t;

	@BeforeEach
	void setup() throws Exception {
		t=new Table(0, 0);
		t.setSeats(4);
		//t.setSeats(13);
		t.setTableId(50);
		//t.setTableId(1000000000);
	}
	
	@Test
	void testGetSeats() {
		assertEquals(4, t.getSeats());
	}
	
	@Test
	void testSetSeats() {
		assertEquals(4, t.getSeats());
		t.setSeats(5);
		assertEquals(5, t.getSeats());
	}
	
	@Test
	void testGetTableId() {
		assertEquals(50, t.getTableId());
	}
	
	@Test
	void testSetTableId() {
		assertEquals(50,t.getTableId());
		t.setTableId(51);
		assertEquals(51,t.getTableId());
	}
	
	
	
		

}
