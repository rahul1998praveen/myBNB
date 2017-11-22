/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

class Truck extends Vehicle{
	int CargoWeight;
	public Truck(int vehicleID,int CargoWeight,int RentalCostPerDay,String Owner){
		super(vehicleID,Owner,RentalCostPerDay);
		this.CargoWeight=CargoWeight;
		
	}
	//getter
	public int getCargoWeight(){
		return this.CargoWeight;
	}

}
