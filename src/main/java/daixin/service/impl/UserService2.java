package daixin.service.impl;

import daixin.Bean.Users;

public interface UserService2 {
    Users QueryforPasswordAndUsername(String Username, String password);
}
