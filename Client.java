import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {
    private JButton btnView;
    private JButton btnHire;
    private JButton btnBack;
    private JButton btnHome;

    public Client(){
        frmClient();

    }
    public void frmClient(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);


        JLabel lblHeading = new JLabel("Welcome Client");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/client2.png")));
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

        JLabel lblView = new JLabel();
        lblView.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblView.setIcon(new ImageIcon(getClass().getResource("/view2.png")));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pannel.add(lblView, gbc);

        btnView = new JButton("View Lawyers");
        btnView.setBackground(new Color(231, 23, 179));
        btnView.setForeground(new Color(255, 255, 255));
        btnView.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnView.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(btnView, gbc);

        JLabel lblHire = new JLabel();
        lblHire.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHire.setIcon(new ImageIcon(getClass().getResource("/hire2.png")));
        gbc.gridx = 11;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        pannel.add(lblHire, gbc);

        btnHire = new JButton("Hire a Lawyer");
        btnHire.setBackground(new Color(231, 23, 179));
        btnHire.setForeground(new Color(255, 255, 255));
        btnHire.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnHire.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 11;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pannel.add(btnHire, gbc);

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
                ViewLawyers viewLawyers = new ViewLawyers();
                viewLawyers.setVisible(true);

                setVisible(false);
            }
        });

        btnHire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HireALawyer hireALawyer = new HireALawyer();
                hireALawyer.setVisible(true);

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

            Client client = new Client();
            client.setVisible(true);
        });
    }
}
