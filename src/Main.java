import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test MyArrayList  
        System.out.println("Testing MyArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + Arrays.toString(arrayList.toArray())); // [10, 20, 30]

        arrayList.set(1, 25);
        System.out.println("After set(1, 25): " + Arrays.toString(arrayList.toArray())); // [10, 25, 30]  

        arrayList.remove(0);
        System.out.println("After remove(0): " + Arrays.toString(arrayList.toArray())); // [25, 30]  

        System.out.println("First element: " + arrayList.getFirst()); // 25  
        System.out.println("Last element: " + arrayList.getLast()); // 30  
        System.out.println("Size: " + arrayList.size()); // 2  
        System.out.println();

        // Test MyLinkedList  
        System.out.println("Testing MyLinkedList:");
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.add(1, "C");
        System.out.println("LinkedList: " + Arrays.toString(linkedList.toArray())); // [A, C, B]  

        linkedList.removeFirst();
        System.out.println("After removeFirst: " + Arrays.toString(linkedList.toArray())); // [C, B]  

        linkedList.removeLast();
        System.out.println("After removeLast: " + Arrays.toString(linkedList.toArray())); // [C]  
        System.out.println("First element: " + linkedList.getFirst()); // C  
        System.out.println("Size: " + linkedList.size()); // 1  
        System.out.println();

        // Test MyStack  
        System.out.println("Testing MyStack:");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack top: " + stack.peek()); // 3  
        System.out.println("Popped: " + stack.pop()); // 3  
        System.out.println("Stack top after pop: " + stack.peek()); // 2  
        System.out.println("Size: " + stack.size()); // 2  
        System.out.println();

        // Test MyQueue  
        System.out.println("Testing MyQueue:");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");
        System.out.println("Queue front: " + queue.peek()); // One  
        System.out.println("Dequeued: " + queue.dequeue()); // One  
        System.out.println("Queue front after dequeue: " + queue.peek()); // Two  
        System.out.println("Size: " + queue.size()); // 2  
        System.out.println();

        // Test MyMinHeap  
        System.out.println("Testing MyMinHeap:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        System.out.println("Min element: " + minHeap.getMin()); // 2  
        System.out.println("Extracted min: " + minHeap.extractMin()); // 2  
        System.out.println("Min element after extraction: " + minHeap.getMin()); // 5  
        System.out.println("Size: " + minHeap.size()); // 2  
    }
}  