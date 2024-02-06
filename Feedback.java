import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Feedback extends JFrame {

    private JLabel lblHeadding;
    private JLabel lblfeedback;
    private JTextField txtfeedback;
    private JButton btnSubmit;
    private JButton btnBack;

    public Feedback(){
        frmFeedback();
    }
    public void frmFeedback(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        setPreferredSize(new Dimension(900, 650));

        JPanel pannel = new JPanel(new GridBagLayout());
        pannel.setBackground(new Color(173, 216, 230));
        getContentPane().add(pannel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 10, 5, 10);

        JPanel headingPanel = new JPanel(new BorderLayout());

        lblHeadding = new JLabel("Feeback");
        lblHeadding.setIcon(new ImageIcon(getClass().getResource("/feedback.png")));
        lblHeadding.setFont(new Font("Segoe UI", Font.BOLD, 50));
        lblHeadding.setForeground(new Color(0, 0, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 12;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pannel.add(lblHeadding, gbc);

        lblfeedback = new JLabel("Put your feedback here");
        lblfeedback.setForeground(new Color(0, 0, 0));
        lblfeedback.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pannel.add(lblfeedback, gbc);

        txtfeedback = new JTextField();
        txtfeedback.setForeground(new Color(0, 0, 0));
        txtfeedback.setFont(new Font("Segoe UI Historic", Font.BOLD, 25));
        txtfeedback.setPreferredSize(new Dimension(600, 300));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        pannel.add(txtfeedback, gbc);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBackground(new Color(139, 0, 0));
        btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnSubmit.setForeground(new Color(255, 255, 255));
        btnSubmit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnSubmit.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 0;
        gbc.gridy = 3;
        pannel.add(btnSubmit, gbc);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(139, 0, 0));
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 0;
        gbc.gridy = 4;
        pannel.add(btnBack, gbc);

        pack();
        setLocationRelativeTo(null);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String feedbackText = txtfeedback.getText().trim();

                if (feedbackText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Feedback field is empty. Please provide your feedback.");
                } else {
                    try {

                        String filePath = "feedback.txt";

                        FileWriter fileWriter = new FileWriter(filePath);

                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                        bufferedWriter.write(feedbackText);

                        bufferedWriter.close();

                        JOptionPane.showMessageDialog(null, "Feedback saved successful");
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error saving feedback: " + ex.getMessage());
                    }
                }
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

    }
    public static void main(String [] args) {

        SwingUtilities.invokeLater(() -> {

            Feedback feedback = new Feedback();
            feedback.setVisible(true);
        });
    }
}
