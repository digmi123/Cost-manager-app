package viewmodel;

import model.IModel;
import model.Expense;
import model.User;
//import model.user.UserDAO;
import view.IView;

public interface IViewModel {
    public void setView(IView view);
//    public void setModel(UserDAO userModel);
//    public void setModel(ExpenseDAO expenseModel);
    public void setModel(IModel model);
    public void add(User user);
    public void add(Expense expense);
    public void getUserDetails(String username, String password);

}
