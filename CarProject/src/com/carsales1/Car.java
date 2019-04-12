package com.carsales1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;



public class Car {
	
	private String modelYear;
	private String make;
	private String model;
	private int price;
	private String engineType;
	private int currentMileage;
	private String carPhoto;
	private int mpg;
	private Date purchaseDate;
	private String transmissionType;
	private boolean isNew;
	private int vinNumber;
	private static final String path = "/Users/adriandavis/Desktop/carProjectSaves/";
	

public Car() {}

public Car(String modelYear, String make, String model, int price, String engineType, int currentMileage,
		int mpg, String transmissionType, boolean isNew) {
	
	this.modelYear = modelYear;
	this.make = make;
	this.model = model;
	this.price = price;
	this.engineType = engineType;
	this.currentMileage = currentMileage;	
	this.mpg = mpg;
	this.transmissionType = transmissionType;
	this.isNew = isNew;
	//this.vinNumber = vinNumber;
}

public String getModelYear() {
	return modelYear;
}

public void setModelYear(String modelYear) {
	this.modelYear = modelYear;
}

public String getMake() {
	return make;
}

public void setMake(String make) {
	this.make = make;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getEngineType() {
	return engineType;
}

public void setEngineType(String engineType) {
	this.engineType = engineType;
}

public int getCurrentMileage() {
	return currentMileage;
}

public void setCurrentMileage(int currentMileage) {
	this.currentMileage = currentMileage;
}

public String getCarPhoto() {
	return carPhoto;
}

public void setCarPhoto(String carPhoto) {
	this.carPhoto = carPhoto;
}

public int getMpg() {
	return mpg;
}

public void setMpg(int mpg) {
	this.mpg = mpg;
}

public Date getPurchaseDate() {
	return purchaseDate;
}

public void setPurchaseDate(Date purchaseDate) {
	this.purchaseDate = purchaseDate;
}

public String getTransmissionType() {
	return transmissionType;
}

public void setTransmissionType(String transmissionType) {
	this.transmissionType = transmissionType;
}

public boolean getIsNew() {
	return isNew;
}

public void setIsNew(boolean isNew) {
	this.isNew = isNew;
}

public int getVinNumber() {
	return vinNumber;
}

public void setVinNumber(int vinNumber) {
	this.vinNumber = vinNumber;}



@Override
public String toString() {
	return "Car [modelYear=" + modelYear + ", make=" + make + ", model=" + model + ", price=" + price + ", engineType="
			+ engineType + ", currentMileage=" + currentMileage + ", carPhoto=" + carPhoto + ", mpg=" + mpg
			+ ", purchaseDate=" + purchaseDate + ", transmissionType=" + transmissionType + ", isUsed=" + isNew
			+ ", vinNumber=" + vinNumber + "]";
}

public void saveToFile() {
	System.out.println("test");
	
	try {
		
		String fileName = path + this.vinNumber + ".txt";
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		
		bw.write(formatData());
		
		bw.close();
		
	} catch(IOException ex) {
		
	}
	
}

public String formatData() {
	
	
	return this.modelYear + "," + 
			this.make + "," +
			this.model + "," +
			this.price + "," +
			this.currentMileage + "," +
			this.mpg + "," +
			this.engineType + "," +
			this.transmissionType + "," +
			this.isNew + "," +
			this.carPhoto;
}
public Car readFromFile() {
	
	Car car = new Car();
	
	String fileName = path + this.vinNumber + ".txt";
	
	
	try {
		
		Scanner input = new Scanner(new File(fileName));
		
		while(input.hasNextLine()) {
			
			String line = input.nextLine();
			String[] parsedLine = line.split(",");
			
			car.modelYear = parsedLine[0];
			car.model = parsedLine[1];
			car.make = parsedLine[2];
			car.price = Integer.parseInt(parsedLine[3]);
			car.engineType = parsedLine[4];
			car.currentMileage = Integer.parseInt(parsedLine[5]);
			car.mpg = Integer.parseInt(parsedLine[6]); 
			car.transmissionType = parsedLine[7];
			car.isNew = Boolean.parseBoolean(parsedLine[8]);
		//	car.vinNumber = parsedLine[9];			
		}
		
		input.close();
		
	} catch (FileNotFoundException ex) {
		
	}
	
	return car;
	
}
public boolean isMoreThan120Days() {
	// 120 days ago
	LocalDateTime temp120Days = LocalDateTime.now().minusDays(120);	
	LocalDateTime purchaseDateConverted = LocalDateTime.ofInstant(purchaseDate.toInstant(), ZoneId.systemDefault());

	//must check to see if car is has been in inventory for longer than 120 days	
	return purchaseDateConverted.isBefore(temp120Days);
}
public int generateVin() {
	
	
	return vinNumber = (int) (Math.random() * 100);
}



}

