package model.expense;

import model.user.User;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseDAO {
    public int addExpense(Expense expense) throws SQLException;
    //public int updateExpense(String user) throws SQLException;
    public List<Expense> getExpensesByUserId(int userId) throws SQLException;
}
