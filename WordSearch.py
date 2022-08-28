# Time Complexity : O(M * N * 3^L) Where L is the length of the word on M * N array
#  Space Complexity : O(L) It would be the recursive stack 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        #Declare the length of row and column
        m = len(board)
        n = len(board[0])
        
        #Direction arra to move i the UDLR fashion
        dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        visited  = set()
        
        #Start a dfs search and if the index is greater than the word length return true else add and traverse the neighbours
        def dfs(row, col, idx):
            if idx >= len(word):
                return True
            
            visited.add((row, col))
            
            for direction in dirs:
                nr = row+direction[0]
                nc = col+direction[1]
                if (nr >=0 and nr < m and 
                    nc >=0 and nc < n and (nr, nc) not in visited 
                    and board[nr][nc] == word[idx]):
                    if dfs(nr,nc,idx+1):
                        return True
            visited.remove((row, col))
            return False 
        #Tracerse the board to perform the dfs
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if dfs(i,j,1):
                        return True
        return False