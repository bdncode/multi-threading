package bdn.multi.threading;

public class SynchronizedCounter {

    private int balance = 0;
    private int synchronizedBalance = 0;

    public static void main(String[] args) {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        synchronizedCounter.balance();
    }

    public void balance() {

        Runnable addRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    add();
                    synchronizedAdd();
                }
            }
        };

        Runnable subtractRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    subtract();
                    synchronizedSubtract();
                }
            }
        };

        try {
            Thread addThread = new Thread(addRunnable);
            Thread subtractThread = new Thread(subtractRunnable);

            addThread.start();
            subtractThread.start();

            addThread.join();
            subtractThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(balance);
        System.out.println(synchronizedBalance);
    }

    public void add() {
        balance++;
    }

    public void subtract() {
        balance--;
    }

    public void synchronizedAdd() {
        synchronized (this) {
            synchronizedBalance++;
        }
    }

    public void synchronizedSubtract() {
        synchronized (this) {
            synchronizedBalance--;
        }
    }
}
