package streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatGPTScenarioBased {
    public static void main(String[] args) {
        //  Find the Most Frequent Word in a Sentence
        findFreq();

        // Find the Second Highest Salary
        findSecondHighest();

        //Convert a Nested List into a Single List
        convertNestedLoop();

//        Find the Longest Word in a List
        findLongestWord();

//        Find Numbers That Appear Exactly Twice
        findFreqTwoNumbers();

//       Group Employees by Department
        groupEmployeesBasedOnDept();

//        Reverse a List Without Using Collections.reverse()
        reverseList();

        findNonRepeatongChar();
    }

    private static void findNonRepeatongChar(){
        String input = "swiss";
        Character nonRepeatingChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("NonRepeatingChar :: "+nonRepeatingChar);
    }

    private static void reverseList(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> collect = IntStream.range(0, numbers.size())
                .mapToObj(i -> numbers.get(numbers.size() - i - 1))
                .collect(Collectors.toList());
        System.out.println("ReversedList :: "+collect);
    }
    private static void groupEmployeesBasedOnDept(){
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("Dave", "Finance")
        );

        Map<String, List<String>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        System.out.println(grouped);
    }

    private static void findFreqTwoNumbers(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 5, 1, 6, 7, 5, 8,1);
        Map<Integer, Long> collect = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        List<Integer> collect1 = collect.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Freq 2 numbers :: "+collect1);
    }

    private static void findLongestWord(){
        List<String> words = List.of("elephant", "dog", "rhinoceros", "cat");
        Map<String, Integer> map = words.stream()
                                        .collect(Collectors.toMap(word -> word, word -> word.length()));
        String key = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Longest word :: "+key);

//        List<String> words = List.of("elephant", "dog", "rhinoceros", "cat");
//
//        String longestWord = words.stream()
//                .max(Comparator.comparingInt(String::length))
//                .orElse("No words");
//
//        System.out.println(longestWord); // Output: rhinoceros
    }

    private static void convertNestedLoop(){
        List<List<Integer>> nestedList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );

        List<Integer> collect = nestedList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("Nested loop :: "+collect);
    }

    private static void findSecondHighest(){
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 77, 99);
        Optional<Integer> optional = integers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("Second hoghest :: "+optional.get());
    }

    private static void findFreq(){
        String sentence = "apple banana apple orange banana apple orange apple";
        Map<String, Long> freqMap= Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        String key = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        System.out.println("Max freq string :: "+key);

    }

    private static void topRepeatedWords() throws IOException {
        Map<String, Long> wordCount = Files.lines(Paths.get("/filePath.txt"))
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<String> repeatedWords = wordCount.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(10)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("Top repeated words "+repeatedWords);
    }

    static class Employee {
        String name, department;
        Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }
        public String getDepartment() { return department; }
        public String getName() { return name; }
    }
}


