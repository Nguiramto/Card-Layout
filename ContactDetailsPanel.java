import javax.swing.*;
import java.awt.*;

public class ContactDetailsPanel extends JPanel {
    private JLabel nameLabel, phoneLabel, emailLabel;
    private ContactManagerApp app;

    public ContactDetailsPanel(ContactManagerApp app) {
        this.app = app;
        setLayout(new GridLayout(4, 1));

        nameLabel = new JLabel();
        phoneLabel = new JLabel();
        emailLabel = new JLabel();
        JButton backButton = new JButton("Back to List");

        backButton.addActionListener(e -> app.switchTo("ContactList"));

        add(nameLabel);
        add(phoneLabel);
        add(emailLabel);
        add(backButton);
    }

    public void displayContact(Contact contact) {
        nameLabel.setText("Name: " + contact.getName());
        phoneLabel.setText("Phone: " + contact.getPhone());
        emailLabel.setText("Email: " + contact.getEmail());
    }
}
