import model.IModel;
import model.SimpleCostManagerModel;
import model.expense.ExpenseDAOImplementation;
import model.user.UserDAOImplementation;
import view.IView;
//import view.PagesView.LoginPage;
//import view.PagesView.RegisterPage;
import view.SimpleCostManagerView;
import viewmodel.IViewModel;
import viewmodel.SimpleViewModel;

import javax.swing.*;

public class Main {
    public static void main(String args[]){

        UserDAOImplementation userModel = new UserDAOImplementation();
        ExpenseDAOImplementation expenseModel = new ExpenseDAOImplementation();
        IModel model = new SimpleCostManagerModel();
        IViewModel vm = new SimpleViewModel();
        IView view = new SimpleCostManagerView();


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                view.initLoginPage();
                view.startLoginPage();
            }
        });

        model.setViewModel(vm);
        vm.setModel(userModel);
        vm.setModel(expenseModel);
        vm.setView(view);
        view.setViewModel(vm);
    }
}
