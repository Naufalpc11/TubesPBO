package kelompok9.rapidrail;

public abstract class Ticket {
    protected String ticketId; 
    protected double price;

    public Ticket(String ticketId, double price) {
        this.ticketId = ticketId;
        this.price = price;
    }

    public void setTickedId(String ticketId) {
        this.ticketId = ticketId;
    }
    public String getTicketId() {
        return ticketId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public abstract void printInformation();
}
