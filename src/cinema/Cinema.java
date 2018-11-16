package cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cinema {

    private final String cinemaName;
    private List<Chair> chairs = new ArrayList<>();

    public Cinema(String cinemaName, int numberOfRows, int chairsInRow){
        this.cinemaName = cinemaName;

        int rowMax = 'A' + (numberOfRows - 1);
        for (char row = 'A'; row <= rowMax; row++) {
            for (int chairNumber = 1; chairNumber <= chairsInRow; chairNumber++) {
                Chair chair = new Chair(row + String.format("%02d", chairNumber));
                chairs.add(chair);
            }
        }
    }

    public String getCinemaName(){
        return cinemaName;
    }

    public boolean reserveChair(String chairNumber){
        Chair requestChair = new Chair(chairNumber);
        int foundChair = Collections.binarySearch(chairs, requestChair, null);
        if(foundChair >=0){
            return chairs.get(foundChair).reserve();
        }else{
            System.out.println("There is no chair " + chairNumber);
            return false;
        }
//        for(Chair chair : chairs){
//            System.out.print("*");
//            if(chair.getChairNumber().equals(chairNumber)){
//                requestChair = chair;
//                break;
//            }
//        }
//
//        if(requestChair == null){
//            System.out.println("There is no chair " + chairNumber );
//            return false;
//        }
//        return requestChair.reserve();
    }

    public void getChair() {
        for(Chair chair : chairs){
            System.out.println(chair.getChairNumber());
        }
    }


}
