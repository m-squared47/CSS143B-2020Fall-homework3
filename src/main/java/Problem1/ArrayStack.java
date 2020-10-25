package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        this.size = capacity;
        Object array = new Object[capacity];
        data = (T[])array;
    }

    @Override
    public boolean push(T val) {

        return false;   // place holder
    }

    @Override
    public T pop() {
        // homework
        T val = null;   // place holder
        return val;   // place holder
    }

    @Override
    public T peek() {
        // homework
        T val = null;   // place holder
        return val;   // place holder
    }

    @Override
    public int size() {
        return size;
    }
}
