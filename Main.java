package Labs.Lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Given Code
        System.out.println("Given Code");
        System.out.println("-----------------------------");
        Pokemon pikachu = new Pokemon("Pikachu", "Electric");
        Pokemon charmander = new Pokemon("Charmander", "Fire");

        System.out.println(pikachu);
        System.out.println(charmander);

        //"bad" version - No Generics
        System.out.println();
        System.out.println("\"Bad\" Version - No Generics");
        System.out.println("-----------------------------");
        PokeBox box = new PokeBox(pikachu);
        System.out.println(box.get());
        box.set(charmander);
        System.out.println(box.get());

        //Generics
        System.out.println();
        System.out.println("Generics");
        System.out.println("-----------------------------");
        Box<Pokemon> pokemonBox = new Box<>(pikachu);
        Box<String> itemBox = new Box<>("Oran Berry");
        Box<Integer> levelBox = new Box<>(25);
        System.out.println(pokemonBox.get());
        System.out.println(itemBox.get());
        System.out.println(levelBox.get());

        //Two Type Parameters
        System.out.println();
        System.out.println("Two Type Parameters");
        System.out.println("-----------------------------");
        Pair<Pokemon, String> heldItem = new Pair<>(pikachu, "Oran Berry");
        System.out.println(heldItem);

        //Bounded Generics
        System.out.println();
        System.out.println("Bounded Generics");
        System.out.println("-----------------------------");
        PokemonOnlyBox<Pokemon> b1 = new PokemonOnlyBox<>(pikachu);
        System.out.println(b1.getType());

        //Show Bounds working with subclass
        System.out.println();
        System.out.println("Show Bounds Working With Subclass");
        System.out.println("-----------------------------");
        BattlePokemon squirtle = new BattlePokemon("Squirtle", "Water", 60);
        PokemonOnlyBox<BattlePokemon> battleBox = new PokemonOnlyBox<>(squirtle);
        System.out.println(battleBox.getValue());

        //Swap two boxes
        System.out.println();
        System.out.println("Swap two boxes");
        System.out.println("-----------------------------");
        Box<String> a = new Box<>("Potion");
        Box<String> b = new Box<>("Rare Candy");
        System.out.println("Before: a=" + a.get() + ", b=" + b.get());
        swap(a, b);
        System.out.println("After:  a=" + a.get() + ", b=" + b.get());

        //Wildcard Team Printer
        System.out.println();
        System.out.println("Wildcard Team Printer");
        System.out.println("-----------------------------");
        List<Pokemon> pokemonTeam = new ArrayList<>();
        pokemonTeam.add(pikachu);
        pokemonTeam.add(charmander);

        List<BattlePokemon> battleTeam = new ArrayList<>();
        battleTeam.add(squirtle);
        battleTeam.add(new BattlePokemon("Snorlax", "Normal", 110));

        System.out.println("Pokemon Team: ");
        printTeam(pokemonTeam);
        System.out.println();
        System.out.println("Battle Team: ");
        printTeam(battleTeam);
    }

    //Method to swap two boxes
    public static <T> void swap(Box<T> a, Box<T> b){
        T swapValue = a.get();
        a.set(b.get());
        b.set(swapValue);
    }

    //Wildcard TeamPrinter Method
    public static void printTeam(List <? extends Pokemon> team){
        for(Pokemon pokemon: team)
        System.out.println(pokemon);
    }
}
