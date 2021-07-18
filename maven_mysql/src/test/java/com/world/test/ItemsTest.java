package com.world.test;

import com.world.domain.Items;
import dao.ItemsDao;
import dao.impl.ItemsDatImpl;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao=new ItemsDatImpl();
        List<Items> list=itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items.getName());
        }
    }
}
