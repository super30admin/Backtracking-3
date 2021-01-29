#time: O(NX3^L)
#space: O(L)

class Solution:
    isvalid=False
    def exist(self, board: List[List[str]], word: str) -> bool:
        if( board==None or len(board)==0):
            return False
        m=len(board)
        n=len(board[0])
        self.isvalid=False
        for i in range(m):
            for j in range(n):
                if(self.helper(board,0,i,j,word,m,n)):
                    return True

        return False
    
    def helper(self,board,index,i,j,word,m,n):
        if (index==len(word)):
            return True
        if (i<0 or j<0 or i>=m or j>=n or board[i][j]=='#'):
            return False
        direct=[[0,1],[1,0],[-1,0],[0,-1]]
        if(board[i][j]==word[index]):
            temp=board[i][j]
            board[i][j]='#'

            for d in direct:
                r=i+d[0]
                c=j+d[1]
                if(self.helper(board,index+1,r,c,word,m,n)):
                    return True

            #backtrack
            board[i][j]=temp