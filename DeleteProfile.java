import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProfile extends JFrame {

    private JLabel lblHeading;
    private JLabel lblUN;
    private JLabel lblPW;
    private JTextField txtUN;
    private JPasswordField txtPW;
    private JButton btnDelete;
    private JButton btnCansel;

    public DeleteProfile(){
        frmDeleteProfile();
    }
    public void frmDeleteProfile(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 350));
        setPreferredSize(new Dimension(600, 350));

        JPanel pannel = new JPanel();
        pannel.setBackground(new Color(173, 216, 230));
        pannel.setLayout(new GridBagLayout());
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        lblHeading = new JLabel("Delete Profile");
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 45));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading, gbc);

        lblUN = new JLabel("User name");
        lblUN.setForeground(new Color(0, 0, 0));
        lblUN.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblUN, gbc);

        txtUN = new JTextField();
        txtUN.setBackground(new Color(211, 211, 211));
        txtUN.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtUN.setCaretColor(new Color(51, 153, 255));
        txtUN.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pannel.add(txtUN, gbc);

        lblPW = new JLabel("Password");
        lblPW.setForeground(new Color(0, 0, 0));
        lblPW.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblPW, gbc);

        txtPW = new JPasswordField();
        txtPW.setBackground(new Color(211, 211, 211));
        txtPW.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtPW.setCaretColor(new Color(51, 153, 255));
        txtPW.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pannel.add(txtPW, gbc);

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(139, 0, 0));
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnDelete.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 0;
        gbc.gridy = 5;
        pannel.add(btnDelete, gbc);

        btnCansel = new JButton("Cancle");
        btnCansel.setBackground(new Color(139, 0, 0));
        btnCansel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnCansel.setForeground(new Color(255, 255, 255));
        btnCansel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnCansel.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 0;
        gbc.gridy = 6;
        pannel.add(btnCansel, gbc);

        pack();
        setLocationRelativeTo(null);

        btnCansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUN.getText();
                String password = new String(txtPW.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username and Password fields are required.");
                }
                else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username field are required.");
                }
                else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password field are required.");
                }
                else {
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your profile?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION)
                    {
                        Connection connection = null;
                        PreparedStatement preparedStatement = null;

                        try {

                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");

                            String deleteSQL = "DELETE FROM lawyer WHERE SetUsername = ? AND Password = ?";
                            preparedStatement = connection.prepareStatement(deleteSQL);
                            preparedStatement.setString(1, username);
                            preparedStatement.setString(2, password);

                            int rowsDeleted = preparedStatement.executeUpdate();

                            if (rowsDeleted > 0) {

                                HomePage homePage = new HomePage();
                                homePage.setVisible(true);

                                setVisible(false);

                                Lawyer lawyer = new Lawyer();
                                lawyer.setVisible(false);
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "No matching user profile found.");
                            }
                        }
                        catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error deleting user profile: " + ex.getMessage());
                        }
                        finally {

                            try {
                                // Close resources
                                if (preparedStatement != null) {
                                    preparedStatement.close();
                                }
                                if (connection != null) {
                                    connection.close();
                                }
                            }
                            catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    else if (choice == JOptionPane.NO_OPTION) {
                        setVisible(true);
                    }
                }
            }
        });

    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            DeleteProfile deleteProfile = new DeleteProfile();
            deleteProfile.setVisible(true);
        });
    }
}
