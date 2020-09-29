# Leetcode problem link : https://leetcode.com/problems/palindrome-partitioning/
# Time Complexity:    O(mxn x n^L) where mxn is the size of the matrix and L the length of the word to be searched
# Space Complexity:   O(L) at most L recursive calls on the recursive stack
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Look for the occurrence of the first character in the board.
    2. Start dfs search for the word in adjacent neighbors. Change the current character to a speacial character to avoid using the same character again
    3. Continue dfs for the next character and so on till word length is same as current index. Return true in that case
    4. Replace the special character back once returned from dfs call to make sure next search is not altered and hence backtrack the way up.

'''

class Solution:
    def __init__(self):
        self.dirs = [[0,-1],[0,1],[-1,0],[1,0]]
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.backtrack(board,word,0,i,j):
                        return True
        return False
        
    def backtrack(self,board,word,index,i,j):
        if index >= len(word)-1:
            return True
        temp = board[i][j]
        board[i][j] = "#"
        for direction in self.dirs:
            r = i + direction[0]
            c = j + direction[1]
            
            if r >= 0 and r < len(board) and c >= 0 and c < len(board[0]) and index+1 < len(word) and board[r][c] == word[index+1]:
                
                if self.backtrack(board,word,index+1,r,c):
                    return True
            
        
        board[i][j] = temp
        return False
                