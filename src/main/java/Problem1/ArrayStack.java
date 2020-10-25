package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        this.size = 0;
        this.data = (T[]) new Object[capacity];
    }

    @Override
    public boolean push(T val) {
        if(size == data.length){
            return false;
        }else{
            this.data[size] = val;          //data[] stays null for some reason
            size++;                         //even after hours of debug mode
            return true;
        }
    }

    @Override
    public T pop() {
        T val = data[size - 1]; //element popped
        data[size] = null;      //element in data[] is null

        if(size > 0) {          //if more than one element
            size--;             //decrement size
        }

        return val;             //return popped value
    }

    @Override
    public T peek() {
        T val = data[size];     //element at top of the stack
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
