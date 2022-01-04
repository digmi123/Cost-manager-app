package model;

import viewmodel.IViewModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleCostManagerModel implements  IModel{

    IViewModel viewModel;
    public User userDAO = new SimpleCostManagerModel.User();
    public Expense ExpenseDAO = new SimpleCostManagerModel.Expense();;

    private static final Connection conn = SimpleCostManagerModel.GetConnection();

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/costmanager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "88788456";


    public class User {

        private String username;
        private String password;

            public User(String username, String password) {
                userDAO.username = username;
                userDAO.password = password;
            }

            public User()
            {

            }

            public int addUser(model.User user) throws SQLException {

                String query = "insert into users (username, password) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                int numOfExecutedRows = ps.executeUpdate();
                System.out.println("User added successfully");
                return numOfExecutedRows;
            }


            public int getUserId(String username,String password) throws SQLException {
                String query = "select * from users where username = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id");
                }
                else{
                    return 0;
                }
            }


            public List<model.User> getUsers() throws SQLException {

                String query = "select * from users";
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                List<model.User> ls = new ArrayList();

                while (rs.next()) {
                    model.User user = new model.User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    ls.add(user);
                }
                return ls;
            }

            public String getUsername() {
                return userDAO.username;
            }

            public void setUsername(String username) {
                userDAO.username = username;
            }

            public String getPassword() {
                return userDAO.password;
            }

            public void setPassword(String password) {
                userDAO.password = password;
            }
    }

    public class Expense
    {
        public int addExpense(model.Expense expense) throws SQLException {
            String query = "insert into expenses (user_id, category, price, currency, date, description) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, expense.getUserId());
            ps.setString(2, expense.getCategory());
            ps.setFloat(3, expense.getPrice());
            ps.setString(4, expense.getCurrency());
            ps.setString(5, expense.getDate());
            ps.setString(6, expense.getDescription());
            System.out.println("Expense has been added successfully");

            int numOfExecutedRows = ps.executeUpdate();
            return numOfExecutedRows;
        }


        public List<model.Expense> getExpensesByUserId(int userId) throws SQLException {
            String query = "select * from expenses where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            List<model.Expense> ls = new ArrayList();

            while (rs.next()) {
                model.Expense expense = new model.Expense();
                expense.setCategory(rs.getString("category"));
                expense.setCurrency(rs.getString("currency"));
                expense.setDate(rs.getString("date"));
                expense.setPrice(rs.getFloat("price"));
                expense.setDescription(rs.getString("description"));
                ls.add(expense);
            }
            return ls;
        }
    }


    public static Connection GetConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("connection established");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public void setViewModel(IViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void setUser()
    {
        this.userDAO = new User();
    }

    @Override
    public List<model.User> getUsers() throws SQLException {
        return userDAO.getUsers();
    }

    @Override
    public int getUserId(String username, String password) throws SQLException {
        int connectedUserId = userDAO.getUserId(username,password);
        System.out.println("The connected user id is" + connectedUserId);
        return connectedUserId;
    }

    @Override
    public int addUser(model.User user) throws SQLException {
        return userDAO.addUser(user);
    }

    @Override
    public int addExpense(model.Expense expense) throws SQLException {
        return ExpenseDAO.addExpense(expense);
    }

    @Override
    public List<model.Expense> getExpensesByUserId(int userId) throws SQLException {
        return ExpenseDAO.getExpensesByUserId(userId);
    }


}


