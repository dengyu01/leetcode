package com.hsc.recall;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = check(board, visit, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visit, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        boolean result = false;
        int[][] index = new int[][] {
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1},
        };
        visit[i][j] = true;
        for (int l = 0; l < index.length; l++) {
            int newX = i + index[l][0];
            int newY = j + index[l][1];
            if (newX >= 0 && newX < visit.length && newY >= 0 && newY < visit[0].length) {
                if (!visit[newX][newY]) {
                    boolean flag = check(board, visit, newX, newY, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visit[i][j] = false;
        return result;
    }
}
