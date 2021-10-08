import java.util.*;

public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {
    ArrayList<E> heap;

    /** constructs empty heap **/
    public MaxHeap(){
        this.heap = new ArrayList<E>();
    }

    /** returns max value **/
    public E findMax() {
        return this.heap.get(0);
    }

    /** swaps two given positions in heap **/
    private void swap(int position1, int position2) {
        E holder = this.heap.get(position1);
        this.heap.set(position1, this.heap.get(position2));
        this.heap.set(position2, holder);
    }

    /** adds new value to heap and swaps it to it's correct position **/
    public void addHeap(E val) {
        int current = this.heap.size();
        this.heap.add(val);
        while(this.heap.get((current - 1) / 2).compareTo(val) < 0) {
            int parent = (current - 1) / 2;
            this.swap(parent, current);
            current = parent;
        }
    }

    //returns the max value at the root of the heap by swapping the last value
    // and percolating the value down from the root to preserve max heap property
    // children of node at i are given by the formula 2i+1,2i+2, to not exceed the
    // bounds of the Heap index, namely, 0 ... size()-1.
    // throw appropriate exception
    public E removeHeap() {

    }

    // takes a list of items E and builds the heap and then prints
    // decreasing values of E with calls to removeHeap().
    public void heapSort(List<E> list){

    }

    // merges the other maxheap with this maxheap to produce a new maxHeap.
    public void heapMerge(MaxHeap<E> other){
        for (E val: other.heap) {
            this.add(val);
        }
    }

    //takes a list of items E and builds the heap by calls to addHeap(..)
    public void buildHeap(List<E> list) {
        for (E val: list) {
            addHeap(val);
        }
    }

    public void print() {
        int row = 1;
        int count = 0;

        for (E i: this.heap) {
            if (count == row) {
                System.out.println();
                count = 0;
                row++;
            }

            System.out.printf("%d ", i);
            count++;
        }
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        ArrayList<Integer> arrl = new ArrayList<>();
        arrl.add(9);
        arrl.add(7);
        arrl.add(10);
        arrl.add(99);

        h.buildHeap(arrl);
        h.print();
    }


}
