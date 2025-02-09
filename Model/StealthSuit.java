package Model;

public class StealthSuit extends SuperheroSuit {
    
    public StealthSuit(int id, int durability,String type) {
        super(id, durability);
        this.type = type;
    }

    @Override
    public boolean isValid() {
        return durability >= 50;
    }
}
