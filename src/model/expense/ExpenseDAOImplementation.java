package model.expense;

import model.SimpleCostManagerModel;
import model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//package model.expense;
//
//import model.SimpleCostManagerModel;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
public class ExpenseDAOImplementation implements ExpenseDAO {
    private static final Connection conn = SimpleCostManagerModel.GetConnection();

    @Override
    public int addExpense(Expense expense) throws SQLException {
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

    @Override
    public List<Expense> getExpensesByUserId(int userId) throws SQLException {
        String query = "select * from expenses where user_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        List<Expense> ls = new ArrayList();

        while (rs.next()) {
            Expense expense = new Expense();
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

