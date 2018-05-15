package lk.ijse.controller;

import lk.ijse.dto.PlaceOrderDTO;
import lk.ijse.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
@RestController
@RequestMapping("order")
public class PlaceOderController {
    @Autowired
    private PlaceOrderService placeOrderService;

    @PostMapping("/place")
    public boolean place(@RequestBody PlaceOrderDTO placeOrderDTO){
        return placeOrderService.placeOrder(placeOrderDTO);
    }

}
