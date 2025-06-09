import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Usando ArrayList como implementação
        List<Object> arrayList = new ArrayList<>();
        QueueBridge arrayListQueue = new ListQueueBridge(arrayList);
        AbstractQueue queue1 = new ConcreteQueue(arrayListQueue);

        List<Object> linkedList = new LinkedList<>();
        QueueBridge linkedListQueue = new ListQueueBridge(linkedList);
        AbstractQueue queue2 = new ConcreteQueue(linkedListQueue);

        queue1.queue("Item 1");
        queue1.queue("Item 2");
        queue2.queue("Item A");
        queue2.queue("Item B");
        queue2.queue("Item C");
        System.out.println("Tamanho da fila 1: " + queue1.size());
        System.out.println("Removendo 1º item da fila 1: " + queue1.dequeue());
        System.out.println("Tamanho da fila 1: " + queue1.size());
        System.out.println("Tamanho da fila 2: " + queue2.size());
        
    }
}