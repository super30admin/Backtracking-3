# time complexity: O(mxn)
# space complexity: O(length of word)


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board==None or len(board)==0: return False
        m=len(board)
        n=len(board[0])
        dirs=[[0,1], [-1,0], [1,0], [0,-1]]
        
        def backtrack(board, word, index, r, c):
            #base
            if index==len(word):
                return True
            
            if r<0 or c<0 or r==m or c==n or board[r][c]=='#':
                return False
            #logic
            if board[r][c]==word[index]:
                #action
                ch=board[r][c]
                board[r][c]='#'
                for dir in dirs:
                    newr=r+dir[0]
                    newc=c+dir[1]
                    #recurse
                    if backtrack(board, word, index+1, newr, newc):
                        return True
                #backtrack
                board[r][c]=ch
                    
            return False
            
        for i in range(m):
            for j in range(n):
                if board[i][j]==word[0]:
                    if backtrack(board, word, 0, i, j): return True
                    
        return False