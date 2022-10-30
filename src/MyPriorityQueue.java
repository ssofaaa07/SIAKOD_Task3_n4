public interface MyPriorityQueue<T extends Comparable<T>> {

    public void insert(T value, int priority);

    public T extractMax();

    public void increase(T value, int priority);
}
