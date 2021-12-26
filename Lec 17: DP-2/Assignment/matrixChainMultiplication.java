public class Solution { 
    public static int mcm(int[] p){ 
        int storage[][] = new int[p.length][p.length]; 
        for(int i= p.length-2; i>= 1; i--){
            for(int j =1; j<=p.length-1; j++){ 
                if(i < j ){ 
                    int minCost = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){ 
                        int cost = storage[i][k] + storage[k+1][j] + p[i-1]*p[k]*p[j]; 
                        if(cost < minCost){ 
                            minCost = cost;
                        } 
                        storage[i][j] = minCost; 
                    }
                }
            } 
        }
        return storage[1][p.length-1]; 
    }
}
