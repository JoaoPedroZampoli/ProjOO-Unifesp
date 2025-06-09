public class ConcreteQueue extends AbstractQueue{
    public ConcreteQueue(QueueBridge queueBridge) {
        super(queueBridge);
    }

    @Override
    public void queue(Object o) {
        queueBridge.queue(o);
    }

    @Override
    public Object dequeue() {
        return queueBridge.dequeue();
    }

    @Override
    public boolean isEmpty() {
        return queueBridge.isEmpty();
    }

    @Override
    public int size() {
        return queueBridge.size();
    }
}
