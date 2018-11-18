package dogHotel;

import java.util.*;

public class DogHotel {

    private String hotelName;
    private List<Suite> suiteList = new ArrayList<Suite>();

    static final Comparator<Suite> PRICE_ORDER = new Comparator<Suite>() {
        @Override
        public int compare(Suite suite1, Suite suite2) {
            if(suite1.getPrice() < suite2.getPrice()){
                return -1;
            }else if(suite1.getPrice() > suite2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };

    public DogHotel(String hotelName, int house, int floor, int suites) {
        this.hotelName = hotelName;

        int houseMax = 'A' + (house - 1);
        for (char houseLetter = 'A'; houseLetter <= houseMax; houseLetter++) {
            for (int i = 1; i <= floor; i++) {
                for (int j = 1; j <= suites; j++) {
                    double price = 10.00;
                    if((houseLetter < 'C') && (floor > 1 && floor <=3)) {
                        price = 12.00;
                    }else if(houseLetter > 'C'){
                        price = 8.00;
                    }
                    Suite suite = new Suite(houseLetter + "" + i + String.format("%02d", j), price);
                    suiteList.add(suite);
                }
            }
        }
    }

    public Collection<Suite> getSuiteList() {
        return suiteList;
    }

    public boolean suiteReservation(String suiteID) {
        Suite requestedSuite = new Suite(suiteID, 0);
        int foundSuite = Collections.binarySearch(suiteList, requestedSuite, null);
        if (foundSuite >= 0) {
            suiteList.get(foundSuite).reserve();
            return true;
        } else {
            System.out.println("There is no suite with ID: " + suiteID);
            return false;
        }
    }
}









