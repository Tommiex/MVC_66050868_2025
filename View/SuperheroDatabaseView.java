package View;

import javax.swing.*;
import Controller.Manage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Class to display and manage the superhero suit database view
public class SuperheroDatabaseView extends JFrame {
    // Declare UI components
    private JTextArea outputArea; // Area to display the list of superhero suits
    private Manage manage; // Controller object to interact with the database

    public SuperheroDatabaseView(Manage manage) {
        this.manage = manage;
        manage.superheroDatabaseView = this;
        setTitle("Superhero Suit Database");

        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        setLayout(new FlowLayout());

        add(new JLabel("Superhero Suits List:"));
        
        add(scrollPane);

        // Load all suits when window opens
        displayAllSuits();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //
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
