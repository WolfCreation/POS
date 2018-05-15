package lk.ijse.repository.impl;

import lk.ijse.domain.Item;
import lk.ijse.repository.ItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SL_WOLF on 5/15/2018.
 */
@Repository
@Transactional
@Qualifier("")
public class ItemRepositoryImpl implements ItemRepository{

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean addItem(Item item) {
        Serializable save = currentSession().save(item);
        if (save != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
        currentSession().update(item);
        return true;
    }

    @Override
    public boolean deleteItem(int id) {
        currentSession().delete(searchItem(id));
        return true;
    }

    @Override
    public Item searchItem(int id) {
        Item item =currentSession().get(Item.class,id);
        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> allItems = currentSession().createCriteria(Item.class).list();
        return allItems;
    }
}
