package lk.ijse.model;

import javax.persistence.*;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
@Entity
public class OrderDetails {

    private int qty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "oid" ,referencedColumnName = "oid",insertable = false,updatable = false))
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "itemId" , referencedColumnName = "itemId" , insertable = false,updatable = false))
    private Item item;
    @EmbeddedId
    private OrderDetails_PK orderDetails_pk;

    public OrderDetails() {
    }

    public OrderDetails(int oid,int itemId,int qty, Orders orders, Item item) {
        this.qty = qty;
        this.orders = orders;
        this.item = item;
        orderDetails_pk = new OrderDetails_PK(oid,itemId);
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderDetails_PK getOrderDetails_pk() {
        return orderDetails_pk;
    }

    public void setOrderDetails_pk(OrderDetails_PK orderDetails_pk) {
        this.orderDetails_pk = orderDetails_pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetails that = (OrderDetails) o;

        if (qty != that.qty) return false;
        if (orders != null ? !orders.equals(that.orders) : that.orders != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        return orderDetails_pk != null ? orderDetails_pk.equals(that.orderDetails_pk) : that.orderDetails_pk == null;
    }

    @Override
    public int hashCode() {
        int result = qty;
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (orderDetails_pk != null ? orderDetails_pk.hashCode() : 0);
        return result;
    }
}
