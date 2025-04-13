public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        int index = heap.size() - 1;
        bubbleUp(index);
    }

    public T extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty.");
        T min = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();
        bubbleDown(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty.");
        return heap.getFirst();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex).compareTo(heap.get(index)) <= 0) break;

            // Swap
            T temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(index));
            heap.set(index, temp);
            index = parentIndex;
        }
    }

    private void bubbleDown(int index) {
        while (index < heap.size()) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }
            if (smallest == index) break; // Heap property is satisfied

            // Swap
            T temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);
            index = smallest;
        }
    }
}