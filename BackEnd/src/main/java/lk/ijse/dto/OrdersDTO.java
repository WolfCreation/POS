package lk.ijse.dto;

import java.io.Serializable;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
public class OrdersDTO implements Serializable{

    private int oid;
    private String date;
    private int cid;

    public OrdersDTO() {
    }

    public OrdersDTO(int oid, String date, int cid) {
        this.oid = oid;
        this.date = date;
        this.cid = cid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
