import java.io.*; 
import java.util.*;
public class Solution{ 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static void printsolution(int[][] solution, int n) { 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
            {
                System.out.print(solution[i][j] + " "); 
            }
        }
    }
    static void solveMaze(int maze[][], int solution[][], int x, int y, int n) { 
        if (x == n - 1 && y == n - 1) { 
            solution[x][y] = 1; printsolution(solution, n); 
            System.out.println(); 
            return; 
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0) {
            return;
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1) {
            return; 
        }
        solution[x][y] = 1; 
        solveMaze(maze, solution, x - 1, y, n);
        solveMaze(maze, solution, x + 1, y, n);
        solveMaze(maze, solution, x, y - 1, n);
        solveMaze(maze, solution, x, y + 1, n); 
        solution[x][y] = 0; 
    }
    static void ratInAMaze(int maze[][], int n) { 
        int[][] solution = new int[20][20];
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) {
                solution[i][j] = 0;
            }
        }
        solveMaze(maze, solution, 0, 0, n);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim()); 
        int[][] maze = new int[20][20]; 
        for (int i = 0; i < n; i++) { 
            StringTokenizer tk = new StringTokenizer(br.readLine().trim()); 
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        ratInAMaze(maze, n);
    }
}
