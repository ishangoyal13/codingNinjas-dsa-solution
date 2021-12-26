import java.util.*;
public class Solution {

	public static int numConnected(int[][] edges, int n) {
        
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        boolean visited[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i])
                count=count+countIsland(edges,i,visited);
        }
        return count;
    }
    public static int countIsland(int edges[][],int sv,boolean visited[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        int n=edges.length;
        while(!q.isEmpty()){
            int front=q.remove();
            for(int i=0;i<n;i++){
                if(edges[front][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        return 1;
    }


}
