import java.util.HashMap;
public class Solution {

	public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr1) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		for(int i : arr2) {
			
			if(map.containsKey(i) && map.get(i) >0) {
				System.out.println(i);
				map.put(i, map.get(i)-1);
			}
			
		}

	}
}
