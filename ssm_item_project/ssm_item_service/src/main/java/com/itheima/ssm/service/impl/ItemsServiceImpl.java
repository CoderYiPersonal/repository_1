package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ItemsDao;
import com.itheima.ssm.domain.Items;
import com.itheima.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;


    @Override
    public List<Items> findAllItems() {
        return itemsDao.findAllItems();
    }

    @Override
    public Items findAllItemById(Integer id) {
        return itemsDao.findAllItemById(id);
    }

    @Override
    public void updateItems(Items items) {
        itemsDao.updateItems(items);
    }
}
