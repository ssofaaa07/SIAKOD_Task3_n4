import java.util.ArrayList;

public class MyPriorityQueueOfArray<T extends Comparable<T>> implements MyPriorityQueue<T>{

    private class Node {
        T value;
        int priority;

        Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    ArrayList<Node> heap = new ArrayList<>();
    int size = 0;

    @Override
    public void insert(T value, int priority) {
        heap.add(new Node(value, priority));
        sort();
        size++;
    }

    @Override
    public T extractMax() {
        T maxValue = heap.remove(0).value;
        size--;
        return maxValue;
    }

    @Override
    public void increase(T value, int priority) {
        for (int i = 0; i < size; i++) {
            if (heap.get(i).value.equals(value)) {
                heap.get(i).priority += priority;
                sort();
                break;
            }
        }
    }

    public void sort() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (heap.get(j + 1).priority < heap.get(j).priority) {
                    T value1 = heap.get(j).value;
                    T value2 = heap.get(j + 1).value;
                    int priority1 = heap.get(j).priority;
                    int priority2 = heap.get(j + 1).priority;
                    heap.get(j).value = value2;
                    heap.get(j).priority = priority2;
                    heap.get(j + 1).value = value1;
                    heap.get(j + 1).priority = priority1;
                }
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            Node value = heap.get(i);
            System.out.println(value.value.toString() + ' ' + value.priority);
        }
    }
}
