#Time complexity: exponential
#Space complexity: O(L)
class Solution:
    def exist(self, board, word: str) -> bool:
        path=set()
        def dfs_recur(row,col,i):
            if i==len(word):
                return True
            if row<0 or row>=len(board) or col<0 or col>=len(board[0]) or word[i]!=board[row][col] or (row,col) in path:
                return False
            path.add((row,col))
            res=dfs_recur(row+1,col,i+1) or dfs_recur(row-1,col,i+1) or dfs_recur(row,col+1,i+1) or dfs_recur(row,col-1,i+1)
            path.remove((row,col))
            return res        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0]:
                    if dfs_recur(i,j,0): 
                        return True
        return False
