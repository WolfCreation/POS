package lk.ijse.service.impl;

import lk.ijse.domain.Customer;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.repository.CustomerRepository;
import lk.ijse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getAddress());
        return   customerRepository.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(customerDTO.getCid(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getAddress());
        return   customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public CustomerDTO serachCustomer(int id) {
        Customer customer=customerRepository.searchCustomer(id);
        CustomerDTO customerDTO= new CustomerDTO(customer.getCid(),customer.getName(),customer.getContact(),customer.getAddress());
        return customerDTO;
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
