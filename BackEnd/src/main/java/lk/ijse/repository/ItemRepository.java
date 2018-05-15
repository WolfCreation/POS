package lk.ijse.repository;

import lk.ijse.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface ItemRepository extends JpaRepository<Item , Integer>{
}
