/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

class Car extends Vehicle{
	int PassengersNumber;
	public Car(int vehicleID,int PassengerNumber,int RentalCostPerDay,String Owner){
		super(vehicleID,Owner,RentalCostPerDay);
		this.PassengersNumber=PassengerNumber;
		
	}
	//getter
	public int getPassengerNumber(){
		return this.PassengersNumber;
	}

}
