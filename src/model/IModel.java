package model;

import viewmodel.IViewModel;

import java.sql.SQLException;
import java.util.List;

public interface IModel {
    public void setViewModel(IViewModel viewModel);
    public void setUser();
    public List<model.User> getUsers() throws SQLException;
    public int getUserId(String username,String password) throws SQLException;
    public int addUser(User user) throws SQLException;
    public int addExpense(model.Expense expense) throws SQLException;
    public List<Expense> getExpensesByUserId(int userId) throws SQLException;
}
