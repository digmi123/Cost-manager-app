package viewmodel;

import model.IModel;
import model.expense.Expense;
import model.expense.ExpenseDAO;
import model.user.User;
import model.user.UserDAO;
import view.IView;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleViewModel implements IViewModel{

    private UserDAO userModel;
    private ExpenseDAO expenseModel;
    private IView view;
    private ExecutorService service;
    public int connectedUserId;

    public SimpleViewModel() {
        this.service = Executors.newFixedThreadPool(3);
    }


    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void setModel(UserDAO userModel) {
        this.userModel = userModel;
    }

    @Override
    public void setModel(ExpenseDAO expenseModel) {
        this.expenseModel = expenseModel;
    }


    @Override
    public void add(User user) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    userModel.addUser(user);

                } catch(Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // pop up window with msg on VIEW
                        }
                    });
                }
            }
        });
    }

    @Override
    public void add(Expense expense) {
        //TODO: send the expense to the model and send it to the view also in order to update the row in the table
    }

    @Override
    public void getUserDetails(String username, String password) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    connectedUserId = userModel.getUserId(username,password);
                    if(connectedUserId == 0){
                        //Dialog box with error no user exist;
                    }
                    // 1.get the username in order to present it in the header of the app.
                    // 2.get the user id in order to query for the Expense table of specific user.
                    // 3.update in the view new table with the data that we got in line 2.

                } catch(Exception e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            // pop up window with msg on VIEW
                        }
                    });
                }
            }
        });
    }

}
