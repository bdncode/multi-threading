package bdn.multi.threading;

public class SynchronizedExchangerMain {

    public static void main(String[] args) {

        SynchronizedExchanger synchronizedExchanger = new SynchronizedExchanger();

        Thread thread1 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        synchronizedExchanger.setObjectWithSyncMethod("" + i);
                    }
                }
            }
        );

        Thread thread2 = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(synchronizedExchanger.getObjectWithSyncMethod());
                    }
                }
            }
        );

        thread1.start();
        thread2.start();
    }
}
