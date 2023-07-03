import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooGUI extends JFrame implements ActionListener {
    private JButton addAnimalsButton;
    private JButton removeAnimalsButton;
    private JButton updateButton;
    private JButton animalsDataButton;
    private JButton viewAnimalsButton;
    private JButton exitButton;
    private JTextArea animalTextArea;
    Zoo zoo;
    Lion lion = null ;          //lion object
    Bear bear = null;
    Monkey monkey = null;
    Capybara capybara = null;
    Croc crocodile = null;

    public ZooGUI() {
        zoo = new Zoo();
        setTitle("Zoo System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel title = new JLabel("Zoo System");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        addAnimalsButton = new JButton("Add Animals");
        removeAnimalsButton = new JButton("Remove Animals");
        updateButton = new JButton("Update");
        animalsDataButton = new JButton("Animals Data");
        viewAnimalsButton = new JButton("View Animals");
        exitButton = new JButton("Exit");

        addAnimalsButton.addActionListener(this);
        removeAnimalsButton.addActionListener(this);
        updateButton.addActionListener(this);
        animalsDataButton.addActionListener(this);
        viewAnimalsButton.addActionListener(this);
        exitButton.addActionListener(this);

        buttonPanel.add(addAnimalsButton);
        buttonPanel.add(removeAnimalsButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(animalsDataButton);
        buttonPanel.add(viewAnimalsButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAnimalsButton) {
            addAnimal();
        } else if (e.getSource() == removeAnimalsButton) {
            removeAnimal();
            // Code for Remove Animals option
        } else if (e.getSource() == updateButton) {
            updateAnimal();
            // Code for Update option
        } else if (e.getSource() == animalsDataButton) {
            // Code for Animals Data option
        } else if (e.getSource() == viewAnimalsButton) {
            JFrame viewAnimalFrame = new viewAnimal(zoo);
            viewAnimalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // Code for View Animals option
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void addAnimal() {
        String[] animalOptions = {"Lion", "Bear", "Monkey", "Capybara", "Crocodile", "Exit"};
        int choice = JOptionPane.showOptionDialog(this, "Add Animals", "Animal Type", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, animalOptions, animalOptions[0]);

        if (choice == JOptionPane.CLOSED_OPTION || choice == 5) {
            return; // Exit option chosen or dialog closed
        }

        String animalName = JOptionPane.showInputDialog(this, "Enter the animal's name:");
        if (animalName == null) {
            int userChoice = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit?", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
                return; // Dialog canceled
            }
        }

        int age = 0;
        while (true) {
            String ageInput = JOptionPane.showInputDialog(this, "Enter the animal's age:");
            if (ageInput == null) {
                int userChoice = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit?", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION) {
                    return; // Dialog canceled
                }
            }
            try {
                age = Integer.parseInt(ageInput);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double weight = 0.0;
        while (true) {
            String weightInput = JOptionPane.showInputDialog(this, "Enter the animal's weight (in kilograms):");
            if (weightInput == null) {
                int userChoice = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit?", JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION) {
                    return; // Dialog canceled
                }
            }
            try {
                weight = Double.parseDouble(weightInput);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Create the animal object and add it to the zoo variable
        switch (choice) {
            case 0:
                Lion lion = new Lion(animalName, "Lion", age, weight, "Predator");
                try {
                    zoo.addAnimals(lion);
                    zoo.listAnimals();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 1:
                Bear bear = new Bear(animalName, "Bear", age, weight, "Predator");
                try {
                    zoo.addAnimals(bear);
                    zoo.listAnimals();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                Monkey monkey = new Monkey(animalName,"Monkey",age,weight,"Herbivor");
                try {
                    zoo.addAnimals(monkey);
                    zoo.listAnimals();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 3:
                Capybara capybara = new Capybara(animalName,"Capybara",age,weight,"Herbivor");
                try {
                    zoo.addAnimals(capybara);
                    zoo.listAnimals();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 4:
                Croc croc = new Croc(animalName,"Croc",age,weight,"Predator");
                try {
                    zoo.addAnimals(croc);
                    zoo.listAnimals();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

            // handle other animal cases
        }
    }


    private void removeAnimal() {
        String[] animalOptions = {"Lion", "Bear", "Monkey", "Capybara", "Crocodile", "Exit"};
        int choice = JOptionPane.showOptionDialog(this, "Remove Animals", "Animal Type", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, animalOptions, animalOptions[0]);

        if (choice == 5) {
            return; // Exit option chosen
        }

        String animalName = JOptionPane.showInputDialog(this, "Enter the name of the animal to be removed:");

        // Remove the animal from the zoo variable
        switch (choice) {
            case 0:
                if (zoo.countAnimalsByType("lion") != 0) {
                    try {
                        zoo.deleteAnimal(animalName, "Lion");
//                        zoo.updateAnimalInformation();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Animals not available!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            // handle other animal cases
        }
    }
    private void updateAnimal() {
        String[] animalOptions = {"Lion", "Bear", "Monkey", "Capybara", "Crocodile", "Exit"};
        int choice = JOptionPane.showOptionDialog(this, "Update Animals", "Animal Type", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, animalOptions, animalOptions[0]);

        if (choice == 5) {
            return; // Exit option chosen
        }


        String animalName = JOptionPane.showInputDialog(this, "Enter the name of the animal to be updated:");

        if (zoo.checkAvailability(animalName) == 0) {
            JOptionPane.showMessageDialog(this, "There is no animal with that name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] updateOptions = {"Name", "Age", "Weight"};
        int updateChoice = JOptionPane.showOptionDialog(this, "Update", "Update Type", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, updateOptions, updateOptions[0]);

        switch (updateChoice) {
            case 0:
                String newName = JOptionPane.showInputDialog(this, "Enter the new name of the animal:");
                zoo.updateAnimals(animalName, "name", newName);
                break;
            case 1:
                String newAgeString = JOptionPane.showInputDialog(this, "Enter the new age of the animal:");
                try {
                    int newAge = Integer.parseInt(newAgeString);
                    zoo.updateAnimals(animalName, "age", newAge);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                String newWeightString = JOptionPane.showInputDialog(this, "Enter the new weight of the animal:");
                try {
                    double newWeight = Double.parseDouble(newWeightString);
                    zoo.updateAnimals(animalName, "weight", newWeight);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ZooGUI());
    }
}