package dao;

import entity.item.ItemEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author milenko
 */
@RequestScoped
public class ItemDAO implements PanacheRepository<ItemEntity>{
    
    public ItemEntity getItemById(Long id) {
        return findById(id);
    }
    
    public void addItem(ItemEntity item) {
        persist(item);
    }
    
    public ItemEntity addItemAndReturn(ItemEntity item) {
        addItem(item);
        return item;
    }
    
}
