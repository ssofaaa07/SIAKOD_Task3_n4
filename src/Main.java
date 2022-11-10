import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Tests test = new Tests();
//        test.printResults();
//
//        MyPriorityQueueOfBinaryHeap<Integer> pq = new MyPriorityQueueOfBinaryHeap<>();
//        pq.insert(1,1);
//        pq.insert(2,5);
//        pq.insert(3,0);
//        pq.insert(4,6);
//        pq.insert(5,2);
//        System.out.println("max = " + pq.extractMax());
//        pq.increase(5,7);
//        pq.printHeap();

        for (int i = 0; i<10; i++) {
            ArrayList<Tests.Node> nodes = test.createNodes(10000 * (i+1));
        }

        test.printNodes();

        System.out.println();
        long[] arrResultsInsert = test.testInsert();
//        long[] arrResultsExtractMax = test.testExtractMax();
//        long[] arrResultsIncrease = test.testIncrease();

        System.out.println("insert");
        for (int i = 0; i<10; i++){
            System.out.println(arrResultsInsert[i]);
            if (i == 4) {
                System.out.println("--");
            }
        }
//        System.out.println();
//        System.out.println("extract max");
//        for (int i = 0; i<10; i++){
//            System.out.println(arrResultsExtractMax[i]);
//            if (i == 4) {
//                System.out.println("--");
//            }
//        }
//        System.out.println();
//        System.out.println("increase");
//        for (int i = 0; i<10; i++){
//            System.out.println(arrResultsIncrease[i]);
//            if (i == 4) {
//                System.out.println("--");
//            }
//        }
    }
}