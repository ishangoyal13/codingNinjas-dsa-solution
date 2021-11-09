import java.util.ArrayList;
public class PQ {
	// Complete this class
    private ArrayList<Integer> heap;
    
	public PQ() {
		heap = new ArrayList<Integer>();
    }
	boolean isEmpty() {
		// Implement the isEmpty() function here
        return heap.size() == 0;
        
	}

	int getSize() {
		// Implement the getSize() function here
        return heap.size();
	}

	int getMax() {
		// Implement the getMax() function here
        if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return heap.get(0);
	}

	void insert(int element) {
		// Implement the insert() function here
        heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
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

	int removeMax() {
		// Implement the removeMax() function here
         if (isEmpty()) {
			return Integer.MIN_VALUE;
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
			if(heap.get(c1)>heap.get(min))
				min = c1;
			// first check whether the right child exists then compare for min
			if(c2 < heap.size() && heap.get(c2) > heap.get(min))
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
