package controllers;

import dao.ItemDAO;
import entity.item.ItemEntity;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import rest.item.ItemRequest;

/**
 *
 * @author milenko
 */

@RequestScoped
@Transactional
public class ItemController {
    
    @Inject
    ItemDAO itemDao;
    
    @Location("item/home.html")
    Template itemHome;

    
    public TemplateInstance getHome() {
        return itemHome.data("item", new ItemEntity())
                .data("items", getAllItems());
    }
   
    
    public List<ItemEntity> getAllItems() {
        return itemDao.listAll();
    }

    private ItemEntity getItemFromForm(Long itemId, ItemRequest itemRequstForm) {
        var result = getItemFromForm(itemRequstForm);
        
        result.setId(itemId);
        
        return result;
    }
    
    private ItemEntity getItemFromForm(ItemRequest itemRequstForm) {
        var result = new ItemEntity();

        result.setName(itemRequstForm.getItemName());
        result.setDescription(itemRequstForm.getItemDescription());
        result.setCount(itemRequstForm.getItemCount());
        
        return result;
    }

    public void updateItem(Long itemId, ItemRequest itemRequstForm) {
        var itemDto = getItemFromForm(itemId, itemRequstForm);
        var itemEntity = itemDao.getItemById(itemId);
        mapToEntity(itemDto, itemEntity);
    }
    
    private void mapToEntity(ItemEntity itemDto, ItemEntity itemEntity) {
        itemEntity.setName(itemDto.getName());
        itemEntity.setDescription(itemDto.getDescription());
        itemEntity.setCount(itemDto.getCount());
    }

    public void deleteItem(Long itemId) {
        itemDao.deleteById(itemId);
    }

    public TemplateInstance getItemForEdit(Long itemId) {
        return getHome().data("item", itemDao.getItemById(itemId));
    }

    public void addItem(ItemRequest itemRequstForm) {
        var itemToAdd = getItemFromForm(itemRequstForm);
        itemDao.persist(itemToAdd);
    }
    
}
