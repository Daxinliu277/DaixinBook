package daixin.service.impl;

import daixin.Bean.Users;
import daixin.dao.impl.UserDaoimpl;

public class UserServiceImpl2 extends UserDaoimpl implements UserService2 {

    @Override
    public Users QueryforPasswordAndUsername(String Username, String password) {
        return queryforUsernameAndPassword(Username, password);
    }
}
