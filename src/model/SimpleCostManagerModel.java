package model;

import model.expense.Expense;
import model.expense.ExpenseDAOImplementation;
import model.user.User;
import model.user.UserDAOImplementation;
import viewmodel.IViewModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleCostManagerModel implements  IModel{

    IViewModel viewModel;
    public static void main(String[] args) throws SQLException {
        //UserDAOImplementation userDatabase = new UserDAOImplementation();
        ExpenseDAOImplementation expenseDatabase = new ExpenseDAOImplementation();
//        User user1 = new User("kkk","123456");
//        userDatabase.add(user1);
//        List<User> users = userDatabase.getUsers();
//        for (User user : users) {
//            System.out.println(user.getUsername());
//        }
        Expense expense1 = new Expense("1","Car",300f,"ILS","2021-12-12","Fuel");
        expenseDatabase.addExpense(expense1);
        System.out.println("succeed");

    }

    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/costmanager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "88788456";


    public static Connection GetConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("connection established");
                //statement = connection.createStatement();
                //statement.execute("INSERT INTO users (username,password) VALUES ('digmi','123456')");
                //statement.execute("DELETE FROM users WHERE username='digmi'");
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
}
