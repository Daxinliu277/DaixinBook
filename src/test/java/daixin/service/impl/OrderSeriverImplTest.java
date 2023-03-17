package daixin.service.impl;

import daixin.Bean.Car;
import daixin.Bean.CarItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderSeriverImplTest {

    @Test
    public void orderSerice(){
        OrderService orderService= new OrderSeriverImpl();

        Car car = new Car();
        CarItem carItem = new CarItem(1,"月亮",5,new BigDecimal(20),new BigDecimal(50));

        car.addItem(carItem);

        String s = orderService.create(car, 1);
        System.out.println(s);
    }

}