import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Clear the last element.
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        Arrays.sort((T[]) elements, 0, size, null);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, Math.max(INITIAL_CAPACITY, minCapacity * 2));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }
}