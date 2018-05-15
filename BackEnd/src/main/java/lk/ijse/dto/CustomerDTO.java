package lk.ijse.dto;

import java.io.Serializable;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public class CustomerDTO implements Serializable{

    private int cid;
    private String name;
    private String contact;
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public CustomerDTO(int cid, String name, String contact, String address) {
        this.cid = cid;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
