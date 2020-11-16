package com.blz.cabinvoice.java;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvoiceServiceTest {

	static InvoiceService invoiceService;
	static Ride[] rides;
	static InvoiceSummary expectedInvoiceSummary;

	@BeforeClass
	public static void createInvoiceGeneratorObj() {
		invoiceService = new InvoiceService();
		rides = new Ride[] {
					new Ride(2.0, 5, RideCategory.NORMAL),
					new Ride(0.1, 1, RideCategory.PREMIUM)
				};
		expectedInvoiceSummary = new InvoiceSummary(2, 45);
		System.out.println("Welcome to Cab Invoice Generator Program");
	}

	@Test
	public void givenMultipleRides_ShouldReturnInvoiceSummary() {
		InvoiceSummary actualInvoiceSummary = invoiceService.calculateSummaryFare(Arrays.asList(rides));
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	@Test
	public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
		invoiceService.addRides("def", new Ride[] { new Ride(5.0, 5, RideCategory.NORMAL), new Ride(0.1, 1, RideCategory.NORMAL)});
		invoiceService.addRides("abc", rides);
		InvoiceSummary actualInvoiceSummary = invoiceService.getInvoiceSummary("abc");
		expectedInvoiceSummary = new InvoiceSummary(2, 45);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}
}
