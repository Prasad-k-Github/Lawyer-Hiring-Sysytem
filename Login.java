import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {

    private JLabel lblLogin;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblForgetten;
    private JLabel lblPw;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnSignup;
    private JButton btnReset;
    private JButton btnBack;
    private JCheckBox chkShowPassword;



    public Login() {
        LoginFrm();
    }

    private void LoginFrm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setBackground(new Color(173, 216, 230));
        pannel.setLayout(new GridBagLayout());
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        lblLogin = new JLabel("     Login");
        lblLogin.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblLogin.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 6;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(lblLogin, gbc);

        lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI Historic", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        pannel.add(lblUsername, gbc);

        txtUsername = new JTextField();
        txtUsername.setBackground(new Color(153, 204, 255));
        txtUsername.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtUsername.setCaretColor(new Color(51, 153, 255));
        txtUsername.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(txtUsername, gbc);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI Historic", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pannel.add(lblPassword, gbc);

        txtPassword = new JPasswordField();
        txtPassword.setBackground(new Color(153, 204, 255));
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtPassword.setCaretColor(new Color(51, 153, 255));
        txtPassword.setPreferredSize(new Dimension(250, 30));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(txtPassword, gbc);

        chkShowPassword = new JCheckBox("Show Password");
        chkShowPassword.setOpaque(false);
        chkShowPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkShowPassword.isSelected()) {
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('\u2022');
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pannel.add(chkShowPassword, gbc);

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 0, 255));
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnLogin.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        pannel.add(btnLogin, gbc);

        btnSignup = new JButton("Create Profile");
        btnSignup.setBackground(new Color(0, 204, 51));
        btnSignup.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnSignup.setForeground(new Color(255, 255, 255));
        btnSignup.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnSignup.setPreferredSize(new Dimension(200, 35));
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        pannel.add(btnSignup, gbc);

        lblForgetten = new JLabel("Forgotten Your");
        lblForgetten.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblForgetten.setForeground(new Color(51, 102, 255));
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(lblForgetten, gbc);

        lblPw = new JLabel("Password...?");
        lblPw.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblPw.setForeground(new Color(51, 102, 255));
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        pannel.add(lblPw, gbc);

        btnReset = new JButton("Click here..");
        btnReset.setBackground(new Color(255, 0, 0));
        btnReset.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnReset.setForeground(new Color(255, 255, 255));
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnReset.setPreferredSize(new Dimension(150, 35));
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(btnReset, gbc);

        btnBack = new JButton("Back to Home");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(150, 35));
        gbc.gridx = 5;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        pannel.add(btnBack, gbc);


        pack();
        setLocationRelativeTo(null);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                    return;
                }
                else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Username.");
                    return;
                }
                else if (password.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter Password.");
                    return;
                }

                try {

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");

                    String sql = "SELECT * FROM lawyer WHERE setUsername = ? AND password = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {

                        Lawyer lawyer = new Lawyer();
                        lawyer.setVisible(true);
                        setVisible(false);
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "Login failed. Please check your Username or Password.");
                    }

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
                }
            }
        });


        btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Signup signup = new Signup();
                signup.setVisible(true);

                setVisible(false);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);

                setVisible(false);
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResetPassword resetPassword = new ResetPassword();
                resetPassword.setVisible(true);

                setVisible(false);
            }
        });

    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            Login login = new Login();
            login.setVisible(true);
        });
    }
}

