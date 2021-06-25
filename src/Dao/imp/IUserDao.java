package Dao.imp;

import entity.UserInfo;

import java.util.List;

public interface IUserDao {
    public int add(UserInfo userInfo);

    public List<UserInfo> findAll();

    public int deleteUser(String userId);

    public int login(String username, String password);
}
