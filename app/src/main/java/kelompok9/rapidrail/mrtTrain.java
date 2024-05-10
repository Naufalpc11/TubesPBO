package kelompok9.rapidrail;

public class Train {
    private String trainId;
    private String trainName;
    private String seatSlot;
    private String seatType;

    Train(String trainId, String trainName, String seatSlot, String seatType) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.seatSlot = seatSlot;
        this.seatType = seatType;
    }
}
