/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 *
 */

/**
 * 
 * @Purchase
 * 
 * Purchase class where the purchase object is created and defined
 *
 */

public class Purchase {
	
	
	private int itemQuantity;
	private double purchaseValue;
	private double itemValue;

	
	public Purchase() {
	
	} 
	
	public Purchase(MenuItem purchaseItem, int itemQuantity, double purchaseValue) {
		if((itemQuantity >= 1) || (itemQuantity <= 12)){
			this.itemQuantity = itemQuantity;
		}
		
	
		 
	} 
	
	
	
	@Override
	public String toString() {
		return "Item Quantity  =  " + itemQuantity + "\n" + "Purchase Value  = " + purchaseValue + "\n" + "Item Value= " + itemValue + "\n" + "---------------------------";
	}

	
	
	

	/**************Getters************/
	
	public double getPurchaseValue() {
		return purchaseValue;
		
	}
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	public double getItemValue() {
		return itemValue;
	}
	
	
	/**************Setters*************/
	public void setItemQuantity(int itemQuantity) {
		if((itemQuantity >= 1) || (itemQuantity <= 12)){
			this.itemQuantity = itemQuantity;
		}
	}
	
	public void setPurchaseValue(double purchaseValue) {
		if(purchaseValue == (itemQuantity * itemValue )) {
			this.purchaseValue = purchaseValue;
		}
	}
	
	public void setItemValue(double itemValue) {
		if((itemValue >= 00.01) && (itemValue <= 100.00)) {
			this.itemValue = itemValue;
		}
	}
	
	
	
}
	
	
	
 

