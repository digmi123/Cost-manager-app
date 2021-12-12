package view.PagesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private JFrame loginframe;
    private JTextField usernameField, passwordField;
    private JLabel usernameLabel, passwordLabel,loginPageHeader;
    private JButton btnLogin,btnRegister;


    public LoginPage() {

        loginframe = new JFrame("Login");
        usernameLabel = new JLabel("username :");
        passwordLabel = new JLabel("password :");
        usernameField = new JTextField();
        passwordField = new JTextField();
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");
        loginPageHeader = new JLabel("Login Page");
    }

    public void startLoginPage() {

        //Set the bounds of components
        loginPageHeader.setBounds(220,40,200,35);
        usernameLabel.setBounds(100, 100, 75, 30);
        passwordLabel.setBounds(100, 150, 75, 30);
        usernameField.setBounds(180, 100, 250, 30);
        passwordField.setBounds(180, 150, 250, 30);
        btnLogin.setBounds(170, 220, 100, 25);
        btnRegister.setBounds(330,220,100,25);

        //Add the components into the frame
        loginframe.add(loginPageHeader);
        loginframe.add(usernameLabel);
        loginframe.add(passwordLabel);
        loginframe.add(usernameField);
        loginframe.add(passwordField);
        loginframe.add(btnLogin);
        loginframe.add(btnRegister);

        //Set the components properties
        loginPageHeader.setFont(new Font("MV Boli", Font.PLAIN,30));

        //Frame properties
        loginframe.setLayout(null);
        loginframe.setSize(600, 400);
        loginframe.setVisible(true);

        ActionListener RegisterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginframe.dispose();
                RegisterPage registerPage = new RegisterPage();
                registerPage.startRegisterPage();

            }
        };

        btnRegister.addActionListener(RegisterListener);
    }
}

