package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Phone {

    private int propertyId;
    private String brand;
    private String type;
    private BigDecimal price;
    private String description;
    private BigDecimal priceWithoutBTW;
    private int stock;

    public Phone(int propertyId, String brand, String type, BigDecimal price, String description, int stock){
        this.propertyId=propertyId;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.description=description;
        this.priceWithoutBTW= BigDecimal.valueOf(Math.round(100 * price.doubleValue() / 1.21) / 100F).setScale(2, RoundingMode.HALF_UP);
        this.stock = stock;
    }

    public String printPhone(){
        System.out.println(brand + " " + type + " " + price + "(" + priceWithoutBTW + ")" + "\n \n" + description);
        return brand + " " + type + " " + price + "(" + priceWithoutBTW + ")" + "\n \n" + description;
    }

    public void printBrand(){
        System.out.println(propertyId + ": " + brand);
    }

    public String shortPhone(){
        return brand + " - " + type;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
