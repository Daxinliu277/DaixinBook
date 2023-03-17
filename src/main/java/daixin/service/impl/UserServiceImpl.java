package daixin.service.impl;

import daixin.Bean.Users;
import daixin.dao.impl.UserDao;
import daixin.dao.impl.UserDaoimpl;

public class UserServiceImpl implements UserService {
    private UserDao user = new UserDaoimpl();

    @Override
    public boolean existUsername(String username) {
        if (user.queryforname(username) == null) {//等于null的话就是没有查询到  所以为true
            return false;
        }
        return true;
    }

    @Override
    public Users login(Users users) {
        return user.queryforUsernameAndPassword(users.getUsername(),users.getPassword());
    }

    @Override
    public void registUser(Users users) {
        user.queruforSeveUsers(users);

    }
}
