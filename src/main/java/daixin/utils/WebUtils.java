package daixin.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

    public static <T> T Maptobean(Map map, T bean) {

        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
//       return Integer.parseInt(str);

    }
}
