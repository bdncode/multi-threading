package bdn.multi.threading;

public class StoppableRunnable implements Runnable {

    private boolean stopRequested = false;

    public synchronized void requestStop() {
        this.stopRequested = true;
    }

    public boolean isStopRequested() {
        return this.stopRequested;
    }

    private void trySleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("StoppableRunnable started");
        while (!isStopRequested()) {
            trySleep(1800);
            System.out.println("StoppableRunnable running...");
        }
        System.out.println("StoppableRunnable stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread stoppableThread = new Thread(stoppableRunnable, "Main thread");
        stoppableThread.start();

        Thread.sleep(5000);

        System.out.println("Requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("Stop requested");
    }
}
