/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.DBConnectionHandler;

/**
 *
 * @author SCUBE
 */
public class UserDao {

    public User getUserData(User user) {
        User outModel = new User();
        Connection oConn = null;
        //DBConnectionHandler.getConVentionalConnection();

        try {

            //oConn = DBConnectionHandler.getConVentionalConnection();
            //Class.forName("com.mysql.jdbc.Driver");
            //oConn =DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase", "root", "root");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            oConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

            String sql = "SELECT NAME FROM ROOT.SERVLETUSER WHERE PHONE=? AND PASSWORD=?";

            PreparedStatement ps = oConn.prepareStatement(sql);
            ps.setString(1, user.getPhone());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            System.out.println("sql = " + sql);

            if (rs.next()) {
                outModel.setName(rs.getString("NAME"));
                outModel.setOutCode("0");
                outModel.setOutMessege("Login Successfull");

            } else {
                outModel.setOutCode("1");
                outModel.setOutMessege("Login Not Successfull");

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (oConn != null) {
                DBConnectionHandler.releaseConnection(oConn);
            }
        }
        return outModel;

    }

    public User saveUserData(User user) {
        User outModel = new User();
        Connection oConn = null;
        //DBConnectionHandler.getConVentionalConnection();

        try {

            //oConn = DBConnectionHandler.getConVentionalConnection();
            //Class.forName("com.mysql.jdbc.Driver");
            //oConn =DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase", "root", "root");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            oConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

            String sql = "INSERT INTO ROOT.SERVLETUSER (NAME, PHONE,PASSWORD,ID) VALUES (?,?,?,?)";

            PreparedStatement ps = oConn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());

            ps.executeUpdate();
            System.out.println("sql = " + sql);

            outModel.setName(user.getName());
            outModel.setPhone(user.getPhone());
            outModel.setPassword(user.getPassword());

//            if (ps.executeUpdate())) {
//                outModel.setName(rs.getString("NAME"));
//                outModel.setOutCode("0");
//                outModel.setOutMessege("Login Successfull");
//
//            } else {
//                outModel.setOutCode("1");
//                outModel.setOutMessege("Login Not Successfull");
//
//            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (oConn != null) {
                DBConnectionHandler.releaseConnection(oConn);
            }
        }
        return outModel;

    }

    public User deleteUserData(User user) {
        User outModel = new User();
        Connection oConn = null;
       
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            oConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

            String sql = "DELETE  FROM ROOT.SERVLETUSER WHERE PHONE = ?";

            PreparedStatement ps = oConn.prepareStatement(sql);

            ps.setString(1, user.getPhone());

            ps.executeUpdate();
            System.out.println("sql = " + sql);

            outModel.setPhone(user.getPhone());


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (oConn != null) {
                DBConnectionHandler.releaseConnection(oConn);
            }
        }
        return outModel;

    }

    public User updateUserData(User user) {
        User outModel = new User();
        Connection oConn = null;
       
        try {

           Class.forName("oracle.jdbc.driver.OracleDriver");
            oConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");

            String sql = "UPDATE ROOT.SERVLETUSER SET PASSWORD=? WHERE PHONE=?";

            PreparedStatement ps = oConn.prepareStatement(sql);

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getPhone());

            ps.executeUpdate();
            System.out.println("sql = " + sql);
            outModel.setPassword(user.getPassword());
            outModel.setPhone(user.getPhone());


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (oConn != null) {
                DBConnectionHandler.releaseConnection(oConn);
            }
        }
        return outModel;

    }

    public static void main(String[] args) {

//        Value Check
//        UserDao userDao = new UserDao();
//        User model = new User();
//        model.setPhone("01933575667");
//        model.setPassword("12345");
//        //System.out.println("model = " + model);
//        User logininfo = userDao.saveUserData(model);
//        System.out.println("Name = " + logininfo.getName());
//        System.out.println("OutMessege = " + logininfo.getOutMessege());
//        System.out.println("OutCode = " + logininfo.getOutCode());
//
//        User deleteUser = userDao.deleteUserData(model);
//        System.out.println("Phone = " + deleteUser.getPhone());
  }

}
