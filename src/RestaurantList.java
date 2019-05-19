import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;



/**
 * 
 * @author Andrew Brennan
 * @version 1.0
 * @since 10/11/2018
 * 
 * 
 * @class RestaurantList<E> 
 * create a generic LinkedList class for storing various object types.
 * an interator was implemented on this list.
 * 
 */







public class RestaurantList<E> implements Iterable<E> {

	
	
	/********************INSTANCE FIELDS********************/
	
	public RestaurantNode<E> head = null;
	private int counter;
	
	
	
	/**
	 * 
	 * @insert(E e)  
	 * method for inserting node objects into lists
	 */
	public void insert(E e) {

		RestaurantNode<E> node = new RestaurantNode<>();
		node.setContents(e);
		node.next = null;

		if (head == null) {

			head = node;

		} else {

			RestaurantNode<E> rn = head;
			while (rn.next != null) {
				rn = rn.next;
			}
			rn.next = node;
		}
		counter++;
	}
	
	
	/**
	 * 
	 * @addElementAtStart(E e)
	 * method for adding elements to the start of the list
	 * this was not implemented in the final version
	 * 
	 */
	public void addElementAtStart(E e) {

		RestaurantNode<E> node = new RestaurantNode<>();
		node.setContents(e);
		node.next = head;
		head = node;
		counter++;
	}

	
	
	
	
	// get the index of a node object in the list.
	/**
	 * @get method for getting a node object at a specific index point in the list
	 * 
	 * @param counter
	 * used for indexing the list
	 * 
	 */
	public E get(int counter) {
		if (counter < 0) {
			return null;
		}

		RestaurantNode<E> gn = null;
		if (head != null) {
			gn = head;
			for (int i = 0; i < counter; i++) {
				if (gn.next == null)
					return null;
				gn = gn.next;
			}
			return gn.getContents();
		}
		return gn.getContents();

	}


	/**
	 * 
	 * @Object getContents
	 * method for getting a node object by its contents.
	 * not implemented in the final version
	 * 
	 */
	public Object getContents(E contents) {
		if (counter < 0) {
			return null;
		}

		RestaurantNode<E> getObjectContents = head;
		while (getObjectContents != null && getObjectContents.getContents() != contents)
			getObjectContents = getObjectContents.next;
		if (getObjectContents != null) {
			return getObjectContents.getContents();
		}
		return getObjectContents;
	}

	
	
	
	/**
	 * 
	 * @deleteAt
	 * method for deleting a node by its index number
	 */
	public void deleteAt(int counter) {

		if (counter == 0) {

			head = head.next;

		} else {

			RestaurantNode<E> n = head;
			RestaurantNode<E> n1 = null;

			for (int i = 0; i < counter - 1; i++) {

				n = n.next;
			}

			n1 = n.next;
			n.next = n1.next;

		}

	}

	// get the size of the list
	// https://www.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
	// needs a referance for this
	
	
	/**
	 * 
	 * @getCount
	 * method for getting the length of the linked list
	 * returns an integer value for the length
	 */
	public int getCount() {
		RestaurantNode<E> temp = head;
		int counter = 0;
		while (temp != null) {
			counter++;
			temp = temp.next;
		}
		return counter;
	}
	
	
	/**
	 * 
	 * @show
	 * method for getting a toString of a node, used for essentially printing a list
	 */
	public String show() {
		RestaurantNode<E> node = head;
		String showList ="";
		while (node != null) {

			showList += (node.getContents().toString());
			node = node.next;
		}
		return showList;
	}
	
	public void reset() {
		head = null;
	}

	
	/**
	 * 
	 * @RestaurantIterator
	 * the Iterator class for the linked list
	 *
	 */
	public class RestaurantIterator implements Iterator<E> {

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Iterator.super.remove();
		}

		private RestaurantNode<E> pos;

		public RestaurantIterator(RestaurantNode<E> node) {
			pos = node;
		}

		@Override
		public boolean hasNext() {

			return pos != null;
		}

		@Override
		public E next() {

			RestaurantNode<E> temp = pos;
			pos = pos.next;
			return temp.getContents();
		}

	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new RestaurantIterator(head);
	}

}
