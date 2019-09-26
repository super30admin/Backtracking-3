/* Problem Statement:
Verified on leetcode

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

Accepted
159,693
Submissions


 *
 * Time Complexity : O() Have confusion on it, will update after clarification 
 * Space Complexity : O(n) excluding the result set 
 */


/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
#define QUEEN 'Q'
bool is_valid_move(char **current_arr, int row, int col, int n) {
    int row_idx = 0;
    char **curr_arr = current_arr;
    int col_idx = 0;
    int idx = 0;
    
    for (idx = 0; idx < n; idx++) {
        if ((idx != col && curr_arr[row][idx] == QUEEN)) {
            return false;
        }
        if ((idx != row && curr_arr[idx][col] == QUEEN)) {
            return false;
        }
    }
    //printf("chk 2 \n");
    row_idx = row - 1; col_idx = col - 1;
    while(row_idx >= 0 && col_idx >= 0) {
        if (curr_arr[row_idx--][col_idx--] == QUEEN) {
            return false;
        }
    }

    row_idx = row - 1; col_idx = col + 1;
    while(row_idx >= 0 && col_idx < n) {
        if (curr_arr[row_idx--][col_idx++] == QUEEN) {
            return false;
        }
    }

    return true;
    
}

void solve(int n, int* returnSize, int* ret_col, char** current_arr, int row, char*** final_arr) {
    int idx = 0;
    int len = 0;
    int col_idx = 0;
    char ***fin_arr = final_arr;
    char **curr_arr = current_arr;
    
    /* Keep on going until rows are not finished */
    if (row < n) {
        
        for (col_idx = 0; col_idx < n; col_idx++) {
            /* make a choice */
            curr_arr[row][col_idx] = QUEEN;
            if (is_valid_move(curr_arr,row,col_idx, n)) {
               solve(n, returnSize, ret_col, curr_arr, row + 1, final_arr);                
            }
            /* undo that choice */
            curr_arr[row][col_idx] = '.';
        }
    } else {
        /* We have reached the end, it means we found a solution add it to the final array */
        final_arr[*returnSize] = (char **)malloc(sizeof(char *) * n);
        ret_col[*returnSize] = n;
        for (idx = 0; idx < n; idx++) {
            final_arr[*returnSize][idx] = (char *)malloc(sizeof(char) * (n + 1));
            strncpy(final_arr[*returnSize][idx], current_arr[idx], n);
            final_arr[*returnSize][idx][n] = '\0';
        }
        *returnSize = *returnSize + 1;
    }
}

char *** solveNQueens(int n, int* returnSize, int** returnColumnSizes){

    char ***final_arr = NULL;
    *returnSize = 0;
    int row_idx = 0, col_idx = 0;
    int idx = 0;
    int *ret_col = NULL;
    char **current_arr = NULL;
    
    /* Init case handle */
    if (!n) {
        return final_arr;
    }
    
    /* Memory allocation */
    #define FINAL_ARR 500
    final_arr = (char ***)calloc(FINAL_ARR, sizeof(char **));

    ret_col = (int *)malloc(sizeof(int) * FINAL_ARR);
    
    /* processing of input data */
    current_arr = (char **)malloc(sizeof(char *) * FINAL_ARR);
    for (idx = 0; idx < n; idx++) {
        current_arr[idx] = (char *)malloc(sizeof(char) * n);
        memset(current_arr[idx], '.', n);
    }
    /* For first row, select positions and then rest of the work will be done in recursion */
    for (col_idx = 0; col_idx < n; col_idx++) {
        /* make a choice */
        current_arr[row_idx][col_idx] = QUEEN;
        solve(n, returnSize, ret_col, current_arr, row_idx + 1,final_arr);
        current_arr[row_idx][col_idx] = '.';
    }
    free(current_arr);
 
    /* set the return column size */
    *returnColumnSizes = ret_col;
    return final_arr;
}




/* use leetcode platform to test it */


