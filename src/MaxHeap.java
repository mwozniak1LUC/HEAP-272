import java.util.*;

public class MaxHeap<E extends Comparable<E>> extends ArrayList<E>   {
    ArrayList<E> heap;

    /** constructs empty heap **/
    public MaxHeap(){
        heap = new ArrayList<E>();
    }

    /** returns index of parent of currentIndex **/
    public int parent(int currentIndex) {
        if (currentIndex == 0) {
            throw new IllegalArgumentException("Invalid index (no parent)");
        } else {
            return ((currentIndex - 1) / 2);
        }
    }

    /** returns index of leftChild of currentIndex **/
    public int leftChild(int currentIndex){
        return currentIndex * 2 + 1;
    }

    /** returns index of rightChild of currentIndex **/
    public int rightChild(int currentIndex){
        return currentIndex * 2 + 2;
    }


    /** returns max value in the heap **/
    public E findMax() {
        if (this.heap.get(0) != null)
            return this.heap.get(0);
        else {
            return null;
        }
    }

    /** adds new value to heap and swaps it to it's correct position using siftUp**/
    public void addHeap(E val) {
        this.heap.add(val);
        siftUp(this.heap.size() - 1);
    }

    /** swaps max value with last value and then returns swapped value to appropriate position, removing and returning max **/
    public E removeHeap() {
        E max = findMax();
        Collections.swap(this.heap, 0, this.heap.size() - 1);
        this.heap.remove(this.heap.size() - 1);
        siftDown(0);
        return max;
    }

    public void siftUp(int current) {
        while (current > 0 && this.heap.get(parent(current)).compareTo(this.heap.get(current)) < 0) {
            Collections.swap(this.heap, current, parent(current));
            current = parent(current);
        }
    }

    public void siftDown(int current) {
        while (leftChild(current) < this.heap.size()) {
            int toSwap = leftChild(current);
            if (toSwap + 1 < this.heap.size() && this.heap.get(toSwap + 1).compareTo(this.heap.get(toSwap)) > 0) {
                toSwap = rightChild(current);
            }
            if (this.heap.get(current).compareTo(this.heap.get(toSwap)) > 0)
                break;
            Collections.swap(this.heap, current, toSwap);
        }
    }



    /** takes a list of items E and builds the heap and then prints, decreasing values of E with calls to removeHeap(). **/
    public void heapSort(List<E> list) {
        buildHeap(list);
        while (this.heap.size() > 0) {
            System.out.println(removeHeap());
        }
    }

    /** merges the other maxheap with this maxheap to produce a new maxHeap. **/
    public void heapMerge(MaxHeap<E> other){
        while (other.size() > 0) {
            this.add(other.removeHeap());
        }
    }

    /** takes a list of items E and builds the heap by calls to addHeap(..) **/
    public void buildHeap(List<E> list) {
        for (E i : list) {
            addHeap(i);
        }
    }
}
