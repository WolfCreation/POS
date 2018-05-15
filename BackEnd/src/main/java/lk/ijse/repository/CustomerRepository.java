package lk.ijse.repository;

import lk.ijse.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
