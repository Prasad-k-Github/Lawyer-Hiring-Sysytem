import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup extends JFrame {

    //Lebals
    private JLabel lblHeading;
    private JLabel lblFullname;
    private JLabel lblDOB;
    private JLabel lblNIC;
    private JLabel lblAddress;
    private JLabel lblPhoneNo;
    private JLabel lblEmail;
    private JLabel lblGender;
    private JLabel lblQulification;
    private JLabel lblSetUN;
    private JLabel lblPassword;

    //Text Fields
    private JTextField txtFullname;
    private JTextField txtDOB;
    private JTextField txtNIC;
    private JTextField txtAddress;
    private JTextField txtPhoneNo;
    private JTextField txtEmail;
    private JRadioButton RBMale;
    private JRadioButton RBFemale;
    private JTextField txtQulification;
    private JTextField txtSetUN;
    private JPasswordField txtPassword;
    //Buttons
    private JButton btnSave;
    private JButton btnBack;

    public Signup(){
        SignupForm();

    }
    public void SignupForm(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);


        lblHeading = new JLabel("     Registration Form");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading, gbc);

        lblFullname = new JLabel("Full name");
        lblFullname.setForeground(new Color(0, 0, 0));
        lblFullname.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblFullname, gbc);

        txtFullname = new JTextField();
        txtFullname.setBackground(new Color(211, 211, 211));
        txtFullname.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtFullname.setCaretColor(new Color(51, 153, 255));
        txtFullname.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pannel.add(txtFullname, gbc);

        lblDOB = new JLabel("Date of birth");
        lblDOB.setForeground(new Color(0, 0, 0));
        lblDOB.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblDOB, gbc);

        txtDOB = new JTextField();
        txtDOB.setBackground(new Color(211, 211, 211));
        txtDOB.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtDOB.setCaretColor(new Color(51, 153, 255));
        txtDOB.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pannel.add(txtDOB, gbc);

        lblNIC = new JLabel("NIC no");
        lblNIC.setForeground(new Color(0, 0, 0));
        lblNIC.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(lblNIC, gbc);

        txtNIC = new JTextField();
        txtNIC.setBackground(new Color(211, 211, 211));
        txtNIC.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtNIC.setCaretColor(new Color(51, 153, 255));
        txtNIC.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 6;
        pannel.add(txtNIC, gbc);

        lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(0, 0, 0));
        lblAddress.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        pannel.add(lblAddress, gbc);

        txtAddress = new JTextField();
        txtAddress.setBackground(new Color(211, 211, 211));
        txtAddress.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtAddress.setCaretColor(new Color(51, 153, 255));
        txtAddress.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 8;
        pannel.add(txtAddress, gbc);

        lblPhoneNo = new JLabel("Phone no");
        lblPhoneNo.setForeground(new Color(0, 0, 0));
        lblPhoneNo.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        pannel.add(lblPhoneNo, gbc);

        txtPhoneNo = new JTextField();
        txtPhoneNo.setBackground(new Color(211, 211, 211));
        txtPhoneNo.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtPhoneNo.setCaretColor(new Color(51, 153, 255));
        txtPhoneNo.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 10;
        pannel.add(txtPhoneNo, gbc);

        btnSave = new JButton("Save");
        btnSave.setBackground(new Color(139, 0, 0));
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnSave.setPreferredSize(new Dimension(300, 40));
        gbc.gridx = 0;
        gbc.gridy = 12;
        pannel.add(btnSave, gbc);

        lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(0, 0, 0));
        lblEmail.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblEmail, gbc);

        txtEmail = new JTextField();
        txtEmail.setBackground(new Color(211, 211, 211));
        txtEmail.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtEmail.setCaretColor(new Color(51, 153, 255));
        txtEmail.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 6;
        gbc.gridy = 2;
        pannel.add(txtEmail, gbc);

        lblGender = new JLabel("Gender");
        lblGender.setForeground(new Color(0, 0, 0));
        lblGender.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblGender, gbc);

        RBMale = new JRadioButton("Male");
        RBMale.setForeground(new Color(231, 23, 179));
        RBMale.setOpaque(false);
        RBMale.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 6;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pannel.add(RBMale, gbc);

        RBFemale = new JRadioButton("Female");
        RBFemale.setForeground(new Color(231, 23, 179));
        RBFemale.setOpaque(false);
        RBFemale.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(RBFemale, gbc);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(RBMale); // Add both radio buttons to the ButtonGroup
        genderGroup.add(RBFemale);

        lblQulification = new JLabel("Qulification");
        lblQulification.setForeground(new Color(0, 0, 0));
        lblQulification.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pannel.add(lblQulification, gbc);

        txtQulification = new JTextField();
        txtQulification.setBackground(new Color(211, 211, 211));
        txtQulification.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtQulification.setCaretColor(new Color(51, 153, 255));
        txtQulification.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 6;
        gbc.gridy = 7;
        pannel.add(txtQulification, gbc);

        lblSetUN = new JLabel("Set User name");
        lblSetUN.setForeground(new Color(0, 0, 0));
        lblSetUN.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        pannel.add(lblSetUN, gbc);

        txtSetUN = new JTextField();
        txtSetUN.setBackground(new Color(211, 211, 211));
        txtSetUN.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtSetUN.setCaretColor(new Color(51, 153, 255));
        txtSetUN.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 6;
        gbc.gridy = 9;
        pannel.add(txtSetUN, gbc);

        lblPassword = new JLabel("Set Password");
        lblPassword.setForeground(new Color(0, 0, 0));
        lblPassword.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        pannel.add(lblPassword, gbc);

        txtPassword = new JPasswordField();
        txtPassword.setBackground(new Color(211, 211, 211));
        txtPassword.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtPassword.setCaretColor(new Color(51, 153, 255));
        txtPassword.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 6;
        gbc.gridy = 11;
        pannel.add(txtPassword, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(300, 40)); // Set button size here
        gbc.gridx = 6;
        gbc.gridy = 12;
        pannel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);

                setVisible(false);
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fullname = txtFullname.getText();
                String dob = txtDOB.getText();
                String nic = txtNIC.getText();
                String address = txtAddress.getText();
                String phoneNo = txtPhoneNo.getText();
                String email = txtEmail.getText();
                String gender = RBMale.isSelected() ? "Male" : "Female";
                String qualification = txtQulification.getText();
                String setUsername = txtSetUN.getText();
                String password = txtPassword.getText();


                if (fullname.isEmpty() || dob.isEmpty() || nic.isEmpty() || address.isEmpty() || phoneNo.isEmpty()
                        || email.isEmpty() || qualification.isEmpty() || setUsername.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
                    return; // Exit the method if any field is empty
                }

                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
                    return;
                }

                if (!isValidPhoneNumber(phoneNo)) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid phone number.");
                    return;
                }

                try {

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
                    System.out.println("connected");

                    StringBuilder sql = new StringBuilder();
                    sql.append("INSERT INTO lawyer (fullname, dob, nic, address, phoneNo, email, gender, qualification, setUsername, password) ")
                            .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                    PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());

                    preparedStatement.setString(1, fullname);
                    preparedStatement.setString(2, dob);
                    preparedStatement.setString(3, nic);
                    preparedStatement.setString(4, address);
                    preparedStatement.setString(5, phoneNo);
                    preparedStatement.setString(6, email);
                    preparedStatement.setString(7, gender);
                    preparedStatement.setString(8, qualification);
                    preparedStatement.setString(9, setUsername);
                    preparedStatement.setString(10, password);

                    int rowsInserted = preparedStatement.executeUpdate();

                    if (rowsInserted != 0) {

                        Lawyer lawyer = new Lawyer();
                        lawyer.setVisible(true);
                        setVisible(false);
                        JOptionPane.showMessageDialog(null, "Registration successfully!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Data could not be saved.");
                    }

                    preparedStatement.close();
                    connection.close();
                }

                catch (SQLException ex) {
                    ex.printStackTrace();
                    String errorMessage = "Database error  " + ex.getMessage();
                    JOptionPane.showMessageDialog(null, errorMessage, "Database Error", JOptionPane.ERROR_MESSAGE);
                }

                catch (Exception ex) {
                    ex.printStackTrace();
                    String errorMessage = "This code has error " + ex.getMessage();
                    JOptionPane.showMessageDialog(null, errorMessage, "This code", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }

    private boolean isValidPhoneNumber(String phoneNo) {
        return phoneNo.matches("\\d{10}");
    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            Signup signup = new Signup();
            signup.setVisible(true);
        });
    }



}
