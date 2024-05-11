package kelompok9.rapidrail;

import java.util.ArrayList;
import java.util.List;


public class Schedule {
    private List<TrainSchedule> trainSchedules;

    public Schedule() {
        this.trainSchedules = new ArrayList<>();
    }

    public void addTrainSchedule(Train train, String departureStation, String departureTime, String arrivalStation, String arrivalTime) {
        TrainSchedule trainSchedule = new TrainSchedule(train, departureStation, departureTime, arrivalStation, arrivalTime);
        trainSchedules.add(trainSchedule);
    }

    public void displayAllTrainSchedules() {
        System.out.println("All Train Schedules:");
        for (TrainSchedule schedule : trainSchedules) {
            System.out.println(schedule);
        }
    }

    public static class TrainSchedule {
        private Train train;
        private String departureStation;
        private String departureTime;
        private String arrivalStation;
        private String arrivalTime;

        public TrainSchedule(Train train, String departureStation, String departureTime, String arrivalStation, String arrivalTime) {
            this.train = train;
            this.departureStation = departureStation;
            this.departureTime = departureTime;
            this.arrivalStation = arrivalStation;
            this.arrivalTime = arrivalTime;
        }

        public String showSchedule() {
            return "Train: " + train.getTrainName() + " (ID: " + train.getTrainId() + ")"
                    + ", Departure Station: " + departureStation + ", Departure Time: " + departureTime
                    + ", Arrival Station: " + arrivalStation + ", Arrival Time: " + arrivalTime;
        }
    }
}
