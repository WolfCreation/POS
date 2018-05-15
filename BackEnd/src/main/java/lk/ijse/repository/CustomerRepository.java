package lk.ijse.repository;

import lk.ijse.domain.Customer;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface CustomerRepository {

    public boolean addCustomer(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean deleteCustomer(int id);

    public Customer searchCustomer(int id);

    public List<Customer> findAll();

}

