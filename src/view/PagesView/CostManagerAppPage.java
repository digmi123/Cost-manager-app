package view.PagesView;

import javax.swing.*;
import java.awt.*;

public class CostManagerAppPage {
    private JFrame appframe;
    private JPanel newExpense, expenseTable, addExpenseWindow, expenseControlWindow;
    private JMenu categories;
    private JLabel categoryLabel;
    private JTextField sumField, currencyField, dateField, descField;
    private JButton addExpensebtn;


    public CostManagerAppPage() {
        appframe = new JFrame("Cost manager application");
        newExpense = new JPanel();
        categoryLabel = new JLabel("Category :");
        sumField = new JTextField("Sum");
        currencyField = new JTextField("Currency");
        descField = new JTextField("Description");
        expenseTable = new JPanel();
        addExpenseWindow = new JPanel();
        expenseControlWindow = new JPanel();

        addExpensebtn = new JButton("Add expense");

    }

    public void startAppPage() {

        //newExpense.setLayout(new FlowLayout());
        //newExpense.setBounds(60,60,100,200);

        //define the panel to hold buttons
//            newExpense.add(categoryLabel);
//            newExpense.add(sumLabel);
//            newExpense.add(currencyLabel);
//            newExpense.add(dateLabel);
//            newExpense.add(textLabel);

//            categoryLabel.setBounds();
//            sumLabel.setBounds();
//            currencyLabel.setBounds();
//            dateLabel.setBounds();
//            textLabel.setBounds();

        //appframe.add(newExpense);
        //appframe.setLayout(null);
        //{"Adir","Car","300","ILS","Fuel"}

        Object[][] rowData = {{"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"},
                {"Adir", "Car", "300", "ILS", "Fuel"}, {"Adir", "Car", "300", "ILS", "Fuel"}};

        Object[] columnNames = {"Username", "Category", "Price", "Currency", "Description"};
        JTable table = new JTable(rowData, columnNames);
        table.setLayout(new FlowLayout());
        //table.setPreferredScrollableViewportSize(new Dimension(300,150));
        //table.setFillsViewportHeight(true);


        //JScrollPane scrollPane = new JScrollPane(table);

        expenseControlWindow.add(sumField);
        expenseControlWindow.add(currencyField);
        //expenseButtons.add(dateField);
        expenseControlWindow.add(descField);
        expenseControlWindow.add(addExpensebtn);
        //expenseControlWindow.setLayout(new GridLayout(3,2));
        expenseControlWindow.setLayout(new GridLayout(3, 2));
        expenseControlWindow.setBackground(Color.yellow);

        //addExpenseWindow.setSize(new Dimension(400,500));
        addExpenseWindow.add(expenseControlWindow, BorderLayout.EAST);
        addExpenseWindow.setBackground(Color.black);


        //expenseTable.add(new JScrollPane(table));
        appframe.add(expenseTable, BorderLayout.WEST);
        appframe.add(addExpenseWindow, BorderLayout.WEST);

        appframe.setSize(900, 700);
        appframe.setVisible(true);
    }
}
