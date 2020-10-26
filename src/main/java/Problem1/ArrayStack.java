package Problem1;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        this.size = 0;                              //size to 0
        this.data = (T[]) (new Object[capacity]);   //set new array for data
    }

    @Override
    public boolean push(T val) {

        if(data.length > size){     //if there are still empty spaces in array
            data[size] = val;       //data at index size-1 initialized to val
            size++;                 //increment size by 1
            return true;            //return true for assertion check
        }else{
            return false;
        }
    }

    @Override
    public T pop() {
        T val = data[size - 1]; //element popped
        data[size - 1] = null;      //element in data[] is null

        if(size > 0) {          //if more than one element
            size--;             //decrement size
        }

        return val;             //return popped value
    }

    @Override
    public T peek() {
        T val = data[size - 1];     //element at top of the stack
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
