import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewClient extends JFrame {

    private JTable clientTable;
    private JButton btnBack;
    private DefaultTableModel tableModel;
    private JLabel lblun;
    private JTextField txtun;
    private JButton btnView;

    public ViewClient() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        JLabel lblHeading = new JLabel("Your Clients");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/client2.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(lblHeading, gbc);

        lblun = new JLabel("Enter Lawyer ID");
        lblun.setForeground(new Color(0, 0, 0));
        lblun.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblun, gbc);

        txtun = new JTextField();
        txtun.setBackground(new Color(211, 211, 211));
        txtun.setBorder(BorderFactory.createLineBorder(new Color(51, 102, 255)));
        txtun.setCaretColor(new Color(51, 153, 255));
        txtun.setPreferredSize(new Dimension(300, 30));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(txtun, gbc);

        btnView = new JButton("View");
        btnView.setBackground(new Color(139, 0, 0));
        btnView.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnView.setForeground(new Color(255, 255, 255));
        btnView.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnView.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(btnView, gbc);

        String[] columnNames = {"Full Name", "Address", "Phone No", "Email", "Case Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        clientTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(clientTable);
        scrollPane.setPreferredSize(new Dimension(800, 300));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 12;
        panel.add(scrollPane, gbc);

        tableModel.setRowCount(0);

        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lawyerId = txtun.getText().trim();

                if (lawyerId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a Lawyer ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    tableModel.setRowCount(0);

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
                        Statement statement = connection.createStatement();
                        String query = "SELECT FullName, Address, PhoneNo, Email, CaseType FROM client WHERE SelectLawyer = '" + lawyerId + "'";
                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.isBeforeFirst()) {
                            JOptionPane.showMessageDialog(null, "You don't have any clients yet.", "No Results", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else {
                            while (resultSet.next()) {
                                String fullName = resultSet.getString("FullName");
                                String address = resultSet.getString("Address");
                                String phoneNo = resultSet.getString("PhoneNo");
                                String email = resultSet.getString("Email");
                                String caseType = resultSet.getString("CaseType");

                                tableModel.addRow(new Object[]{fullName, address, phoneNo, email, caseType});
                            }
                        }

                        resultSet.close();
                        statement.close();
                        connection.close();
                    }
                    catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "" + ex.getMessage());
                    }
                }
            }
        });

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lawyer lawyer = new Lawyer();
                lawyer.setVisible(true);

                setVisible(false);
            }
        });
    }

    public static void main(String [] args) {
        SwingUtilities.invokeLater(() -> {
            ViewClient viewClient = new ViewClient();
            viewClient.setVisible(true);
        });
    }
}
