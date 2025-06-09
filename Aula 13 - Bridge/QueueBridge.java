
public interface QueueBridge {
    void queue(Object item);
    Object dequeue();
    int size();
    boolean isEmpty();
}
