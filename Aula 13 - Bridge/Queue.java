public interface Queue {
    void enqueue(Object item);
    Object dequeue();
    boolean isEmpty();
    int size();
}
