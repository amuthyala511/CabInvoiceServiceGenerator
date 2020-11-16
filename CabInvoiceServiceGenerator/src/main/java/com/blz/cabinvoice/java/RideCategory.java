package com.blz.cabinvoice.java;

public enum RideCategory {
	NORMAL(10.0, 1, 5), PREMIUM(15.0, 2, 20);
	
	private double costPerKilometer;
	private int costPerMinute;
	private double miniumCostPerRide;
	
	RideCategory(double costPerKilometer, int costPerMinute, double miniumCostPerRide) {
		this.costPerKilometer = costPerKilometer;
		this.costPerMinute = costPerMinute;
		this.miniumCostPerRide = miniumCostPerRide;
	}
	
	public double calculateFarePerRide(Ride ride) {
		double fare = ride.distance * costPerKilometer + ride.time * costPerMinute;
		if(fare < miniumCostPerRide)
			return miniumCostPerRide;
		return fare;
	}
}
