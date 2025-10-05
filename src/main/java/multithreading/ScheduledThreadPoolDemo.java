package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);//2 threads

        Runnable task1 = () -> System.out.println("Task 1 executed after 2 seconds - "+ Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task 2 is running every 3 seconds"+ Thread.currentThread().getName());

        //task 1 run once after 2 seconds delay
        scheduler.schedule(task1, 2, TimeUnit.SECONDS);

        //task 2 run every 3 seconds after 1 second delay
        scheduler.scheduleAtFixedRate(task2,1,3,TimeUnit.SECONDS);

        scheduler.schedule(() -> {System.out.print("Shutting down the scheduler..."); scheduler.shutdown();},10, TimeUnit.SECONDS);

    }
}