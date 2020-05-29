import javax.swing.*;

public class Interface_design extends JFrame {
    private JPanel mainpanel;
    private JPasswordField PasswordField;
    private JTextField usernameTextField;
    private JButton enterButton;
    private JButton cancelButton;
    private JPanel loginPanel;

    public Interface_design(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new Interface_design("My Quick Test");
        frame.setVisible(true);
    }
}
