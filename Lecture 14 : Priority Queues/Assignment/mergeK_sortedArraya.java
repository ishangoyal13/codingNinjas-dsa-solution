import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Triplet{
	int value;
	int rowIndex;
	int colIndex;
}
class TripletComparator implements Comparator<Triplet>{
	public int compare(Triplet a , Triplet b) {
		if(a.value <= b.value) {
			return -1;
		}
		return 1;
	}
}
public class Solution {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

		TripletComparator comparator = new TripletComparator();
		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>(comparator);
		for(int i=0;i<input.size();i++) {
			if(input.get(i)!=null) {
				Triplet a = new Triplet();
				a.value = input.get(i).get(0);
				a.rowIndex = i;
				a.colIndex = 0;
				priorityQueue.add(a);
			}			
		}
		ArrayList<Integer> arr = new ArrayList<>();
		while(!priorityQueue.isEmpty()) {
			
			Triplet a = priorityQueue.remove();
			arr.add(a.value);
			
			if( a.colIndex+1 <  input.get(a.rowIndex).size() ) {
				Triplet b = new Triplet();
				b.value = input.get(a.rowIndex).get(a.colIndex+1);
				b.rowIndex = a.rowIndex  ;
				b.colIndex = a.colIndex+1;
				priorityQueue.add(b);
			}
			
		}
		return arr;

	}

}
