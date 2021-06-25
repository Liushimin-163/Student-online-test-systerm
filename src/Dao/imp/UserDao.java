package Dao.imp;

import Util.dbUtil;
import entity.UserInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao implements IUserDao{
    private dbUtil utils = new dbUtil();

    public int add(UserInfo userInfo) {
        String sql = "insert into userinfo(userName,password,gender,email) values" +
                "(?,?,?,?)";
        PreparedStatement ps = utils.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, userInfo.getUserName());
            ps.setString(2, userInfo.getPassword());
            ps.setString(3, userInfo.getGender());
            ps.setString(4, userInfo.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close();
        }

        return result;

    }

    public List<UserInfo> findAll() {
        List<UserInfo> list = new LinkedList<>();
        String sql = "select * from userinfo";
        UserInfo userInfo = null;
        PreparedStatement ps = utils.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            while (rs.next()) {
                Integer userId = rs.getInt("userId");
                String username = rs.getString("userName");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                userInfo = new UserInfo(userId, username, password, gender, email);
                list.add(userInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close(rs);
            utils.close();
        }

        return list;
    }

    public int deleteUser(String userId) {
        String sql = "delete from userinfo where userId=?";
        PreparedStatement ps = utils.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            utils.close();
        }
        return result;
    }

    public int login(String username, String password) {

        String sql = "select count(*) from userinfo where userName =? and password = ?";
        PreparedStatement ps = utils.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1,username);
            ps.setString(2,password);
            rs =  ps.executeQuery();
            while (rs.next()){
                result =  rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            utils.close(rs);
        }
        return result;

    }
}
