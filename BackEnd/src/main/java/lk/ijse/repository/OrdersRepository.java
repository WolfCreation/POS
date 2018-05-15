package lk.ijse.repository;

import lk.ijse.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SL_WOLF on 5/16/2018.
 */
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
