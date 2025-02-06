import javax.swing.*;
import java.awt.*;

public class ContactFormPanel extends JDesktopPane {
    private JTextField nameField, phoneField, emailField;
    private ContactManagerApp app;

    public ContactFormPanel(ContactManagerApp app) {
        this.app = app;
        setLayout(new GridLayout(5, 1));

        nameField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        JButton saveButton = new JButton("Save Contact");
        JButton cancelButton = new JButton("Cancel");

        saveButton.addActionListener(e -> saveContact());
        cancelButton.addActionListener(e -> app.switchTo("ContactList"));

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(new JLabel("Email:"));
        add(emailField);
        add(saveButton);
        add(cancelButton);
    }

    private void saveContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled out.");
            return;
        }

        app.addContact(new Contact(name, phone, email));
        app.switchTo("ContactList");
    }

}
