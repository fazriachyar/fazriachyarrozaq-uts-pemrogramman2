package com.fazriachyar.javaswing.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FazriAchyarUserRegister extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FazriAchyarUserLogin frame = new FazriAchyarUserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FazriAchyarUserRegister() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 90, 400, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Daftar");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(125, 30, 273, 93);
        contentPane.add(lblNewLabel);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(125, 125, 150, 52);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        textField.setBounds(125, 170, 150, 30);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBackground(Color.CYAN);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmail.setBounds(125, 200, 150, 52);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        emailField.setBounds(125, 245, 150, 30);
        contentPane.add(emailField);
        emailField.setColumns(10);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(125, 270, 150, 52); 
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        passwordField.setBounds(125, 315, 150, 30);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Daftar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(125, 360, 150, 52);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select nama from user where nama=?;");

                    st.setString(1, userName);
                    ResultSet rs = st.executeQuery();
                    if (!rs.next()) {
                        PreparedStatement std = (PreparedStatement) connection
                            .prepareStatement("INSERT INTO `user` (`nama`, `email`, `password`, `created_at`, `updated_at`) VALUES (?, ?, ?, now(), null);\r\n");

                        std.setString(1, userName);
                        std.setString(2, email);
                        std.setString(3, password);
                        int rsd = std.executeUpdate();

                        if (rsd == 1){
                            dispose();
                            FazriAchyarUserLogin obj = new FazriAchyarUserLogin();
                            obj.setTitle("Login");
                            obj.setVisible(true);
                            JOptionPane.showMessageDialog(btnNewButton, "Anda Berhasil Daftar");
                        }
                        else {
                            JOptionPane.showMessageDialog(btnNewButton, "Gagal Mendaftar");
                        }
                    } 
                    else {
                        JOptionPane.showMessageDialog(btnNewButton, "Username Sudah Terdaftar!");
                    }
                } 
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(FazriAchyarUserLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 100, 50);
        contentPane.add(label);
    }
}