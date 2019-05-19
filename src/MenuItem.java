/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 *
 */

/**
 * 
 * @MenuItem
 * 
 * MenuItem object is created and defined here
 * 
 *
 */


public class MenuItem {

	private String  itemName;
	private double  itemPrice;
	private int 	itemCode;

	
	
	
	
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MenuItem(String itemName, double itemPrice, int itemCode) {
		this.itemName  = itemName;
		
		if((itemPrice >= 01.00) || (itemPrice <= 1000.00)) {
			this.itemPrice = itemPrice;
		}
		if((itemCode >= 1) && (itemCode <= 99999)) {
			this.itemCode = itemCode;
		}
	}

	
	
	@Override
	public String toString() {
		return "Item Name   = " + itemName + "\n" + "Item Price  =  " + itemPrice + "\n" + "\n" + "---------------------" + "\n";
	}


	

	
	/**********Getters***********/
	public int getItemCode() {
		return itemCode;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	
	
	/*********Setters*************/
	public void setItemCode(int itemCode) {
		if((itemCode >= 1) && (itemCode <= 99999)) {
			this.itemCode = itemCode;
		}
	}
	
	public void setItemPrice(double itemPrice) {
		if((itemPrice >= 01.00) && (itemPrice <= 1000.00)) {
			this.itemPrice = itemPrice;
		}
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
