public abstract class AbstractQueue {
    protected QueueBridge queueBridge;

    public AbstractQueue(QueueBridge queueBridge) {
        this.queueBridge = queueBridge;
    }

    // public void enqueue(Object item) {
    //     queueBridge.queue(item);
    // }

    // public Object dequeue(){
    //     return queueBridge.dequeue();
    // }

    // public int size(){
    //     return queueBridge.size();
    // }

    // public boolean isEmpty(){
    //     return queueBridge.isEmpty();
    // }
    public abstract void queue(Object o);
    public abstract Object dequeue();
    public abstract boolean isEmpty();
    public abstract int size();
}
