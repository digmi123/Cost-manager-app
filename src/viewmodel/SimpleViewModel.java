package viewmodel;

import model.IModel;
import model.Expense;
import model.User;
import view.IView;
import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleViewModel implements IViewModel{

//    private UserDAO userModel;
//    private ExpenseDAO expenseModel;
    private IModel model;
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
    public void setModel(IModel model) {
        this.model = model;
    }

//    @Override
//    public void setModel(UserDAO userModel) {
//        this.userModel = userModel;
//    }
//
//    @Override
//    public void setModel(ExpenseDAO expenseModel) {
//        this.expenseModel = expenseModel;
//    }


    @Override
    public void add(User user) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    model.addUser(user);

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
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    model.addExpense(expense);
                    List<Expense> expensesList = model.getExpensesByUserId(connectedUserId);

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            view.showExpensesTable(expensesList);
                        }
                    });

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
    public void getUserDetails(String username, String password) {
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Hi");
                    connectedUserId = model.getUserId(username,password);

                    if(connectedUserId == 0){
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                view.showErrorBox("There no such user with this username or password please try again");
                            }
                        });
                    }
                    else
                    {
                        view.setConnectionStatus(true);
                        view.setConnectedUserId(connectedUserId);

                        List<Expense> expensesList = model.getExpensesByUserId(connectedUserId);
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                view.showExpensesTable(expensesList);
                            }
                        });
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
