package lk.ijse.service.impl;

import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.model.Customer;
import lk.ijse.model.Item;
import lk.ijse.repository.ItemRepository;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Service
@Transactional
public class ItemServiceImpl  implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        Item item=new Item(itemDTO.getItemId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty());
        return itemRepository.save(item)!=null;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        int itemId=itemDTO.getItemId();
        Optional<Item> op=itemRepository.findById(itemId);
        if(op.isPresent()){
            Item item= new Item(itemDTO.getItemId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty());
            return itemRepository.save(item)!=null;
        }
        return false;
    }

    @Override
    public boolean deleteItem(int id) {
        Optional<Item> op=itemRepository.findById(id);
        if(op.isPresent()){
            Item item=new Item(op.get().getItemId(),op.get().getDescription(),op.get().getPrice(),op.get().getQty());
            itemRepository.delete(item);
            return true;
        }
        return false;
    }

    @Override
    public ItemDTO searchItem(int id) {
        Optional<Item> op=itemRepository.findById(id);
        if (op.isPresent()){
            return new ItemDTO(op.get().getItemId(),op.get().getDescription(),op.get().getPrice(),op.get().getQty());
        }
        return null;
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
