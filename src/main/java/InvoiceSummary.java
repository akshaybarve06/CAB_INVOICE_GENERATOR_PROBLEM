public class InvoiceSummary {

    public final double totalFare;
    public final int noOfRides;
    public final double averageFare;

    public InvoiceSummary( int noOfRides,double totalFare){
        this.totalFare=totalFare;
        this.noOfRides=noOfRides;
        this.averageFare=this.totalFare/this.noOfRides;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.totalFare, totalFare) == 0 &&
                noOfRides == that.noOfRides &&
                Double.compare(that.averageFare, averageFare) == 0;
    }
}
