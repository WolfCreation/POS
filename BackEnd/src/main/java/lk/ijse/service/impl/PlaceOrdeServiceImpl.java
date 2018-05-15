package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.OrderDetailsDTO;
import lk.ijse.dto.PlaceOrderDTO;
import lk.ijse.model.*;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.OrderDetailsRepository;
import lk.ijse.repository.OrdersRepository;
import lk.ijse.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
@Service
@Transactional
public class PlaceOrdeServiceImpl implements PlaceOrderService{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO) {

        Customer customer= new Customer();
        Optional<Customer> op=customerRepository.findById(placeOrderDTO.getOrdersDTO().getCid());
        if(op.isPresent()){
            customer.setCid(op.get().getCid());
            customer.setName(op.get().getName());
            customer.setContact(op.get().getContact());
            customer.setAddress(op.get().getAddress());
        }

        //////////////////////////////////////////////////////////////////////

        Orders orders= new Orders();
        orders.setDate(placeOrderDTO.getOrdersDTO().getDate());
        orders.setOid(placeOrderDTO.getOrdersDTO().getOid());
        orders.setCustomer(customer);

        ////////////////////////////////////////////////////////

        List<OrderDetailsDTO> orderDetailsDTOS=placeOrderDTO.getOrderDetailsDTOS();

        ////////////////////////////////////////////////////////////////////////

        boolean result =ordersRepository.save(orders)!=null;

        if (result){

            for (OrderDetailsDTO orderDetailsDTO:orderDetailsDTOS){

                OrderDetails orderDetails = new OrderDetails();

                orderDetails.setOrders(orders);
                orderDetails.setQty(orderDetailsDTO.getQty());

                Item item=new Item(orderDetailsDTO.getItemDTO().getItemId(),
                        orderDetailsDTO.getItemDTO().getDescription(),
                        orderDetailsDTO.getItemDTO().getPrice(),
                        orderDetailsDTO.getItemDTO().getQty());

                orderDetails.setItem(item);
                orderDetails.setOrderDetails_pk(new OrderDetails_PK(orders.getOid(),item.getItemId()));

                orderDetailsRepository.save(orderDetails);

            }
            return true;

        }else {
            return false;
        }
    }
}
