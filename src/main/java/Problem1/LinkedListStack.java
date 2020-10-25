package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private LinkedList<T> data;

    public LinkedListStack() {
        data = new LinkedList<T>();
    }

    @Override
    public boolean push(T val) {
        data.add(val);
        return true;   // place holder
    }

    @Override
    public T pop() {
        T val = data.getLast();   // get last element
        data.removeLast();        //remove last element
        return val;   // return popped element
    }

    @Override
    public T peek() {
        T val = data.getLast();   // last element
        return val;   // return last element
    }

    @Override
    public int size() {
        return data.size();
    }
}
