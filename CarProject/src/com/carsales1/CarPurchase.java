package com.carsales1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.carsales1.Car;

public class CarPurchase {
	private String firstName;
	private String lastName;
	private Date dateCustomerPurchased;
	private Car carPurchased;
	private static final String path = "/Users/adriandavis/Desktop/carProjectSaves2/";
	private String purchasedMake;
	private String purchasedModel;
	
public CarPurchase() {}

public CarPurchase(String firstName, String lastName, Date dateCustomerPurchased, Car carPurchased) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateCustomerPurchased = dateCustomerPurchased;
	this.carPurchased = carPurchased;
}

public CarPurchase(String firstName, String lastName, Date dateCustomerPurchased, String purchasedMake, String purchasedModel) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateCustomerPurchased = dateCustomerPurchased;
	this.purchasedMake = carPurchased.getMake();
	this.purchasedModel = carPurchased.getModel();
}
public String getFirstname() {
	return firstName;
}

public void setFirstname(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Date getDateCustomerPurchased() {
	return dateCustomerPurchased;
}

public void setDateCustomerPurchased(Date dateCustomerPurchased) {
	this.dateCustomerPurchased = dateCustomerPurchased;
}

public Car getCarPurchased() {
	return carPurchased;
}

public void setCarPurchased(Car carPurchased) {
	this.carPurchased = carPurchased;
}

public void saveToFile() {
	System.out.println("test");
	
	try {
		
		String fileName = path + this.carPurchased.getVinNumber() + ".txt";
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		bw.write(formatData());
		
		bw.close();
		
	} catch(IOException ex) {
		
	}
	
}

public String formatData() {
	
	
	return this.firstName + "," + 
			this.lastName + "," +
			this.dateCustomerPurchased + "," +
			this.carPurchased.getModelYear() + "," + 
			this.carPurchased.getMake() + "," +
			this.carPurchased.getModel();
			
			
}

public CarPurchase readFromFile() {
	
	CarPurchase car = new CarPurchase();
	
	String fileName = path + this.carPurchased.getVinNumber() + ".txt";
	
	
	try {
		
		Scanner input = new Scanner(new File(fileName));
		
		while(input.hasNextLine()) {
			
			String line = input.nextLine();
			String[] parsedLine = line.split(",");			
			car.firstName = parsedLine[0];
			car.lastName = parsedLine[1];
			car.dateCustomerPurchased = new SimpleDateFormat("dd/MM/yyyy").parse(parsedLine[2]);
			car.purchasedMake = parsedLine[3];
			car.purchasedModel = parsedLine [4];						
		}
		
		input.close();
		
	} catch (FileNotFoundException | ParseException ex) {
		
	}
	
	return car;
	
}

@Override
public String toString() {
	return this.firstName + " "+ this.lastName + " " + this.carPurchased.getMake() + " " + this.carPurchased.getModel();
}






}