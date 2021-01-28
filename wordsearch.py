class Solution:
    '''
    Time Complexity: O(3^n)
    Space Complexity: O(1)
    '''
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def helper(i,j,n):
            if(board[i][j]!=word[n]):
                return False
            
            if(n==len(word)-1):
                return True
            
            board[i][j] = "#"
            
            dirs = [(0,1),(0,-1),(1,0),(-1,0)]
            
            for q in dirs:
                r = q[0] + i
                c = q[1] + j
                
                if(r>=0 and c>=0 and r<len(board) and c<len(board[0]) and board[r][c]!="#"):
                    z = helper(r,c,n+1)
                    if(z==True):
                        return True
            board[i][j] = word[n]
            return False
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if(board[i][j] == word[0]):
                    z = helper(i,j,0)
                    if(z==True):
                        return z
        
        return False
