package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvancedStreams {
    public static void main(String[] args) {
        //Scenario: Parallel Stream vs Sequential Stream Performance
//        compareSequentialAndParallelStream();

//        Scenario: Multi-threaded Sorting Using Parallel Streams
//        parallelSorting();

//        Scenario: Custom Thread Pool in Parallel Streams
//        By default, parallel streams use the ForkJoin Pool. How can you control the number of threads?
//        customThreadPool();

//        Scenario: Optimizing Stream Operations with Lazy Evaluation
//    📌 Problem:
//        Given a list of words, convert them to uppercase and filter words starting with ‘A’.
//        Optimize performance without unnecessary operations.
//            lazyEvaluation();

//        Scenario: Batch Processing Using Streams
//                📌 Problem:
//        Given 1 million records, process them in batches of 100K for better memory efficiency.
        batchProcessing();
    }

    private static void batchProcessing(){
//        Key Takeaways:
//        Batch processing reduces memory overhead.
//                Avoids loading large datasets into memory at once.
        List<Integer> mainList = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());

        int batchSize = 100_000;
        for(int i=0;i<mainList.size();i+=batchSize){
            List<Integer> batchList = mainList.subList(i, Math.min(i + batchSize, mainList.size()));
            long sum = batchList.stream().mapToLong(num -> num).sum();
            System.out.println("Sum :: "+sum);
        }
    }

    private static void lazyEvaluation(){
        //Notes :
//        Streams are lazy, meaning intermediate operations don’t run until the
//        terminal operation (forEach(), collect()) is called.
//        Minimize unnecessary processing to improve performance.

        List<String> words = List.of("Apple", "Banana", "Avocado", "Grapes", "Apricot");

        Stream<String> stream = words.stream()
                .peek(w -> System.out.println("Mapping: " + w))
                .map(String::toUpperCase)
                .peek(w -> System.out.println("Filtering: " + w))
                .filter(w -> w.startsWith("A"));

        System.out.println("Final Output: ");
        stream.forEach(System.out::println);
    }

    private static void customThreadPool() {
//        Key Takeaways:
//        Default parallel streams use all CPU cores.
//                Custom thread pools allow manual control over parallelism.
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        try {
            forkJoinPool.submit(()->
                    IntStream.range(1,100)
                            .parallel()
                            .forEach(i->System.out.println(Thread.currentThread().getName()+" -> "+i))
                        ).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            forkJoinPool.shutdown();
        }
    }
    private static void parallelSorting(){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            employees.add(new Employee("Emp" + i, Math.random() * 100000));
        }

        long startTime = System.currentTimeMillis();
        List<Employee> collect = employees.parallelStream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream Sorted 1M Employees in " + (endTime - startTime) + "ms");

        long startTime2 = System.currentTimeMillis();
        List<Employee> collect2 = employees.parallelStream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        long endTime2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Sorted 1M Employees in " + (endTime2 - startTime2) + "ms");
    }

    private static void compareSequentialAndParallelStream(){
        List<Integer> list = IntStream.range(1, 1_0000_000).boxed().collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        long sum = list.stream().mapToLong(num -> num).sum();
        long endTime = System.currentTimeMillis();

        System.out.println("Sum :: "+sum+"\t TimeTaken :: "+(endTime-startTime));

        long startTime2 = System.currentTimeMillis();
        long sum2 = list.parallelStream().mapToLong(num->num).sum();
        long endTime2 = System.currentTimeMillis();

        System.out.println("Sum2 :: "+sum2+"\t TimeTaken :: "+(endTime2-startTime2));
    }


    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public double getSalary() { return salary; }
        public String getName() { return name; }
    }
}
