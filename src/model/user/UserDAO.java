package model.user;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public int addUser(User user) throws SQLException;
    public int getUserId(String user, String password) throws SQLException;
    public List<User> getUsers() throws SQLException;
}
