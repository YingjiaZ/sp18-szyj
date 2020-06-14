/** create Deque class */
public class LinkedListDeque<T> implements Deque<T> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** Create an empty linked list Deque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        sentinel.next = new IntNode(sentinel, item, sentinel.next);  //change sentinel.nest
        sentinel.next.next.prev = sentinel.next;  //change original first first item's "previous"
        size = size + 1;
    }

    /** Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        sentinel.prev = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size = size + 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    @Override
    public void printDeque() {
        IntNode ptr = this.sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return first;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size = size - 1;
        return last;
    }

    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
            index = index - 1;
        }
        T value = ptr.item;
        return value;
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(sentinel.next, index);
    }

    private T getHelper(IntNode N, int index) {
        if (index == 0) {
            return N.item;
        }
        return getHelper(N.next, index - 1);
    }
}
