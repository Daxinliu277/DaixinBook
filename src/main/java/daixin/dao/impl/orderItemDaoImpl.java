package daixin.dao.impl;

import daixin.Bean.orderItem;

public class orderItemDaoImpl extends BaseDao implements orderItemDao{

    @Override
    public int saveOrderItem(orderItem order) {
        String sql="insert into t_order_Items (id,name,count,price,total_price,order_id) values (?,?,?,?,?,?)";
        return update(sql,order.getId(),order.getName(),order.getCount(),order.getPrice(),order.getTotalPrice(),order.getOrderId());
    }
}
