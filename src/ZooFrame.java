import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ZooFrame extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> typeCombo;
    private JTextField furColorField;
    private JCheckBox canFlyCheck;
    private JButton addButton;
    private JTextArea logArea;

    private ArrayList<Animal> zooAnimals = new ArrayList<>();

    public ZooFrame() {
        setTitle("Digital Zoo Manager");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Animal Type:"));
        typeCombo = new JComboBox<>(new String[]{"Mammal", "Bird"});
        inputPanel.add(typeCombo);

        inputPanel.add(new JLabel("Fur Color (for Mammal):"));
        furColorField = new JTextField();
        inputPanel.add(furColorField);

        inputPanel.add(new JLabel("Can Fly? (for Bird):"));
        canFlyCheck = new JCheckBox();
        inputPanel.add(canFlyCheck);

        add(inputPanel, BorderLayout.NORTH);

        addButton = new JButton("Add Animal");
        add(addButton, BorderLayout.CENTER);

        logArea = new JTextArea();
        logArea.setEditable(false);
        add(new JScrollPane(logArea), BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAnimal();
            }
        });
    }

    private void addAnimal() {
        String name = nameField.getText();
        int age;
        try {
            age = Integer.parseInt(ageField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }

        String type = (String) typeCombo.getSelectedItem();
        Animal animal = null;

        if ("Mammal".equals(type)) {
            String furColor = furColorField.getText();
            animal = new Mammal(name, age, furColor);
        } else if ("Bird".equals(type)) {
            boolean canFly = canFlyCheck.isSelected();
            animal = new Bird(name, age, canFly);
        }

        if (animal != null) {
            zooAnimals.add(animal);
            logArea.append("Added a new " + type + "!\n");
            logArea.append("Info: " + animal.getInfo() + "\n");
            logArea.append("Sound: " + animal.makeSound() + "\n\n");
        }
    }
}
