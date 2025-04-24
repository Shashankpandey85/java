import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {
    int id;
    String name;
    int age;
    String gender;
    String diagnosis;

    public Patient(int id, String name, int age, String gender, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
    }
}

public class ModernHospitalUI {
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static int patientIdCounter = 1;

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Hospital Management System");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Side navigation panel
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setBackground(new Color(33, 33, 33));
        navPanel.setPreferredSize(new Dimension(200, 0));

        JLabel title = new JLabel("HMS");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(new EmptyBorder(20, 20, 20, 20));
        navPanel.add(title);

        JButton btnAdd = createNavButton("Add Patient");
        JButton btnView = createNavButton("View Patients");

        navPanel.add(btnAdd);
        navPanel.add(btnView);

        // Main panel with CardLayout
        JPanel mainPanel = new JPanel(new CardLayout());
        JPanel addPanel = createAddPatientPanel();
        JPanel viewPanel = createViewPatientPanel();

        mainPanel.add(addPanel, "Add");
        mainPanel.add(viewPanel, "View");

        frame.add(navPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Navigation
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        btnAdd.addActionListener(e -> cl.show(mainPanel, "Add"));
        btnView.addActionListener(e -> {
            refreshPatientTable(viewPanel);
            cl.show(mainPanel, "View");
        });

        // Show
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setMaximumSize(new Dimension(180, 40));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(55, 71, 79));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return btn;
    }

    private static JPanel createAddPatientPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(40, 80, 40, 80));

        JLabel heading = new JLabel("Add New Patient");
        heading.setFont(new Font("Segoe UI", Font.BOLD, 24));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField tfName = createTextField("Enter Name");
        JTextField tfAge = createTextField("Enter Age");
        JTextField tfGender = createTextField("Enter Gender");
        JTextField tfDiagnosis = createTextField("Enter Diagnosis");

        JButton btnSave = new JButton("Save Patient");
        btnSave.setBackground(new Color(25, 118, 210));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnSave.setFocusPainted(false);
        btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnSave.addActionListener(e -> {
            try {
                String name = tfName.getText();
                int age = Integer.parseInt(tfAge.getText());
                String gender = tfGender.getText();
                String diagnosis = tfDiagnosis.getText();

                patientList.add(new Patient(patientIdCounter++, name, age, gender, diagnosis));
                JOptionPane.showMessageDialog(panel, "Patient added successfully.");

                tfName.setText("");
                tfAge.setText("");
                tfGender.setText("");
                tfDiagnosis.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Invalid input. Please try again.");
            }
        });

        panel.add(heading);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(tfName);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tfAge);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tfGender);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(tfDiagnosis);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnSave);

        return panel;
    }

    private static JTextField createTextField(String placeholder) {
        JTextField tf = new JTextField();
        tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        tf.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tf.setBorder(BorderFactory.createTitledBorder(placeholder));
        return tf;
    }

    private static JPanel createViewPatientPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 40, 20, 40));
        panel.setBackground(Color.WHITE);

        String[] columns = {"ID", "Name", "Age", "Gender", "Diagnosis"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(240, 240, 240));

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.putClientProperty("table", table);
        panel.putClientProperty("model", model);

        return panel;
    }

    private static void refreshPatientTable(JPanel viewPanel) {
        JTable table = (JTable) viewPanel.getClientProperty("table");
        DefaultTableModel model = (DefaultTableModel) viewPanel.getClientProperty("model");

        model.setRowCount(0); // Clear table
        for (Patient p : patientList) {
            model.addRow(new Object[]{p.id, p.name, p.age, p.gender, p.diagnosis});
        }
    }
}

