package bdn.multi.threading;

import java.util.Scanner;

public class VolatileCounter {

    public static void main(String[] args) {
        ExtendedThread extendedThread = new ExtendedThread();
        extendedThread.start();

        Scanner requestStop = new Scanner(System.in);
        requestStop.nextLine();

        extendedThread.requestStop();
    }

    private static class ExtendedThread extends Thread {

        private volatile boolean stopRequested = false;
        private int counter = 0;

        public void run() {
            while (!stopRequested) {
                try {
                    System.out.println(counter);
                    counter++;
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void requestStop() {
            stopRequested = true;
        }
    }
}
