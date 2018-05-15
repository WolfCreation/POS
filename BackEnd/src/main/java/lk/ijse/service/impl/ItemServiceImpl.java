package lk.ijse.service.impl;

import lk.ijse.domain.Item;
import lk.ijse.dto.ItemDTO;
import lk.ijse.repository.ItemRepository;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        Item item=new Item(itemDTO.getItemId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty());
        return itemRepository.addItem(item);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        Item item=new Item(itemDTO.getItemId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty());
        return itemRepository.updateItem(item);
    }

    @Override
    public boolean deleteItem(int id) {
        return itemRepository.deleteItem(id);
    }

    @Override
    public ItemDTO searchItem(int id) {
        Item item=itemRepository.searchItem(id);
        ItemDTO itemDTO=new ItemDTO(item.getItemId(),item.getDescription(),item.getPrice(),item.getQty());
        return itemDTO;
    }

    @Override
    public List<ItemDTO> findAll() {
        List<ItemDTO> allItems=new ArrayList<>();
        List<Item> all=itemRepository.findAll();
        for(Item item : all){
            ItemDTO itemDTO= new ItemDTO(item.getItemId(),item.getDescription(),item.getPrice(),item.getQty());
            allItems.add(itemDTO);
        }

        return allItems;
    }
}
