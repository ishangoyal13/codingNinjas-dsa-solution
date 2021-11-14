import java.util.Comparator; 
import java.util.PriorityQueue;
public class Solution { 
    public static void findMedian(int arr[]) { 
        int n = arr.length; 
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(new Comparator<Integer>() 
    { 
        public int compare(Integer first, Integer second) { 
            return (second - first); }
    });
        PriorityQueue<Integer> higherHalf = new PriorityQueue<>(); 
        int median; 
        for(int size = 1; size <= n; size++) { 
            if(!lowerHalf.isEmpty() && lowerHalf.peek() > arr[size-1])
            {
                lowerHalf.add(arr[size - 1]); 
                if(lowerHalf.size() > higherHalf.size() + 1) {
                    higherHalf.add(lowerHalf.poll());
                }
            } else { higherHalf.add(arr[size - 1]); 
                    if(higherHalf.size() > lowerHalf.size() + 1) {
                        lowerHalf.add(higherHalf.poll()); }
                   } if(size % 2 == 1) { 
                if(higherHalf.size() > lowerHalf.size()) {
                    median = higherHalf.peek();
                } else { 
                    median = lowerHalf.peek(); 
                }
            }
            else {
                median = (lowerHalf.peek() + higherHalf.peek()) / 2;
                   }
            System.out.print(median + " ");
        }
    }
}
