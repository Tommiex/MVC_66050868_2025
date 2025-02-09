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
    private JButton refreshButton;

    public SuperheroRepairedListView(Manage manage) {
        this.manage = manage;
        manage.superheroRepairedListView = this;
        setTitle("Superhero Suit Database");

        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        refreshButton = new JButton("Refresh Stock");
        setLayout(new FlowLayout());

        add(new JLabel("Superhero Suits List:"));
        add(refreshButton, BorderLayout.SOUTH);
        add(scrollPane);

        // Load all repaired suits when window opens
        displayAllRepairedSuits();
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshRepairedListView();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    private void displayAllRepairedSuits() {
        String allSuits = manage.getAllRepairedSuits();
        outputArea.setText(allSuits);
    }
    public void refreshRepairedListView(){
        outputArea.setText("");
        displayAllRepairedSuits();
    }
}
