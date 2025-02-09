package Model;
// Suit type class that inherits from SuperheroSuit
public class StealthSuit extends SuperheroSuit {
    // Constructor to initialize all attribute
    public StealthSuit(int id, int durability,String type) {
        super(id, durability);
        this.type = type;
    }
// Override the isValid method to check if the suit's durability is OK (valid)
    @Override
    public boolean isValid() {
        return durability >= 50;
    }
}
