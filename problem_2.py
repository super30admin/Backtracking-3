# Time Complexity - 3^k 
# Space Complexity- O(k)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):

                if(self.backtrack(board,word,0,i,j,m,n,dirs)): 
                    return True
        return False

    def backtrack(self,board,word,idx,i,j,m,n,dirs):
        if idx == len(word):
            return True
        if i < 0 or i == m or j < 0 or j == n or  board[i][j] == '$' :
            return False
        if board[i][j] == word[idx] : 
            board[i][j] = '$' 
            for each in dirs: 
                nr = i + each[0]
                nc = j + each[1]
                if (self.backtrack(board,word,idx+1,nr,nc,m,n,dirs)):
                    return True

            board[i][j] = word[idx] 
        return False 



