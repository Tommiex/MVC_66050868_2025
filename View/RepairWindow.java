package View;

import javax.swing.*;
import Controller.Manage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepairWindow extends JFrame {
    private JTextArea suitDetails;
    private JButton btnRepair;
    private Manage manage;
    private int suitId;

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

        // Button 
        btnRepair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manage.repairSuit(suitId);
                suitDetails.setText(manage.getSuitById(suitId).toString());
                manage.refreshDatabaseView();
                if(manage.getSuitById(suitId).getDurability() == 100){
                    btnRepair.setEnabled(false);
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setVisible(true);
    }
}
