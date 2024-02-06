import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewLawyers extends JFrame {

    private JTable lawyerTable;
    private JButton btnBack;
    private DefaultTableModel tableModel;

    public ViewLawyers(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        JLabel lblHeading = new JLabel("Our Lawyers");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/Lawyer12345.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading, gbc);

        JLabel lblHeading1 = new JLabel("");
        lblHeading1.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading1.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading1, gbc);

        String[] columnNames = {"ID", "Full Name", "Qualification", "Phone No", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        lawyerTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(lawyerTable);
        scrollPane.setPreferredSize(new Dimension(800, 300));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 12;
        pannel.add(scrollPane, gbc);

        tableModel.setRowCount(0);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lawyerhiringsystem", "root", "Prasad@1997");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SetUsername, FullName, Qualification, PhoneNo, Email FROM lawyer");

            while (resultSet.next()) {

                String SetUsername = resultSet.getString("SetUsername");
                String FullName = resultSet.getString("FullName");
                String Qualification = resultSet.getString("Qualification");
                int PhoneNo = resultSet.getInt("PhoneNo");
                String Email = resultSet.getString("Email");

                tableModel.addRow(new Object[]{SetUsername, FullName, Qualification, PhoneNo, Email});
            }

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.setVisible(true);

                setVisible(false);
            }
        });

    }
    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            ViewLawyers viewLawyers = new ViewLawyers();
            viewLawyers.setVisible(true);
        });
    }
}
