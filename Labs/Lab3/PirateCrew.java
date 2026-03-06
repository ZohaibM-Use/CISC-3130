package Labs.Lab3;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PirateCrew {

    static class Pirate{
        String name, role;
        int bounty;

        public Pirate(String name, String role, int bounty) {
            this.name = name;
            this.role = role;
            this.bounty = bounty;
        }

    }

    public static void main(String[] args) {
        List<Pirate> crew = new ArrayList<>(
            List.of(
                new Pirate("Luffy", "Captain", 300),
                new Pirate("Zoro", "Swordsman", 120),
                new Pirate("Nami", "Navigator", 66),
                new Pirate("Sanji", "Cook", 130),
                new Pirate("Chopper", "Doctor", 50),
                new Pirate("Fisher", "Apprentice", 10),
                new Pirate("Luna", "Apprentice",39)
            ));

        //Part A
        System.out.println("Original Crew");
        crew.forEach(pirate -> System.out.println(
                pirate.name + " " + pirate.role + " " + pirate.bounty));
        System.out.println("-----------------------------------------------");

        Predicate<Pirate> highBounty = pirate -> pirate.bounty >= 100;
        List<Pirate> bigShots = new ArrayList<>(crew.stream().filter(highBounty).toList());
        System.out.println("Big Shots");
        bigShots.forEach(pirate -> System.out.println(
                pirate.name + " " + pirate.role + " " + pirate.bounty));
        System.out.println("-----------------------------------------------");


        //Part B
        Iterator<Pirate> it = crew.iterator();
        while (it.hasNext()){
            Pirate pirate = it.next();
            if (pirate.role.equals("Apprentice"))
                it.remove();
        }
        System.out.println("Removed Apprentice");
        crew.forEach(pirate -> System.out.println(
                pirate.name + " " + pirate.role + " " + pirate.bounty));
        System.out.println("-----------------------------------------------");


        //Part C
        /*
        Comparator can be written using lambda. It simplifies the logic for readability.
        In this case, it is comparing integers (comparingInt) of every pirate in bigShots.
        It sorts the list from lowest -> highest but with reversed() it is now high -> low
         */
        System.out.println("Big shots ordered (Highest First)");
        bigShots.sort(Comparator.comparingInt((Pirate pirate) -> pirate.bounty).reversed());
        bigShots.forEach(pirate -> System.out.println(
                pirate.name + " " + pirate.role + " " + pirate.bounty));
        System.out.println("-----------------------------------------------");

        /*
        The stream API has a groupingBy method.
        This returns a map with the key being the condition you chose to group by
         */
        System.out.println("Pirates grouped by role");
        Map<String, List<Pirate>> groupedByRole = crew.stream()
                .collect(Collectors.groupingBy(pirate -> pirate.role));
        groupedByRole.forEach((role, group) -> {
            System.out.println("==" + role + "==");
            group.forEach(pirate -> System.out.println(
                    pirate.name + " " + pirate.bounty));
        });
        System.out.println("-----------------------------------------------");

        /*
        Method referencing is an even shorter form to write code.
        Can only be used if methods are being used to get something, not perform logic
         */
        System.out.println("Method Referencing");
        crew.stream()
                .map(pirate -> pirate.name) //converts every pirate obj into just its name
                .forEach(System.out::println); // pirate -> System.out.println(pirate.name)
        System.out.println("-----------------------------------------------");

        /*
        The .map method is part of the Stream API and is different from a Map data structure.
        It transforms data into a specified format.
        In this instance, it transforms every pirate into just the pirate name.
         */
        System.out.println("List of only pirate names");
        List<String> pirateNames = crew.stream().map(pirate -> pirate.name).toList();
        pirateNames.forEach(System.out::println);
        System.out.println("-----------------------------------------------");

        /*
        Reduce is a part of Stream API and adds up every value.
        For objects, the .map is needed to convert the obj into one type.
        Reduce needs an identifier (a place to start) and an operation to perform
         */
        System.out.println("Total bounty using reduce");
        int totalBounty = crew.stream()
                .map(pirate -> pirate.bounty)
                .reduce(0, (a,b) -> a+b);
        System.out.println("Total Bounty: $" + totalBounty);
        System.out.println("-----------------------------------------------");

        /*
        The anymatch is a part of the Stream API.
        It checks if a condition is present in a list.
        Works similar to .contains in ArrayList, the difference being .contains checks for an exact match
        but anymatch checks if a condition is true
         */
        System.out.println("Check if any pirate has bounty over 200 using anymatch");
        if (crew.stream().anyMatch(pirate -> pirate.bounty > 200))
            System.out.println("A pirate in the list has a bounty over 200");
        else System.out.println("No pirates with bounty over 200");
    }
}
