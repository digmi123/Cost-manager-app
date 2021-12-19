package view;

import model.user.User;
import viewmodel.IViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCostManagerView implements IView {

    private IViewModel vm;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CostManagerAppPage costManagerApp;

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
                    //if (connectedUserid not exist )

                    //TODO:Ask the teacher how can we implement the validation of username in the db and than show the specific tables of the...
                    //user in the view.

                    loginframe.dispose();
                    costManagerApp = new CostManagerAppPage();
                    //costManagerApp.setViewModel(vm);
                    //costManagerApp.setUserLoggedIn()//user);
                    costManagerApp.startAppPage();

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
        private JCheckBox houseCheckBox, selfCareCheckBox, carCheckBox;
        private JPanel newExpense, expenseTable, addExpenseWindow, expenseControlWindow, categoryPanel, appPanel, searchPanel;
        private JList categoryList;
        private JLabel categoryLabel;
        private JTextField sumField, currencyField, dateField, descField, priceField;
        private JButton addExpensebtn;
        private IViewModel vm;
        private User userLoggedIn;
        private static final String[] categoriesItems = {"House", "Self care", "Car", "dfc", "fgfg", "fgfg", "asdads", "erfdsf"};


        public CostManagerAppPage() {

            appframe = new JFrame("Cost manager application");
            appPanel = new JPanel();
            categoryLabel = new JLabel("Category List:");
            priceField = new JTextField("Price");
            dateField = new JTextField("Date");
            currencyField = new JTextField("Currency");
            descField = new JTextField("Description");
            expenseTable = new JPanel();
            addExpenseWindow = new JPanel();
            expenseControlWindow = new JPanel();
            searchPanel = new JPanel();
            categoryPanel = new JPanel();
            addExpensebtn = new JButton("Add expense");
//        houseCheckBox = new JCheckBox("House");
//        selfCareCheckBox = new JCheckBox("Self Care");
//        carCheckBox = new JCheckBox("Car");
        }

        public void fillCategoryListPanel() {
            categoryList = new JList(categoriesItems);
            categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            categoryList.setVisibleRowCount(4);


//        categoryPanel.setLayout(new GridLayout(4,1));
//        categoryPanel.setSize(new Dimension(300,300));
//        categoryPanel.add(categoryLabel);
//        categoryPanel.add(houseCheckBox);
//        categoryPanel.add(selfCareCheckBox);
//        categoryPanel.add(carCheckBox);
//        categoryPanel.setBackground(Color.yellow);
        }


        public void startAppPage() {

            fillCategoryListPanel();
            categoryPanel.add(new JScrollPane(categoryList));
            categoryPanel.setBackground(Color.yellow);
            addExpenseWindow.add(categoryPanel);
            //addExpenseWindow.add(new JScrollPane(categoryList));

            //addExpenseWindow.setBackground(Color.black);

            Object[][] rowData = {{"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                    {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"}};

            Object[] columnNames = {"Username", "Category", "Price", "Currency", "Description"};
            JTable table = new JTable(rowData, columnNames);
            table.setLayout(new FlowLayout());

            expenseControlWindow.add(priceField);
            expenseControlWindow.add(descField);
            expenseControlWindow.add(currencyField);
            expenseControlWindow.add(dateField);
            expenseControlWindow.add(addExpensebtn);

            expenseControlWindow.setLayout(new GridLayout(3, 2));

            //addExpenseWindow.add(expenseControlWindow, BorderLayout.WEST);
            addExpenseWindow.add(expenseControlWindow);


            expenseTable.add(new JScrollPane(table));
            appPanel.setLayout(new GridBagLayout());
            //GridBagConstraints constraints = new GridBagConstraints();
            //setMyConstraints(constraints,0,0,1,1);
            //appPanel.add(categoryPanel,constraints);
            //appPanel.add(categoryPanel);
            //setMyConstraints(constraints,0,1,2,1);
            //appPanel.add(expenseTable,constraints);
            //appPanel.add(expenseTable);
            appframe.add(expenseTable, BorderLayout.SOUTH);
            //setMyConstraints(constraints,1,0,1,1);
            //appPanel.add(addExpenseWindow,constraints);
            //appPanel.add(addExpenseWindow);
            appframe.add(addExpenseWindow, BorderLayout.NORTH);
            //appframe.add(appPanel);


            appframe.setSize(900, 700);
            appframe.setVisible(true);
        }


        private static void setMyConstraints(GridBagConstraints constraints, int gridx, int gridy, int anchor) {
            constraints.gridx = gridx;
            constraints.gridy = gridy;
            constraints.anchor = anchor;
        }

        private static void setMyConstraints(GridBagConstraints constraints, int gridx, int gridy, int gridWidth, int gridHeight) {
            constraints.gridx = gridx;
            constraints.gridy = gridy;
            constraints.gridwidth = gridWidth;
            constraints.gridheight = gridHeight;
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
}

