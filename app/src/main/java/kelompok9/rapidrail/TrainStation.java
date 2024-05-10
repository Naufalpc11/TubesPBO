package kelompok9.rapidrail;

public class TrainStation {
    private String departureStation;
    private String arrivalStation;
    private String trainStationName;

    TrainStation(String departureStation, String arrivalStation, String trainStationName) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.trainStationName = trainStationName;


    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }
    public String getDepartureStation() {
        return departureStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }
    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setTrainStationName(String trainStationName) {
        this.trainStationName = trainStationName;
    }
    public String getTrainStationName() {
        return trainStationName;
    }

    public void showSchedule() {
        
    }
}
