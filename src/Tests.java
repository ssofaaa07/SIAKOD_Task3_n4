public class Tests {

    public void test() {

        MyPriorityQueueOfArray<Integer> pq = new MyPriorityQueueOfArray<>();
        pq.insert(1,1);
        pq.insert(2,5);
        pq.insert(3,0);
        pq.insert(4,6);
        pq.insert(5,2);
        System.out.println("max = " + pq.extractMax());
        pq.increase(5,7);
        pq.printHeap();

    }

}
