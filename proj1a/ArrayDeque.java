/** build the ArrayDeque class, using arrays as the core data structure. */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Plus nextFirst or nextLast in circular. */
    private int plusOne(int next) {
        next += 1;
        if (next == items.length) {
            next = 0;
        }
        return next;
    }

    /** Minus nextFirst or nextLast in circular. */
    private int minusOne(int next) {
        next -= 1;
        if (next < 0) {
            next = items.length -  1;
        }
        return next;
    }
    /** Resize the array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int front = plusOne(nextFirst);
        int back = minusOne(nextLast);
        /* If "front" > "back", split items into two parts.
        The first part is at the back of the new array.*/
        if (front < back) {
            System.arraycopy(items, 0, a, 0, size);
        } else {
            System.arraycopy(items, front, a, 0, items.length - front);
            System.arraycopy(items, 0, a, items.length - front, back + 1);
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size = size + 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        plusOne(nextLast);
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
        int ptr = nextFirst;
        ptr = plusOne(ptr);
        int i = 0;
        while (i < size) {
            System.out.print(items[ptr] + " ");
            ptr = plusOne(ptr);
            i += 1;
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * consider usage factor >= 25% */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        int fp = plusOne(nextFirst);
        T first = items[fp];
        items[fp] = null;
        size = size - 1;
        nextFirst = fp;
        if (items.length >= 16 && items.length > 4 * size) {
            resize(size / 2);  // int/int = int
        }
        return first;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * consider usage factor >= 25% */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int lp = minusOne(nextLast);
        T last = items[lp];
        items[lp] = null;
        size = size - 1;
        nextFirst = lp;
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
