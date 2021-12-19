package model.user;

import model.SimpleCostManagerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplementation implements UserDAO {
    private static final Connection conn = SimpleCostManagerModel.GetConnection();

    @Override
    public int addUser(User user) throws SQLException {
        String query = "insert into users (username, password) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        int numOfExecutedRows = ps.executeUpdate();
        System.out.println("User added successfully");
        return numOfExecutedRows;
    }

    @Override
    public int getUserId(String username,String password) throws SQLException {

        String query = "select * from users where username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        if (rs.next()) {
            //user.setUser_id(rs.getInt("emp_id"));
            return rs.getInt("id");
        }
         else{
            return 0;
        }
    }

    @Override
    public List<User> getUsers() throws SQLException {

        String query = "select * from users";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<User> ls = new ArrayList();

        while (rs.next()) {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            ls.add(user);
        }
        return ls;
    }
}
