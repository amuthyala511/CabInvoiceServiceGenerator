package com.blz.cabinvoice.java;

public class Ride {
	public double distance;
	public int time;
	public RideCategory cabRideType;

	public Ride(double distance, int time, RideCategory cabRideType) {
		this.distance = distance;
		this.time = time;
		this.cabRideType = cabRideType;
	}
}

