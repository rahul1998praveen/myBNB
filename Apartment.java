/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

import java.util.*;

class Apartment extends Property { // Implementing the interface
	/*
	 * Sub-class specific objects
	 */
	int storeyNo;
	int noOfBeds;

	public Apartment(int rentalID, int rentPerDay, 
			String Owner, String postAddress, int storeyNo, int noOfBeds)
			throws Exception {
		/*
		 * Sending attributes back to the super class
		 */
		super(rentalID, rentPerDay, Owner, postAddress);
		this.storeyNo = storeyNo;
		this.noOfBeds = noOfBeds;

	}

	/*
	 * Sub class specific getters
	 */
	public int getStoreyNo() {
		return this.storeyNo;
	}

	public int getNoOfBeds() {
		return this.noOfBeds;
	}
}
