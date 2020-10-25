package Problem1;

public class MinStack extends ArrayStack<Integer> {
    // okay to add member variables
    // can only use Stack interface and ArrayStack from this folder
    // do not use Java Stack
    private int min;    //minimum value
    private int[] minStack;
    private int index;

    public MinStack(int size) {
        // homework
        super(size); // place holder
        this.minStack = new int[size];
        this.index = 0;
    }

    @Override
    public boolean push(Integer val) {
        // homework
        if(index == 0){      //if the array is empty
            min = val;      //set min as val
            minStack[index] = min;
        }else{              //if array has more than 1 element
            if(min > val){  //check if val is less than the current min
                min = val;
                minStack[index] = min;
            }
        }
        index++; //private variable size incremented by 1
        return super.push(val);
    }

    @Override
    public Integer pop() {
        // homework
        int val = super.pop();

        index--;

        min = minStack[index];

        return val;
    }

    public Integer getMin() {
        // homework
        // loop of any kind is not allowed
        return min; // place holder
    }
}

