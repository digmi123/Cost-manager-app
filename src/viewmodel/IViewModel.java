package viewmodel;

import model.IModel;
import model.expense.Expense;
import model.expense.ExpenseDAO;
import model.user.User;
import model.user.UserDAO;
import view.IView;

public interface IViewModel {
    public void setView(IView view);
    public void setModel(UserDAO userModel);
    public void setModel(ExpenseDAO expenseModel);
    public void add(User user);
    public void add(Expense expense);
    public void getUserDetails(String username, String password);

}
