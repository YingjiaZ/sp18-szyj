/** build the ArrayDeque class, using arrays as the core data structure. */
public class ArrayDeque<T> {
    T[] items;
    public int size;
    public int nextFirst;
    public int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = nextLast = 0;
    }

    /** Resize the array to the target capacity. */
    private void resize (int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        nextFirst = capacity - 1;
        nextLast = size;
        items = a;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size*2);
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        }
        nextFirst -= 1;
        size = size + 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size*2);
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        }
        nextLast += 1;
        size = size + 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < items.length; i += 1) {
            if (items[i] == null) {
                continue;
            }
            System.out.print(items[i] + " ");
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null.
     * consider usage factor >= 25% */
    public T removeFirst() {
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst = nextFirst + 1;
        }
        T first = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        if (items.length >= 16 && items.length > 4 * size) {
            resize(size / 2);  // int/int = int
        }
        return first;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * consider usage factor >= 25% */
    public T removeLast() {
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast = nextLast - 1;
        }
        T last = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        if (items.length >= 16 && items.length > 4 * size) {
            resize(size / 2);  // int/int = int
        }
        return last;
    }

    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        return items[index];
    }
}