package lk.ijse.model;


import javax.persistence.*;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Customer customer;

    public Orders() {
    }

    public Orders(int oid, String date, Customer customer) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (oid != orders.oid) return false;
        if (date != null ? !date.equals(orders.date) : orders.date != null) return false;
        return customer != null ? customer.equals(orders.customer) : orders.customer == null;
    }

    @Override
    public int hashCode() {
        int result = oid;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
