package bdn.multi.threading;

public class SynchronizedExchangerMain {

    public static void main(String[] args) {

        SynchronizedExchanger synchronizedExchanger = new SynchronizedExchanger();

        Thread setterThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        synchronizedExchanger.setObjectWithSyncMethod("" + i);
                    }
                }
            }
        );

        Thread getterThread = new Thread(
            new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(synchronizedExchanger.getObjectWithSyncMethod());
                    }
                }
            }
        );

        setterThread.start();
        getterThread.start();
    }
}
