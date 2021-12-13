public class OthelloBoard {

    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public OthelloBoard() {
        board = new int[8][8];
        board[3][3] = player1Symbol;
        board[3][4] = player2Symbol;
        board[4][3] = player2Symbol;
        board[4][4] = player1Symbol;
    }

    public void print() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean move(int symbol, int x, int y){
        
        if(x<0 || y<0 || x>=8 || y>=8 || board[x][y]!=0 ){
            return false;
        }
        
        int[] XDir = {0, 1, 1, 1, 0, -1, -1, -1};
		int[] YDir = {1, 1, 0, -1, -1, -1, 0, 1};
        int c = 0;
        for(int i=0;i<XDir.length;i++) {
            boolean valid = true;
            int X = x + XDir[i];
            int Y = y + YDir[i];
            int count=0;
            while(X>=0 && Y>=0 && X<8 && Y<8 && board[X][Y]!=0 && board[X][Y]!=symbol) {
                count++;
                X += XDir[i];
                Y += YDir[i];
            }
            
            if(count==0 ) {
                valid=false;
            }
            if(valid && board[X][Y] == symbol) {
                board[x][y] = symbol;
                X = x + XDir[i];
                Y = y + YDir[i];
                while(X>=0 && Y>=0 && X<8 && Y<8 &&  board[X][Y]!=0 &&  board[X][Y]!=symbol) {
                    board[X][Y] = symbol;
                    X += XDir[i];
                    Y += YDir[i];
                }
                c++;
            }
        }
        if(c==0) {
            return false;
        }
        return true;

    }
}
