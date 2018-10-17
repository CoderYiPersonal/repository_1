package com.itheima.ssm.service;



import  com.itheima.ssm.domain.Items;

import java.util.List;

public interface ItemsService {
    List<Items> findAllItems();

    Items findAllItemById(Integer id);

    void updateItems(Items items);
}
