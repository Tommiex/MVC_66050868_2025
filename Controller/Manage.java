package Controller;

import java.util.function.Function;

import Model.SuperheroSuit;
import Model.SuperheroSuitDatabase;
import View.RepairWindow;
import View.SuperheroDatabaseView;
import View.SuperheroRepairedListView;

public class Manage {
    private SuperheroSuitDatabase db;
    public RepairWindow repairWindow;
    public SuperheroDatabaseView superheroDatabaseView;
    public SuperheroRepairedListView superheroRepairedListView;
    public Manage() {
        db = new SuperheroSuitDatabase();
    }
    // Function to get all Suits from SuperheroSuitDatabase
    public String getAllSuits() {
        StringBuilder sb = new StringBuilder();
        for (SuperheroSuit suit : db.getAllSuits()) {
            sb.append(suit).append("\n");
        }
        return sb.toString();
    }
    //Function to get all suits that have ever been repaired
    public String getAllRepairedSuits() {
        StringBuilder sb = new StringBuilder();
        for (SuperheroSuit suit : db.getAllRepairedSuits()) {
            sb.append(suit).append("\n");
        }
        return sb.toString();
    }
    //Check if this ID exists in the database and whether its durability is valid or invalid
    public String checkSuit(int suitId) {
        SuperheroSuit suit = db.findSuitById(suitId);
        //ID not exists
        if (suit == null) {
            return "Suit ID not found!";
        }
        return suit.toString() + "\nInvalid: " + !suit.isValid();
    }

    // Repair
    public String repairSuit(int suitId) {
        SuperheroSuit suit = db.findSuitById(suitId);
        if (suit == null) {
            return "Suit ID not found!";
        }
        suit.repair();
        //Add the repaired suit to the list of repaired suits
        db.addRepairedSuitList(suit);
        superheroRepairedListView.refreshRepairedListView();
        return "Suit repaired! New status:\n" + suit.toString();
    }
    public void refreshDatabaseView(){
        this.superheroDatabaseView.refreshDatabaseView();
    }
    public SuperheroSuit getSuitById(int suitId) {
        return db.findSuitById(suitId);
    }
}
