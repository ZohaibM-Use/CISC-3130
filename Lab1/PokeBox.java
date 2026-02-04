package Labs.Lab1;

public class PokeBox {
    private Pokemon value;

    PokeBox(Pokemon value){
        this.value = value;
    }

    public Pokemon get(){
        return value;
    }

    public void set(Pokemon newValue){
        this.value = newValue;
    }
}
