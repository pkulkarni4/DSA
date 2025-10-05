package others;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TestMapFunction {
    public static void main(String[] args) {
        convertStringListToIntUsingMap();
        flatMapExample();
        filterExamples();
        peekExample();
    }

    private static void peekExample() {
        List<String> addresses = Arrays.asList("1234, Main St, Fairfax VA", "234, Fairfax Dr, Chantilly, VA");
        addresses.stream()
                .peek(p-> System.out.println("\t stream(): "+ p))
                .filter(s -> s.startsWith("123"))
                .sorted()
                .peek(p -> System.out.println("\t sorted : " + p))
                .map(i -> MessageFormat.format("{0}\t", i))
                .forEach(System.out::print);
        System.out.println();

    }

    private static void filterExamples() {
        List<Integer> ints = Arrays.asList(1, 2, -4, 0, 2, 0, -1, 14, 0, -1);
        List<Integer> filtered = ints.stream()
                .filter(i -> i != 0)
                .filter(i -> i % 2 == 0)
                .distinct()
                .sorted()
                .toList();
        filtered.stream().map(i -> MessageFormat.format("{0}\t", i)).forEach(System.out::print);
        System.out.println();
        ints.stream()
                .filter(i -> i != 0)
                .filter(i -> i % 2 == 0)
                .distinct()
                .sorted()
                .map(i -> MessageFormat.format("{0}\t", i))
                .forEach(System.out:: print)
        ;
        System.out.println();
        Optional<Integer> maxInt = ints.stream()
                .filter(i -> i != 0)
                .filter(i -> i % 2 == 0)
                .distinct()
                .max((i, j) -> Integer.compare(i,j))
                ;
        System.out.println(maxInt.get());
    }

    private static void flatMapExample() {
        List<List<String>> melons = Arrays.asList(Arrays.asList("Gac", "Cantaloupe"), Arrays.asList("Hemi", "Gac", "Apollo"), Arrays.asList("Gac", "Hemi", "Cantaloupe"));
        List<String> distinctNames = melons.stream()
                .flatMap(Collection::stream)
                .distinct()
                .toList();
        distinctNames.stream().map(name -> MessageFormat.format("{0}\t", name)).forEach(System.out::print);
        System.out.println();
    }

    private static void convertStringListToIntUsingMap() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        stringList.stream().map(s -> MessageFormat.format("{0}\t", s)).forEach(System.out::print);
        System.out.println();
        List<Integer> integerList = stringList.stream()
                .map(Integer::parseInt)
                .toList();

        integerList.stream().map(i -> MessageFormat.format("{0}\t", i)).forEach(System.out::print);
        System.out.println();
    }
}
