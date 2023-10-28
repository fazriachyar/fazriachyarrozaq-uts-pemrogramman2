package com.fazriachyar.javaswing.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class FazriAchyarUserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FazriAchyarUserHome frame = new FazriAchyarUserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FazriAchyarUserHome() {

    }

    /**
     * Create the frame.
     */
    public FazriAchyarUserHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 90, 400, 600);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Apakah Kamu Yakin?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    FazriAchyarUserLogin obj = new FazriAchyarUserLogin();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
                FazriAchyarUserLogin obj = new FazriAchyarUserLogin();

                obj.setTitle("Student-Login");
                obj.setVisible(true);
            }
        });
        btnNewButton.setBounds(30, 10, 150, 30);
        contentPane.add(btnNewButton);

        JButton btnAboutButton = new JButton("About");
        btnAboutButton.setForeground(new Color(0, 0, 0));
        btnAboutButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnAboutButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnAboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FazriAchyarAbout obj = new FazriAchyarAbout();
                obj.setTitle("Login");
                obj.setVisible(true);
            }
        });
        btnAboutButton.setBounds(110, 50, 150, 30);
        contentPane.add(btnAboutButton);
        

        JButton button = new JButton("Ubah password\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FazriAchyarChangePassword bo = new FazriAchyarChangePassword(userSes);
                bo.setTitle("Ubah password");
                bo.setVisible(true);

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 17));
        button.setBounds(210, 10, 150, 30);
        contentPane.add(button);

        JLabel lblUserList = new JLabel("List Mahasiswa Terdaftar :");
        lblUserList.setForeground(Color.BLACK);
        lblUserList.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUserList.setBounds(30, 50, 273, 93);
        contentPane.add(lblUserList);

        MouseWheelListenerPanel m = new MouseWheelListenerPanel();
        m.setPreferredSize(new Dimension(100,4000));
        // Buat objek JTable
        JTable table = new JTable(10,3);
        JScrollPane scrollPane = new JScrollPane(m);
        add(scrollPane, BorderLayout.CENTER);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select user.id,user.nama,user.email from user;");


                    ResultSet rs = st.executeQuery();

                    // Buat model tabel
                    DefaultTableModel model = new DefaultTableModel();

                    // Set nama kolom tabel
                    model.addColumn("id");
                    model.addColumn("nama");
                    model.addColumn("email");
                    String[] header = {"id", "nama", "email"};
                    model.setColumnIdentifiers(header);

                    // Isi tabel dengan data dari database
                    while (rs.next()) {
                        Object[] rowData = new Object[3];
                        rowData[0] = rs.getString("id");
                        rowData[1] = rs.getString("nama");
                        rowData[2] = rs.getString("email");
                        model.addRow(rowData);
                    }

                    // Set model tabel ke JTable
                    table.setModel(model);

                    // Tambahkan JTable ke JFrame
                    table.setBounds(30, 120, 330, 180);
                    scrollPane.setBounds(330, 120, 30, 180);
                    contentPane.add(table);
                    contentPane.add(scrollPane);


                    // JScrollPane scrollPane = new JScrollPane(table);
                    // contentPane.add(scrollPane);
                } 
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } 
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(FazriAchyarUserHome.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}

class MouseWheelListenerPanel extends JPanel implements MouseWheelListener
{
    MouseWheelListenerPanel()
    {
        addMouseWheelListener(this);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if (e.isControlDown())
        {
            if (e.getWheelRotation() < 0)
            {
                System.out.println("mouse wheel Up");
            }
            else
            {
                System.out.println("mouse wheel Down");
            }
        }
        else
        {
            getParent().dispatchEvent(e);
        }

    }
}