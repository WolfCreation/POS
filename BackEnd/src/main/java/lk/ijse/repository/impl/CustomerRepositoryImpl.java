package lk.ijse.repository.impl;

import lk.ijse.domain.Customer;
import lk.ijse.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        Serializable save = currentSession().save(customer);
        if (save != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        currentSession().update(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(int id) {
        currentSession().delete(searchCustomer(id));
        return true;
    }

    @Override
    public Customer searchCustomer(int id) {
        Customer customer =currentSession().get(Customer.class,id);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = currentSession().createCriteria(Customer.class).list();
        return allCustomers;
    }
}
