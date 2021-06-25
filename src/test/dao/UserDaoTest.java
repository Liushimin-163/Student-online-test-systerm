package test.dao;

import Dao.imp.UserDao;
import entity.UserInfo;
import jdk.jfr.StackTrace;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class UserDaoTest {
@Test
  public void testAdd(){
      UserDao userDao=new UserDao();
      UserInfo userInfo=new UserInfo();
      userInfo.setUserName("lily");
      userInfo.setGender("M");
      userInfo.setPassword("root123");
      userInfo.setEmail("lily@163.com");
      int result=userDao.add(userInfo);
        Assert.assertSame(1,result);
    }
@Test
    public void testFindAll(){
      UserDao userDao=new UserDao();
        List<UserInfo> list = userDao.findAll();
        System.out.println(list);
        Assert.assertNotNull(list);

    }
    @Test
   public  void testUserDelete(){
        UserDao userDao=new UserDao();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("lily");
        userInfo.setGender("M");
        userInfo.setPassword("root123");
        userInfo.setEmail("lily@163.com");;
        int result=userDao.deleteUser("1");
        Assert.assertSame(1,result);
    }
    @Test
    public void testlogin(){
        UserDao userDao=new UserDao();
        UserInfo userInfo=new UserInfo();
        userInfo.setUserName("lily");
        userInfo.setGender("M");
        userInfo.setPassword("root123");
        userInfo.setEmail("lily@163.com");
        int result=userDao.login(userInfo.getUserName(),userInfo.getPassword());
        Assert.assertSame(1,result);
    }

}
