package View;

import javax.swing.*;
import Controller.Manage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SuperheroDatabaseView extends JFrame {
    private JTextArea outputArea;
    private Manage manage;
    private JButton refreshButton;

    public SuperheroDatabaseView(Manage manage) {
        this.manage = manage;
        manage.superheroDatabaseView = this;
        setTitle("Superhero Suit Database");

        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        refreshButton = new JButton("Refresh Stock");
        setLayout(new FlowLayout());

        add(new JLabel("Superhero Suits List:"));
        add(refreshButton, BorderLayout.SOUTH);
        add(scrollPane);

        // Load all suits when window opens
        displayAllSuits();
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshDatabaseView();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    private void displayAllSuits() {
        String allSuits = manage.getAllSuits();
        outputArea.setText(allSuits);
    }
    public void refreshDatabaseView(){
        outputArea.setText("");
        displayAllSuits();
    }
}
