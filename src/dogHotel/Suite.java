package dogHotel;

public class Suite implements Comparable<Suite> {

    private String suiteID;
    private boolean reserved;
    private double price;

    public Suite(String suiteID, double price){
        this.suiteID = suiteID;
        this.price = price;
    }

    public String getSuiteID(){
        return suiteID;
    }

    public boolean isReserved() {
        return reserved;
    }

    public double getPrice() {
        return price;
    }

    public boolean reserve(){
        if(!reserved){
            System.out.println("Suite " + suiteID + " reserved");
            reserved = true;
            return true;
        }else{
            System.out.println("Suite " + suiteID + " already reserved");
            return false;
        }
    }

    public boolean cancelReservation(){
        if(reserved){
            System.out.println("Reservation " + suiteID + " canceled");
            reserved = false;
            return true;
        }else{
            System.out.println("There is no reservation at suite " + suiteID);
            return false;
        }
    }

    @Override
    public int compareTo(Suite suite){
        return this.suiteID.compareToIgnoreCase(suite.getSuiteID());
    }
}
