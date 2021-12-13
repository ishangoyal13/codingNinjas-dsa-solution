public class Solution {
	
	 int solve(String[] Graph , int N, int M)
	{
		String searchingString = "CODINGNINJA";
		boolean[][] visited = new boolean[Graph.length][];
		for(int i=0;i<Graph.length;i++) {
			visited[i] = new boolean[Graph[i].length()];
		}

		for(int i=0;i<Graph.length;i++) {

			for(int j=0;j<Graph[i].length();j++) {
				if(Graph[i].charAt(j) == 'C' ) {
					
					boolean ans =  dfs( Graph,visited,searchingString.substring(1),i,j);
					if(ans) {
						return 1;
					}
                   

				}
			}

		}
		return 0;

	}

	public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {

		if(searchString.length() == 0) {
			visited[i][j] = true;
			return true;
		}

		visited[i][j] = true;
		// To traverse in 8 different directions
		int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
		int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };

		for(int k=0;k<X_Dir.length;k++) {

			int x = i+ X_Dir[k];
			int y = j+ Y_Dir[k];

			if( x>=0 && y>=0 && x< graph.length &&
					y < graph[x].length() && 
					graph[x].charAt(y) ==searchString.charAt(0) && !visited[x][y]  ) {

				boolean smallAns = dfs(graph, visited, searchString.substring(1), x, y);
				if(smallAns) {
					return smallAns;
				}
				
			}


		}
		
		visited[i][j] = false;
		return false;


	}
	
	
}
