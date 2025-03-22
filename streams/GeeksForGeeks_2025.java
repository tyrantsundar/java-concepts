package streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeeksForGeeks_2025 {
//    LINK : https://www.geeksforgeeks.org/java-8-interview-questions-and-answers/

    public static void main(String[] args) {

        //Stream geneartion
        geneateStream();

        //Collect elements in map
        collectElementInMap();
//
////        21. How to find duplicate elements in a Stream in Java?
//        findDuplicateElems(List.of(2,3,4,3,4,5,7,8,1,2));
////
////        22. Count occurrence of a given character in a string using Stream API in Java.
//        findCharacterCountInString("geeksforgeeks",'g');
//
////        23. How to get Slice of a Stream in Java?
//        getSliceOfList(List.of(0,1,2,3,4,5,6,7,8,9,10),3,7);
//
////        24. How to Reverse elements of a Parallel Stream in Java?
//        reverseElemsOfList();
//
////        25. Write a Program to Iterate over a Stream with Indices in Java 8.
//        iterateOverIndexInJava();

    }

    private static void geneateStream(){
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = integers.stream();
        System.out.println("Using list");
        stream.forEach(System.out::println);

        System.out.println("Using stream of");
        Stream<String> streamStr = Stream.of("A", "B", "C", "D");
        streamStr.forEach(System.out::println);

        System.out.println("Using generate ");
        List<Double> collect = Stream.generate(Math::random).limit(5).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

        System.out.println("Using iterator ");
        Stream<Integer> evenNumber = Stream.iterate(0, n -> n + 2).limit(5);
        evenNumber.forEach(System.out::println);
    }


    private static void collectElementInMap(){
        List<String> names = List.of("sundar", "prabu", "raj");
        int i=0;
        Map<Integer, String> collect = names.stream()
                .collect(Collectors.toMap(name -> name.length(), name -> name));
        System.out.println("Map :: "+collect);
    }
    private static void reverseElemsOfList(){
        List<Integer> list = Arrays.asList(217, 317, 417, 517);
        Stream<Integer> collect = list.stream().collect(reverseStream());
        System.out.println("ReversedList :: ");
        collect.forEach(System.out::println);
        System.out.println();
    }

    private static Collector<Integer, ? , Stream<Integer>> reverseStream(){
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    Collections.reverse(list);
                    return list.stream();
                }
        );
    }
    private static void findDuplicateElems(List<Integer> list){
        Set<Integer> set = new HashSet<>();
        List<Integer> collect = list.stream().filter(elem -> !set.add(elem)).collect(Collectors.toList());
        System.out.println("Duplicate Elements :: "+collect);
    }

    private static void findCharacterCountInString(String str, char ch){
        long count = str.chars().filter(c-> c == ch).count();
        System.out.println(String.format("Count of character %s is %s.",ch,count));
    }

    private static void getSliceOfList(List<Integer> list, int startIndex , int endIndex ){
//        APPROACH : 1
//        List<Integer> ansList = new ArrayList<>();
//        IntStream.range(startIndex,endIndex+1).forEach(index -> ansList.add(list.get(index)));
//        System.out.println("Sliced List "+ansList);

//        APPROACH : 2
        List<Integer> ansList = list.stream()
                                    .skip(startIndex)
                                    .limit(endIndex - startIndex + 1)
                                    .collect(Collectors.toList());
        System.out.print("Sliced List :: ");
        ansList.stream().forEach(System.out :: print);
        System.out.println();
    }

    private static void iterateOverIndexInJava(){
        String[] arr = new String[]{"H","E","L","L","O"};
        IntStream.range(0, arr.length)
                .mapToObj(val -> String.format(arr[val]+" : "+val))
                .forEach(System.out::println);
    }


}
