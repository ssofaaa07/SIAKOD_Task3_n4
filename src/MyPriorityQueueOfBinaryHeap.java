import java.util.ArrayList;

public class MyPriorityQueueOfBinaryHeap<T extends Comparable<T>> implements MyPriorityQueue<T> {

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
        size++;

        if (size > 1) {
            siftUp(size - 1);
        }
    }

    @Override
    public T extractMax() {
        T maxValue = heap.get(0).value;

        heap.get(0).value = heap.get(size - 1).value;
        heap.get(0).priority = heap.get(size - 1).priority;

        heap.remove(size - 1);
        size--;

        if (size > 1) {
            siftDown(0);
        }
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
        if (index != -1) {
            heap.get(index).priority += priority;
            siftDown(index);
        }
    }

    public void siftUp(int startIndex) {

        int index = startIndex;

        while (index > 0) {

            int parentIndex = (index % 2 == 0) ? ((index - 1) / 2) : (index / 2);

            if (heap.get(index).priority < heap.get(parentIndex).priority) {
                Node tmp = heap.get(index);
                heap.set(index, heap.get(parentIndex));
                heap.set(parentIndex, tmp);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void siftDown(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int largest = index;
        if (left < size && heap.get(left).priority < heap.get(index).priority) {
            largest = left;
        }
        if (right < size && heap.get(right).priority < heap.get(index).priority) {
            largest = right;
        }

        if (largest != index) {
            Node tmp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, tmp);
            siftDown(largest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            Node value = heap.get(i);
            System.out.println(value.value.toString() + ' ' + value.priority);
        }
    }


}
