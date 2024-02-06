import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetPassword extends JFrame {

    private JLabel lblHeading;
    private JLabel lblUn;
    private JLabel lblCreatePW;
    private JLabel lblConfirmPW;
    private JTextField txtUn;
    private JPasswordField txtCreatePW;
    private JPasswordField txtConfirmPW;
    private JButton btnSave;
    private JButton btnBack;
    private JCheckBox chkShowCreatePW;
    private JCheckBox chkShowConfirmPW;

    public ResetPassword(){

        frmResetPW();
    }
    public void frmResetPW(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        lblHeading = new JLabel(" Password Reset");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading, gbc);

        lblUn = new JLabel("Enter your User ID");
        lblUn.setForeground(new Color(0, 0, 0));
        lblUn.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblUn, gbc);

        txtUn = new JTextField();
        txtUn.setBackground(new Color(211, 211, 211));
        txtUn.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtUn.setCaretColor(new Color(51, 153, 255));
        txtUn.setPreferredSize(new Dimension(500, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pannel.add(txtUn, gbc);

        lblCreatePW = new JLabel("Create New Password");
        lblCreatePW.setForeground(new Color(0, 0, 0));
        lblCreatePW.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblCreatePW, gbc);

        txtCreatePW = new JPasswordField();
        txtCreatePW.setBackground(new Color(211, 211, 211));
        txtCreatePW.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtCreatePW.setCaretColor(new Color(51, 153, 255));
        txtCreatePW.setPreferredSize(new Dimension(500, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pannel.add(txtCreatePW, gbc);

        chkShowCreatePW = new JCheckBox("Show Password");
        chkShowCreatePW.setOpaque(false);
        chkShowCreatePW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkShowCreatePW.isSelected()) {
                    txtCreatePW.setEchoChar((char) 0);
                } else {
                    txtCreatePW.setEchoChar('\u2022');
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        pannel.add(chkShowCreatePW, gbc);

        lblConfirmPW = new JLabel("Confirm Password");
        lblConfirmPW.setForeground(new Color(0, 0, 0));
        lblConfirmPW.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pannel.add(lblConfirmPW, gbc);

        txtConfirmPW = new JPasswordField();
        txtConfirmPW.setBackground(new Color(211, 211, 211));
        txtConfirmPW.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtConfirmPW.setCaretColor(new Color(51, 153, 255));
        txtConfirmPW.setPreferredSize(new Dimension(500, 30));
        gbc.gridx = 0;
        gbc.gridy = 7;
        pannel.add(txtConfirmPW, gbc);

        chkShowConfirmPW = new JCheckBox("Show Password");
        chkShowConfirmPW.setOpaque(false);
        chkShowConfirmPW.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chkShowConfirmPW.isSelected()) {
                    txtConfirmPW.setEchoChar((char) 0);
                } else {
                    txtConfirmPW.setEchoChar('\u2022');
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 8;
        pannel.add(chkShowConfirmPW, gbc);

        btnSave = new JButton("Save");
        btnSave.setBackground(new Color(139, 0, 0));
        btnSave.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnSave.setPreferredSize(new Dimension(500, 40));
        gbc.gridx = 0;
        gbc.gridy = 9;
        pannel.add(btnSave, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(500, 40));
        gbc.gridx = 0;
        gbc.gridy = 10;
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
                String userID = txtUn.getText().trim();
                char[] newPasswordChars = txtCreatePW.getPassword();
                char[] confirmPasswordChars = txtConfirmPW.getPassword();

                String newPassword = new String(newPasswordChars);
                String confirmPassword = new String(confirmPasswordChars);

                // Validate user ID, new password, and confirmation
                if (userID.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(ResetPassword.this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(ResetPassword.this, "Passwords do not match.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    // Database update logic
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
                        String updateQuery = "UPDATE lawyer SET Password = ? WHERE SetUsername = ?";
                        PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

                        preparedStatement.setString(1, newPassword);
                        preparedStatement.setString(2, userID);

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected != 0) {
                            JOptionPane.showMessageDialog(ResetPassword.this, "Password updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

                            // Navigate to the login screen
                            Login login = new Login();
                            login.setVisible(true);

                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(ResetPassword.this, "Failed to update password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(ResetPassword.this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            ResetPassword resetPassword = new ResetPassword();
            resetPassword.setVisible(true);
        });
    }
}
