import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JFrame {
    private Zoo zoo;
    private JTextField animalNameField, ageField, weightField;
    private JTextArea outputArea;

    public MainGUI() {
        zoo = new Zoo();
        animalNameField = new JTextField(20);
        ageField = new JTextField(5);
        weightField = new JTextField(5);
        outputArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Zoo System");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Animal Name:"));
        inputPanel.add(animalNameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weightField);

        JButton addButton = new JButton("Add Animal");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String animalName = animalNameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double weight = Double.parseDouble(weightField.getText());

                // Create and add the animal to the zoo
                // Replace the code with your implementation
                // lion = new Lion(animalName, "Lion", age, weight, "Predator");
                // zoo.addAnimals(lion);
            }
        });

        JButton viewButton = new JButton("View Animals");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display the animals in the output area
                // Replace the code with your implementation
                // outputArea.setText(zoo.getAnimalsAsString());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}