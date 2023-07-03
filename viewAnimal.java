import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class viewAnimal extends JFrame {
    Zoo zoo;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    JTable table;

    public viewAnimal(Zoo zoo) {

        this.zoo = zoo;
        this.setTitle("View Details");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create column names
        String[] columnNames = {"Type", "Name", "Age", "Weight", "Diet"};

        // Create the table model with column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Create the JTable with the table model
        table = new JTable(model);

        // Set table properties
        table.setPreferredScrollableViewportSize(new Dimension(600, 400));
        table.setFillsViewportHeight(true);

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 600, 400);
        scrollPane.setBorder(border);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Display animal information
        displayAnimalInformation();

        // Set column widths
        setColumnWidths();
        setRowHeights();

        // Set layout manager for the frame
        setLayout(null);

        this.setVisible(true);
    }

    private void displayAnimalInformation() {

        // Get the animals array from the Zoo
        Animals[] animals = zoo.getAnimals();

        // Iterate through each animal and add its information to the table model
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (Animals animal : animals) {
            if (animal != null) {
                String type = animal.getType();
                String name = animal.getName();
                int age = animal.getAge();
                double weight = animal.getWeight();
                String diet = animal.getDiet();

                // Create an array with the animal information
                Object[] rowData = {type, name, age, weight, diet};

                // Add the row to the table model
                model.addRow(rowData);
            }
        }
    }

    private void setColumnWidths() {
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);

            if (i == 0) {  // Adjust width for the first column (Type)
                column.setPreferredWidth(100);
            } else {  // Adjust width for other columns
                column.setPreferredWidth(100);
            }
        }
    }
    private void setRowHeights() {
        int rowHeight = 30;  // Set the preferred row height (in pixels)

        // Set the row height for each row in the table
        for (int row = 0; row < table.getRowCount(); row++) {
            table.setRowHeight(row, rowHeight);
        }
    }
}