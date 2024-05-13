package kelompok9.rapidrail;

public class TrainTicket extends Ticket{
    private String costumerName;

    public TrainTicket(String ticketId, double price, String costumerName) {
        super(ticketId, price);
        this.costumerName = costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }
    public String getCostumerName() {
        return costumerName;
    }

    @Override
    public void printInfotmation() {
        System.out.println("Hello");
    }
    
}
