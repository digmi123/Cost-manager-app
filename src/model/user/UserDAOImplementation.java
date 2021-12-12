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
    public int add(User user) throws SQLException {
        String query = "insert into users (username, password) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        int numOfExecutedRows = ps.executeUpdate();
        return numOfExecutedRows;
    }

    @Override
    public User getUser(String username) throws SQLException {

        String query = "select * from users where username = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, username);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            //user.setUser_id(rs.getInt("emp_id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }

        if (check) {
            return user;
        } else
            return null;
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
