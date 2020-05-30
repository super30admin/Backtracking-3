"""
// Time Complexity :O(MN*4^L) mn = length of matrix and 4 choices at each step, l = length of the word
// Space Complexity :O(L)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
compare from row,column (0,0) and check for first word. If match, check the adjacent
numbers i.e [(row+1, column),(row-1, column),(row, column+1),(row,column-1)]
"""
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None:
            return False

        for row in range(len(board)+1):
            for column in range(len(board)+1):
                if self.dfs(board,row,column,word):
                    return True
        return False

    def dfs(self,board,row,column,word):
        if len(word) == 0:
            return True

        if row < 0 or row >=len(board) or column < 0 or column >=len(board[0]) or word[0] !=board[row][column]:
            return False
        temp = board[row][column]
        board[row][column] = "#"
        result = self.dfs(board,row +1,column,word[1:] ) or self.dfs(board,row -1,column,word[1:] ) or self.dfs(board,row,column+ 1,word[1:] ) or self.dfs(board,row,column- 1,word[1:] )
        board[row][column] = temp
        return result
