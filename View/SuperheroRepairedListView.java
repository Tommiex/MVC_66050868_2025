package View;

import javax.swing.*;
import Controller.Manage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/*  Show list of repaired suit
 *      This window will refresh automatically when a new suit is repaired
 */
public class SuperheroRepairedListView extends JFrame {
    private JTextArea outputArea;
    private Manage manage;


    public SuperheroRepairedListView(Manage manage) {
        this.manage = manage; // Initialize Manager 
        manage.superheroRepairedListView = this; // Assign this view to the manage object
        setTitle("Superhero Suit Database");
        
        outputArea = new JTextArea(20, 40); // Place to show all repaired suit
        outputArea.setEditable(false); // Make this area non-editable
        JScrollPane scrollPane = new JScrollPane(outputArea); // Add scroll to move

        setLayout(new FlowLayout());

        add(new JLabel("Superhero Suits List:"));
        add(scrollPane);

        // Load all repaired suits when window opens
        displayAllRepairedSuits();
      
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(600, 400);
        setVisible(true);
    }
    //display all suit in database 
    private void displayAllRepairedSuits() {
        String allSuits = manage.getAllRepairedSuits();
        outputArea.setText(allSuits);
    }
    // Function used to get the updated suit and display it
    public void refreshRepairedListView(){
        outputArea.setText(""); // Clear the output area
        displayAllRepairedSuits();// Reload the list of all repaired suits
    }
}
