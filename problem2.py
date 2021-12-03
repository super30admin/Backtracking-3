#Time O(n*m*3^L), space O(n)
class Solution:
    dirt = [[0,1],[0,-1],[1,0],[-1,0]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        # if board==None or len(board)==0 or len(board[0])==0 or board[0]==0:
        #     return False
 #Traversing Matrix      
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.backtrack(board,word,i,j,0):
                    return True
                
        return False
    
    def backtrack(self,board,word,i,j,index):
        if index == len(word):
            return True

        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or board[i][j]=='#':
            return False
#Action
        if board[i][j]==word[index]:
            c= word[index]
            board[i][j]='#'
#Recursion
            for d in self.dirt:
                ni = i+d[0]
                nj=j+d[1]

                if self.backtrack(board,word,ni,nj,index+1):
                    return True
#Backtrack
            board[i][j]=c

        return False


