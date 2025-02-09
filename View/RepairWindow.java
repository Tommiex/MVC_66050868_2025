package View;

import javax.swing.*;
import Controller.Manage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Repair window that allows the user to repair a superhero suit
public class RepairWindow extends JFrame {
    private JTextArea suitDetails; // Area to display the details of the suit
    private JButton btnRepair; // Button to trigger the repair of the suit
    private Manage manage; // Controller object to manage the repair process
    private int suitId; // ID of the suit being repaired

    public RepairWindow(Manage manage, int suitId) {
        this.manage = manage;
        manage.repairWindow = this;
        this.suitId = suitId;

        setTitle("Repair Suit");

        suitDetails = new JTextArea(5, 30);
        suitDetails.setEditable(false);
        suitDetails.setText(manage.getSuitById(suitId).toString());
        JScrollPane scrollPane = new JScrollPane(suitDetails);

        btnRepair = new JButton("Repair Suit");

        setLayout(new FlowLayout());

        add(new JLabel("Suit Durability Issue"));
        add(scrollPane);
        add(btnRepair);

       // Add action listener to the "Repair Suit" button
       btnRepair.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Call the repair method in the manage object
            manage.repairSuit(suitId);
            // Update the suit details after repair
            suitDetails.setText(manage.getSuitById(suitId).toString());
            // Refresh the database view to reflect the changes
            manage.refreshDatabaseView();

            // If the durability reaches 100, disable the repair button
            if (manage.getSuitById(suitId).getDurability() == 100) {
                btnRepair.setEnabled(false); // Disable the repair button if the suit is fully repaired
            }
        }
    });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);
    }
}
