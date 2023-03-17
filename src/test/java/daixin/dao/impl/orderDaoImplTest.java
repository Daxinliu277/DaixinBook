package daixin.dao.impl;


import daixin.Bean.Order;
import daixin.Bean.orderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class orderDaoImplTest {

    @Test
    public void order(){
        orderDao order=new orderDaoImpl();
        int i = order.saveOrder(new Order("1314555", new Date(), new BigDecimal(50), 0, 1));
        if(i==0){
            System.out.println("添加失败");
        }
        System.out.println("添加成功");

    }
    @Test
    public void orderItem(){
        orderItemDao order =new orderItemDaoImpl();

        int first = order.saveOrderItem(new orderItem(1, "first", 5, new BigDecimal(555), new BigDecimal(555), "1314555"));

        if(first==0){
            System.out.println("添加失败");
        }
        System.out.println("添加成功");

    }

}