package model.user;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public int add(User user) throws SQLException;
    public User getUser(String user) throws SQLException;
    public List<User> getUsers() throws SQLException;
}
