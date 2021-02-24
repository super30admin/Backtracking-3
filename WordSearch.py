#TimeComplexity:O(N*M * 3 power len(word) 
#SpaceComplexity: Constant space as we are not using any extra space
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution:
    dirs=[[1,0],[-1,0],[0,1],[0,-1]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==word[0]:
                    if self.recur(board,i,j,word,0):
                        return True
        return False

    def recur(self,board,i,j,word,index):
        if index+1==len(word):
            return True
        temp=board[i][j]
        board[i][j]='#'
        for dir in self.dirs:
            r=i+dir[0]
            c=j+dir[1]
            if(r>=0 and c>=0 and r<len(board) and c<len(board[0]) and board[r][c]==word[index+1]):
                if self.recur(board,r,c,word,index+1):
                    return True
        board[i][j]=temp
        
                
        