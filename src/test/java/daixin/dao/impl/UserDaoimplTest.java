package daixin.dao.impl;

import daixin.Bean.Users;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoimplTest {

    @Test
    public void queryforUsernameAndPassword() {
        Users daixin = new UserDaoimpl().queryforUsernameAndPassword("daixin", "123456");
        System.out.println(daixin);
    }
}