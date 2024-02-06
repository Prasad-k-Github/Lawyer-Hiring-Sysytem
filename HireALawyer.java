import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HireALawyer extends JFrame {
    private JLabel lblHeading;
    private JLabel lblFullName;
    private JLabel lblAddress;
    private JLabel lblphoneNo;
    private JLabel lblEmail;
    private JLabel lblCaseType;
    private JLabel lblLawyer;
    private JTextField txtFullname;
    private JTextField txtAddress;
    private JTextField txtPhoneNo;
    private JTextField txtEmail;
    private JComboBox cmbCasetype;
    private JComboBox cmbLayer;
    private JButton btnHire;
    private JButton btnBack;


    public HireALawyer(){

        Hireform();
        LawyerCmb
                ();
        setVisible(true);

    }

    public void Hireform() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        lblHeading = new JLabel("Hire a Lawyer");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/hire2.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(lblHeading, gbc);

        lblFullName = new JLabel("Full name");
        lblFullName.setForeground(new Color(0, 0, 0));
        lblFullName.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblFullName, gbc);

        txtFullname = new JTextField();
        txtFullname.setBackground(new Color(211, 211, 211));
        txtFullname.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtFullname.setCaretColor(new Color(51, 153, 255));
        txtFullname.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        pannel.add(txtFullname, gbc);

        lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(0, 0, 0));
        lblAddress.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblAddress, gbc);

        txtAddress = new JTextField();
        txtAddress.setBackground(new Color(211, 211, 211));
        txtAddress.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtAddress.setCaretColor(new Color(51, 153, 255));
        txtAddress.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pannel.add(txtAddress, gbc);

        lblphoneNo = new JLabel("Phone no");
        lblphoneNo.setForeground(new Color(0, 0, 0));
        lblphoneNo.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(lblphoneNo, gbc);

        txtPhoneNo = new JTextField();
        txtPhoneNo.setBackground(new Color(211, 211, 211));
        txtPhoneNo.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtPhoneNo.setCaretColor(new Color(51, 153, 255));
        txtPhoneNo.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 6;
        pannel.add(txtPhoneNo, gbc);

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

        lblCaseType = new JLabel("Case type");
        lblCaseType.setForeground(new Color(0, 0, 0));
        lblCaseType.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblCaseType, gbc);

        cmbCasetype = new JComboBox();
        cmbCasetype.addItem("--Select--");
        cmbCasetype.addItem("Criminal");
        cmbCasetype.addItem("Civil Case");
        cmbCasetype.addItem("Family Case");
        cmbCasetype.addItem("Business");
        gbc.gridx = 6;
        gbc.gridy = 4;
        pannel.add(cmbCasetype, gbc);

        lblLawyer = new JLabel("Select A Lawyer");
        lblLawyer.setForeground(new Color(0, 0, 0));
        lblLawyer.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(lblLawyer, gbc);

        cmbLayer = new JComboBox();
        cmbLayer.addItem("--Select--");
        gbc.gridx = 6;
        gbc.gridy = 6;
        pannel.add(cmbLayer, gbc);

        btnHire = new JButton("Hire");
        btnHire.setBackground(new Color(139, 0, 0));
        btnHire.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnHire.setForeground(new Color(255, 255, 255));
        btnHire.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnHire.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 0;
        gbc.gridy = 7;
        pannel.add(btnHire, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 6;
        gbc.gridy = 7;
        pannel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnHire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = txtFullname.getText().trim();
                String address = txtAddress.getText().trim();
                String phoneNo = txtPhoneNo.getText().trim();
                String email = txtEmail.getText().trim();
                String caseType = cmbCasetype.getSelectedItem().toString();
                String SelectLawyer = cmbLayer.getSelectedItem().toString();

                String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
                String phoneRegex = "^[0-9]{10}$";

                if (fullName.isEmpty() || address.isEmpty() || !email.matches(emailRegex) || !phoneNo.matches(phoneRegex) || caseType.equals("--Select--") || SelectLawyer.equals("--Select--")) {
                    if (fullName.isEmpty() || address.isEmpty() || caseType.equals("--Select--") || SelectLawyer.equals("--Select--")) {
                        JOptionPane.showMessageDialog(HireALawyer.this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (!email.matches(emailRegex)) {
                        JOptionPane.showMessageDialog(HireALawyer.this, "Invalid email format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (!phoneNo.matches(phoneRegex)) {
                        JOptionPane.showMessageDialog(HireALawyer.this, "Invalid phone number format (10 digits required).", "Validation Error", JOptionPane.ERROR_MESSAGE);
                    }
                    return;
                }

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
                    String insertQuery = "INSERT INTO client (fullName, address, phoneNo, email, caseType, SelectLawyer) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

                    preparedStatement.setString(1, fullName);
                    preparedStatement.setString(2, address);
                    preparedStatement.setString(3, phoneNo);
                    preparedStatement.setString(4, email);
                    preparedStatement.setString(5, caseType);
                    preparedStatement.setString(6, SelectLawyer);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected != 0) {
                        JOptionPane.showMessageDialog(HireALawyer.this, "Hiring successfull. Your lawyer will contacted you", "Success", JOptionPane.INFORMATION_MESSAGE);

                        Client client = new Client();
                        client.setVisible(true);

                        setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(HireALawyer.this, "Hiring Failed please Try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(HireALawyer.this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(HireALawyer.this, "Something went Wrong: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.setVisible(true);

                setVisible(false);
            }
        });
    }

    private void LawyerCmb() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
            String query = "SELECT SetUsername, FullName FROM lawyer";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<String> lawyerNames = new ArrayList<>();
            lawyerNames.add("--Select--");

            while (resultSet.next()) {
                String lawyerName = resultSet.getString("SetUsername");
                lawyerNames.add(lawyerName);
            }

            cmbLayer.setModel(new DefaultComboBoxModel<>(lawyerNames.toArray(new String[0])));


            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            HireALawyer hireALawyer = new HireALawyer();
            hireALawyer.setVisible(true);
        });
    }
}
