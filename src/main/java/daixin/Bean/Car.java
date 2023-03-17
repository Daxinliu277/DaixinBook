package daixin.Bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Car {

    Map<Integer, CarItem> itemList = new LinkedHashMap<Integer, CarItem>();

    public Car() {
    }

    public void addItem(CarItem item) {//这里的item就是在这里创建的或new出来的那个类
        CarItem carItem = itemList.get(item.getId());//查询里面有没有相同的id值 carItem是代表这里获取的id 查询有没有相对应的值有的话就是获取当对应id值的对象 没有的话就把当前类中的数据放入listitem

        if (carItem == null) {
            itemList.put(item.getId(), item);//如果查询到当前的linkedHashMap中没有 相对应的Car实例 就添加进去
        } else {
            item.setCount(carItem.getCount() + 1);//然后在修改map中相对应id的那个数量，carItem.getCount()拿到获取到的id值的数量信息然后+1 这里是代表map中的相对应的id值中的CarItem对象数据
            item.setTotalPrice(carItem.getPrice().multiply(new BigDecimal(item.getCount())));//然后在拿到当前获取到的id值中的信息
                                                                            // 去X商品数量 item.getCount是代表已经加过的数量值
            itemList.put(item.getId(), item);//然后重新将他写入map中
        }

    }

    public void delete(Integer id) {
        itemList.remove(id);
    }

    public void clear() {
        itemList.clear();
    }

    public void updateCount(Integer id, Integer Count) {
        CarItem carItem = itemList.get(id);
        if (carItem != null) {
            carItem.setCount(Count);
            carItem.setTotalPrice(carItem.getPrice().multiply(new BigDecimal(carItem.getCount())));//因为重复存入了要重新计算
        }
    }


    public Integer getTotalCount() {
       Integer totalCount = 0;
        for (Map.Entry<Integer, CarItem> entry : itemList.entrySet()) {
            totalCount += entry.getValue().getCount();//获取到value中的所有对象的count值然后全部添加给totalcount然后return输出到control Disk
        }

        return totalCount;
    }

    public BigDecimal getTotalPrice() {//获取所有商品的总价
        BigDecimal totalPrice=new BigDecimal(0);
        for (Map.Entry<Integer, CarItem> entry : itemList.entrySet()) {
            totalPrice =totalPrice.add( entry.getValue().getTotalPrice());//获取到value中的所有对象的count值然后全部添加给totalcount然后return输出到control Disk
        }


        return totalPrice;
    }


    public Map<Integer, CarItem> getItemList() {

        return itemList;
    }

    public void setItemList(Map<Integer, CarItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", itemList=" + itemList +
                '}';
    }
}
