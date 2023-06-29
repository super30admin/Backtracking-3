#word search problem

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        """
        Using DFS and backtracking
        TC: o(M*N 2^l) l=len of word; and n=no of rows; m=no of cols
        SC: O(l)
        """
        if board == None or len(board)==0 : return False
        
        m=len(board)
        n=len(board[0])
        dirs=[(1,0),(0,1),(-1,0),(0,-1)]
        
        def backtrack_helper(board, i, j, word,idx):
            # Base case is
            if idx == len(word): return True
            if i < 0 or i==m or j<0 or j==n or board[i][j]=="#" : return False
                        
            # logic is
            if board[i][j]==word[idx]:
                
                # action
                board[i][j] = "#"
                # Recurse
                for d in dirs:
                    nr=d[0]+i
                    nc=d[1]+j
                    if (backtrack_helper(board,nr,nc,word, idx + 1)): return True
                #back track
                board[i][j] = word[idx]
                
        for i in range(m): 
            for j in range(n):
                if word[0] == board[i][j]:
                    if(backtrack_helper(board, i, j, word, 0)== True): return True
            
        return False
        
