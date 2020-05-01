import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class thread_main {

    public static void main(String[] args) {
        //thread num
        int thread_Num = 10;

        //Use PidManager from Assignment 1
        PidManager p1 = new PidManager();

        //Welcome text
        System.out.println("Running thread");
        System.out.println("Inside : " + Thread.currentThread().getName());

        //initial the Pid_Map for threads
        if(p1.allocate_map() == 1){
            System.out.println("Pid_Map initialized");
            System.out.println("Creating Runnable...");
            //Create 10 threads to run the Pid_map
            for(int i = 1; i <= thread_Num; i++){
                //Create runnable object to test
                createRunnable(p1);
            }
        } else {
            System.out.println("Failed to initialize map");
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Creating Runnable...Round 2");
        //Create 10 threads to run the Pid_map
        for(int i = 1; i <= thread_Num; i++){
            //Create runnable object to test
            createRunnable(p1);
        }


    }

    public static void createRunnable(PidManager p1) {
        //runnable object function
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            Integer pid = p1.allocate_Pid();
            if(pid != -1) {
                //Always check for open position in Pid_map
                //PID was assigned to the thread name,
                //Later we can get the name of PID value to release it.
                Thread.currentThread().setName(pid.toString());
                System.out.println("Running " + name + " Current Pid: " + pid + " allocated!");
            } else {
                pid = p1.allocate_Pid();
            }

            //Random between 1 - 10
            Integer threadSleepTime = (int)(Math.random() * 10 + 1);

            try {
                //Thread sleeps for a while - time is random
                // *1000 make it from milisec -> Sec
                Thread.sleep(threadSleepTime * 1000);
                Integer pidRelease = Integer.valueOf(currentThread().getName());
                //Release PID
                p1.releasePid(pidRelease);

                //Print out the thread with it and their allocated and released id
                System.out.println(name + " Released Pid: " + pid + " waited " + threadSleepTime + " secs.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        //thread start the runnable object
        Thread thread = new Thread(runnable);
        //Start the thread
        thread.start();
    }
}

