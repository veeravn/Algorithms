package com.vnaidu;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if(board.length == 0){
            return;
        }
        int[] dx = {1,1,1,0,-1,-1,-1,0};
        int[] dy = {1,0,-1,-1,-1,1,0,1};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int livecount = 0;
                for(int k=0;k<dx.length;k++){
                    if(isSafe(i+dx[k],j+dy[k],board.length, board[0].length)){
                        if(board[i+dx[k]][j+dy[k]] == 1 || board[i+dx[k]][j+dy[k]] == -1){
                            livecount++;
                        }
                    }
                }
                if(board[i][j] == 1 && (livecount < 2 || livecount > 3)){
                    board[i][j] = -1;
                }
                if(board[i][j] == 0 && livecount == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 2) board[i][j] = 1;
                if(board[i][j] == -1) board[i][j] = 0;
            }
        }

    }
    public boolean isSafe(int i, int j, int rowBorder, int columnBorder){
        return i >= 0 && i < rowBorder && j >= 0 && j < columnBorder;
    }

}
