/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;


public class Vehicle implements RentItem{//Implementing the interface
	String Owner;
	int RentalDays;
	int RentalCostPerDay;
	int vehicleID;
	
	public Vehicle(int vehicleID,String Owner,int RentalCostPerDay){
		this.Owner=Owner;
		this.vehicleID=vehicleID;
		this.RentalCostPerDay=RentalCostPerDay;
	}
	// Set of getters
	public String getOwner(){
		return this.Owner;
	}
	public int getRentalDays(){
		return this.RentalDays;
	}
	public int getRentalCostPerDay(){
		return this.RentalCostPerDay;
	}
	public int getvehicleID(){
		return this.vehicleID;
	}
	//Interface
	
	public void RentItem(int rentalDays) {
		// TODO Auto-generated method stub
		this.RentalDays=rentalDays;
		
	}

}
