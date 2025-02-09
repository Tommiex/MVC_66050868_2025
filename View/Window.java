package View;

import javax.swing.*;
import Controller.Manage;
import Model.SuperheroSuit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton btnGetOutfitCode;
    private Manage manage;

    public Window(Manage manage) {
        this.manage = manage;
        setTitle("Superhero Suit Checker");

        inputField = new JTextField(20);
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        btnGetOutfitCode = new JButton("Check Suit");

        setLayout(new FlowLayout());

        add(new JLabel("Enter Suit ID:"));
        add(inputField);
        add(btnGetOutfitCode);
        add(new JLabel("Output:"));
        add(scrollPane);

        btnGetOutfitCode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText().trim();
                if (!inputText.matches("\\d{6}")) {
                    showErrorDialog("Invalid Suit ID! Must be 6 digits.");
                    return;
                }

                int suitId = Integer.parseInt(inputText);
                SuperheroSuit suit = manage.getSuitById(suitId);

                if (suit == null) {
                    showErrorDialog("Suit ID not found in the database.");
                    return;
                }

                outputArea.setText(suit.toString());

                // If durability is invalid, show repair window
                if (!suit.isValid()) {  
                    new RepairWindow(manage, suitId);
                    if(manage.superheroRepairedListView == null){
                        new SuperheroRepairedListView(manage);
                    }
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setVisible(true);
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
