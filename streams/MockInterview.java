package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockInterview {
    public static void main(String[] args) {
        findUniqueChar();
    }

    private static void findUniqueChar(){
        String str = "programming";
        Set<Character> collect = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        System.out.println("output : "+collect);
    }

    private static void compareSeqVsParallel(){
        List<Integer> list = IntStream.range(1, 100_000_000).boxed().collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        long sum = list.parallelStream().mapToLong(num -> num).sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sum :: "+sum+" TimeTaken :: "+(endTime-startTime));

        long startTime2 = System.currentTimeMillis();
        long sum2 = list.stream().mapToLong(num -> num).sum();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Sum2 :: "+sum2+" TimeTaken :: "+(endTime2-startTime2));
    }

    private static void sortUsingMultiThread(){
        List<Employee> employeeList = new ArrayList<>();
        for(int i=1;i<=1_000_000;i++){
            employeeList.add(new Employee(""+i,Math.random()*1000));
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);
        try {
            forkJoinPool.submit(()->{
                List<Employee> collect = employeeList.parallelStream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                        .collect(Collectors.toList());
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void transactionproblem(){
        List<Integer> integerList = IntStream.range(1, 1_00_000_000).boxed().collect(Collectors.toList());

        int batchSize = 100_000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<integerList.size(); i+=batchSize) {
            List<Integer> batch = integerList.subList(i, Math.min(i + batchSize, integerList.size()));
            executorService.submit(() -> batch.stream().mapToLong(num -> num).sum());
        }
        executorService.shutdown();
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
