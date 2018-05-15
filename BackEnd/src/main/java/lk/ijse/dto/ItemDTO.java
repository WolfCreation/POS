package lk.ijse.dto;

import java.io.Serializable;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public class ItemDTO implements Serializable{

    private int itemId;
    private String description;
    private double price;
    private int qty;

    public ItemDTO() {
    }

    public ItemDTO(int itemId, String description, double price, int qty) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
