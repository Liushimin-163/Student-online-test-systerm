package Service.imp;

import Dao.imp.IUserDao;
import Dao.imp.UserDao;
import entity.UserInfo;

import java.util.List;

public class UserService implements IUserService{
    IUserDao userDao = new UserDao();

    @Override
    public int add(UserInfo userInfo) {
        return userDao.add(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public int deleteUser(String userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public int login(String username, String password) {
        return userDao.login(username, password);
    }
}
