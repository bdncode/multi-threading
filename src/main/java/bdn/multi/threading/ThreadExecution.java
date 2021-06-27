package bdn.multi.threading;

public class ThreadExecution {

    //    Four ways to specify Thread execution
    public static void main(String[] args) {

//      1 Implement the Runnable interface with an anonymous class
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println("Anonymous runnable interface " + name);
            }
        };

        Thread anonymousThread = new Thread(anonymousRunnable);
        anonymousThread.start();

//      2 Implement the Runnable interface with a Java Lambda Expression
        Runnable lambdaRunnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println("Lambda runnable interface " + name);
        };

        Thread lambdaThread = new Thread(lambdaRunnable);
        lambdaThread.start();

//      3 Create a subclass of the Thread class
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.start();

//      4 Create a class that implements the Runnable interface
        Thread implementedThread = new Thread(new ImplementedThread());
        implementedThread.start();
    }

    private static class ExtendedThread extends Thread {

        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Extended thread class " + name);
        }
    }

    private static class ImplementedThread implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Implemented thread class " + name);
        }
    }
}
