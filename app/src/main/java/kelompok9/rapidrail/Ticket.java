package kelompok9.rapidrail;

public abstract class Ticket {
    protected String ticketId; 
    protected double price;

    public Ticket(String ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String printTicket();
}
