class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if len(board)==0 or board==None:
            return False
        m=len(board)
        n=len(board[0])
        def dfs(board,word,i,j,index):
            if index==len(word):
                return True
            if i<0 or j<0 or i>=m or j>=n or board[i][j]=='#':
                return False
            dirs=[(0,1),(1,0),(0,-1),(-1,0)]
            if board[i][j]==word[index]:
                temp=board[i][j]
                board[i][j]='#'
                for d in dirs:
                    r=d[0]+i
                    c=d[1]+j
                    if dfs(board,word,r,c,index+1):
                        return True
                board[i][j]=temp
        for i in range(m):
            for j in range(n):
                if dfs(board,word,i,j,0):
                    return True
        return False

#Time-Complexity: O(3^nL)
#Space-Complexity:O(1)