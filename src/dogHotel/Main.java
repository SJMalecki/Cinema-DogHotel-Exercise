package dogHotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DogHotel dogHotel = new DogHotel("Seb Hotel", 2, 2,3);

        System.out.println();

        dogHotel.suiteReservation("A102");
        dogHotel.suiteReservation("A102");
        dogHotel.suiteReservation("A502");
        dogHotel.suiteReservation("B103");

        List<Suite> suites = new ArrayList<Suite>(dogHotel.getSuiteList());

        List<Suite> priceSuites = new ArrayList<Suite>(dogHotel.getSuiteList());
        priceSuites.add(new Suite("B000", 18.00));
        priceSuites.add(new Suite("A000", 15.00));
        Collections.sort(priceSuites, DogHotel.PRICE_ORDER);
        printList(priceSuites);
    }

    public static void printList(List<Suite> list){
        for(Suite suite : list){
            String reserved = "available";
            if(suite.isReserved()){
                reserved = "reserved";
            }
            System.out.print(suite.getSuiteID() + " " + suite.getPrice() + " " + reserved + "\n");
        }
        System.out.println();
    }
}
