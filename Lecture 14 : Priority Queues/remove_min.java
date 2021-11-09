import java.util.ArrayList;

public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
        int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		int parent = 0;
		int c1 = parent*2+1;		// left child
		int c2 = parent*2+2;		// right child
		// the base termination condition of the while loop will be => leftChildIndex < heap.size()
		while(c1<heap.size())
		{
			// using a temp variable that will hold the minimum priority of the root, left and right child
			// initializing that varaible to the parent index
			int min = parent;
			// checking whether min < leftChild
			if(heap.get(c1)<heap.get(min))
				min = c1;
			// first check whether the right child exists then compare for min
			if(c2 < heap.size() && heap.get(c2) < heap.get(min))
				min = c2;
			
			// if min is still holding the index of parent then parent is the smallest => break the loop
			if(min == parent)
				break;
			// else do the swapping between the min and parent
			int t2 = heap.get(parent);
			heap.set(parent, heap.get(min));
			heap.set(min, t2);
			// now update the required indexes
			parent = min;
			c1 = parent*2+1;
			c2 = parent*2+2;
		}
		return temp;
	}
}

class PriorityQueueException extends Exception {

}
