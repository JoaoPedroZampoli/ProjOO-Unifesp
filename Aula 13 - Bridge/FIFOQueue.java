public class FIFOQueue implements Queue {
    private Queue queue;

    public FIFOQueue(Queue queue){
        this.queue = queue;
    }

    @Override
    public void enqueue(Object item) {
        queue.enqueue(item);
    }

    @Override
    public Object dequeue() {
        return queue.dequeue();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
