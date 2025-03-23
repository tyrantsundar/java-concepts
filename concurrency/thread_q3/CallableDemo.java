package concurrency.thread_q3;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CallableDemo implements Callable<Integer> {
    private int start;
    private int end;

    public CallableDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer call() throws Exception {
        return (int)IntStream.range(start,end+1).mapToLong(num->num).sum();
    }
}
