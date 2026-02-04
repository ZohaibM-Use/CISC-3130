package Labs.Lab1;

public class Box <T> {
    private T value;

    Box(T value){
        this.value = value;
    }

    public T get(){
        return value;
    }

    public void set(T newValue){
        this.value = newValue;
    }


}
