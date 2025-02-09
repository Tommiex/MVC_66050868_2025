package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperheroSuitDatabase {
    // List to store all superhero suits
    private List<SuperheroSuit> suits = new ArrayList<>();
    // List to store suits that have been repaired
    private List<SuperheroSuit> repairedSuits = new ArrayList<>();
    // Random object for generating random values
    private static final Random RANDOM = new Random();

    // Constructor that generates sample suits when the database is initialized
    public SuperheroSuitDatabase() {
        generateSampleSuits();
    }

   // Method to generate a list of sample superhero suits
   private void generateSampleSuits() {
    // Ensure the list has at least 50 suits
    while (suits.size() < 50) {
        int id = 100000 + RANDOM.nextInt(900000); // Generate a random 6-digit ID
        int durability = RANDOM.nextInt(101); // Generate a random durability value between 0 and 100
        SuperheroSuit suit = createRandomSuit(id, durability); // Create a random suit based on the ID and durability
        suits.add(suit); // Add the suit to the list
    }
}

    private SuperheroSuit createRandomSuit(int id, int durability) {
        int type = RANDOM.nextInt(3);
        switch(type) {
            case 0:
              return new PowerSuit(id,durability,"PowerSuit");
             
            case 1:
              return new StealthSuit(id,durability,"StealthSuit");
             
            default :
              return new DisguiseSuit(id,durability,"DisguiseSuit");
          }
   
    }

      // Method to find a suit by its ID from the list of all suits
      public SuperheroSuit findSuitById(int id) {
        return suits.stream() // Use stream to filter suits based on the ID
                    .filter(suit -> suit.getId() == id) // Match the ID
                    .findFirst() // Return the first match (if any)
                    .orElse(null); // Return null if no match is found
    }

    // Method to add a suit if that suit not already present
    public void addRepairedSuitList(SuperheroSuit sp){
        if(!repairedSuits.contains(sp)) { // Check if the suit is already in the repaired list
            repairedSuits.add(sp); // Add the suit to the repaired list
        }
    }
    // Getter method to get list that store all superhero suits
    public List<SuperheroSuit> getAllSuits() {
        return suits;
    }
    // Getter method to get list that store all repaired superhero suits
    public List<SuperheroSuit> getAllRepairedSuits() {
        return repairedSuits;
    }
}
