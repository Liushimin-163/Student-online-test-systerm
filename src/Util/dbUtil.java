package Util;

import java.sql.*;

public class dbUtil {
    private static String drive="com.mysql.cj.jdbc.Driver";
    private static String urls="jdbc:mysql://localhost:3306/useSSL?characterEncoding=utf-8&serverTimezone=UTC";
    private static String username="root";

    private static String userPw="rootroot";
    PreparedStatement ps = null;
    Connection conn=null;

    public static Connection getCon(){
        try{
            Class.forName(drive);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn=null;
        try{
            conn= DriverManager.getConnection(urls,username,userPw);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    public PreparedStatement createStatement(String sql) {
        try {
            ps = getCon().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    public void close() {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }}
