package cinema;

public class Chair implements Comparable<Chair>{
    private String chairNumber;
    private boolean reserved = false;

    public Chair(String chairNumber){
        this.chairNumber = chairNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public boolean reserve(){
        if(!this.reserved){
            this.reserved = true;
            System.out.println("Chair " + chairNumber + " reserved");
            return true;
        }else {
            System.out.println("Chair " + chairNumber + " is already reserved");
            return false;
        }
    }

    public boolean cancel(){
        if(this.reserved){
            this.reserved = false;
            System.out.println("This chair " + chairNumber + " is no longer reserved");
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Chair chair) {
        return this.chairNumber.compareToIgnoreCase(chair.getChairNumber());
    }
}
