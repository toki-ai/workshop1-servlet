package models;

public class Car {
    private int CarID;
    private String CarName;
    private String Manufacturer; 
    private int Price; 
    private int ReleasedYear; 

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String CarName) {
        this.CarName = CarName;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getReleasedYear() {
        return ReleasedYear;
    }

    public void setReleasedYear(int ReleasedYear) {
        this.ReleasedYear = ReleasedYear;
    }

    @Override
    public String toString() {
        return "Car{" + "CarID=" + CarID + ", CarName=" + CarName + ", Manufacturer=" + Manufacturer + ", Price=" + Price + ", ReleasedYear=" + ReleasedYear + '}';
    }

    public Car(int CarID, String CarName, String Manufacturer, int Price, int ReleasedYear) {
        this.CarID = CarID;
        this.CarName = CarName;
        this.Manufacturer = Manufacturer;
        this.Price = Price;
        this.ReleasedYear = ReleasedYear;
    }
  
}
