package cabInvoice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceServiceNormal=new InvoiceService(CabSubscriptions.NORMAL);
    InvoiceService invoiceServicePremium = new InvoiceService(CabSubscriptions.PREMIUM);

    // Form Normal Subscriptions

    // TC For Calculate Total Fare When Distance and Time is Given (NORMAL)
    @Test
    public void givenDistanceAndTimeForNormalSubscriptions_ShouldReturnTotalFare(){
        double distance= 2.0;
        int time=5;
        double fare=invoiceServiceNormal.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }
    // TC For Calculate Minimum Fare When Distance and Time is Given (NORMAL)
    @Test
    public void givenDistanceAndTimeForNormalSubscriptions_ShouldReturnMinimumFare(){
        double distance= 0.1;
        int time=1;
        double fare=invoiceServiceNormal.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
    // TC For Calculate Invoice Summary For Multiple Rides (NORMAL)
    @Test
    public void givenMultipleRidesForNormalSubscriptions_ShouldReturnInvoiceSummary(){
        Ride[] rides = {new Ride(2.0,5),
                        new Ride(0.1,1)};
        InvoiceSummary summary =invoiceServiceNormal.calculateFare(rides);
        InvoiceSummary expectedSummary=new InvoiceSummary(2 ,30.0 );
        Assert.assertEquals(expectedSummary,summary);
    }
    // TC For Return Invoice User when UserId and No of Rides are Given (NORMAL)
    @Test
    public void givenUserIDAndRidesForNormalSubscriptions_ShouldReturnInvoiceSummary(){
        String userID="abc@xyz.com";
        Ride[] rides = {new Ride(2.0,5),
                new Ride(0.1,1)};
        invoiceServiceNormal.addRide(userID, rides);
        InvoiceSummary summary = invoiceServiceNormal.getInvoiceSummary(userID);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2 , 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    // For Premium Subscriptions

    // TC For Calculate Total Fare When Distance and Time is Given (PREMIUM)
    @Test
    public void givenDistanceAndTimeForPremiumSubscription_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceServicePremium.calculateFare(distance, time);
        Assert.assertEquals(40, fare, 0.0);
    }
    // TC For Calculate Minimum Fare When Distance and Time is Given (PREMIUM)
    @Test
    public void givenDistanceAndTimeForPremiumSubscription_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceServicePremium.calculateFare(distance, time);
        Assert.assertEquals(20, fare, 0.0);
    }
    // TC For Calculate Invoice Summary For Multiple Rides (PREMIUM)
    @Test
    public void givenMultipleRidesForPremiumSubscription_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceServicePremium.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    // TC For Return Invoice User when UserId and No of Rides are Given (PREMIUM)
    @Test
    public void givenUserIdAndRidesForPremiumSubscription_ShouldReturnInvoiceSummary() {
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        invoiceServicePremium.addRide(userId, rides);
        InvoiceSummary summary = invoiceServicePremium.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2 , 60.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }




}
