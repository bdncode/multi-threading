package bdn.multi.threading;

public class ThreadSleep {

    public static void main(String[] args) {

        Runnable lambdaRunnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Lambda runnable interface " + name);
                Thread.sleep(1800);
                System.out.println("Finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread lambdaThread = new Thread(lambdaRunnable);
        lambdaThread.start();
    }
}
