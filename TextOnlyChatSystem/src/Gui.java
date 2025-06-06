import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener {

    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;
    private JLabel messageLabel;

    public Gui() {
        setTitle("Login Form");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Panel
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Username input
        JPanel userPanel = new JPanel(new FlowLayout());
        userPanel.add(new JLabel("Username:"));
        userField = new JTextField(15);
        userPanel.add(userField);

        // Password input
        JPanel passPanel = new JPanel(new FlowLayout());
        passPanel.add(new JLabel("Password:"));
        passField = new JPasswordField(15);
        passPanel.add(passField);

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Message label
        messageLabel = new JLabel("", SwingConstants.CENTER);

        // Add all to panel
        panel.add(userPanel);
        panel.add(passPanel);
        panel.add(loginButton);
        panel.add(messageLabel);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            messageLabel.setText("Login successful!");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel.setText("Invalid username or password.");
            messageLabel.setForeground(Color.RED);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Gui().setVisible(true);
        });
    }
}
