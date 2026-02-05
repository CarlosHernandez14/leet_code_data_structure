import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreads implements Runnable {


    @Override
    public void run() {

    }

    public static void main(String[] args) {
        TestThreads t = new TestThreads();
        Thread thread = new Thread(t);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(thread);
    }
}
