package kelompok9.rapidrail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TrainTicket extends Ticket {
    private String customerName;
    private Schedule.TrainSchedule schedule;
    private Train train;
    private Passenger passenger;

    public TrainTicket(String ticketId, double price, String customerName, Schedule.TrainSchedule schedule, Train train, Passenger passenger) {
        super(ticketId, price);
        this.customerName = customerName;
        this.schedule = schedule;
        this.train = train;
        this.passenger = passenger;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void printInformation() {
        String fileName = "TrainTicket.txt";

        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);

            writer.write("========================================== Train Ticket ==========================================\n");
            writer.write("Ticket ID      : " + getTicketId() + "\n");
            writer.write("Name who Order : " + getCustomerName() + "\n");
            writer.write("Train Number   : " + train.getTrainId() + "\n");
            writer.write("Departure      : " + schedule.getDepartureStation() + " at " + schedule.getDepartureTime() + "\n");
            writer.write("Arrival        : " + schedule.getArrivalStation() + " at " + schedule.getArrivalTime() + "\n");
            writer.write("Seat Type      : " + train.getSeatType() + "\n");
            writer.write("Seat Number    : " + passenger.getchairId() + "\n");
            writer.write("Ticket Price   : $" + getPrice() + "\n");
            writer.write("==================================================================================================\n");

            writer.close();

            System.out.println("Tiket berhasil dicetak ke file " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat mencetak tiket: " + e.getMessage());
        }
    }
}
