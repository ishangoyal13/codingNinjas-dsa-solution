import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] edges = new int[n][n];
		for(int i=0;i<e;i++) {
			int se = scanner.nextInt();
			int ee = scanner.nextInt();
			edges[se][ee] = 1;
			edges[ee][se] = 1;
		}
		System.out.println(isConnected(edges,0));
    }
    public static boolean isConnected(int[][] edges,int sv) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            for(int i=0;i<edges.length;i++) {
                if(!visited[i] && edges[front][i] ==1) {
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }
        return true;



    }
	
}
