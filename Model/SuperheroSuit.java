package Model;

public abstract class SuperheroSuit {
    protected int id; // suit id
    protected int durability; 
    protected String type; // Type of superhero suit. | PowerSuit, StealthSuit, Disguise
    //Constructor to initialize attribute
    public SuperheroSuit(int id, int durability) {
        this.id = id;
        this.durability = durability;
    }
    //Getter method to retrieve
    public int getId() {
        return id;
    }

    public int getDurability() {
        return durability;
    }

    public abstract boolean isValid(); 

    public void repair() {
        this.durability = Math.min(this.durability + 25, 100);
    }

    @Override
    public String toString() {
        return "Suit ID: " + id + ", Durability: " + durability+ ", Type: " + type + ", Valid: " + isValid();
    }
}
