import java.util.ArrayList;
import java.util.Random;

public class Tests {
    class Node {
        int value;
        int priority;

        Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    MyPriorityQueueOfBinaryHeap<Integer> priorityQueueOfBinaryHeap = new MyPriorityQueueOfBinaryHeap<>();
    MyPriorityQueueOfArray<Integer> priorityQueueOfArray = new MyPriorityQueueOfArray<>();
    ArrayList<Node> nodes = new ArrayList<>();

    public ArrayList<Node> createNodes(int n) {
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Node((int) (- 100 + Math.random()*200), (int) (Math.random()*100)));
        }
        return arr;
    }

    public MyPriorityQueueOfBinaryHeap<Integer> createPQBH(int n) {
        MyPriorityQueueOfBinaryHeap<Integer> pq = new MyPriorityQueueOfBinaryHeap<>();
        for (int i = 0; i < n; i++) {
            pq.insert(nodes.get(i).value, nodes.get(i).priority);
        }
        return pq;
    }

    public MyPriorityQueueOfArray<Integer> createPQA(int n) {
        MyPriorityQueueOfArray<Integer> pq = new MyPriorityQueueOfArray<>();
        for (int i = 0; i < n; i++) {
            pq.insert(nodes.get(i).value, nodes.get(i).priority);
        }
        pq.sort();
        return pq;
    }

    public void printNodes() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println(nodes.get(i).value);
        }
    }

    public long[] testInsert() {
        long[] arrResults = new long[10];
        long cntTime;
        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(5000*(i+1));
                priorityQueueOfBinaryHeap = createPQBH(5000 * (i + 1));
                long start = System.nanoTime();

                priorityQueueOfBinaryHeap.insert(nodes.get(i).value, nodes.get(i).priority);

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i] = cntTime / cnt;
        }

        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(5000*(i+1));
                priorityQueueOfArray = createPQA(5000 * (i+1));
                long start = System.nanoTime();

                priorityQueueOfArray.insert(nodes.get(i).value, nodes.get(i).priority);

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i + 5] = cntTime/cnt;
        }
        return arrResults;
    }

    public long[] testExtractMax() {
        long[] arrResults = new long[10];
        long cntTime;
        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(2000 * (i + 1));
                priorityQueueOfBinaryHeap = createPQBH(2000 * (i + 1));
                long start = System.nanoTime();

                priorityQueueOfBinaryHeap.extractMax();

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i] = cntTime/cnt;
        }

        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(2000 * (i + 1));
                priorityQueueOfArray = createPQA(2000 * (i + 1));
                long start = System.nanoTime();

                priorityQueueOfArray.extractMax();

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i + 5] = cntTime/cnt;
        }
        return arrResults;
    }

    public long[] testIncrease() {
        long[] arrResults = new long[10];
        long cntTime;
        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(2000 * (i + 1));
                priorityQueueOfBinaryHeap = createPQBH(2000 * (i + 1));
                long start = System.nanoTime();

                priorityQueueOfBinaryHeap.increase(nodes.get(i + 10).value, 10);

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i] = cntTime/cnt;
        }

        for (int i = 0; i < 5; i++) {
            cntTime = 0;
            int cnt = 0;
            while (cnt < 5) {
                nodes = createNodes(2000 * (i + 1));
                priorityQueueOfArray = createPQA(2000 * (i + 1));
                long start = System.nanoTime();

                priorityQueueOfArray.increase(nodes.get(i + 10).value, 10);

                long finish = System.nanoTime();
                cntTime += (finish - start);
                cnt++;
            }
            arrResults[i + 5] = cntTime/cnt;
        }
        return arrResults;
    }

    public long[] test() {

        long[] arrResults = new long[6];

        MyPriorityQueueOfBinaryHeap<Integer> priorityQueueOfBinaryHeap = new MyPriorityQueueOfBinaryHeap<>();
        MyPriorityQueueOfArray<Integer> priorityQueueOfArray = new MyPriorityQueueOfArray<>();

        ArrayList<Node> nodes = new ArrayList<>();

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
//        for (int c = 1; c <= 100; c++) {
//            ArrayList<Node> nodes = createNodes();
//        }
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
