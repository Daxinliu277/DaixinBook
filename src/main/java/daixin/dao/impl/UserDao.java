package daixin.dao.impl;

import daixin.Bean.Users;

public interface UserDao {
    Users queryforname(String username);

    Users queryforUsernameAndPassword(String username, String password);

    int queruforSeveUsers(Users users);
}
