package lk.ijse.controller;

import lk.ijse.dto.ItemDTO;
import lk.ijse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public boolean save(@RequestBody ItemDTO dto){

        ItemDTO itemDTO= new ItemDTO();
        itemDTO.setItemId(dto.getItemId());
        itemDTO.setDescription(dto.getDescription());
        itemDTO.setPrice(dto.getPrice());
        itemDTO.setQty(dto.getQty());

        return itemService.addItem(itemDTO);
    }
    @GetMapping("/all")
    public List<ItemDTO> getAll(){
        return itemService.findAll();
    }
    @PutMapping("/update")
    public boolean update(@RequestBody ItemDTO itemDTO){
        return itemService.updateItem(itemDTO);
    }

    @GetMapping("/find")
    public ItemDTO find(@RequestParam int id){
        return itemService.searchItem(id);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int id){
        return itemService.deleteItem(id);
    }


}
