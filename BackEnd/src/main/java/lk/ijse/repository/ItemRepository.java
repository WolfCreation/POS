package lk.ijse.repository;

import lk.ijse.domain.Item;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface ItemRepository {

    public boolean addItem(Item item);

    public boolean updateItem(Item item);

    public boolean deleteItem(int id);

    public Item searchItem(int id);

    public List<Item> findAll();

}
