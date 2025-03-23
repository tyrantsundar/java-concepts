package concurrency.thread_q3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        CallableDemo t1 = new CallableDemo(1,10);
        CallableDemo t2 = new CallableDemo(20,22);
        CallableDemo t3 = new CallableDemo(1,3);

        List<Integer> result = new ArrayList<>();
        result.add(t1.call());
        result.add(t2.call());
        result.add(t3.call());

        System.out.println("result ::: "+result);
    }
}
