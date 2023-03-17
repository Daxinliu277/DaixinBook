package daixin.service.impl;

import daixin.Bean.Users;

public interface UserService {
    boolean existUsername(String username);

    Users login(Users users);

    void registUser(Users users);
}
