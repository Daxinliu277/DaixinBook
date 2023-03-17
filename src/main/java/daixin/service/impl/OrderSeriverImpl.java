package daixin.service.impl;

import daixin.Bean.*;
import daixin.dao.impl.*;
import daixin.utils.jdbcUtils;

import java.util.Date;
import java.util.Map;

public class OrderSeriverImpl implements OrderService {
    private orderDao orderdao = new orderDaoImpl();
    private orderItemDao orderitem = new orderItemDaoImpl();

    private BookDao book = new BookDaoimpl();

    @Override
    public String create(Car car, Integer id) {
        String orderId = System.currentTimeMillis() + "" + id;
        Order order = new Order(orderId, new Date(), car.getTotalPrice(), 0, id);//创建订单
        //保存订单
        orderdao.saveOrder(order);
        int i = 78 / 0;
//        try {
        for (Map.Entry<Integer, CarItem> entry : car.getItemList().entrySet()) {

            CarItem value = entry.getValue();//获取购物车每一个商品 value 然后转换为 orderItem
            //把订单保存到数据库中
            orderitem.saveOrderItem(new orderItem(null, value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice(), orderId));

            Book book1 = book.queryBookByid(value.getId());
            book1.setSales(book1.getSales() + value.getCount());//销量 每卖出一本销量+1
            book1.setStock(book1.getStock() - value.getCount());//Count销量 也就是买这个书的本数  库存 每卖出一本库存-1
            book.updateBook(book1);

        }
//        } catch (Exception e){
//            jdbcUtils.CloseAndRollback();
//        }finally {
//            jdbcUtils.CloseAndCommit();
//        }
        car.clear();//购买成功后清空购物车


        return orderId;
    }
}
