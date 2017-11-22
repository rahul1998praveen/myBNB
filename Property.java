/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

import java.util.*;

import javax.swing.JOptionPane;

public class Property implements RentItem{
	int rentPerDay;
	static int count = 0;
	int rentalID;
	String Owner;
	String postAddress;
	int daysAllowed = 300;
	int totalRentalDays;/* No. of days for which the property is rented */

	int daysRented = 0;/* total days for which the property is being rented */

	/*
	 * Super Class to store all the common properties
	 */
	public Property(int rentalID,int rentPerday,String Owner, String postAddress){
		/*
		 * All the setters
		 */
		this.Owner = Owner;
		this.rentPerDay=rentPerday;
		this.postAddress = postAddress;
		this.rentalID=rentalID;
	}

	/*
	 * All the getters
	 */
	public int getrentalID() {
		return rentalID;
	}

	public String getOwner() {
		return Owner;
	}

	public String getpostAddress() {
		return postAddress;
	}

	public int getRentPerDay() {
		return this.rentPerDay;
	}

	public int gettotalRentalDays() {
		return this.totalRentalDays;
	}

	public int getDaysRented() {
		return daysRented;
	}
	//Implementing the interface
	public void RentItem(int rentalDays) {
		// TODO Auto-generated method stub
		this.totalRentalDays=rentalDays;
	}
}
