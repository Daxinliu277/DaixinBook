package daixin.dao.impl;

import daixin.Bean.Order;

public class orderDaoImpl extends BaseDao implements orderDao{
    @Override
    public int saveOrder(Order order) {//sql数据库中的references关键字意思是  跟指定的表中和指定的值必须相对应 否则将会爆错
        String sql="insert into t_order(`order_id`,`create_time`, price,`status`,`user_id`) values (?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
