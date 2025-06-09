import java.util.ArrayList;
import java.util.List;

public class ArrayListQueue implements Queue {
    //private List list = new ArrayList();
    List <Object> list = new ArrayList<>();

    public void enqueue(Object item){
        list.add(item);
    }

    public Object dequeue(){
        if(!isEmpty()){
            return list.remove(0);
        }
        else{
            throw new RuntimeException("Queue is empty");

        }
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }
}
