import java.util.HashMap;
public class Solution {

    public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : arr) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1 );
			}else {
				map.put(i, 1);
			}
		}
		int maxFreq = 0;
		int max = Integer.MIN_VALUE;
		for(int i : arr) {
			if( maxFreq < map.get(i) ) {
				maxFreq = map.get(i);
				max = i;
			}
		}
		return max;
    }
}
