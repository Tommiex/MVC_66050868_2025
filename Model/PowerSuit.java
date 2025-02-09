package Model;

public class PowerSuit extends SuperheroSuit {
    public PowerSuit(int id, int durability,String type) {
        super(id, durability);
        this.type = type;
    }

    @Override
    public boolean isValid() {
        return durability >= 70;
    }
}
