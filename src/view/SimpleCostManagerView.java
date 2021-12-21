package view;

import model.expense.Expense;
import model.user.User;
import viewmodel.IViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class SimpleCostManagerView implements IView {

    private IViewModel vm;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CostManagerAppPage costManagerApp;
    public boolean isConnected = false;
    public int connectedUserId;

    public class LoginPage {

        private JFrame loginframe;
        private JTextField usernameField, passwordField;
        private JLabel usernameLabel, passwordLabel, loginPageHeader;
        private JButton btnLogin, btnRegister;
        private User userLoggedIn;

        public void initLoginPage() {

            loginframe = new JFrame("Login");
            usernameLabel = new JLabel("username :");
            passwordLabel = new JLabel("password :");
            usernameField = new JTextField();
            passwordField = new JTextField();

            btnLogin = new JButton("Login");
            ActionListener LoginListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //TODO:Check for valid username and password and just than go to the app with specific user details.

                    vm.getUserDetails(usernameField.getText(), passwordField.getText());
                    System.out.println("Got the details and going to pass it to view model");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    if (isConnected) {
                        loginframe.dispose();
                        costManagerApp = new CostManagerAppPage();
                        costManagerApp.startAppPage();
                    }

                }
            };
            btnLogin.addActionListener(LoginListener);
            btnRegister = new JButton("Register");
            ActionListener RegisterListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginframe.dispose();
                    registerPage = new RegisterPage();
                    //registerPage.setViewModel(vm);
                    registerPage.startRegisterPage();

                }
            };
            btnRegister.addActionListener(RegisterListener);
            loginPageHeader = new JLabel("Login Page");
        }

        public void startLoginPage() {

            //Set the bounds of components
            loginPageHeader.setBounds(220, 40, 200, 35);
            usernameLabel.setBounds(100, 100, 75, 30);
            passwordLabel.setBounds(100, 150, 75, 30);
            usernameField.setBounds(180, 100, 250, 30);
            passwordField.setBounds(180, 150, 250, 30);
            btnLogin.setBounds(170, 220, 100, 25);
            btnRegister.setBounds(330, 220, 100, 25);

            //Add the components into the frame
            loginframe.add(loginPageHeader);
            loginframe.add(usernameLabel);
            loginframe.add(passwordLabel);
            loginframe.add(usernameField);
            loginframe.add(passwordField);
            loginframe.add(btnLogin);
            loginframe.add(btnRegister);

            //Set the components properties
            loginPageHeader.setFont(new Font("MV Boli", Font.PLAIN, 30));

            //Frame properties
            loginframe.setLayout(null);
            loginframe.setSize(600, 400);
            loginframe.setVisible(true);

            // Set action listeners to the inner class Login page

        }
    }

    public class RegisterPage {
        private JFrame registerFrame;
        private JTextField usernameField, passwordField;
        private JLabel usernameLabel, passwordLabel, registerPageHeader;
        private JButton btnLogin, btnRegister;
        private IViewModel vm;


        public RegisterPage() {
            registerFrame = new JFrame("Register");
            usernameLabel = new JLabel("username :");
            passwordLabel = new JLabel("password :");
            usernameField = new JTextField();
            passwordField = new JTextField();
            btnRegister = new JButton("Submit");
            btnLogin = new JButton("Login page");
            registerPageHeader = new JLabel("Register Page");
        }

        public void startRegisterPage() {

            //Set the bounds of components
            registerPageHeader.setBounds(205, 40, 200, 35);
            usernameLabel.setBounds(100, 100, 75, 30);
            passwordLabel.setBounds(100, 150, 75, 30);
            usernameField.setBounds(180, 100, 250, 30);
            passwordField.setBounds(180, 150, 250, 30);
            //btnRegister.setBounds(250, 220, 100, 25);
            btnLogin.setBounds(170, 220, 100, 25);
            btnRegister.setBounds(330, 220, 100, 25);

            //Add the components into the frame

            registerFrame.add(registerPageHeader);
            registerFrame.add(usernameLabel);
            registerFrame.add(passwordLabel);
            registerFrame.add(usernameField);
            registerFrame.add(passwordField);
            registerFrame.add(btnRegister);
            registerFrame.add(btnLogin);

            //Set the components properties
            registerPageHeader.setFont(new Font("MV Boli", Font.PLAIN, 30));

            //Frame properties
            registerFrame.setLayout(null);
            registerFrame.setSize(600, 400);
            registerFrame.setVisible(true);

            ActionListener RegisterListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    User user = new User(usernameField.getText(), passwordField.getText());
                    //System.out.println(user.getUsername());
                    vm.add(user);
                }
            };

            ActionListener LoginListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerFrame.dispose();
                    //view.PagesView.LoginPage loginPage = new view.PagesView.LoginPage();
                    //loginPage.setViewModel(vm);
                    //loginPage.startLoginPage();
                    loginPage.startLoginPage();
                }
            };

            btnRegister.addActionListener(RegisterListener);
            btnLogin.addActionListener(LoginListener);
        }
    }

    public class CostManagerAppPage {
        private JFrame appframe;
        private JPanel newExpense, expenseTablePanel, addExpenseWindow, expenseControlWindow, categoryPanel, appPanel, searchPanel, newCategoryPanel;
        private JList categoryList;
        private JLabel categoryLabel;
        private JTextField newCategoryTextField, currencyField, dateField, descField, priceField;
        private JButton addExpensebtn, addNewCategory;
        private JTable expensesTable;
        private User userLoggedIn;
        private DefaultTableModel expenseTableModel;
        private DefaultListModel listModel;
        private static final String[] defaultCategoriesList = {"House", "Self care", "Car", "dfc", "fgfg", "fgfg", "asdads", "erfdsf"};


        public CostManagerAppPage() {

            appframe = new JFrame("Cost manager application");
            appPanel = new JPanel();
            categoryLabel = new JLabel("Category List:");
            priceField = new JTextField("Price");
            dateField = new JTextField("YYYY-MM-DD");
            currencyField = new JTextField("Currency");
            descField = new JTextField("Description");
            expenseTablePanel = new JPanel();
            addExpenseWindow = new JPanel();
            expenseControlWindow = new JPanel();
            searchPanel = new JPanel();
            categoryPanel = new JPanel();
            newCategoryPanel = new JPanel();
            addExpensebtn = new JButton("Add expense");
            expensesTable = new JTable();
            expenseTableModel = new DefaultTableModel();
            newCategoryTextField = new JTextField("Add new category");
            addNewCategory = new JButton("Add category");

            ActionListener addExpense = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Expense expense = new Expense(connectedUserId, categoryList.getSelectedValue().toString(),
                            Float.parseFloat(priceField.getText()) , currencyField.getText(), dateField.getText(), descField.getText());
                    vm.add(expense);
                }
            };

            ActionListener addNewCategoryListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listModel.addElement(newCategoryTextField.getText());
                    System.out.println("New category has been added to the list");
                }
            };

            addNewCategory.addActionListener(addNewCategoryListener);
            addExpensebtn.addActionListener(addExpense);

            newCategoryPanel.setLayout(new BoxLayout(newCategoryPanel,BoxLayout.Y_AXIS));

            expensesTable.setModel(expenseTableModel);
            expenseTableModel.addColumn("Category");
            expenseTableModel.addColumn("Price");
            expenseTableModel.addColumn("Currency");
            expenseTableModel.addColumn("Date");
            expenseTableModel.addColumn("Description");
        }

        public void fillCategoryListPanel() {
            listModel = new DefaultListModel();
            for (String s : defaultCategoriesList){
                listModel.addElement(s);
            }
            categoryList = new JList(listModel);
            categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            categoryList.setVisibleRowCount(4);
        }


        public void startAppPage() {

            // creating list object with the categories that we mentioned in category list variable.
            fillCategoryListPanel();
            //adding the scroll list of categories into its own panel.
            categoryPanel.add(new JScrollPane(categoryList));
            //add the panel that we have created into the bigger panel of addExpense.
            addExpenseWindow.add(newCategoryPanel);
            addExpenseWindow.add(categoryPanel);

            newCategoryPanel.add(newCategoryTextField);
            newCategoryPanel.add(addNewCategory);

            expensesTable.setLayout(new FlowLayout());

            //adding the textFields and the add button to its own panel called expenseControlWindow.
            expenseControlWindow.add(priceField);
            expenseControlWindow.add(descField);
            expenseControlWindow.add(currencyField);
            expenseControlWindow.add(dateField);
            expenseControlWindow.add(addExpensebtn);

            // setting the view settings of the panel expenseControlWindow.
            expenseControlWindow.setLayout(new GridLayout(3, 2));

            //add the panel that we have created into the bigger panel of addExpense.
            addExpenseWindow.add(expenseControlWindow);
            expenseTablePanel.add(new JScrollPane(expensesTable));
            appPanel.setLayout(new GridBagLayout());
            appframe.add(expenseTablePanel, BorderLayout.SOUTH);

            appframe.add(addExpenseWindow, BorderLayout.NORTH);

            //set the settings of the App frame.
            appframe.setSize(900, 600);
            appframe.setVisible(true);
        }

        public void fillExpensesTable(List<Expense> expensesData)
        {
            expenseTableModel.setRowCount(0);
            for(Expense expense : expensesData)
            {
                expenseTableModel.addRow(new Object[] {
                        expense.getCategory(),
                        expense.getPrice(),
                        expense.getCurrency(),
                        expense.getDate(),
                        expense.getDescription()
                });
            }

        }

    }

    public SimpleCostManagerView() {}

    @Override
    public void setViewModel(IViewModel viewModel) {
        this.vm = viewModel;
    }

    @Override
    public void initLoginPage() {
        loginPage = new LoginPage();
        loginPage.initLoginPage();
    }

    @Override
    public void startLoginPage() {
        loginPage.startLoginPage();
    }

    @Override
    public void showExpensesTable(List<Expense> expensesList) {

        costManagerApp.fillExpensesTable(expensesList);
    }

    @Override
    public void setConnectionStatus(boolean isConnected) {
        this.isConnected = isConnected;
    }

    @Override
    public void setConnectedUserId(int connectedUserId) {
        this.connectedUserId = connectedUserId;
    }

    @Override
    public void showErrorBox(String error) {
        JOptionPane.showMessageDialog(null,error);
    }


}

