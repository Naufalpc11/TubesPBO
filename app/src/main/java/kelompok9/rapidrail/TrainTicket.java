package kelompok9.rapidrail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TrainTicket extends Ticket{
    
    private String costumerName;
    public TrainTicket(String costumerName, String ticketId, double price) {
        super(ticketId, price);
        this.costumerName = costumerName;
    }

    public void setCostumerName(String costumerName){
        this.costumerName = costumerName;
    }
    public String getCostumerName() {
        return costumerName;
    }

    @Override
    public String printTicket() {
        String fileName = "train_ticket_" + getTicketId() + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                String ticketInfo = "Ticket ID: " + getTicketId() + "\n";
                ticketInfo += "Customer Name: " + getCostumerName() + "\n";
                ticketInfo += "Price: $" + getPrice() + "\n";

                writer.write(ticketInfo);

                System.out.println("Ticket details written to file: " + fileName);
                return ticketInfo;
            } catch (IOException e) {
                System.out.println("Error writing ticket details to file: " + e.getMessage());
                return null;
            }
            }

}
