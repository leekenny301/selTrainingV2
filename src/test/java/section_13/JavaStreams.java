package section_13;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

    static ArrayList<String> names;

    public JavaStreams(){
        JavaStreams.names = new ArrayList<>();
    }

    public void classicIterator(){
        int count = 0;
        for (String name : names) {
            if (name.startsWith("A")) {
                count += 1;
                System.out.println(name);
            }
        }
        System.out.println(count);
    }

    public void streamFilterA(){
        Long c = names.stream().filter(name->name.startsWith("A")).count();
        System.out.println(c);
    }

    public void streamFilterAV2(){
        Long c = Stream.of("Amy", "Abigail", "Carson", "Lindy", "Berlinda", "Aaron", "Kenny")
                .filter(name -> name.startsWith("A")).count();
        System.out.println(c);
    }

    public void streamFilterFiveLetters(){
        // Storing it in a variable(using toList) and printing it
        List<String> x = names.stream().filter(s -> s.length() == 5).toList();
        x.forEach(System.out::println);

        // Direct printing without storing it in a variable
        // names.stream().filter(s -> s.length() == 5).toList().forEach(System.out::println);
    }

    public void streamMapUpperCase(){
        names.stream().filter(s -> s.endsWith("y")).map(String::toUpperCase).forEach(System.out::println);
    }

    public void streamMapUpperCaseSorted(){
        names.stream().filter(s -> s.endsWith("y")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }

    public void concatStream(){
        List<String> names = Arrays.asList("Celestie", "Bryan", "Enrica", "Damien");
        Stream<String> newStream = Stream.concat(JavaStreams.names.stream(), names.stream());
        Assert.assertTrue(newStream.anyMatch(s -> s.equalsIgnoreCase("Amy")));
//        newStream.sorted().forEach(System.out::println);
    }

    public void collectStream(){
        List<String> ls = JavaStreams.names.stream().filter(s -> s.contains("a")).sorted().map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(ls.get(1));

        //
        //print unique number from this array
        //sort the array

        List<Integer> intList = Arrays.asList(8,3,6,3,2,5,9,0,65,3);
        System.out.println("List numbers: ");
        intList.forEach(System.out::println);

        System.out.println("\nUnique numbers: ");
        intList.stream().distinct().forEach(System.out::println);

        System.out.println("\nSorted numbers: ");
        intList.stream().sorted().forEach(System.out::println);

        System.out.println("\nSorted and unique numbers: ");
        intList.stream().sorted().distinct().forEach(System.out::println);

        System.out.println("\nSorted and print first 4 elements: ");
        intList.stream().sorted().limit(4).forEach(System.out::println);

        System.out.println("\nSorted, Unique and print 3rd index: ");
        System.out.println(intList.stream().distinct().sorted().toList().get(3));

        System.out.println("\n--------Separator--------\n");
        int[] arrWithDups = {10, 3, 5, 3, 9, 22, 4, 3, 1, 5, 6 };
        Arrays.stream(arrWithDups).asLongStream().distinct().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        JavaStreams streams = new JavaStreams();
        names.addAll(Arrays.asList("Amy", "Abigail", "Carson", "Lindy", "Berlinda", "Aaron", "Kenny"));
//        streams.streamFilterA();
//        streams.streamFilterAV2();
//        streams.streamFilterFiveLetters();
//        streams.streamMapUpperCase();
//        streams.streamMapUpperCaseSorted();
//        streams.concatStream();
        streams.collectStream();



    }




}
