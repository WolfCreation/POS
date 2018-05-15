package lk.ijse.dto;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
public class OrderDetailsDTO {

    private int qty;
    private ItemDTO itemDTO;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(int qty, ItemDTO itemDTO) {
        this.qty = qty;
        this.itemDTO = itemDTO;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }
}

