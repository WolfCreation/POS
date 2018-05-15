package lk.ijse.service;

import lk.ijse.dto.CustomerDTO;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface CustomerService {

    public boolean addCustomer(CustomerDTO customerDTO);

    public boolean updateCustomer(CustomerDTO customerDTO);

    public boolean deleteCustomer(int id);

    public CustomerDTO searchCustomer(int id);

    public List<CustomerDTO> findAll();


}
