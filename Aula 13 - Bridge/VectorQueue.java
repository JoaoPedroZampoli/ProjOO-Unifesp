import java.util.List;
import java.util.Vector;

public class VectorQueue implements Queue {
    private List<Object> list = new Vector<>();

    public void enqueue(Object item) {
        list.add(item);
    }

    public Object dequeue() {
        if (!isEmpty()) {
            return list.remove(0);
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
    
}
