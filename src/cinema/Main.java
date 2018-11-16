package cinema;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Lux Cinema", 8, 10);
        //cinema.getChair();

        if(cinema.reserveChair("D08")){
            System.out.println("Thank you for reservation");
        }else{
            System.out.println("Chair is already reserved");
        }

        if(cinema.reserveChair("G08")){
            System.out.println("Thank you for reservation");
        }else{
            System.out.println("Please choose another chair");
        }
    }
}
