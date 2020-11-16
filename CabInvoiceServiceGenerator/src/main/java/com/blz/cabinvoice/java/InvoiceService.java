package com.blz.cabinvoice.java;

import java.util.Arrays;
import java.util.List;

public class InvoiceService {

	RideRepository rideRepository;

	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

	public InvoiceSummary calculateSummaryFare(List<Ride> rides) {
		double fare = 0;
		for (Ride ride : rides) {
			if(ride.cabRideType != null)
				fare += ride.cabRideType.calculateFarePerRide(ride);
		}
		return new InvoiceSummary(rides.size(), fare);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRide(userId, Arrays.asList(rides));
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateSummaryFare(rideRepository.getRides(userId));
	}
}

