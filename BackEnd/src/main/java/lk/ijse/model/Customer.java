package lk.ijse.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String name;
    private String contact;
    private String address;

    public Customer() {

    }

    public Customer(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public Customer(int cid, String name, String contact, String address) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (cid != customer.cid) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (contact != null ? !contact.equals(customer.contact) : customer.contact != null) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;
    }

    @Override
    public int hashCode() {
        int result = cid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
