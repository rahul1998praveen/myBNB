/*
 * Made By Rahul Praveen 
 * Student number - 16203022
 */
package myBNB;

import java.io.FileWriter;
import java.awt.font.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*; // JFrame is a swing class
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import myBNB.Property;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int choice;
		ArrayList<Car> cars = new ArrayList<>();
		ArrayList<Truck> trucks = new ArrayList<>();
		ArrayList<Apartment> apartments = new ArrayList<>();
		ArrayList<House> houses = new ArrayList<>();
		ArrayList<Villa> villas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPress 1 to rent a Property or press 2 to rent a Vehicle.\n");
		choice = sc.nextInt();
		// Asking user for choice, whether to rent a vehicle or a property
		if (choice == 1) {
			ReadInputPropertyFile(apartments, houses, villas);
			userInputProperty(apartments, villas, houses);

		} else if (choice == 2) {
			readVehicleFile(cars, trucks);
			userInputVehicle(cars, trucks);
		} else {
			JOptionPane.showMessageDialog(null, "No option selected");
		}

	}

	// Reading from the input vehicle file
	public static void ReadInputPropertyFile(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src\\myBNB\\propertyInput.txt"));
		int propertyType;
		int rentalDays;
		try {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				Scanner sc = new Scanner(line);
				propertyType = sc.nextInt();

				// reading the first input, i.e property type
				if (propertyType == 1) {
					// TODO: We know this is an apartment; so we parse the
					// current line accordingly.
					// System.out.println(sc.nextInt()+ sc.nextInt()+ sc.next()+
					// sc.next()+ sc.nextInt()+sc.nextInt());
					apartments.add(new Apartment(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(),
							sc.nextInt()));
				}
				if (propertyType == 2) {
					// TODO: We know this is a house; so we parse the current
					// line accordingly.
					houses.add(new House(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt()));

				}
				if (propertyType == 3) {
					// TODO: We know this is a villa; so we parse the current
					// line accordingly.
					villas.add(new Villa(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt()));
				}
				sc.close();
			}
			// Exception handling

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error file not found");
		}
	}

	// JFrame for taking the user input fo properties
	public static void userInputProperty(ArrayList<Apartment> apartments, ArrayList<Villa> villas,
			ArrayList<House> houses) throws Exception {
//Adding all the properties to JFrame 
		JFrame GUI = new JFrame("Rent Property");
		JLabel label1;
		JLabel label3;
		JLabel label2;
		JTextField text1;
		JTextField text2;
		JButton InputButton;
		label1 = new JLabel("Rental ID:");
		label3 = new JLabel(
				"Press Rent to rent the property, Press Calculate to calculate the income, Close the JFrame to get output file done");
		label2 = new JLabel("Rental Days");

		text1 = new JTextField(2);
		text2 = new JTextField(2);
		JButton calculate = new JButton("Calculate");
		calculate.setPreferredSize(new Dimension(70, 20));
		InputButton = new JButton("add days");
		label1.setPreferredSize(new Dimension(70, 70));
		label2.setPreferredSize(new Dimension(70, 70));
		text1.setPreferredSize(new Dimension(50, 50));
		text2.setPreferredSize(new Dimension(50, 50));
		label1.setSize(label1.getPreferredSize());
		label2.setSize(label1.getPreferredSize());
		text1.setSize(text1.getPreferredSize());
		text2.setSize(text1.getPreferredSize());
		InputButton.setPreferredSize(new Dimension(70, 20));
		InputButton.setSize(InputButton.getPreferredSize());
		InputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean found = false;
				int rentID;
				int rentalDays;
				String userID = text1.getText();
				String rDays = text2.getText();
				rentID = Integer.parseInt(userID);
				rentalDays = Integer.parseInt(rDays);
				if (!found) {
					for (Villa villa : villas) {
						if (villa.getrentalID() == rentID) {
							found = true;
							villa.RentItem(rentalDays);// Using the interface to
														// send rental days
						}
					}
				}
				if (!found) {
					for (Apartment apartment : apartments) {
						if (apartment.getrentalID() == rentID) {
							found = true;
							apartment.RentItem(rentalDays);
						}
					}
				}
				if (!found) {
					for (House house : houses) {
						if (house.getrentalID() == rentID) {
							found = true;
							house.RentItem(rentalDays);
						}
					}
				}
			}
		});
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateIncome(apartments, houses, villas);
				printProperties(apartments, houses, villas);
			}
		});

		try {
			GUI.add(label1);
			GUI.add(text1);
			GUI.add(label2);
			GUI.add(text2);
			GUI.add(InputButton);
			GUI.add(calculate);
			GUI.add(label3);
			GUI.setSize(new Dimension(700, 700));
			GUI.setLayout(new FlowLayout());
			GUI.setVisible(true);
			GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Frame  not working");
		}
	}

	public static int CalculateIncome(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {
		/*
		 * Calculating income of all the properties
		 */
		int TotalRentIncome = 0;
		int i;
		for (i = 0; i < apartments.size(); i++) {
			if (apartments.get(i).gettotalRentalDays() == 0) {
				i++;
			} else {
				TotalRentIncome += (apartments.get(i).gettotalRentalDays() * apartments.get(i).getRentPerDay());
			}

		}
		for (i = 0; i < houses.size(); i++) {
			if (houses.get(i).gettotalRentalDays() == 0) {
				i++;
			} else {
				TotalRentIncome += houses.get(i).gettotalRentalDays() * houses.get(i).getRentPerDay()
						+ houses.get(i).getClearingFees();
			}

		}
		for (i = 0; i < villas.size(); i++) {
			if (villas.get(i).gettotalRentalDays() == 0) {
				i++;
			} else {
				TotalRentIncome += (villas.get(i).getLuxuryTax() + villas.get(i).getServiceTaxPerDay()
						+ villas.get(i).gettotalRentalDays()) * villas.get(i).getRentPerDay();
			}

		}
		return TotalRentIncome;
	}

	public static void printProperties(ArrayList<Apartment> apartments, ArrayList<House> houses,
			ArrayList<Villa> villas) {
		// Printing all properties to the output file
		try {
			String outputFileProp = "src\\myBNB\\OutputProperty.txt";
			PrintWriter out = new PrintWriter(new FileWriter(outputFileProp));
			int i;
			out.println("==============All Apartments===========================");
			for (i = 0; i < apartments.size(); i++) {
				out.println("\tRegistration Number:" + apartments.get(i).getrentalID() + "\t Owner name:"
						+ apartments.get(i).getOwner() + "\t No.of Beds:" + apartments.get(i).getNoOfBeds()
						+ "\t Rent Per Day: " + apartments.get(i).getRentPerDay() + "\t Storey Number:"
						+ apartments.get(i).getStoreyNo() + "\t Total Rental Days: "
						+ apartments.get(i).gettotalRentalDays() + "\t Postal Address :"
						+ apartments.get(i).getpostAddress());
			}
			out.println("==============All Houses==========================");
			for (i = 0; i < houses.size(); i++) {
				out.println("\tNo. Of Storeys:" + houses.get(i).getStoreys() + "\t Owner Name: "
						+ houses.get(i).getOwner() + "\t Clearing Fees:" + houses.get(i).getClearingFees()
						+ "\t Rent Per Day:" + houses.get(i).getRentPerDay() + "\t Registration Number "
						+ houses.get(i).getrentalID() + "\t Total Rental Days " + houses.get(i).gettotalRentalDays()
						+ "\t Postal Address " + houses.get(i).getpostAddress());
			}
			out.println("==============All villas=======================");
			for (i = 0; i < villas.size(); i++) {
				out.println("\tLuxury Tax:" + villas.get(i).getLuxuryTax() + "\t OwnerName: " + villas.get(i).getOwner()
						+ "\t Registration Number" + villas.get(i).getrentalID() + "\t Postal Address "
						+ villas.get(i).getpostAddress() + "\t Rent Per Day: " + villas.get(i).getRentPerDay());
			}
			int rent = CalculateIncome(apartments, houses, villas);
			out.println("The total Rent for all the properties is:\t" + rent);
			out.close();
			out.flush();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Output file not found");
		}
	}

	public static void readVehicleFile(ArrayList<Car> cars, ArrayList<Truck> trucks) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src\\myBNB\\vehicleInput.txt"));
		int vehicleType;
		try {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				Scanner s = new Scanner(line);
				vehicleType = s.nextInt();
				if (vehicleType == 1) {
					// System.out.println(s.nextInt()+""+ s.nextInt()+""+
					// s.nextInt()+""+ s.next());
					cars.add(new Car(s.nextInt(), s.nextInt(), s.nextInt(), s.next()));
				}
				if (vehicleType == 2) {
					trucks.add(new Truck(s.nextInt(), s.nextInt(), s.nextInt(), s.next()));
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "vehicleInput.txt not found");

		}
	}

	public static void userInputVehicle(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		//Creating JFrame components 
		JFrame GUI2 = new JFrame("VehicleInput");
		JLabel label1;
		JLabel label2;
		JLabel label3;
		JTextField text1;
		JTextField text2;
		JButton InputButton;
		label1 = new JLabel("Vehicle ID:");
		label3 = new JLabel(
				"Press Rent to rent the property, Press Calculate to calculate the income, Close the JFrame to get output file done");
		label2 = new JLabel("Rental Days");
		label3.setSize(new Dimension(20, 100));
		text1 = new JTextField(2);
		text2 = new JTextField(2);
		JButton calculate = new JButton("Calculate");
		calculate.setPreferredSize(new Dimension(70, 20));
		InputButton = new JButton("Rent");
		label1.setPreferredSize(new Dimension(70, 70));
		label2.setPreferredSize(new Dimension(70, 70));
		text1.setPreferredSize(new Dimension(50, 50));
		text2.setPreferredSize(new Dimension(50, 50));
		label1.setSize(label1.getPreferredSize());
		label2.setSize(label1.getPreferredSize());
		text1.setSize(text1.getPreferredSize());
		text2.setSize(text1.getPreferredSize());
		InputButton.setPreferredSize(new Dimension(70, 70));
		InputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean found = false;
				int rentalDays = Integer.parseInt(text2.getText());
				int vehicleID = Integer.parseInt(text1.getText());
				if (!found) {
					for (Car car : cars) {
						if (car.getvehicleID() == vehicleID) {
							found = true;
							car.RentItem(rentalDays);
						}
					}

				}
				if (!found) {
					for (Truck truck : trucks) {
						if (truck.getvehicleID() == vehicleID) {
							found = true;
							truck.RentItem(rentalDays);
						}
					}
				}
			}
		});
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateVehicleIncome(cars, trucks);
				printVehicles(cars, trucks);
			}
		});
		try {
			//adding all hte properties to the JFrame 
			GUI2.add(label1);
			GUI2.add(text1);
			GUI2.add(label2);
			GUI2.add(text2);
			GUI2.add(InputButton);
			GUI2.add(calculate);
			GUI2.add(label3);
			GUI2.setLayout(new FlowLayout());
			GUI2.setSize(new Dimension(700, 700));
			GUI2.setVisible(true);
			GUI2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Could Not Open Jframe for vehicles");
		}
	}

	public static void printVehicles(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		try {
			String OutputFileProp = "src\\myBNB\\vehicleOutput.txt";
			// Printing out all the properties to the output file
			PrintWriter out = new PrintWriter(new FileWriter(OutputFileProp));
			int i;
			out.println("============================All Cars=====================\n");
			for (i = 0; i < cars.size(); i++) {
				out.println("carID:" + cars.get(i).getvehicleID() + "\tcarOwner:" + cars.get(i).getOwner()
						+ "\tCar rental cost:" + cars.get(i).getRentalCostPerDay() + "\tCar rented for: "
						+ cars.get(i).getRentalDays());
			}
			for (i = 0; i < trucks.size(); i++) {
				out.println("trucksID:" + trucks.get(i).getvehicleID() + "\tTruck Owner:" + trucks.get(i).getOwner()
						+ "\tTruck rent per day:" + trucks.get(i).getRentalCostPerDay() + "\tTruck rented for:"
						+ trucks.get(i).getRentalDays());
			}

			out.println("\nthe total income generated from vehicles is :\t" + calculateVehicleIncome(cars, trucks));
			out.close();
			out.flush();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Output file not found");
		}

	}

	public static int calculateVehicleIncome(ArrayList<Car> cars, ArrayList<Truck> trucks) {
		int rent = 0;
		int i;
		// Calculating rent for the Vehicles
		for (i = 0; i < cars.size(); i++) {
			// If vehicle has not been rented

			rent += cars.get(i).getRentalDays() * cars.get(i).getRentalCostPerDay();

		}
		for (i = 0; i < trucks.size(); i++) {

			rent += (trucks.get(i).getRentalCostPerDay() + trucks.get(i).getCargoWeight())
					* trucks.get(i).getRentalDays();

		}
		return rent;
	}
}
