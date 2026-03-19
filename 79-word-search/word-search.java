class Solution {
    public boolean exist(char[][] board, String word) {
        boolean letterExists = false;
        
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == word.charAt(0)){
                   if(isExists(word,board,i,j,row,col,0))
                        return true;
                }
            }
        }
        return letterExists;
    }


    private boolean isExists(String s, char[][]board,int i, int j,int row, int col, int idx) {
        if(idx>=s.length())
            return true;
        if(!isValid(s,board,i,j,row,col,idx)) {
            return false;
        }    
        char temp = board[i][j];
        board[i][j]='#';
        boolean val = 
             isExists(s,board,i-1,j,row,col,idx+1) ||
            isExists(s,board,i+1,j,row,col,idx+1) ||
            isExists(s,board,i,j-1,row,col,idx+1) ||
            isExists(s,board,i,j+1,row,col,idx+1);
        board[i][j]=temp;
        return val;    
    }

    private boolean isValid (String s, char[][]board,int i, int j, int row, int col, int idx) {
        return i>=0 && j>=0 && i<row && j<col && s.charAt(idx) == board[i][j];
    }
}