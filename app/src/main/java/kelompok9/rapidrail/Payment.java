package kelompok9.rapidrail;

public class Payment extends Ticket {
    private PurchaseMethod purchaseMethod;
    private String atmNumber;
    private int atmPin;

    public Payment(PurchaseMethod purchaseMethod, String atmNumber, int atmPin, double price){
        super("N/A", price);
        this.purchaseMethod = purchaseMethod;
        this.atmNumber = atmNumber;
        this.atmPin = atmPin;
    }

    public void setPurchaseMethod(PurchaseMethod purchaseMethod){
        this.purchaseMethod = purchaseMethod;
    }

    public PurchaseMethod getPurchaseMethod(){
        return purchaseMethod;
    }

    public void setAtmNumber(String atmNumber){
        this.atmNumber = atmNumber;
    }

    public String getAtmNumber(){
        return atmNumber;
    }

    public void setAtmPin(int atmPin){
        this.atmPin = atmPin;
    }

    public int getAtmPin(){
        return atmPin;
    }

    public void showPaymentDetails() {
        System.out.println("Purchase Method: " + purchaseMethod);
        System.out.println("ATM Number: " + atmNumber);
        System.out.println("Total Price : " );
    }

    @Override
    public String printTicket() {
        throw new UnsupportedOperationException("implemented method 'printTicket'");
    }
}
