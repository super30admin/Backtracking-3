#Time Complexity :O(3^L)
#Space Complexity :O(L) L is len of the board
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m=len(board)
        n=len(board[0])
        self.dirs=[(0,-1),(0,1),(1,0),(-1,0)]
        for i in range(m):
            for j in range(n):
                if self.helper(board,word,i,j,0):
                    return True
        return False

    def helper(self,board,word,i,j,idx):
        #base
        if idx==len(word):
            return True
        
        if i<0 or i==len(board) or j<0 or j==len(board[0]) or board[i][j]=='#':
            return False

        #logic
        if board[i][j]==word[idx]:
            board[i][j]='#'
            for dir in self.dirs:
                nr=dir[0]+i
                nc=dir[1]+j
                if self.helper(board,word,nr,nc,idx+1):
                    return True
            board[i][j]=word[idx]
        return False