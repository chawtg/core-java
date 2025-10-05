package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); //3 threads

        Runnable task= () -> System.out.println("Running in thread: "+ Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Submit 3 tasks
        for (int i=1; i <= 3; i++){
            executor.submit(task);
        }

        executor.shutdown();
    }
}