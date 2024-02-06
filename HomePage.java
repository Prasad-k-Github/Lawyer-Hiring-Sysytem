import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JButton btnClient;
    private JButton btnFeedback;
    private JButton btnLawyer;
    private JButton btnAboutUs;

    public HomePage() {

        Background();
    }

    private void Background() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        getContentPane().add(pannel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 10, 5, 10);

        JPanel headingPanel = new JPanel(new BorderLayout());

        JLabel lblHeading = new JLabel("LAWYER HIRING");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading.setForeground(new Color(0, 0, 204));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 12;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(lblHeading, constraints);

        JLabel lblHeading1 = new JLabel("SYSTEM");
        lblHeading1.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeading1.setForeground(new Color(0, 0, 204));
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 12;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading1, constraints);

        JLabel lblLawyer = new JLabel();
        lblLawyer.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblLawyer.setIcon(new ImageIcon(getClass().getResource("/Lawyer12345.png")));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        pannel.add(lblLawyer, constraints);

        btnLawyer = new JButton("Lawyer");
        btnLawyer.setBackground(new Color(231, 23, 179));
        btnLawyer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnLawyer.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        pannel.add(btnLawyer, constraints);

        JLabel lblClient = new JLabel();
        lblClient.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblClient.setIcon(new ImageIcon(getClass().getResource("/client2.png")));
        constraints.gridx = 11;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        pannel.add(lblClient, constraints);

        btnClient = new JButton("Client");
        btnClient.setBackground(new Color(231, 23, 179));
        btnClient.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnClient.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 11;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        pannel.add(btnClient, constraints);

        JLabel lblAboutUs = new JLabel();
        lblAboutUs.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblAboutUs.setIcon(new ImageIcon(getClass().getResource("/about us.png")));
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        pannel.add(lblAboutUs, constraints);

        btnAboutUs = new JButton("About Us");
        btnAboutUs.setBackground(new Color(231, 23, 179));
        btnAboutUs.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnAboutUs.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        pannel.add(btnAboutUs, constraints);

        JLabel lblFeedback = new JLabel();
        lblFeedback.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblFeedback.setIcon(new ImageIcon(getClass().getResource("/feedback.png")));
        constraints.gridx = 11;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        pannel.add(lblFeedback, constraints);

        btnFeedback = new JButton("Feedback");
        btnFeedback.setBackground(new Color(231, 23, 179));
        btnFeedback.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnFeedback.setPreferredSize(new Dimension(200, 40));
        constraints.gridx = 11;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        pannel.add(btnFeedback, constraints);

        pack();
        setLocationRelativeTo(null);

        btnLawyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Login loginForm = new Login();
                loginForm.setVisible(true);

                setVisible(false);
            }
        });

        btnClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client();
                client.setVisible(true);

                setVisible(false);
            }
        });

        btnAboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AboutUs aboutUs = new AboutUs();
                aboutUs.setVisible(true);

                setVisible(false);
            }
        });

        btnFeedback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feedback feedback =new Feedback();
                feedback.setVisible(true);

                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            HomePage homepage = new HomePage();
            homepage.setVisible(true);
        });
    }
}
