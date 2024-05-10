package kelompok9.rapidrail;

public class Train {
    private String trainId;
    private String trainName;
    private int seatSlot;
    private String seatType;

    Train(String trainId, String trainName, int seatSlot, String seatType) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.seatSlot = seatSlot;
        this.seatType = seatType;
    }

    public void setTrainId(String trainId){
        this.trainId = trainId;
    }
    public String getTrainId(){
        return trainId;
    }

    public void setTrainName(String trainName){
        this.trainName = trainName;
    }
    public String getTrainName(){
        return trainName;
    }

    public void setSeatSlot(int seatSlot){
        this.seatSlot = seatSlot;
    }
    public int getSeatSlot(){
        return seatSlot;
    }

    public void setSeatType(String seatType){
        this.seatType = seatType;
    }
    public String getSeatType(){
        return seatType;
    }

    public void showDescriptionOfTrain() {
        System.out.println(getTrainName() + "(Mass Rapid Transit) Train");
        System.out.println("Seat Slot : " + getSeatSlot());
        System.out.println("Available Seat Types : " + getSeatType());
        System.out.println("Maximum Speed : 110 KM/h");
        System.out.println("Carriage : 6 Carriages");
        System.out.println("---------------------------------------------------------");
        System.out.println(getTrainName() + "(Light Rapid Transit) Train");
        System.out.println("Seat Slot : " + getSeatSlot());
        System.out.println("Available Seat Types : " + getSeatType());
        System.out.println("Maximum Speed : 90 KM/h");
        System.out.println("Carriage : 2-4 Carriages");
    }
}
