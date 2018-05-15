package lk.ijse.dto;

import lk.ijse.model.Orders;

import java.util.List;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
public class PlaceOrderDTO {



    private OrdersDTO ordersDTO;
    private List<OrderDetailsDTO> orderDetailsDTOS;

    public PlaceOrderDTO() {

    }

    public PlaceOrderDTO(OrdersDTO ordersDTO, List<OrderDetailsDTO> orderDetailsDTOS) {
        this.ordersDTO = ordersDTO;
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public OrdersDTO getOrdersDTO() {
        return ordersDTO;
    }

    public void setOrdersDTO(OrdersDTO ordersDTO) {
        this.ordersDTO = ordersDTO;
    }

    public List<OrderDetailsDTO> getOrderDetailsDTOS() {
        return orderDetailsDTOS;
    }

    public void setOrderDetailsDTOS(List<OrderDetailsDTO> orderDetailsDTOS) {
        this.orderDetailsDTOS = orderDetailsDTOS;
    }
}
