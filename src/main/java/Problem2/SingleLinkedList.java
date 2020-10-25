package Problem2;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // copy constructor
    public SingleLinkedList(SingleLinkedList list) {
        this.head = list.head;
        this.size = list.size;
    }

    public int removeAll(int valueToRemove) {
        int count = 0; //counts how many removed

        if( head == null) {     //if empty, return 0
            return 0;
        }

        ListNode curr = head;           //current head
        ListNode trail = null;   //modified version of current linked list

        while (curr != null){
            if (curr.val == valueToRemove){     //if match is found
                if (curr == head) {             //if current matches this head
                    head = head.next;           //this head becomes the next
                    curr = head;                //update current
                    count++;                    //update count
                }else{
                    trail.next = curr.next;  //next value is put in place
                    curr = trail.next;       //current is now level with trailing
                    count++;                //update count
                }
            } else {
                trail = curr;    //value is passed back to trailing
                curr = curr.next;       //move to next current
            }
        }
        return count; // return number of nodes removed
    }

    // reverse the linked list nodes iteratively (no recursion)
    public void reverse() {                 //(with help from geeksforgeeks.org)
                                            //For a diagram (not in java):
                                            // https://media.geeksforgeeks.org/wp-content/cdn-uploads/RGIF2.gif
        ListNode last = null;               //3 pointers
        ListNode curr = head;
        ListNode next;

        while(curr != null){            //while there are still items in list
            next = curr.next;           //save next
            curr.next = last;           //reverse
            last = curr;                //last steps up 1
            curr = next;                //head moves up 1
        }
        head = last;
        // in-place

        //STUCK HERE
    }

    // do not change any function below

    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }
}
