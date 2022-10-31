import java.util.ArrayList;
import java.util.Random;

public class Tests {
    private class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
    public ArrayList<Node> createPQ() {
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add(new Node(new Random(100).nextInt(), new Random(100).nextInt()));
        }
        return arr;
    }

    public long[] test() {

        long[] arrResults = new long[6];

        MyPriorityQueueOfBinaryHeap<Integer> priorityQueueOfBinaryHeap = new MyPriorityQueueOfBinaryHeap<>();
        MyPriorityQueueOfArray<Integer> priorityQueueOfArray = new MyPriorityQueueOfArray<>();

        ArrayList<Node> nodes = createPQ();

        long cntTime = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();

            priorityQueueOfBinaryHeap.insert(nodes.get(i).value, nodes.get(i).priority);

            long finish = System.nanoTime();
            cntTime += ((finish - start));
        }
        arrResults[0] = cntTime / 100;

        cntTime = 0;
        for (int i = 0; i < 100; i++) {
            if (i > 1) {
                priorityQueueOfArray.sort();
            }
            long start = System.nanoTime();

            priorityQueueOfArray.insert(nodes.get(i).value, nodes.get(i).priority);

            long finish = System.nanoTime();
            cntTime += (finish - start);
        }
        arrResults[1] = cntTime / 100;
        priorityQueueOfArray.sort();

        cntTime = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();

            priorityQueueOfBinaryHeap.extractMax();

            long finish = System.nanoTime();
            cntTime += (finish - start);
        }
        arrResults[2] = cntTime / 100;

        cntTime = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();

            priorityQueueOfArray.extractMax();

            long finish = System.nanoTime();
            cntTime += (finish - start);
        }
        arrResults[3] = cntTime / 100;

        cntTime = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();

            priorityQueueOfBinaryHeap.increase(nodes.get(i).value, 10);

            long finish = System.nanoTime();
            cntTime += (finish - start);
        }
        arrResults[4] = cntTime / 100;

        cntTime = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.nanoTime();

            priorityQueueOfArray.insert(nodes.get(i).value, 10);

            long finish = System.nanoTime();
            cntTime += (finish - start);
        }
        arrResults[5] = cntTime / 100;

        return arrResults;
    }

    public void printResults() {
        for (int c = 1; c <= 100; c++) {
            ArrayList<Node> nodes = createPQ();
        }
        long[] arrResults = test();
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                System.out.println("Insert");
                System.out.println("Of Binary Heap: " + arrResults[0]);
            }
            if (i == 1) {
                System.out.println("Of Array: " + arrResults[1]);
            }
            if (i == 2) {
                System.out.println("Extract Max");
                System.out.println("Of Binary Heap: " + arrResults[2]);
            }
            if (i == 3) {
                System.out.println("Of Array: " + arrResults[3]);
            }
            if (i == 4) {
                System.out.println("Increase");
                System.out.println("Of Binary Heap: " + arrResults[4]);
            }
            if (i == 5) {
                System.out.println("Of Array: " + arrResults[5]);
            }
        }
    }

}
