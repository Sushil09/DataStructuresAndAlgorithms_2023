class Solution {
    public int countBattleships(char[][] board) {
        int battleShip = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='X') {
                    battleShip++;
                    testBattleship(i,j,board);
                }
            }
        }
        return battleShip;
    }

    private static void testBattleship(int i, int j, char[][] board) {
        if(board[i][j]=='.')
            return;
        board[i][j]='.';
        int[] x = {0,1,-1,0};
        int[] y = {1,0,0,-1};

        for(int k=0;k<4;k++){
            int newX= i+x[k];
            int newY= j+y[k];
            if(isValid(newX,newY,board)){
                testBattleship(newX,newY,board);
            }
        }   
    }

    private static boolean isValid(int x, int y, char[][] board) {
        return x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y] =='X';
    }
}