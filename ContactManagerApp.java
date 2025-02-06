import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContactManagerApp {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private ContactListPanel contactListPanel;
    private ContactDetailsPanel contactDetailsPanel;
    private ContactFormPanel contactFormPanel;
    private ArrayList<Contact> contacts;

    public ContactManagerApp() {
        frame = new JFrame("Card Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        contacts = new ArrayList<>();
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        contactListPanel = new ContactListPanel(this);
        contactDetailsPanel = new ContactDetailsPanel(this);
        contactFormPanel = new ContactFormPanel(this);

        cardPanel.add(contactListPanel, "ContactList");
        cardPanel.add(contactDetailsPanel, "ContactDetails");
        cardPanel.add(contactFormPanel, "ContactForm");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    public void switchTo(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        contactListPanel.refreshContactList();
    }

}
