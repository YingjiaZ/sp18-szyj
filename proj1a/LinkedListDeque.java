/** create Deque class */
public class LinkedListDeque<T> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode Prev;
        public T item;
        public IntNode Next;

        public IntNode(IntNode p, T i, IntNode n) {
            Prev = p;
            item = i;
            Next = n;
        }
    }

    /** Create an empty linked list Deque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.Prev = sentinel;
        sentinel.Next = sentinel;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.Next = new IntNode(sentinel, item, sentinel.Next);  //change sentinel.nest
        sentinel.Next.Next.Prev = sentinel.Next;  //change original first first item's "previous"
        size = size + 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.Prev = new IntNode(sentinel.Prev, item, sentinel);
        sentinel.Prev.Prev.Next = sentinel.Prev;
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
        IntNode ptr = this.sentinel.Next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.Next;
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T first = sentinel.Next.item;
        sentinel.Next = sentinel.Next.Next;
        sentinel.Next.Prev = sentinel;
        size = size - 1;
        return first;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T last = sentinel.Prev.item;
        sentinel.Prev = sentinel.Prev.Prev;
        sentinel.Prev.Next = sentinel;
        size = size - 1;
        return last;
    }

    /**  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque! */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode ptr = sentinel.Next;
        while (index != 0) {
            ptr = ptr.Next;
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
         return getHelper(sentinel.Next, index);
    }

    private T getHelper(IntNode N, int index) {
        if (index == 0) {
            return N.item;
        }
        return getHelper(N.Next,index - 1);
    }
}