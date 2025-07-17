import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConferenceManagerGUI {
    JFrame frame;
    JTextField nameField, typeField, ownerField, phoneField;
    JButton submitBtn, clearBtn;

    public ConferenceManagerGUI() {
        // Frame setup
        frame = new JFrame("Conference & Event Manager");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Icon
        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());

        // Header panel with image (optional)
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(34, 34, 34));
        JLabel headerLabel = new JLabel(new ImageIcon("header.jpg"));
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // Center panel for form
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBackground(new Color(34, 34, 34));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Labels and fields
        JLabel nameLabel = new JLabel("Event Name:");
        nameField = new JTextField();
        JLabel typeLabel = new JLabel("Event Type:");
        typeField = new JTextField();
        JLabel ownerLabel = new JLabel("Owner Full Name:");
        ownerField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();

        // Style labels
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Color labelColor = Color.WHITE;
        for (JLabel label : new JLabel[]{nameLabel, typeLabel, ownerLabel, phoneLabel}) {
            label.setForeground(labelColor);
            label.setFont(labelFont);
        }

        // Buttons
        submitBtn = new JButton("Submit");
        clearBtn = new JButton("Clear");
        Color buttonColor = new Color(176, 215, 12);
        submitBtn.setBackground(buttonColor);
        clearBtn.setBackground(buttonColor);
        submitBtn.setForeground(Color.BLACK);
        clearBtn.setForeground(Color.BLACK);

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);
        submitBtn.setFont(btnFont);
        clearBtn.setFont(btnFont);

        // Add components to form
        formPanel.add(nameLabel); formPanel.add(nameField);
        formPanel.add(typeLabel); formPanel.add(typeField);
        formPanel.add(ownerLabel); formPanel.add(ownerField);
        formPanel.add(phoneLabel); formPanel.add(phoneField);
        formPanel.add(submitBtn); formPanel.add(clearBtn);

        frame.add(formPanel, BorderLayout.CENTER);

        // Button listeners
        submitBtn.addActionListener(e -> submitForm());
        clearBtn.addActionListener(e -> clearForm());

        // Show frame
        frame.setVisible(true);
    }

    private void submitForm() {
        String name = nameField.getText();
        String type = typeField.getText();
        String owner = ownerField.getText();
        String phone = phoneField.getText();

        if (name.isEmpty() || type.isEmpty() || owner.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(frame, "Event submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }

    private void clearForm() {
        nameField.setText("");
        typeField.setText("");
        ownerField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConferenceManagerGUI::new);
    }
}
