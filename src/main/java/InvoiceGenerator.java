public class InvoiceGenerator {

    public static final double MIN_COST_PER_KMS = 10 ;
    public static final int COST_PER_TIME = 1 ;
    public static final int MIN_FARE=5;
    double totalFare=0;

    public double calculateFare(double distance, int time) {
        double totalFare= distance*MIN_COST_PER_KMS + time*COST_PER_TIME;
        if ( totalFare < MIN_FARE)
            return MIN_FARE;
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        for (Ride ride :rides ) {
            totalFare+=this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
