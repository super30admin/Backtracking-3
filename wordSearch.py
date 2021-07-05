# Time Complexity : O(M*N*(3^L))
# Space Complexity : O(L) -Stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board)==0:
            return False
        path=[]
        index=0
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.helper(board,i,j, index, word):
                    return True
        return False

    def helper(self, board, i, j, index, word):
        if index==len(word):
            return True
        if i<0 or i==len(board) or j<0 or j==len(board[0]) or board[i][j]!=word[index]:
            return False

        temp=board[i][j]
        board[i][j]="#"
        for dir in self.dirs:
            r=i+dir[0]
            c=j+dir[1]
            if self.helper(board, r,c, index+1, word):
                return True

        board[i][j]=temp
        return False





