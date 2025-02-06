import javax.swing.*;
import java.awt.*;

public class ContactListPanel extends JPanel {

    private JList<String> contactJList;
    private DefaultListModel<String> listModel;
    private ContactManagerApp app;

    public ContactListPanel(ContactManagerApp app) {
        this.app = app;
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        contactJList = new JList<>(listModel);
        add(new JScrollPane(contactJList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add New Contact");
        JButton viewButton = new JButton("View Details");

        addButton.addActionListener(e -> app.switchTo("ContactForm"));
        viewButton.addActionListener(e -> {
            int selectedIndex = contactJList.getSelectedIndex();
            if (selectedIndex != -1) {
                app.switchTo("ContactDetails");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contact.");
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void refreshContactList() {
        listModel.clear();
        for (Contact contact : app.getContacts()) {
            listModel.addElement(contact.getName());
        }
    }

}
