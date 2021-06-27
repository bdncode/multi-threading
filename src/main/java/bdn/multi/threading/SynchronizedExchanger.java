package bdn.multi.threading;

public class SynchronizedExchanger {

    private Object object;
    private Object synchronizedObject;

    public synchronized void setObjectWithSyncMethod(Object o) {
        this.synchronizedObject = o;
    }

    public synchronized Object getObjectWithSyncMethod() {
        return this.synchronizedObject;
    }

    public void setObjectWithSyncBlock(Object o) {
        synchronized (this) {
            this.synchronizedObject = o;
        }
    }

    public Object getObjectWithSyncBlock() {
        synchronized (this) {
            return this.synchronizedObject;
        }
    }

    public void setObject(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return this.object;
    }
}
