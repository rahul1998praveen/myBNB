/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

import java.util.ArrayList;

class Villa extends Property {
	/*
	 * Sub-class specific objects
	 */
	int serviceTaxPerDay;
	int luxuryTax;

	public Villa(int rentalID,int rentPerDay, String Owner,String postAddress,int serviceTaxPerDay, int luxuryTax) {

		/*
		 * Sending attributes back to the super class
		 */

		super(rentalID,rentPerDay, Owner, postAddress);
		this.luxuryTax = luxuryTax;
		this.serviceTaxPerDay = serviceTaxPerDay;
	}

	/*
	 * Sub class specific getters
	 */
	public int getServiceTaxPerDay() {
		return this.serviceTaxPerDay;
	}

	public int getLuxuryTax() {
		return this.luxuryTax;
	}
}
