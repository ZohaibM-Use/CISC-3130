package Labs.Lab1;

public class PokemonOnlyBox <T extends Pokemon> {
    private T value;

    PokemonOnlyBox(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T newValue){
        this.value = newValue;
    }

    String getType(){
        return value.getType();
    }
}
