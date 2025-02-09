package Model;

public class DisguiseSuit extends SuperheroSuit {
    public DisguiseSuit(int id, int durability,String type) {
        super(id, durability);
        this.type = type;
    }

    @Override
    public boolean isValid() {
        return durability % 10 != 3 && durability % 10 != 7;
    }
}
