import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = getNode(index);
        current.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = getNode(index);
            MyNode prev = current.prev;
            newNode.next = current;
            newNode.prev = prev;
            current.prev = newNode;
            if (prev != null) {
                prev.next = newNode;
            }
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = getNode(index);
        MyNode prev = current.prev;
        MyNode next = current.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next; // Removing the head
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev; // Removing the tail
        }

        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IllegalStateException("List is empty.");
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // List is now empty
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IllegalStateException("List is empty.");
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List is now empty
        }
        size--;
    }

    @Override
    public void sort() {
        // Simple bubble sort implementation for demonstration. A more efficient sort can be used.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (((Comparable<T>) get(j)).compareTo(get(j + 1)) > 0) {
                    T temp = get(j);
                    set(j, get(j + 1));
                    set(j + 1, temp);
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}