/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 * 
 * 
 * @class RestaurantNode<E>
 * create a generic node class for the linkedlist
 * 
 */
public class RestaurantNode<E> {
	
	
	public RestaurantNode<E> next = null;
	private E contents;
	
	public E getContents() { return contents; } 
	public void setContents(E c) { contents=c; }

	

}
