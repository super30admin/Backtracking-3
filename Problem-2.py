class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        def backtrack(board,word,i,j,index):
            #base
            if index==len(word):
                return True
            if (i not in range(m) or j not in range(n) or board[i][j]=='#'):
                return False

            #logic
            if board[i][j]==word[index]:
                temp = board[i][j]
                board[i][j] = '#'
                for d in dirs:
                    r = i+d[0]
                    c = j+d[1]
                    if backtrack(board,word,r,c,index+1):
                        return True
                board[i][j] =temp

            return False






        if board is None or len(board)==0:
            return False
        m = len(board)
        n = len(board[0])
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        for i in range(m):
            for j in range(n):
                if backtrack(board,word,i,j,0):
                    return True
        return False
    
