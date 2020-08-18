#Backtracking-3
#Problem2 : https://leetcode.com/problems/word-search/
#All test cases passed on Leetcode
#Time Complexity:    O(NX3^L)
#Space Complexity:    O(L) L is the length of the string
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        #edge
        if board==None or len(board)==0:
            return False
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if self.dfs(board,word,i,j,m,n,0):
                    return True
        return False
        
    def dfs(self,board,word,i,j,m,n,index):
        #base
        if index==len(word):
            return True
        if i<0 or j<0 or i>=m or j>=n or board[i][j]=='#':
            return False
        #logic
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        if word[index]==board[i][j]:
            temp=board[i][j]
            #action
            board[i][j]='#'
            #recurse
            for dir in dirs:
                r=dir[0]+i
                c=dir[1]+j
                if (self.dfs(board,word,r,c,m,n,index+1)):
                    return True
            #backtrack
            board[i][j]=temp
        return False
                
        
                    