package lk.ijse.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
@Embeddable
public class OrderDetails_PK implements Serializable{

    private int oid;
    private int itemId;

    public OrderDetails_PK() {
    }

    public OrderDetails_PK(int oid, int itemId) {
        this.oid = oid;
        this.itemId = itemId;
    }
}
