package Homework.Homework2;

import java.util.Objects;

public class Pair <K, V> {
    private K first;
    private V second;

    //Constructors

    public Pair() {
        this(null, null);
    }

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    //Getters and Setters
    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    //Overrides
    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}