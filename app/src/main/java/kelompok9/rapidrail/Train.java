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

}
