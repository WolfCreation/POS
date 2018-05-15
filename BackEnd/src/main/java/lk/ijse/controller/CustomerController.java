package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@RestController
@RequestMapping("cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public boolean save(@RequestBody CustomerDTO dto){

//        CustomerDTO customerDTO= new CustomerDTO();
//        customerDTO.setCid(dto.getCid());
//        customerDTO.setName(dto.getName());
//        customerDTO.setContact(dto.getContact());
//        customerDTO.setAddress(dto.getAddress());

        return customerService.addCustomer(dto);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAll(){
        return customerService.findAll();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO);
    }

    @GetMapping("/find")
    public CustomerDTO find(@RequestParam int id){
        return customerService.searchCustomer(id);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int id){
        return customerService.deleteCustomer(id);
    }


}
