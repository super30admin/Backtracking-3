// Time Complexity : (board_rows*board_cols)*4^len(word)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we do this using DFS and backtracking.we start by finding the first letter from word in board and then do dfs to find the pattern in the board.If found return true and we also backtrack to find whether word is present in the board or not.


# DFS and Backtracking
class Solution(object):
    def helper(self,board,word,row,col,index):
        if row<0 or row>=len(board) or col<0 or col>=len(board[0]) or board[row][col]=='#':
            return False
        if board[row][col]==word[index]:
            if index==len(word)-1:
                return True
            ele=board[row][col]
            board[row][col]='#'
            dirs=[[0,1],[1,0],[-1,0],[0,-1]]
            for k in dirs:
                row1=row+k[0]
                col1=col+k[1]
                if self.helper(board,word,row1,col1,index+1):
                    return True
            board[row][col]=ele
    
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if board==None or len(board)==0:
            return []
        list1=[]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.helper(board,word,i,j,0):
                    return True
        return False
                    
                    
        