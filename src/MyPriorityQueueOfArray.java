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
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap.get(i).priority > priority) {
                index = i;
            }
        }

        if (index == -1) {
            heap.add(new Node(value, priority));
        } else {
            heap.add(index - 1, new Node(value, priority));
        }
        size++;
//        else {
//            heap.add(new Node(heap.get(size - 1).value, heap.get(size - 1).priority));
//            size++;
//
//            for (int j = size - 2; j > index; j--) {
//                T value1 = heap.get(j - 1).value;
//                int priority1 = heap.get(j - 1).priority;
//                heap.get(j).value = value1;
//                heap.get(j).priority = priority1;
//            }
//            heap.get(index).value = value;
//            heap.get(index).priority = priority;
//        }
    }

    @Override
    public T extractMax() {
        T maxValue = heap.remove(0).value;
        size--;
        return maxValue;
    }

    @Override
    public void increase(T value, int priority) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap.get(i).value.equals(value)) {
                index = i;
            }
        }
        if (index == -1) {
            return;
        } else {
            heap.get(index).priority += priority;
            for (int j = index; j < size - 1; j++) {
                if (heap.get(j).priority > heap.get(j + 1).priority) {
                    Node tmp = heap.get(j);
                    heap.set(j, heap.get(j + 1));
                    heap.set(j + 1, tmp);
                } else {
                    return;
                }
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
