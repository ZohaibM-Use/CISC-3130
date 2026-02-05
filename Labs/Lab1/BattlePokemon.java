package Labs.Lab1;

public class BattlePokemon extends Pokemon {
    private int hp;

    BattlePokemon(String name, String type, int hp){
        super(name, type);
        this.hp = hp;
    }

    public int getHp(){
        return this.hp;
    }

    @Override
    public String toString(){
        return super.toString() + " " + this.hp;
    }
}
