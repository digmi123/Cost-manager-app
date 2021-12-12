package view.PagesView;

import javax.swing.*;
import java.awt.*;

public class RegisterPage {
    private JFrame registerFrame;
    private JTextField usernameField, passwordField;
    private JLabel usernameLabel, passwordLabel,registerPageHeader;
    private JButton btnLogin,btnRegister;

    public RegisterPage() {
        registerFrame = new JFrame("Register");
        usernameLabel = new JLabel("username :");
        passwordLabel = new JLabel("password :");
        usernameField = new JTextField();
        passwordField = new JTextField();
        btnRegister = new JButton("Register");
        registerPageHeader = new JLabel("Register Page");
    }

    public void startRegisterPage() {

        //Set the bounds of components
        registerPageHeader.setBounds(205,40,200,35);
        usernameLabel.setBounds(100, 100, 75, 30);
        passwordLabel.setBounds(100, 150, 75, 30);
        usernameField.setBounds(180, 100, 250, 30);
        passwordField.setBounds(180, 150, 250, 30);
        btnRegister.setBounds(250,220,100,25);

        //Add the components into the frame

        registerFrame.add(registerPageHeader);
        registerFrame.add(usernameLabel);
        registerFrame.add(passwordLabel);
        registerFrame.add(usernameField);
        registerFrame.add(passwordField);
        registerFrame.add(btnRegister);

        //Set the components properties
        registerPageHeader.setFont(new Font("MV Boli", Font.PLAIN,30));

        //Frame properties
        registerFrame.setLayout(null);
        registerFrame.setSize(600, 400);
        registerFrame.setVisible(true);

    }

//    ActionListener DelListener = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    };


//    ActionListener DelListener = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if(resultScreen.getText().length() > 0){
//                resultScreen.setText(resultScreen.getText().substring(0,resultScreen.getText().length()-1));
//            }
//        }
//    };
}
