package daixin.Bean;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CarTest {
    private Map<Integer, CarItem> map = new LinkedHashMap<>();

    @Test
    public void addItem() {
        Car car = new Car();
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));

        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));
        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));


        System.out.println(car);
    }

    @Test
    public void delete() {
        Car car = new Car();
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));

        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));
        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));

        car.delete(1);

        System.out.println(car);
    }

    @Test
    public void clear() {
        Car car = new Car();
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));
        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));

        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));
        car.addItem(new CarItem(2, "ee", 1, new BigDecimal(40), new BigDecimal(990)));

        car.clear();

        car.addItem(new CarItem(1, "aa", 1, new BigDecimal(30), new BigDecimal(100)));

        car.updateCount(1, 10);
        System.out.println(car);

    }
    @Test
    public void updateCount(){


    }


}