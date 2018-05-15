package lk.ijse.service.impl;

import lk.ijse.dto.CustomerDTO;
import lk.ijse.model.Customer;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        Customer customer= new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getAddress());
        return customerRepository.save(customer)!=null;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
       int id=customerDTO.getCid();
       Optional<Customer> op = customerRepository.findById(id);
       if(op.isPresent()){
           Customer customer=new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getAddress());
          return customerRepository.save(customer)!=null;
       }
       return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
      CustomerDTO customerDTO = searchCustomer(id);
      if(customerDTO!=null){
          customerRepository.delete(new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getAddress()));
          return true;
      }
      return false;
    }

    @Override
    public CustomerDTO searchCustomer(int id) {
        Optional<Customer> op=customerRepository.findById(id);
        if(op.isPresent()){
           return new CustomerDTO(op.get().getCid(),op.get().getName(),op.get().getContact(),op.get().getAddress());
        }
        return null;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<CustomerDTO> allCustomers=new ArrayList<>();
        List<Customer> all=customerRepository.findAll();
        for(Customer customer : all){
            CustomerDTO customerDTO= new CustomerDTO(customer.getCid(),customer.getName(),customer.getContact(),customer.getAddress());
            allCustomers.add(customerDTO);
        }

        return allCustomers;
    }
}
