package lk.ijse.service;

import lk.ijse.dto.ItemDTO;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
public interface ItemService {

    public boolean addItem(ItemDTO itemDTO);

    public boolean updateItem(ItemDTO itemDTO);

    public boolean deleteItem(int id);

    public ItemDTO searchItem(int id);

    public List<ItemDTO> findAll();


}
