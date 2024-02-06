import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs extends JFrame {

    private JLabel lblHeading;
    private JLabel lblP1;
    private JButton btnBack;


    public AboutUs(){

        frmAboutUs();
    }

    public void frmAboutUs(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel();
        pannel.setLayout(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        setContentPane(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        lblHeading = new JLabel("   Welcome to Us");
        lblHeading.setIcon(new ImageIcon(getClass().getResource("/about us.png")));
        lblHeading.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblHeading.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.CENTER;
        pannel.add(lblHeading, gbc);

        lblP1 = new JLabel("Hello and welcome to our system. You can find the lawyer you need ");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        lblP1 = new JLabel("in this system, and if you are a lawyer, you can simply reach your ");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        lblP1 = new JLabel("clients. This system was developed with the goal of offering a better ");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        lblP1 = new JLabel("qualitative and effective service to our clients.");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        lblP1 = new JLabel("");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        lblP1 = new JLabel("");
        lblP1.setForeground(new Color(0, 0, 0));
        lblP1.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pannel.add(lblP1, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(200, 40));
        gbc.gridx = 0;
        gbc.gridy = 8;
        pannel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnBack.addActionListener(new ActionListener() {
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

            AboutUs aboutUs = new AboutUs();
            aboutUs.setVisible(true);
        });
    }


}
