package com.cn.cnkart.dal;

import com.cn.cnkart.entity.ItemDetails;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Repository
public class ItemDetailsDALImpl implements ItemDetailsDAL{

    @Autowired
    EntityManager entityManager;

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        ItemDetails itemDetails = session.get(ItemDetails.class,id);
        session.delete(itemDetails);
    }
}
