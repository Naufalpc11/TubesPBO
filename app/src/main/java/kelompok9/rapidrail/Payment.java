package kelompok9.rapidrail;

public class Payment {
    private String purchaseMethod;
    private String atmNumber;
    private int atmPin;

    Payment(String purchaseMethod, String atmNumber, int atmPin){
        this.purchaseMethod = purchaseMethod;
        this.atmNumber = atmNumber;
        this.atmPin = atmPin;
    }

    public void setPurchaseMethod(String purchaseMethod){
        this.purchaseMethod = purchaseMethod;
    }
    public String getPurchaseMethod(){
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
}
