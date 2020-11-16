package com.blz.cabinvoice.java;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceServiceTest {

	static InvoiceService invoiceService;

	@BeforeClass
	public static void createInvoiceGeneratorObj() {
		invoiceService = new InvoiceService();
		System.out.println("Welcome to Cab Invoice Generator Program");
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		Ride[] rides = {
					new Ride(2.0, 5),
					new Ride(0.1, 1)
				};
		InvoiceSummary actualInvoiceSummary = invoiceService.calculateSummaryFare(Arrays.asList(rides));
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	@Test
	public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
		invoiceService.addRides("abc", new Ride[] { new Ride(2.0, 5), new Ride(0.1, 1)});
		invoiceService.addRides("def", new Ride[] { new Ride(5.0, 5), new Ride(0.1, 1)});
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary("def");
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}
}
