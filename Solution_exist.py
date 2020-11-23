"""
Time complexity O(4^l) or O(3^l) ie (MxN)(3^l)

Space complexity 0(l) where l is length of word


"""


class Solution_exist:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs=[[1,0],[0,1],[-1,0],[0,-1]]
        if(board == None or len(board)==0):
            return False
        m=len(board)
        n=len(board[0])
        
        for i in range(m):
            for j in range(n):
                if(self.backtrack(board,word,i,j,0)):
                    return True
        return False
    
    
    def backtrack(self,board,word,i,j,idx):
        ##base
        
        if idx==len(word):
            return True
        if(i<0 or i>=len(board) or j<0 or j>=len(board[0])):
            return False
        
        ##logic
        if(board[i][j]==word[idx]):
            #action
            temp=board[i][j]
            board[i][j]='*'
            #recurse
            for dir in self.dirs:
                r=i+dir[0]
                c=j+dir[1]
                if(self.backtrack(board,word,r,c,idx+1)):
                    board[i][j]=temp
                    return True
            #backtrack
            board[i][j]=temp
        return False
                
            
        