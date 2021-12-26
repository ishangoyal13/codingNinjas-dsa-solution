public class Solution {
    
	public static boolean ratInAMaze(int maze[][]){

		int path[][] = new int[maze.length][maze.length];
		return solveMaze(maze,0,0,path);
	}
    
    public static boolean solveMaze(int[][] maze, int i, int j, int[][] path)
	{
		int n=maze.length;
		if (i<0 || j<0 || i>=n || j>=n)
			return false;
		if (path[i][j]==1)
			return false;
		if (maze[i][j]==0)
			return false;
		path[i][j]=1;
		if (i==n-1 && j==n-1)
			return true;
		
		if (solveMaze(maze,i-1,j,path))
			return true;
		
		if (solveMaze(maze,i,j+1,path))
			return true;
		if (solveMaze(maze,i+1,j,path))
			return true;
		if (solveMaze(maze,i,j-1,path))
			return true;
		return false;
	}
}
