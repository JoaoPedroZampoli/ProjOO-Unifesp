import java.util.List;

public class ListQueueBridge implements QueueBridge{
    private List<Object> list;

    public ListQueueBridge(List<Object> list) {
        this.list = list;
    }

    @Override
    public void queue(Object item){
        list.add(item);
    }

    @Override
    public Object dequeue(){
        if(!isEmpty()){
            return list.remove(0);
        }
        else{
            throw new RuntimeException("Queue is empty");
        }
    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
}