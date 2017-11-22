/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

import java.util.*;

class House extends Property {
	/*
	 * Sub-class specific objects
	 */
	int noOfStoreys;
	int clearingFees;

	public House(int rentalID,int rentPerDay , String owner,String postAddress, int clearingFees, int noOfStoreys) {
		/*
		 * Sending attributes back to the super class
		 */
		super(rentalID,rentPerDay, owner, postAddress);
		this.noOfStoreys = noOfStoreys;
		this.clearingFees = clearingFees;
	}

	/*
	 * Sub class specific getters
	 */
	public int getStoreys() {
		return this.noOfStoreys;
	}

	public int getClearingFees() {
		return this.clearingFees;
	}
}
