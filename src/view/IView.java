package view;

import model.Expense;
import viewmodel.IViewModel;

import java.util.List;

public interface IView {
    public void setViewModel(IViewModel viewModel);
    public void initLoginPage();
    public void startLoginPage();
    public void showExpensesTable(List<Expense> expensesList);
    public void setConnectionStatus(boolean isConnected);
    public void setConnectedUserId(int connectedUserId);
    public void showErrorBox(String error);
}
