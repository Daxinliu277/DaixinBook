package daixin.dao.impl;

import daixin.Bean.Users;

public class UserDaoimpl extends BaseDao implements UserDao {
    @Override
    public Users queryforname(String username) {

        String sql = "select id,username,password,email from t_user where username= ?";
        return queryforOne(Users.class, sql, username);
    }

    @Override
    public Users queryforUsernameAndPassword(String username, String password) {
        String sql = "select `id`,username,password from t_user where username=? And password=?";
        return queryforOne(Users.class, sql, username, password);
    }

    @Override
    public int queruforSeveUsers(Users users) {
        String sql = "insert into t_user(username,password,email) values(?,?,?)";
        return update(sql, users.getUsername(), users.getPassword(), users.getEmail());

    }


}
