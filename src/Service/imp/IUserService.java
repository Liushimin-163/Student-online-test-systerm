package Service.imp;

import entity.UserInfo;

import java.util.List;

public interface IUserService {
    public int add(UserInfo userInfo);

    public List<UserInfo> findAll();

    public int deleteUser(String userId);

    public int login(String username, String password);
}
