import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Menu {
	
	
	/*******Instance fields********/
	private String name;
	private double price;
	private int    code;
	private RestaurantList<MenuItem> menuList = new RestaurantList<>();
	 

	public Menu(MenuItem menuItem) {
		
		setMenuList(new RestaurantList<MenuItem>());
	
	}
	



		

	
	
	
	

/*************Getters*************/
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getCode() {
		return code;
	}
	
	public RestaurantList<MenuItem> getMenuList() {
		return menuList;
	}


/************Setters**************/
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setMenuList(RestaurantList<MenuItem> menuList) {
		this.menuList = menuList;
	}
	
}
