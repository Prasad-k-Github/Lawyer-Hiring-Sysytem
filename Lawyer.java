import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lawyer extends JFrame {

    private JButton btnView;
    private JButton btnDelete;
    private JButton btnBack;
    private JButton btnHome;

    public Lawyer(){
        frmLawyer();

    }
    public void frmLawyer(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);


        JLabel lblHeading = new JLabel("Welcome Lawyer");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/lawyer12345.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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

        JLabel lblLawyer = new JLabel();
        lblLawyer.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblLawyer.setIcon(new ImageIcon(getClass().getResource("/view2.png")));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pannel.add(lblLawyer, gbc);

        btnView = new JButton("View Cases");
        btnView.setBackground(new Color(231, 23, 179));
        btnView.setForeground(new Color(255, 255, 255));
        btnView.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnView.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(btnView, gbc);

        JLabel lblDelete = new JLabel();
        lblDelete.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblDelete.setIcon(new ImageIcon(getClass().getResource("/Delete1.png")));
        gbc.gridx = 11;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pannel.add(lblDelete, gbc);

        btnDelete = new JButton("Delete Profile");
        btnDelete.setBackground(new Color(231, 23, 179));
        btnDelete.setForeground(new Color(255, 255, 255));
        btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnDelete.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 11;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(btnDelete, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        pannel.add(btnBack, gbc);

        btnHome = new JButton("Home");
        btnHome.setBackground(new Color(139, 0, 0));
        btnHome.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnHome.setForeground(new Color(255, 255, 255));
        btnHome.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnHome.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 11;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        pannel.add(btnHome, gbc);


        pack();
        setLocationRelativeTo(null);

        btnView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewClient viewClient = new ViewClient();
                viewClient.setVisible(true);

                setVisible(false);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteProfile deleteProfile = new DeleteProfile();
                deleteProfile.setVisible(true);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);

                setVisible(false);
            }
        });

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);

                setVisible(false);
            }
        });
    }

    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            Lawyer lawyer = new Lawyer();
            lawyer.setVisible(true);
        });
    }
}
