package model.expense;

import model.SimpleCostManagerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            ps.setString(1, expense.getUserId());
            ps.setString(2, expense.getCategory());
            ps.setFloat(3, expense.getPrice());
            ps.setString(4, expense.getCurrency());
            ps.setString(5, expense.getDate());
            ps.setString(6, expense.getDescription());

            int numOfExecutedRows = ps.executeUpdate();
            return numOfExecutedRows;
    }
}
